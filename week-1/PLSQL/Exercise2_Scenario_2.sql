-- Scenario 2: Manage errors when updating employee salaries.
-- o	Question: Write a stored procedure UpdateSalary that increases the salary of an employee by a given percentage. If the employee ID does not exist, handle the exception and log an error message.

CREATE OR REPLACE PROCEDURE UpdateSalary (
    emp_id number,
    bonus number
)
AS 
        valid_id NUMBER;
BEGIN
    select EmployeeID 
    INTO valid_id
    FROM Employees 
    WHERE EmployeeID = emp_id;

    UPDATE Employees
    SET Salary = Salary + Salary * bonus / 100
    WHERE EmployeeID = emp_id;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Salary Updated Successfully'
    );

EXCEPTION
    WHEN NO_DATA_FOUND THEN 
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Employee with this id does not exist');

END;
/

BEGIN
    UpdateSalary(4, 20);
END;
/
