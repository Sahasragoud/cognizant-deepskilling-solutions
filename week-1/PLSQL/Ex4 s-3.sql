-- Scenario 3: Check if a customer has sufficient balance before making a transaction.
-- o	Question: Write a function HasSufficientBalance that takes an account ID and an amount as input and returns a boolean indicating whether the account has at least the specified amount.

CREATE FUNCTION HasSufficientBalance (
    p_acc_id NUMBER,
    p_amount NUMBER
)
RETURN BOOLEAN 
AS
    v_balance NUMBER;
BEGIN 
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID  = p_acc_id;

    IF v_balance >= p_amount THEN
        RETURN TRUE;

    ELSE RETURN FALSE;    

    END IF;

EXCEPTION

    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Account with ' || p_acc_id || ' does not exists.');
    
    RETURN FALSE;
END;
/

DECLARE 
    hasBalance BOOLEAN;
BEGIN
    hasBalance := HasSufficientBalance(2, 100);
    IF hasBalance THEN 
        DBMS_OUTPUT.PUT_LINE('YES, HAS SUFFICIENT BALANCE');
    ELSE
        DBMS_OUTPUT.PUT_LINE('NO, DO NOT HAVE SUFFICIENT BALANCE');
    
    END IF;

END;
/
