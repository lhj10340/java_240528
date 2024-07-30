# 분류별 등록된 제품수를 조회하는 쿼리 
SELECT 
    CA_NAME 분류명, COUNT(PR_CODE) 제품수
FROM
    PRODUCT
RIGHT JOIN
	CATEGORY ON CA_NUM = PR_CA_NUM
GROUP BY CA_NUM;

# 분류 중에서 옷을 클릭했을 떄 => 옷으로 등록된 제품들을 조회하는 쿼리

# 내가 작성한 쿼리 ( = 강사님도 동일하게 작성하셨다. )
SELECT 
    CA_NAME 분류명, PR_NAME 제품명 # 여기만 * 에서 바꾸지 않으셨다.
FROM
    PRODUCT
        JOIN
    CATEGORY ON PR_CA_NUM = CA_NUM
WHERE
    CA_NAME = '옷';
    
# '시원한' 이 들어간 제품을 검색 => 제목에 '시원한'이 포함된 제품을 조회하는 쿼리

# 내가 작성한 쿼리 ( 이만큼 밖에 못 했다. )
SELECT * FROM PRODUCT;

# 강사님이 작성하신 쿼리
# (1) SELECT * FROM PRODUCT WHERE PR_NAME CONCAT('%','시원한','%');
# (2) SELECT * FROM PRODUCT WHERE PR_NAME LIKE '%시원한%';

# 누적 판매량이 가장 많은 제품들을 조회하는 쿼리 
# 판매가 되지 않은 제품들도 조회가 되어야 한다 => OUTER JOIN 이용

# 내가 작성한 쿼리
SELECT 
  *
FROM
    PRODUCT
        LEFT JOIN
    BUY ON PR_CODE = BU_PR_CODE;
    
# 강사님이 작성하신 쿼리
SELECT 
	DENSE_RANK() OVER(ORDER BY SUM(BU_AMOUNT) DESC) 판매순위, PRODUCT.*, SUM(BU_AMOUNT) 판매량
FROM
    PRODUCT
        LEFT JOIN
    (SELECT * FROM BUY WHERE BU_STATE IN('구매', '구매확정')) B ON PR_CODE = BU_PR_CODE
GROUP BY PR_CODE;

# 옷 제품들 중에서 가격이 높은 순으로 제품을 조회하는 쿼리

# 내가 작성한 쿼리 ( 느려 .. )
SELECT 
    *
FROM
    PRODUCT
        JOIN
    CATEGORY ON PR_CA_NUM = CA_NUM
WHERE
    CA_NAME = '옷';
    
# 강사님이 작성하신 쿼리
SELECT 
    PRODUCT.*
FROM
    PRODUCT
        JOIN
    CATEGORY ON PR_CA_NUM = CA_NUM
WHERE
    CA_NAME = '옷'
ORDER BY PR_PRICE DESC;

# abc123회원의 구매 목록을 조회하는 쿼리

# 내가 작성한 쿼리 ( 굳이 JOIN을 할 필요가 없었다. )
SELECT 
    *
FROM
    BUY
        JOIN
    MEMBER ON BU_ME_ID = ME_ID;
    
# 강사님이 작성하신 쿼리
SELECT 
    DISTINCT BU_PR_CODE # 동일한 물품을 구매할 수도 있으니까 ...
FROM
    BUY
WHERE
	BU_ME_ID = 'abc123'
		AND BU_STATE IN ('구매', '구매확정');
        
# abc123회원이 누적 구매 금액을 조회하는 쿼리

# 내가 작성한 쿼리 ( 틀렸다, 다시 보자 )
SELECT 
    BU_ME_ID 구매자, SUM(PR_PRICE) 누적구매금액
FROM
    BUY
JOIN 
	PRODUCT
ON
	BU_PR_CODE = PR_CODE
WHERE
	BU_ME_ID = 'abc123'
		AND BU_STATE IN ('구매', '구매확정');
        
# 강사님이 작성하신 쿼리
SELECT 
   BU_ME_ID, FORMAT(SUM(PR_PRICE * BU_AMOUNT),0) 누적구매금액
FROM
    BUY
        JOIN
    PRODUCT ON PR_CODE = BU_PR_CODE
WHERE BU_STATE IN ('구매', '구매확정') AND BU_ME_ID = 'abc123'
GROUP BY BU_ME_ID;

# 회원별 누적 금액을 조회하는 쿼리

# 내가 작성한 쿼리 ( 못 했다 .. )

# 강사님이 작성하신 쿼리
SELECT 
   ME_ID, IFNULL(FORMAT(SUM(PR_PRICE * BU_AMOUNT),0),0) 누적구매금액
FROM
	MEMBER
		LEFT JOIN
    (SELECT * FROM BUY WHERE BU_STATE IN ('구매', '구매확정')) B ON ME_ID = BU_ME_ID
        LEFT JOIN
    PRODUCT ON PR_CODE = BU_PR_CODE
GROUP BY ME_ID;

# ${} => 있는 그대로, #{} => '' 사이 .. ( 문자열 처리 )