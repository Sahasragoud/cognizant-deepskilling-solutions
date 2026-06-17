-- Scenario 3: Enforce business rules on deposits and withdrawals.
-- o	Question: Write a trigger CheckTransactionRules that ensures withdrawals do not exceed the balance and deposits are positive before inserting a record into the Transactions table.

CREATE OR REPLACE TRIGGER CheckTransactionRules 
BEFORE INSERT
ON Transactions
FOR EACH ROW
DECLARE
    v_balance number;
BEGIN
    IF :New.TransactionType = 'Deposit' 
        AND :New.Amount <= 0 
    THEN
        RAISE_APPLICATION_ERROR(
            -20001,
            'Inavalid Request'
        );
    END IF;

    SELECT Balance 
    INTO v_balance
    from Accounts 
    where AccountId = :New.AccountId;

    IF :NEW.TransactionType = 'Withdrawal' AND 
        :NEW.Amount > v_balance THEN

        RAISE_APPLICATION_ERROR(
            -20001,
            'Inavalid Request'
        );
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(
            -20002,
            'Account does not exist'
        );

END;
/

BEGIN
    INSERT INTO Transactions
VALUES
(
   3,
   1,
   SYSDATE,
   1500,
   'Withdrawal'
);

END;
/
