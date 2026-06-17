-- Scenario 1: The bank needs to process monthly interest for all savings accounts.
-- o	Question: Write a stored procedure ProcessMonthlyInterest that calculates and updates the balance of all savings accounts by applying an interest rate of 1% to the current balance.

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN 
    UPDATE Accounts 
    SET Balance = Balance  + Balance * 0.01
    WHERE AccountType  = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Updated balances of all savings account');

END;
/

BEGIN
    ProcessMonthlyInterest();
END;
/
