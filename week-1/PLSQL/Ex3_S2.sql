-- Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.
-- o	Question: Write a stored procedure UpdateEmployeeBonus that updates the salary of employees in a given department by adding a bonus percentage passed as a parameter.

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_emp_dept varchar2,
    p_bonus number
)
AS
    dep_name varchar2(100);
BEGIN
    SELECT DISTINCT Department 
    INTO dep_name
    FROM Employees 
    WHERE Department = p_emp_dept;

    UPDATE Employees 
    SET Salary = Salary  + Salary  * p_bonus / 100
    WHERE Department = p_emp_dept;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Updated salaries of employees from the given department');

EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        ROLLbACK;
        DBMS_OUTPUT.PUT_LINE('Given Department does not exists');

END;
/

BEGIN
    UpdateEmployeeBonus ('HR', 20);
END;
/
