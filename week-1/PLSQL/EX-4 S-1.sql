-- Scenario 1: Calculate the age of customers for eligibility checks.
-- o	Question: Write a function CalculateAge that takes a customer's date of birth as input and returns their age in years.

CREATE OR REPLACE FUNCTION CalculateAge(
    dob DATE
)
RETURN NUMBER
AS
BEGIN 
    return TRUNC(MONTHS_BETWEEN(SYSDATE, dob)/12);
END;
/
DECLARE 
    age number := 0;
BEGIN
    age := CalculateAge(TO_DATE('1990-07-20', 'YYYY-MM-DD'));
    DBMS_OUTPUT.PUT_LINE('AGE IS : ' || age);

END;
/
