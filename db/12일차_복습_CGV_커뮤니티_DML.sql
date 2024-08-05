# 등록된 모든 영화를 조회하는 쿼리
select * from movie;

# 등록된 모든 영화를 조회하는 쿼리(장르도 함께 검색, 장르 때문에 같은 영화 제목이 여러번 나온다.)
select * from movie join movie_genre on mg_mo_num = mo_num;

# 장르가 액션인 영화를 조회하는 쿼리
select * from movie join movie_genre on mg_mo_num = mo_num where mg_ge_name = '액션';

# 장르가 액션인 영화를 조회하는 쿼리 (join을 이용하지 않고, 서브쿼리를 이용하여 검색하는 방법)
select * from movie where mo_num in (select mg_mo_num from movie_genre where mg_ge_name = '액션');

# 장르가 액션으로 등록된 영화 수를 조회하는 쿼리
select mg_ge_name 장르 , count(mg_mo_num) 영화수 from movie_genre where mg_ge_name = '액션' group by mg_ge_name;

# 모든 장르에 등록된 영화의 수를 조회하는 쿼리 (단, 영화가 등록되지 않은 장르들은 조회가 되지 않도록 할 것)
select * from movie_genre; # 내가 한 것.
select mg_ge_name 장르 , count(mg_mo_num) 영화수 from movie_genre group by mg_ge_name; # 강사님이 하신 것

# 모든 장르에 등록된 영화의 수를 조회하는 쿼리 (단, 영화가 등록되지 않은 장르들도 조회가 되도록)
select * from genre left join movie_genre on mg_ge_name = ge_name; # 내가 한 것.
select mg_ge_name 장르 , count(mg_mo_num) 영화수 from movie_genre right join genre on mg_ge_name = ge_name group by ge_name; # 강사님이 하신 것

# 등록된 영화를 이름순으로 6개 조회하는 쿼리 (내림차순, 1페이지)
select * from movie order by mo_title desc limit 0, 6; # 내가 필기 찾아보고 한 것. ( = 강사님이 하신 것도 동일했다, 잘 찾았다! )

# 등록된 영화를 이름순으로 6개 조회하는 쿼리 (내림차순, 2페이지)
# 1번지에 6개, 0 ~ 5 (6개) 그래서 6번지부터 시작해야한다.
select * from movie order by mo_title desc limit 6, 6;

# 데드풀과 울버린을 관랑한 관객 수를 조회하는 쿼리
select * from movie join schedule on mo_num = sd_mo_num join ticketing on ti_sd_num = sd_num; # 내가 한 것.

select * from ticketing join schedule on ti_sd_num = sd_num; # 강사님이 하신 것.

select '데드풀과 울버린' 영화제목, sum(ti_adult + ti_teenager) 관객수 
from ticketing 
join schedule on ti_sd_num = sd_num 
where sd_mo_num = ( select mo_num from movie where mo_title = '데드풀과 울버린')
group by sd_mo_num; # 강사님이 하신 것 (서브쿼리 이용)

# 영화별 관객수를 조회하는 쿼리
# 고민하다가 못 했다.
select mo_title 영화제목, sum(ti_adult + ti_teenager) 관객수 
from ticketing 
right join schedule on ti_Sd_num = sd_num
right join movie on sd_mo_num = mo_num
group by mo_num; # 강사님이 하신 것.

# 데드풀과 울버린 영화 상영시간을 조회하는 쿼리
select * from movie join schedule on sd_mo_num = mo_num; # 내가 한 것.
select * from schedule where sd_mo_num in (select mo_num from movie where mo_title = '데드풀과 울버린'); # 강사님이 하신 것 (서브쿼리 이용)

# 데드풀과 울버린 상영시간을 조회하는 쿼리 ( 7/27 오후 상영시간을 조회 )
# 고민하다가 못 했다.
select * from schedule where sd_mo_num in (select mo_num from movie where mo_title = '데드풀과 울버린')
	and sd_date = '2024-07-27' and sd_time > '12:00:00';
    
# 2번 상영시간에 예약된 좌석을 조회하는 쿼리
# 제대로 틀렸다.
select se_name from ticketing_list
join ticketing on tl_ti_num = ti_num
join seat on tl_se_num = se_num
where ti_sd_num = '2';
    
# 2번 상영시간에 예약 가능한 좌석을 조회하는 쿼리
# 제대로 틀렸다.
select se_name from schedule 
join screen on sd_sc_num = sc_num 
join seat on sc_num = se_sc_num
where sd_num = 2 and se_name not in (
	select se_name from ticketing_list
	join ticketing on tl_ti_num = ti_num
	join seat on tl_se_num = se_num
	where ti_sd_num = '2'
);

# 휴 잭맨이 참여한 영화 목록을 조회하는 쿼리
# 못 했다.
SELECT 
    MO_TITLE
FROM
    movie
        JOIN
    casting ON cs_mo_num = mo_num
        JOIN
    `character` ON CH_NUM = CS_CH_NUM
        JOIN
    PERSON ON PS_NUM = CH_PS_NUM
		WHERE PS_NAME = '휴 잭맨'; # 강사님이 하신 것
        
# CGV 강남에서 상영했거나 상영중, 상영예정인 영화들을 조회하는 쿼리
SELECT 
    *
FROM
    MOVIE
        JOIN
    SCHEDULE ON SD_MO_NUM = MO_NUM
        JOIN
    SCREEN ON SD_SC_NUM = SC_NUM
        JOIN
    THEATER ON SC_TH_NUM = TH_NUM
WHERE
    SC_TH_NUM = '1'; # 내가 한 것.

SELECT 
    DISTINCT MO_TITLE
FROM
    MOVIE
        JOIN
    SCHEDULE ON SD_MO_NUM = MO_NUM
        JOIN
    (SELECT * FROM SCREEN WHERE SC_TH_NUM = (SELECT TH_NUM FROM THEATER WHERE TH_NAME = 'CGV강남')) SC ON SD_SC_NUM = SC_NUM;
    
    # 강사님이 하신 것 ( JOIN 이 편하지만 자료가 많아지는 경우, 많이 썼을 때 느려질 수 있다. 그럴 때 서브쿼리를 사용하여 속도를 늘려야한다. )
    
# COMMUNITY!

# 게시글을 조회하는 쿼리(번호 내림차순, 3개, 1페이지)
SELECT * FROM POST ORDER BY PO_NUM DESC LIMIT 0, 3; # ( 내가 한 것, 강사님이 하신 것 동일! )

# 게시글 제목에 '구'가 들어가는 게시글을 조회하는 쿼리(번호 내림차순, 3개 , 1페이지)
SELECT * FROM POST WHERE PO_TITLE LIKE ('%구%') ORDER BY PO_TITLE DESC LIMIT 0,3; # 내가 한 것
SELECT * FROM POST WHERE PO_TITLE LIKE CONCAT ('%','구','%') ORDER BY PO_TITLE DESC LIMIT 0,3; # 강사님이 하신 것

# 축구 커뮤니티에 등록된 게시글을 조회하는 쿼리 (커뮤니티 번호가 2번)
SELECT * FROM COMMUNITY JOIN POST ON PO_CO_NUM = CO_NUM WHERE CO_NUM = 2; # 내가 한 것

SELECT * FROM POST WHERE PO_CO_NUM = 2; # 강사님이 하신 것

# 1번 게시글의 댓글들을 조회하는 쿼리 (단, 대댓글은 댓글의 다음에 와야 한다.)
/*
댓글1
	- 댓글1-1
	- 댓글1-2
	- 댓글1-3
댓글2
*/
# 못 했다.
SELECT * FROM COMMENT WHERE CM_PO_NUM = 1 ORDER BY CM_ORI_NUM, CM_NUM; # 강사님이 하신 것

# 1번 게시글의 댓글 1페이지를 조회하는 쿼리(한 페이지에 5개)
SELECT * FROM COMMENT WHERE CM_PO_NUM = 1 order by cm_ori_num, cm_num limit 0,5;

# 게시글을 조회(조회수가 많은 순으로 조회할 것) - 알아두면 좋을 쿼리. 잘 알아둘 것!
select * from post order by po_view desc;

# 게시글을 조회(조회수가 많은 순으로 조회할 것, 조회순으로 했을 때, 3위 게시글까지 조회, rank()를 이용)
select *, rank() over(order by po_view desc) from post; # 내가 한 것 ( 맞았나 모르겠다. )

select * from (select rank() over(order by po_view desc) as ranking, post.* from post) as po 
where ranking <= 3;  # 강사님이 하신 것