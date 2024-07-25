USE PRODUCT;

ROLLBACK;

# 트랜잭션을 시작 : COMMIT할 때까지 최종 적용이 안된다.
START TRANSACTION;

UPDATE PRODUCT 
SET 
    PR_PRICE = 1000000
WHERE
    PR_CODE = 'AB1';
    
SELECT * FROM PRODUCT;
    
SAVEPOINT A1;

UPDATE PRODUCT 
SET 
    PR_PRICE = 2200000
WHERE
    PR_CODE = 'AB1';
    
SAVEPOINT A2;

UPDATE PRODUCT 
SET 
    PR_PRICE = 3200000
WHERE
    PR_CODE = 'AB1';

# ROLLBACK TO A2;
# ROLLBACK;

COMMIT;

SELECT * FROM PRODUCT;