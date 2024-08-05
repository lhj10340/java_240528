# 모든 제품을 조회하는 쿼리
select * from product;

# 금액이 1만원 이상인 제품을 조회하는 쿼리
select * from product where pr_price >= 10000;

# 제품명에 시원한이 들어간 제품을 조회하는 쿼리
select * from product where pr_name like concat('%' , '시원한', '%');

# 카테고리가 옷인 제품을 조회하는 쿼리
select * from product join category on pr_ca_num = ca_num where ca_name = '옷';
select * from product where pr_ca_num = 1; # 강사님이 하신 것. ( join을 사용해서 할 수도 있으나, 해당 문제의 의도는 그게 아니었다. )

# 금액과 제품명을 이용해서 검색하는 쿼리를 일반화해서 만들어보세요.
select * from product where pr_name like concat('%' , '', '%') and pr_price >= 0 ;

SELECT 
    *
FROM
    product
WHERE
    pr_name LIKE CONCAT('%', '', '%')
        AND pr_price >= 0
        AND PR_CA_NUM = 1;

# GROUP BY를 어떤 기준으로 사용하는지 잘 모르겠다.

# 카테고리 별 제품의 평균 가격을 조회하는 쿼리
select CA_NAME 카테고리, AVG(PR_PRICE) from product join category on pr_ca_num = ca_num GROUP BY CA_NAME; # 내가 한 것. ( 비어있을 카테고리를 고려하지 않았다. )
SELECT CA_NAME, FORMAT(IFNULL(AVG(PR_PRICE),0),0) FROM CATEGORY LEFT JOIN PRODUCT ON PR_CA_NUM = CA_NUM GROUP BY CA_NUM; # 강사님이 하신 것.

# 카테고리 별 제품의 평균 가격이 3만원 이상인 카테고리를 조회
select CA_NAME 카테고리, AVG(PR_PRICE) from product join category on pr_ca_num = ca_num GROUP BY CA_NAME HAVING AVG(PR_PRICE) >= 30000; # 내가 한 것, 필기 참고했다.

SELECT CA_NAME, FORMAT(IFNULL(AVG(PR_PRICE),0),0) FROM CATEGORY 
LEFT JOIN PRODUCT ON PR_CA_NUM = CA_NUM 
GROUP BY CA_NUM # 강사님이 하신 것.
HAVING IFNULL(AVG(PR_PRICE),0) >= 30000;

# 카테고리 별 등록된 제품수를 조회
# 못 했다.

SELECT CA_NAME, COUNT(PR_CA_NUM) FROM CATEGORY
LEFT JOIN PRODUCT ON PR_CA_NUM = CA_NUM
GROUP BY CA_NUM; # 강사님이 하신 것.

# 'abc123' 회원이 구매한 제품 정보를 조회
select bu_me_id 구매자, pr_name 제품명, pr_price 가격 from buy join product on bu_pr_code = pr_code; # 내가 한 것, 틀렸다. ( 모든 구매자의 구매정보를 조회했다. 조건으로 특정 회원의 아이디를 추가로 입력해야한다.)

select product.* from buy 
join product on pr_code = bu_pr_code
where bu_me_id = 'abc123' and bu_state in ('구매', '구매 확정');

# 'abc123' 회원의 누적 구매 금액을 조회
select bu_me_id 구매자, format(sum(pr_price),0) 누적금액 from buy join product on bu_pr_code = pr_code group by bu_me_id; # 내가 한 것

select format(sum(pr_price * bu_amount),0) 누적금액 from buy 
join product on pr_code = bu_pr_code
where bu_me_id = 'abc123' and bu_state in ('구매', '구매 확정');

# abc123 회원이 장바구니에 1번 (CLO001) 제품 3개를 담았을 때, 쿼리
# 각 항목이 정확이 무엇에 해당하는지 () 안에 적어주어야 한다.
insert into basket (BA_PR_CODE, BA_ME_ID, BA_AMOUNT) values( 'CLO001' , 'abc123' , 3 );

# abc123 회원이 장바구니에 1번 제품 2개를 담았을 때, 쿼리
# 처음 입력할 때는 INSERT 를 적지만, 이미 있는 것을 변경할 때는 UPDATE 사용한다.
UPDATE BASKET SET BA_AMOUNT = 2 WHERE BA_PR_CODE = 'CLO001' AND BA_ME_ID = 'abc123';

# abc123 회원이 장바구니에 있는 `CLO001` 제품을 2개 구매했을 때, 쿼리
# BUY 테이블에 추가하는 것을 안 했다 ...
# 구매를 완료했으니 장바구니에서 삭제해야한다.
INSERT INTO BUY(BU_PR_CODE, BU_ME_ID, BU_AMOUNT, BU_STATE, BU_DATE) VALUES('CLO001', 'abc123', 2, '구매' ,now());

DELETE FROM BASKET WHERE BA_NUM = 3; # 내가 한 것
DELETE FROM BASKET WHERE BA_ME_ID = 'abc123' AND BA_PR_CODE = 'CLO001'; # 강사님이 하신 것

# 등록된 강의를 조회하는 쿼리
SELECT * FROM LECTURE; # 내가 한 것

# 교수 번호가 2024123001 인 교수님이 강의하는 강의를 조회하는 쿼리
SELECT * FROM LECTURE JOIN PROFESSOR ON LE_PR_NUM = PR_NUM WHERE PR_NUM = 2024123001; # 내가 한 것
SELECT * FROM LECTURE WHERE LE_PR_NUM = '2024123001'; # 강사님이 하신 것

# 학번이 2024123001 인 학생이 수강하는 강의를 조회하는 쿼리
SELECT ST_NAME 학생명, ST_NUM 학번, LE_TITLE 강의 FROM COURSE JOIN STUDENT ON CO_ST_NUM = ST_NUM JOIN LECTURE ON CO_LE_NUM = LE_NUM WHERE ST_NUM = 2024123001; # 내가 한 것

SELECT * FROM LECTURE
JOIN COURSE ON CO_LE_NUM = LE_NUM
WHERE CO_ST_NUM = '2024123001';

# 전공 필수인 강의를 조회하는 쿼리
SELECT * FROM LECTURE WHERE LE_MAJOR = '전공 필수'; # 내가 한 것

# 컴퓨터공학 학생들이 수강하는 강의들을 조회하는 쿼리
# 서브 쿼리를 사용하면 쉽게 해결이 가능하다고 하시는데, 아직 잘 모르겠다.
SELECT ST_NAME 학생명, ST_MAJOR 전공, LE_TITLE 강의명 FROM STUDENT JOIN COURSE ON ST_NUM = CO_ST_NUM JOIN LECTURE ON CO_LE_NUM = LE_NUM WHERE ST_MAJOR = '컴퓨터공학'; # 내가 한 것

SELECT DISTINCT LECTURE.* FROM LECTURE
JOIN COURSE ON CO_LE_NUM = LE_NUM
WHERE CO_ST_NUM IN (SELECT ST_NUM FROM STUDENT WHERE ST_MAJOR = '컴퓨터공학');
