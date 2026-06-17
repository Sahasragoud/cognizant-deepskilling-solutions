CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    source_acc      IN NUMBER,
    destination_acc IN NUMBER,
    transfer_amount IN NUMBER
)
AS
    v_balance NUMBER;
BEGIN

    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = source_acc;

    IF v_balance < transfer_amount THEN

        RAISE_APPLICATION_ERROR(
            -20001,
            'Insufficient Funds'
        );

    END IF;

    UPDATE Accounts
    SET Balance = Balance - transfer_amount,
        LastModified = SYSDATE
    WHERE AccountID = source_acc;

    UPDATE Accounts
    SET Balance = Balance + transfer_amount,
        LastModified = SYSDATE
    WHERE AccountID = destination_acc;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Transfer Successful'
    );

EXCEPTION

    WHEN NO_DATA_FOUND THEN

        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(
            'Source Account Not Found'
        );

    WHEN OTHERS THEN

        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(
            SQLERRM
        );

END;
/

BEGIN

   SafeTransferFunds(
      1,
      2,
      500
   );

END;
/
