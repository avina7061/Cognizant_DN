-- Scenario 1: ProcessMonthlyInterest

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
UPDATE Accounts
SET Balance = Balance + (Balance * 0.01)
WHERE AccountType = 'Savings';

```
COMMIT;
```

END;
/

-- Scenario 2: UpdateEmployeeBonus

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
p_department VARCHAR2,
p_bonus_percent NUMBER
)
IS
BEGIN
UPDATE Employees
SET Salary = Salary + (Salary * p_bonus_percent / 100)
WHERE Department = p_department;

```
COMMIT;
```

END;
/

-- Scenario 3: TransferFunds

CREATE OR REPLACE PROCEDURE TransferFunds(
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
IF v_balance >= p_amount THEN

    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account;

    COMMIT;

ELSE
    DBMS_OUTPUT.PUT_LINE('Insufficient Balance');
END IF;
```

END;
/

