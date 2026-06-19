-- Scenario 1: GenerateMonthlyStatements

DECLARE
CURSOR GenerateMonthlyStatements IS
SELECT CustomerID, TransactionID, Amount
FROM Transactions
WHERE EXTRACT(MONTH FROM TransactionDate) =
EXTRACT(MONTH FROM SYSDATE);

BEGIN
FOR rec IN GenerateMonthlyStatements LOOP
DBMS_OUTPUT.PUT_LINE(
'Customer ID: ' || rec.CustomerID ||
' Transaction ID: ' || rec.TransactionID ||
' Amount: ' || rec.Amount
);
END LOOP;
END;
/

-- Scenario 2: ApplyAnnualFee

DECLARE
CURSOR ApplyAnnualFee IS
SELECT AccountID
FROM Accounts;

BEGIN
FOR rec IN ApplyAnnualFee LOOP
UPDATE Accounts
SET Balance = Balance - 500
WHERE AccountID = rec.AccountID;
END LOOP;

```
COMMIT;
```

END;
/

-- Scenario 3: UpdateLoanInterestRates

DECLARE
CURSOR UpdateLoanInterestRates IS
SELECT LoanID, InterestRate
FROM Loans;

BEGIN
FOR rec IN UpdateLoanInterestRates LOOP
UPDATE Loans
SET InterestRate = rec.InterestRate + 0.5
WHERE LoanID = rec.LoanID;
END LOOP;

```
COMMIT;
```

END;
/
