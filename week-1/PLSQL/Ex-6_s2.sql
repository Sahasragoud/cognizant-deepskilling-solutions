DECLARE

    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_accountid Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;

    v_fee NUMBER := 100;

BEGIN

    OPEN ApplyAnnualFee;

    LOOP

        FETCH ApplyAnnualFee
        INTO v_accountid, v_balance;

        EXIT WHEN ApplyAnnualFee%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE AccountID = v_accountid;

    END LOOP;

    CLOSE ApplyAnnualFee;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Annual Fee Applied');

END;
/
