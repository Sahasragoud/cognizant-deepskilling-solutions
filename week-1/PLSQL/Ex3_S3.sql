-- Scenario 3: Customers should be able to transfer funds between their accounts.
-- o	Question: Write a stored procedure TransferFunds that transfers a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_acc number,
    p_destination_acc number,
    p_transfor_amount number
)
AS
BEGIN

    UPDATE Customers 
    SET  Balance = Balance  - p_transfor_amount
    WHERE CustomerID =  p_source_acc;

    UPDATE Customers 
    SET  Balance = Balance  + p_transfor_amount
    WHERE CustomerID =  p_destination_acc;
    
    COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transaction sucessfull');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('CustomerId does not exist');

end;
/

BEGIN
    TransferFunds (1, 2, 2000);
END;
/
