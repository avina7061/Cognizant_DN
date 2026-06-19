-- Scenario 1: SafeTransferFunds

CREATE OR REPLACE PROCEDURE SafeTransferFunds(
p_from_account NUMBER,
p_to_account NUMBER,
p_amount NUMBER
)
IS
v_balance NUMBER;
BEGIN
SELECT Balance
INTO v_balance
FROM Accounts
WHERE AccountID = p_from_account;

```
IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient Funds');
END IF;

UPDATE Accounts
SET Balance = Balance - p_amount
WHERE AccountID = p_from_account;

UPDATE Accounts
SET Balance = Balance + p_amount
WHERE AccountID = p_to_account;

COMMIT;
```

EXCEPTION
WHEN OTHERS THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

-- Scenario 2: UpdateSalary

CREATE OR REPLACE PROCEDURE UpdateSalary(
p_emp_id NUMBER,
p_percentage NUMBER
)
IS
BEGIN
UPDATE Employees
SET Salary = Salary + (Salary * p_percentage / 100)
WHERE EmployeeID = p_emp_id;

```
IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Employee ID Not Found');
END IF;

COMMIT;
```

EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

-- Scenario 3: AddNewCustomer

CREATE OR REPLACE PROCEDURE AddNewCustomer(
p_customer_id NUMBER,
p_customer_name VARCHAR2,
p_balance NUMBER
)
IS
BEGIN
INSERT INTO Customers(CustomerID, CustomerName, Balance)
VALUES (p_customer_id, p_customer_name, p_balance);

```
COMMIT;
```

EXCEPTION
WHEN DUP_VAL_ON_INDEX THEN
DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists');

```
WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
```

END;
/
