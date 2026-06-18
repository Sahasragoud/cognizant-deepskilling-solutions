CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_employeeid NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2
    );

    PROCEDURE UpdateEmployee(
        p_employeeid NUMBER,
        p_salary NUMBER
    );

    FUNCTION CalculateAnnualSalary(
        p_employeeid NUMBER
    ) RETURN NUMBER;

END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_employeeid NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2
    )
    IS
    BEGIN
        INSERT INTO Employees
        VALUES (
            p_employeeid,
            p_name,
            p_position,
            p_salary,
            p_department,
            SYSDATE
        );
    END HireEmployee;

    PROCEDURE UpdateEmployee(
        p_employeeid NUMBER,
        p_salary NUMBER
    )
    IS
    BEGIN
        UPDATE Employees
        SET Salary = p_salary
        WHERE EmployeeID = p_employeeid;
    END UpdateEmployee;

    FUNCTION CalculateAnnualSalary(
        p_employeeid NUMBER
    )
    RETURN NUMBER
    IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary
        INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_employeeid;

        RETURN v_salary * 12;
    END CalculateAnnualSalary;

END EmployeeManagement;
/
