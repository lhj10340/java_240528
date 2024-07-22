# DB 삭제 (university)
drop database if exists university;
# DB 생성 (university)
create database if not exists university;

use university;

# student 테이블 삭제
drop table if exists student;
# student 테이블 추가
# 학번, 이름, 전공, 학년
create table if not exists student(
	st_num char(10) primary key,
    st_name varchar(30) not null,
    st_major varchar(15) not null,
    st_grade int not null default 1
    );
    
# professor 테이블 삭제
drop table if exists professor;
# professor 테이블 추가
# 교번, 이름(30자), 전공(15자), 교수실(100자)
create table if not exists professor(
	pr_num char(10) primary key,
    pr_name varchar(30) not null,
    pr_major varchar(15) not null,
    pr_room varchar(100) 
    );
    
# lecture 테이블 삭제
drop table if exists lecture;
# lecture 테이블 추가
# 강의 번호(PK), 강의명(30자), 강의실(100자), 강의 시간(시간표, 최대 50자),
# 학점, 시수, 전공 여부(전공 선택, 전공 필수, 교양 선택, 교양 필수), 교수 번호(FK)
create table if not exists lecture(
	le_num int primary key auto_increment,
    le_title varchar(30) not null,
    le_major char(5) not null,
    le_room varchar(100) not null,
    le_schedule varchar(50),
    le_point int,
    le_time int,
    le_pr_num char(10),
    foreign key(le_pr_num) references professor(pr_num)
    );
    
# 수강 테이블 삭제
drop table if exists course;
# course 테이블 추가
# 수강번호(PK), 중간, 기말, 과제, 학점, 출석, 학번(FK), 강의 번호(FK)) // default 값을 적지 않았었다.
create table if not exists course(
	co_num int primary key auto_increment,
    co_mid int default 0,
    co_finalTerm int default 0,
    co_perform int default 0,
    co_homework int default 0,
    co_total varchar(2) default 'F',
    co_attendance int default 0, 
    co_st_num char(10),
    foreign key(co_st_num) references student(st_num),
    co_le_num int,
    foreign key(co_le_num) references lecture(le_num)
    );
    
# 연락처 테이블 삭제
drop table if exists contact;
# 연락처 번호(PK), 주소(100자), 상세 주소 (100자), 전화번호 (최대 13자), 학번(FK)
create table if not exists contact(
	ct_num int primary key auto_increment,
    ct_addr varchar(100) not null,
    ct_detail varchar(100),
    ct_phone varchar(13) not null,
    ct_st_num char(10) not null,
    foreign key(ct_st_num) references student(st_num)
    );
    
/*
전공
컴퓨터 공학 : 160
화학 공학 : 135
기계 공학 : 123
전공이 컴퓨터 공학인 신입생이 5명이고, 5명을 등록하는 쿼리
홍길동(5), 임꺽정(4), 유재석(3), 둘리(2), 고길동(1)

전공이 화학 공학인 신입생이 3명 있고, 3명을 등록하는 쿼리
나영석(2), 강호동(1), 이둘리(3)

전공이 기계 공학인 신입생이 3명 있고, 3명을 등록하는 쿼리
가나다(1), 박둘리(3), 마둘리(2)
학번은 계산해서 넣으세요

신입생이라 1학년이다. default 값이 있으니까 비워놓아도 된다.

*/

insert into student(st_num, st_name, st_major, st_grade)
values (2024160001, '고길동', '컴퓨터공학', 1), (2024160002, '둘리', '컴퓨터공학', 1), (2024160003, '유재석', '컴퓨터공학', 1),
		(2024160004, '임꺽정', '컴퓨터공학', 1), (2024160005, '홍길동', '컴퓨터공학', 1);
        
insert into student(st_num, st_name, st_major, st_grade)
values  (2024135001, '강호동', '화학공학', 1), (2024135002, '나영석', '화학공학', 1), (2024135003, '이둘리', '화학공학', 1);

insert into student(st_num, st_name, st_major, st_grade)
values (2024123001, '가나다', '기계공학', 1), (2024123002, '마둘리', '기계공학', 1), (2024123003, '박둘리', '기계공학', 1);

# 신입교수 박교수 3관 101호 컴퓨터공학
insert into professor(pr_num, pr_name, pr_major, pr_room)
value('2024160001', '박교수', '컴퓨터공학', '3관 101호');
# 신입교수 이교수 3관 201호 화학공학
insert into professor(pr_num, pr_name, pr_major, pr_room)
value('2024135001', '이교수', '화학공학', '3관 201호');
# 신입교수 김교수 3관 301호 기계공학
insert into professor(pr_num, pr_name, pr_major, pr_room)
value('2024123001', '김교수', '기계공학', '3관 301호');

# 강의 등록
# 컴퓨터개론, 전공 필수, 1관 101호, 월1A, 1B, 2A, 2B, 2, 2, 2024160001
insert into lecture
value(null, '컴퓨터개론', '전공 필수' , '1관 101호', '월1A, 1B, 2A, 2B', 2, 2, 2024160001); 
# 프로그래밍언어, 전공 필수, 1관 101호, 월5A,5B,6A,6B,수5A,6A,6B, 3,4, 20241600001
insert into lecture
value(null, '프로그래밍언어', '전공 필수' , '1관 101호', '월5A,5B,6A,6B,수5A,6A,6B', 3, 4, 2024160001); 
# 화학기초, 전공 필수, 2관 101호, 화1A,1B,2A,2B,금1A,1B,2A,2B, 3, 4, 2024135001
insert into lecture
value(null, '화학기초', '전공 필수' , '2관 101호', '화1A,1B,2A,2B,금1A,1B,2A,2B', 3, 4, 2024135001); 
# 동역학, 전공 필수, 4관 101호, 수1A,1B,2A,2B,3A,3B,4A,4B, 3, 4, 2024123001
insert into lecture
value(null, '동역학', '전공 필수' , '4관 101호', '수1A,1B,2A,2B,3A,3B,4A,4B', 3, 4, 2024123001);

#수강 등록
# 수강번호(PK), 중간, 기말, 과제, 학점, 출석, 학번(FK), 강의 번호(FK))

select * from student;
select * from lecture;

# 컴공 고길동, 임꺽정 학생은 컴퓨터 개론, 프로그래밍 언어를 수강 신청
insert into course(co_st_num, co_le_num)
values ('2024160001', 1), ('2024160004', 1), ('2024160001', 2), ('2024160004', 2);
# 컴공 둘리, 홍길동 학생은 컴퓨터 개론을 수강 신청
insert into course(co_st_num, co_le_num)
values ('2024160002', 1), ('2024160005', 1);
# 컴공 유재석 학생은 프로그래밍 언어를 수강 신청
insert into course(co_st_num, co_le_num)
values ('2024160003', 2);
# 화공 강호동, 나영석 학생은 화학기초를 수강 신청
insert into course(co_st_num, co_le_num)
values ('2024135002', 3), ('2024135001', 3);
# 기계 가나다, 마둘리, 박둘리 학생은 동역학을 수강 신청
insert into course(co_st_num, co_le_num)
values ('2024123001', 4), ('2024123002', 4), ('2024123003', 4);
# 기계 가나다 학생은 프로그래밍언어를 수강 신청
insert into course(co_st_num, co_le_num)
values ('2024123001', 2);