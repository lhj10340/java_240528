# 데드풀과 울버린 영화의 CGV강남에서 7/27에 상영하는 상영시간표를 조회하는 쿼리

-- SELECT * FROM THEATER
-- 	JOIN SCREEN
--     ON th_num = sc_th_num
--     JOIN SCHEDULE
--     ON sc_num = sd_sc_num
--     JOIN MOVIE
--     ON sd_mo_num = mo_num
--     where mo_title = 데드풀과 울버린, sd_date = '2024-07-27';

select mo_title 영화, th_name 영화관, sc_name 상영관, sd_date 상영일, sd_time 상영시간 from 
	schedule
    join screen on sd_sc_num = sc_num
    join theater on sc_th_num = th_num
    join movie on sd_mo_num = mo_num
where 
sd_date = '2024-07-27' and th_name = 'CGV강남' and mo_title = '데드풀과 울버린';

# 서브 쿼리를 이용
	SELECT 
    * 
    FROM 
		SCHEDULE
			JOIN 
        SCREEN ON SD_SC_NUM = SC_NUM
			JOIN 
		(SELECT * FROM THEATER WHERE TH_NAME = 'CGV강남') TH
            ON SC_TH_NUM = TH_NUM
            JOIN
		(SELECT * FROM MOVIE WHERE MO_TITLE = '데드풀과 울버린') MO
			ON MO_NUM = SD_MO_NUM
	WHERE
		SD_DATE = '2024-07-27';

# CGV강남 1관에 등록된 좌석을 조회하는 쿼리

SELECT TH_NAME 극장명, SC_NAME 상영관명, SE_NAME 좌석
	FROM SEAT
	JOIN SCREEN
    ON SE_SC_NUM = SC_NUM
    JOIN THEATER
    # 이 부분의 앞뒤 순서가 강사님꺼는 바뀌어 있다.
    ON SC_TH_NUM = TH_NUM
WHERE TH_NAME = 'CGV강남' AND SC_NAME = '1관';

# abc123 회원이 예약한 예매 내역을 조회하는 쿼리
-- select me_id 회원id, tl_num 예매내역
--  from ticketing_list
-- 	join ticketing
--     on tl_ti_num = ti_num
--     join member
--     on ti_me_id = me_id
-- where me_id = 'abc123'

select
	mo_title 영화, sd_date 일시, sd_time 시간, th_name 극장, sc_name 상영관, se_name 좌석
from
	ticketing
    join ticketing_list on ti_num = tl_ti_num
    join seat on se_num = tl_se_num
    join schedule on sd_num = ti_sd_num
    join screen on sd_sc_num = sc_num
    join theater on th_num = sc_th_num
    join movie on sd_mo_num = mo_num
where
	ti_me_id = 'abc123';

# 1번 스케줄에 예약된 좌석을 조회하는 쿼리

SELECT 
    SE_NAME '예약된 좌석번호'
FROM
    (SELECT * FROM ticketing WHERE TI_SD_NUM = 1) TT
    JOIN
		ticketing_list ON TI_NUM = TL_TI_NUM
	JOIN
		SEAT ON TL_SE_NUM = SE_NUM;
        
# CGV강남점 1관의 좌석을 조회하는 쿼리
# 1번 상영관에 좌석들을 조회하는 쿼리

SELECT 
    *
FROM
    SEAT
WHERE
    SE_SC_NUM = 1;
    
# 데드풀과 울버린 CGV강남점 1관 7/27 첫번째에 예약된 좌석을 조회하는 쿼리
# 1번 스케줄에 예약 가능한 1번 상영관 좌석을 조회하는 쿼리
# !1번 스케줄에 예약된 좌석 + 1번 상영관 좌석

SELECT 
    SE_NAME
FROM
    SEAT
WHERE
    SE_SC_NUM = 1 AND SE_NAME NOT IN(SELECT 
    SE_NAME
FROM
    (SELECT * FROM ticketing WHERE TI_SD_NUM = 1) TT
    JOIN
		ticketing_list ON TI_NUM = TL_TI_NUM
	JOIN
		SEAT ON TL_SE_NUM = SE_NUM);
        
# 1번 스케줄에서 예약 가능한 좌석들의 수를 조회

SELECT 
    SE_SC_NUM '상영관' , COUNT(SE_NAME) '예약가능좌석'
FROM
    SEAT
WHERE
    SE_SC_NUM = 1 AND SE_NAME NOT IN(SELECT 
    SE_NAME
FROM
    (SELECT * FROM ticketing WHERE TI_SD_NUM = 1) TT
    JOIN
		ticketing_list ON TI_NUM = TL_TI_NUM
	JOIN
		SEAT ON TL_SE_NUM = SE_NUM);
        
# 장르별 등록된 영화 개수를 조회하는 쿼리

-- SELECT 
--     GE_NAME '장르명', COUNT(MO_TITLE) '영화개수'
-- FROM
--     GENRE
--         JOIN
--     MOVIE_GENRE ON GE_NAME = MG_GE_NAME
--         JOIN
--     MOVIE ON MO_NUM = MG_MO_NUM;

SELECT 
    ge_name 장르, count(mg_num) 영화수
FROM
    movie_genre
        right JOIN
    genre on ge_name = mg_ge_name
group by ge_name;

# 개봉한 영화를 조회하는 쿼리
# group by 잘 모르겠다.

-- SELECT 
--     mo_date 개봉일, count(mo_num) 개봉영화수
-- FROM
--     movie
-- where mo_date >= '2024-07-24'
-- group by mo_date;

SELECT 
    *
FROM
    movie
WHERE
    mo_date <= NOW();
    
# 오늘부터 한달 사이에 개봉한 영화를 조회하는 쿼리

-- SELECT 
--     *
-- FROM
--     movie
-- WHERE
--     mo_date <= NOW() and mo_date >= date_sub(now(), interval 1 month);

SELECT 
    *
FROM
    movie
WHERE
    mo_date between date_sub(now(), interval 1 month) and now();