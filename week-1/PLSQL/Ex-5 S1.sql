-- Scenario 1: Automatically update the last modified date when a customer's record is updated.
-- o	Question: Write a trigger UpdateCustomerLastModified that updates the LastModified column of the Customers table to the current date whenever a customer's record is updated.

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified 
BEFORE UPDATE 
ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified  := SYSDATE;
    DBMS_OUTPUT.PUT_LINE(:NEW.LastModified);
END;
/


BEGIN 
    UPDATE Customers
    SET Balance = 2000
    WHERE CustomerId = 1;
END;
/
