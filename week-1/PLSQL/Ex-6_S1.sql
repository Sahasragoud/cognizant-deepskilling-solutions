DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT TransactionID,
               AccountID,
               TransactionDate,
               Amount,
               TransactionType
        FROM Transactions
        WHERE TRUNC(TransactionDate,'MM')
              = TRUNC(SYSDATE,'MM');

    v_transactionid Transactions.TransactionID%TYPE;
    v_accountid Transactions.AccountID%TYPE;
    v_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_type Transactions.TransactionType%TYPE;

BEGIN

    OPEN GenerateMonthlyStatements;

    LOOP

        FETCH GenerateMonthlyStatements
        INTO v_transactionid,
             v_accountid,
             v_date,
             v_amount,
             v_type;

        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Transaction ID: ' || v_transactionid ||
            ', Account: ' || v_accountid ||
            ', Amount: ' || v_amount ||
            ', Type: ' || v_type
        );

    END LOOP;

    CLOSE GenerateMonthlyStatements;

END;
/
