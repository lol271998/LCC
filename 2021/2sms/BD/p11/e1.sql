START TRANSACTION;
INSERT INTO ACCOUNT(AccountId, Value) VALUES(6, 600);
UPDATE ACCOUNT SET Value = Value - 100 WHERE AccountId = 1; 
UPDATE ACCOUNT SET Value = Value + 100 WHERE AccountId = 2;
SELECT * FROM ACCOUNT;