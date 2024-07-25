
USE CGV;

# 상영시간에 예약 가능한 초기 좌석 수를 상영관 좌석 수로 수정
UPDATE SCHEDULE
        JOIN
    SCREEN ON SC_NUM = SD_SC_NUM 
SET 
    SD_POSSIBLE = SC_SEAT;
    
# 예약된 좌석만큼 상영시간에서 예약 가능한 좌석 수를 빼서 수정하는 쿼리

# 1번 스케줄에 예매된 좌석 수만큼 1번 스케줄의 좌석을 수정하는 쿼리

UPDATE 
	SCHEDULE
SET 
	SD_POSSIBLE = SD_POSSIBLE - (SELECT SUM(TI_ADULT + TI_TEENAGER) FROM TICKETING WHERE TI_SD_NUM = 1)
WHERE
	SD_NUM = 1;
    
# 예매가 발생하면 예매한 상영에서 예약 가능한 좌석 수를 수정하는 트리거

DROP TRIGGER IF EXISTS TICKETING_INSERT;

DELIMITER //

CREATE TRIGGER TICKETING_INSERT
AFTER INSERT ON TICKETING
FOR EACH ROW
BEGIN
	
    # 예매된 성인 수와 청소년 수 만큼 좌석의 수를 조정
    
    UPDATE 
	SCHEDULE
	SET 
		SD_POSSIBLE = SD_POSSIBLE - (NEW.TI_ADULT + NEW.TI_TEENAGER)
	WHERE
		SD_NUM = NEW.TI_SD_NUM;

END //
DELIMITER ;

INSERT INTO TICKETING VALUES ( NULL, 2, 2, 48000, 'abc123', 2);

INSERT INTO TICKETING_LIST VALUES(NULL, 1, 2), (NULL, 2, 2), (NULL, 3, 2), (NULL, 4, 2);

SHOW TRIGGERS;