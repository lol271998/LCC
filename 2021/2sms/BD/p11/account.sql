
USE account;
DROP TABLE IF EXISTS ACCOUNT;

CREATE TABLE ACCOUNT 
(
  AccountId INT PRIMARY KEY,
  Value INT 
);

INSERT INTO ACCOUNT(AccountId, Value)
VALUES (1, 100), 
       (2, 200), 
       (3, 300), 
       (4, 400), 
       (5, 500);

DROP PROCEDURE IF EXISTS transfer;

DELIMITER $
CREATE PROCEDURE transfer(IN id1 INT, IN id2 INT, IN amount INT, OUT done BOOLEAN) 
BEGIN
  
  DECLARE v1 INT;
  DECLARE v2 INT;
  
  START TRANSACTION;

  SET v1 = NULL;
  SET v2 = NULL;
  
  SELECT Value INTO v1 FROM ACCOUNT WHERE AccountId = id1;
  SELECT Value INTO v2 FROM ACCOUNT WHERE AccountId = id2;

  IF v1 IS NULL OR 
     v2 IS NULL OR
     v1 < value OR
     id1 = id2 THEN
     ROLLBACK;
     SET DONE = FALSE; 
  ELSE
    UPDATE ACCOUNT 
    SET Value = Value - amount 
    WHERE AccountId = id1; 

    UPDATE ACCOUNT 
    SET Value = Value + amount 
    WHERE AccountId = id2;

    SET DONE = TRUE;
    COMMIT;
  END IF;
END $
DELIMITER ;

