-- Scenario 1: UpdateCustomerLastModified

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
:NEW.LastModified := SYSDATE;
END;
/

-- Scenario 2: LogTransaction

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
INSERT INTO AuditLog
(
TransactionID,
AccountID,
Amount,
TransactionDate
)
VALUES
(
:NEW.TransactionID,
:NEW.AccountID,
:NEW.Amount,
SYSDATE
);
END;
/

-- Scenario 3: CheckTransactionRules

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
v_balance NUMBER;
BEGIN
SELECT Balance
INTO v_balance
FROM Accounts
WHERE AccountID = :NEW.AccountID;

```
IF :NEW.TransactionType = 'WITHDRAWAL'
   AND :NEW.Amount > v_balance THEN
    RAISE_APPLICATION_ERROR(
        -20001,
        'Insufficient Balance'
    );
END IF;

IF :NEW.TransactionType = 'DEPOSIT'
   AND :NEW.Amount <= 0 THEN
    RAISE_APPLICATION_ERROR(
        -20002,
        'Deposit Amount Must Be Positive'
    );
END IF;
```

END;
/

