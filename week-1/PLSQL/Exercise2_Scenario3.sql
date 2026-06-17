CREATE OR REPLACE PROCEDURE AddNewCustomer (
    id number,
    name varchar2,
    dob DATE,
    balance number,
    lastmodified DATE
)
AS

BEGIN
    INSERT INTO Customers
    VALUES (id,name, dob, balance, lastmodified);

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Customer ID already exsists');

END;
/


BEGIN 
    AddNewCustomer(1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);
END;
/
    

