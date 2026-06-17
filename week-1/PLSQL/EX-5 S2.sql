
-- Scenario 2: Maintain an audit log for all transactions.
-- o	Question: Write a trigger LogTransaction that inserts a record into an AuditLog table whenever a transaction is inserted into the Transactions table.


CREATE TABLE AuditLog(
    AuditID number PRIMARY KEY,
    TransactionID number,
    Action varchar2(20),
    AuditDate DATE
);

CREATE SEQUENCE AuditLogSeq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT
ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog VALUES
    (AuditLogSeq.NEXT, :New.TransactionID, 'INSERT', SYSDATE);
END;
/


BEGIN
    INSERT INTO Transactions
    VALUES (3, 1, SYSDATE, 500, 'Deposit');
END;
/
