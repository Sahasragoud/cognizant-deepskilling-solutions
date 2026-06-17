-- Scenario 2: The bank needs to compute the monthly installment for a loan.
-- o	Question: Write a function CalculateMonthlyInstallment that takes the loan amount, interest rate, and loan duration in years as input and returns the monthly installment amount.

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment( 
    p_loan_amount NUMBER,
    p_interest_rate NUMBER,
    p_loan_duration NUMBER
)
RETURN NUMBER
AS
    v_installment NUMBER;
    v_monthly_installment NUMBER;

BEGIN
    v_installment :=  p_loan_amount + p_loan_amount * p_interest_rate / 100;
    v_monthly_installment := ROUND(v_installment / (12 * p_loan_duration) , 2);
        
    return v_monthly_installment;
EXCEPTION 
    WHEN OTHERS THEN 
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
    RETURN 0;
    

END;
/

DECLARE 
    installment NUMBER:= 0;
BEGIN
    installment := CalculateMonthlyInstallment(
        120000, 12, 1
    );
    DBMS_OUTPUT.PUT_LINE('Monthly installment: ' || installment);
end;
/

