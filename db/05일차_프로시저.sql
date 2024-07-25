
USE university;

# 학과 코드, 이름, 전공이 주어졌을 때 신입생을 등록하는 프로시저

DROP PROCEDURE IF EXISTS INSERT_FRESHMAN;
DELIMITER //

CREATE PROCEDURE INSERT_FRESHMAN(
	IN _MAJOR_CODE CHAR(3),
    IN _MAJOR VARCHAR(15),
    IN _NAME VARCHAR(30) 
)
BEGIN
	DECLARE _YEAR INT;
	DECLARE _NUM CHAR(3);
	DECLARE _ST_NUM CHAR(10);
    
    # 학번을 생성
    # 년 + 학과코드 + 순서
    # 프로시저가 실행될 때, 년도를 가져온다.
    
    SET _YEAR = (SELECT YEAR(NOW()));
    SET _NUM = (SELECT LPAD(COUNT(*)+1, 3, '0') FROM STUDENT WHERE ST_MAJOR = _MAJOR);
    SET _ST_NUM = CONCAT(_YEAR, _MAJOR_CODE, _NUM);
    INSERT INTO STUDENT VALUES (_ST_NUM, _NAME, _MAJOR, 1);
    
END//

DELIMITER ;

# 프로시저 호출
CALL INSERT_FRESHMAN('160', '컴퓨터공학', '논개');

# 결과 확인
SELECT * FROM STUDENT;

-- # 내가 작성한 것
-- # 학번, 강의번호, 중간, 기말, 과제, 출석이 주어지면 학점을 계산해서 추가하는 프로시저를 생성

-- DROP PROCEDURE IF EXISTS UPDATE_POINT;
-- DELIMITER //

-- CREATE PROCEDURE UPDATE_POINT(
-- 	# 학번
--     IN ST_NUM VARCHAR(10),
--     # 강의번호
--     IN LE_NUM CHAR(3),
--     # 중간 : 40%
--     IN CO_MID INT,
--     # 기말 : 40%
--     IN CO_FINALTERM INT,
--     # 과제 : 10%
--     IN CO_HOMEWORK INT,
--     # 출석 : 10%
--     IN CO_ATTENDANCE INT
-- )
-- BEGIN
--     # 최종 성적이 95점이상 A+, 90점이상 A, 85점이상 B+ ..., 60미만 F
--     
--     SET ST_NUM = (SELECT ST_NUM FROM STUDENT);
--     SET LE_NUM = (SELECT LE_NUM FROM LECTURE);
--     SET CO_MID = (SELECT CO_MID FROM COURSE);
--     SET CO_FINALTERM = (SELECT CO_FINALTERM FROM COURSE);
--     SET CO_HOMEWORK = (SELECT CO_HOMEWORK FROM COURSE);
--     SET CO_ATTENDANCE = (SELECT CO_ATTENDANCE FROM COURSE);
--     
--     SET CO_POINT 
-- 		= ((CO_MID * 0.4) + (CO_FINALTERM * 0.4) + (CO_HOMEWORK * 0.1 ) + (CO_ATTENDANCE * 0.1));
--     
--     IF CO_POINT >= 95 THEN
--     
--     # 실행문은 최종성적을 COURSE 테이블의 CO_TOTAL 값에 입력하도록 작성해야한다. ( 모르겠다, 지금 작성한게 맞는지도 모르겠다. )
--     
-- 		실행문 A+;
-- 		ELSEIF CO_POINT >= 90 AND CO_POINT < 95 THEN
--         실행문 A;
--         ELSEIF CO_POINT >= 85 AND CO_POINT < 90 THEN
--         실행문 B+;
--         ELSEIF CO_POINT >= 80 AND CO_POINT < 85 THEN
--         실행문 B;
-- 		ELSEIF CO_POINT >= 75 AND CO_POINT < 80 THEN
--         실행문 C+;
--         ELSEIF CO_POINT >= 70 AND CO_POINT < 75 THEN
--         실행문 C;
--         ELSEIF CO_POINT >= 65 AND CO_POINT < 70 THEN
--         실행문 D+;
--         ELSEIF CO_POINT >= 60 AND CO_POINT < 65 THEN
--         실행문 D;
--         ELSEIF CO_POINT < 60 THEN
--         실행문 F;
-- END//

-- DELIMITER ;

# 강사님 풀이
# 학과 코드, 이름, 전공이 주어졌을 때 신입생을 등록하는 프로시저

DROP PROCEDURE IF EXISTS UPDATE_POINT;
DELIMITER //

CREATE PROCEDURE UPDATE_POINT(

	# 학번
    IN _ST_NUM CHAR(10),
    # 강의번호
    IN _LE_NUM INT, 
    # 중간 : 40%
    IN _MID INT,
    # 기말 : 40%
    IN _FINAL INT,
    # 과제 : 10%
    IN _HOMEWORK INT,
    # 출석 : 10%
    IN _ATTENDANCE INT

)
BEGIN
	# 최종 성적이 95점이상 A+, 90점이상 A, 85점이상 B+ ..., 60미만 F
    
    # 총점을 저장할 변수를 선언
    DECLARE _TOTAL INT;
    # 학점을 저장할 변수를 선언
    DECLARE _POINT VARCHAR(2);
    # 총점을 계산해서 저장
    SET _TOTAL = _MID * 0.4 + _FINAL * 0.4 + _HOMEWORK * 0.1 + _ATTENDANCE * 0.1;
    # 총점이 95점 이상이면 A+
	IF _TOTAL >= 95 THEN
		SET _POINT = 'A+';
    # 총점이 90점 이상이면 A
    ELSEIF _TOTAL >= 90 THEN
		SET _POINT = 'A';
    # 총점이 85점 이상이면 B+
    ELSEIF _TOTAL >= 85 THEN
		SET _POINT = 'B+';
    # 총점이 80점 이상이면 B
    ELSEIF _TOTAL >= 80 THEN
		SET _POINT = 'B';
    # 총점이 75점 이상이면 C+
    ELSEIF _TOTAL >= 75 THEN
		SET _POINT = 'C+';
    # 총점이 70점 이상이면 C
    ELSEIF _TOTAL >= 70 THEN
		SET _POINT = 'C';
    # 총점이 75점 이상이면 D+
    ELSEIF _TOTAL >= 65 THEN
		SET _POINT = 'D+';
    # 총점이 60점 이상이면 D
    ELSEIF _TOTAL >= 60 THEN
		SET _POINT = 'D';
    # 아니면 F
    ELSE
		SET _POINT = 'F';
	END IF;
    
    UPDATE COURSE
    SET 
		CO_MID = _MID,
        CO_FINALTERM = _FINAL,
        CO_HOMEWORK = _HOMEWORK,
        CO_ATTENDANCE = _ATTENDANCE,
		CO_TOTAL = _POINT
    WHERE
		# 이 조건을 만족하는게 없으면 쿼리가 실행되긴해도, 입력되는 건 없다. co_le_num 이 만족하는게 없어서 실행은 되었으나 입력이 되어있는 건 없었다.
		CO_ST_NUM = _ST_NUM AND CO_LE_NUM = _LE_NUM;
END//

DELIMITER ;

CALL UPDATE_POINT('2024160005', 1, 90, 80, 70, 50);

# 프로시저 확인
SHOW PROCEDURE STATUS;
# 프로시저 스크립트 확인
SHOW CREATE PROCEDURE UPDATE_POINT;

#

USE CGV;
# 예매자 아이디, 예매 상영시간번호, 성인 수, 청소년 수가 주어지면 티켓을 예매하는 프로시저를 생성하고 테스트

DROP PROCEDURE IF EXISTS TICKETING;
DELIMITER //

CREATE PROCEDURE TICKETING(
	
    IN _ID VARCHAR(15),
    IN _SD_NUM INT,
    IN _ADULT INT, 
    IN _TEENAGER INT
    
)
BEGIN
	
    DECLARE _ADULT_PRICE INT;
    DECLARE _TEENAGER_PRICE INT;
    DECLARE _MORNING INT;
    
    # 조조영화여부를 가져온다 ( 1:조조, 0: X )
    
    SET _MORNING = (SELECT SD_EARYLY FROM SCHEDULE WHERE SD_NUM = _SD_NUM);
    
    CASE _MORNING
		WHEN 1 THEN
			SET _ADULT_PRICE = (SELECT PR_PRICE * _ADULT FROM PRICE WHERE PR_TYPE = '조조 성인');
            SET _TEENAGER_PRICE = (SELECT PR_PRICE * _TEENAGER FROM PRICE WHERE PR_TYPE = '조조 청소년');
        ELSE
			SET _ADULT_PRICE = (SELECT PR_PRICE * _ADULT FROM PRICE WHERE PR_TYPE = '성인');
            SET _TEENAGER_PRICE = (SELECT PR_PRICE * _TEENAGER FROM PRICE WHERE PR_TYPE = '청소년');
	END CASE;
    INSERT INTO TICKETING 
    VALUES(NULL, _ADULT, _TEENAGER, _ADULT_PRICE + _TEENAGER_PRICE, _ID, _SD_NUM);
END//

DELIMITER ;

CALL TICKETING('abc123', 3, 3, 0);