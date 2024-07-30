# 회원 상태를 추가 : 기간 정지, 영구 정지, 사용
INSERT INTO MEMBER_STATE(MS_NAME) 
VALUES ('기간 정지'),('영구 정지'),('사용');
# 신고 타입을 추가
INSERT INTO REPORT_TYPE(RT_NAME) 
VALUES ('욕설'),('허위사실유포'),('광고'),('음란'),('커뮤니티에 맞지 않음'),('기타');
# 공지 커뮤니티를 등록
INSERT INTO COMMUNITY(CO_NAME)
VALUE ('공지');

# 회원가입 / id: abc123, pw: abc123 email: abc123@naver.com
# 회원가입 / id: qwe123, pw: qwe123 email: qwe123@naver.com
# 회원가입 / id: def123, pw: def123 email: def123@naver.com
# 회원가입 / id: admin123, pw: admin123 email: admin123@naver.com

INSERT INTO MEMBER (ME_ID, ME_PW, ME_EMAIL, ME_MS_NAME)VALUES('abc123', 'abc123', 'abc123@naver.com', '사용');
INSERT INTO MEMBER (ME_ID, ME_PW, ME_EMAIL, ME_MS_NAME)VALUES('qwe123', 'qwe123', 'qwe123@naver.com', '사용');
INSERT INTO MEMBER (ME_ID, ME_PW, ME_EMAIL, ME_MS_NAME)VALUES('def123', 'def123', 'def123@naver.com', '사용');
INSERT INTO MEMBER (ME_ID, ME_PW, ME_EMAIL, ME_MS_NAME, ME_AUTHORITY)VALUES('admin123', 'admin123', 'admin123@naver.com', '사용', 'ADMIN');

# 관리자가 '축구', '야구', '배구', '올림픽' 커뮤니티를 추가했을 때, 필요한 쿼리
INSERT INTO COMMUNITY(CO_NAME) VALUE ('축구');
INSERT INTO COMMUNITY(CO_NAME) VALUE ('야구');
INSERT INTO COMMUNITY(CO_NAME) VALUE ('배구');
INSERT INTO COMMUNITY(CO_NAME) VALUE ('올림픽');

# abc123회원이 축구 커뮤니티에 게시글을 2개 작성했습니다. 제목과 내용은 알아서 작성할 것
# INSERT INTO POST (PO_TITLE, PO_CONTENT, PO_ME_ID, PO_CO_NUM)
# SELECT '축구 커뮤니티 활성화 방안', '이하 생략', 'abc123', CO_NUM FROM COMMUNITY WHERE CO_NAME = '축구' 
INSERT INTO POST(PO_TITLE, PO_CONTENT, PO_ME_ID, PO_CO_NUM) VALUES ('리버풀 우승', 'ㅇㅈ', 'abc123', 2);
INSERT INTO POST(PO_TITLE, PO_CONTENT, PO_ME_ID, PO_CO_NUM) VALUES ('맨유 9등', 'ㅇㅈ', 'abc123', 2);
# abc123회원이 야구 커뮤니티에 게시글을 1개 작성했습니다. 제목과 내용은 알아서 작성할 것
INSERT INTO POST(PO_TITLE, PO_CONTENT, PO_ME_ID, PO_CO_NUM) VALUES ('야구는 잘 몰라', '알려줄 사람', 'abc123', 3);
# abc123회원이 배구 커뮤니티에 게시글을 1개 작성했습니다. 제목과 내용은 알아서 작성할 것
INSERT INTO POST(PO_TITLE, PO_CONTENT, PO_ME_ID, PO_CO_NUM) VALUES ('배구는 하이큐', '재밌다', 'abc123', 4);
# abc123회원이 올림픽 커뮤니티에 게시글을 3개 작성했습니다. 제목과 내용은 알아서 작성할 것
INSERT INTO POST(PO_TITLE, PO_CONTENT, PO_ME_ID, PO_CO_NUM) VALUES ('올림픽 하는 줄 몰랐다!', '???', 'abc123', 5);
INSERT INTO POST(PO_TITLE, PO_CONTENT, PO_ME_ID, PO_CO_NUM) VALUES ('올림픽 하는 줄 몰랐다@', '???', 'abc123', 5);
INSERT INTO POST(PO_TITLE, PO_CONTENT, PO_ME_ID, PO_CO_NUM) VALUES ('올림픽 하는 줄 몰랐다#', '???', 'abc123', 5);
# qwe123회원이 축구 커뮤니티에 게시글을 2개 작성했습니다. 제목과 내용은 알아서 작성할 것
INSERT INTO POST(PO_TITLE, PO_CONTENT, PO_ME_ID, PO_CO_NUM) VALUES ('개집', 'ㅇㅈ', 'qwe123', 2);
INSERT INTO POST(PO_TITLE, PO_CONTENT, PO_ME_ID, PO_CO_NUM) VALUES ('맨갈자', 'ㅇㅈ', 'qwe123', 2);
# qwe123회원이 올림픽 커뮤니티에 게시글을 1개 작성했습니다. 제목과 내용은 알아서 작성할 것
INSERT INTO POST(PO_TITLE, PO_CONTENT, PO_ME_ID, PO_CO_NUM) VALUES ('양궁 잘 한다', '또 금메달', 'qwe123', 5);

# qwe123회원이 1번 게시글을 클릭해서 상세를 확인했을 때, 쿼리
	# 게시글의 조회수가 1 증가한다.
UPDATE POST SET PO_VIEW = PO_VIEW + 1 WHERE PO_NUM = 1;
# 1번 게시글에 qwe123회원이 추천을 눌렀을 때, 쿼리
	# 추천을 추가 ( 처음으로 추천이 올라가는 거라서 insert를 사용해야한다. )
INSERT INTO RECOMMEND(RE_STATE, RE_PO_NUM, RE_ME_ID) VALUES (1, 1, 'qwe123');
# 1번 게시글에 qwe123회원이 추천을 눌렀을 때, 쿼리
	# 추천을 취소 => 추천을 수정하는 방법으로.
UPDATE RECOMMEND SET RE_STATE = 0 WHERE RE_PO_NUM = 1 AND RE_ME_ID = 'qwe123';
# 1번 게시글에 qwe123회원이 추천을 눌렀을 때, 쿼리
	# 추천을 취소 => 추천을 삭제하는 방법으로.
DELETE FROM RECOMMEND WHERE RE_PO_NUM = 1 AND RE_ME_ID = 'qwe123';

# 1번 게시글에 qwe123회원이 추천을 눌렀을 때, 쿼리 => 추천을 수정하는 버전 ( 추천했다가 취소했다가 다시 추천한 경우 )
UPDATE RECOMMEND SET RE_STATE = 1 WHERE RE_PO_NUM = 1 AND RE_ME_ID = 'qwe123';

# 1번 게시글에 qwe123회원이 추천을 눌렀을 때, 쿼리 => 추천을 삭제하는 버전 ( 추천했다가 취소했다가 다시 추천한 경우 )
INSERT INTO RECOMMEND(RE_STATE, RE_PO_NUM, RE_ME_ID) VALUES (1, 1, 'qwe123');

/*
취소했을 때, 추천 정보를 수정하는 경우
=> 처음 추천/비추천 => INSERT
=> 이후 추천/비추천 => UPDATE

취소했을 때, 추천 정보를 삭제하는 경우
=> 처음 추천/비추천 => INSERT
=> 추천/비추천을 취소 => DELETE
=> 이후에 추천/비추천 => INSERT
=> 이후에 추천/비추천 => DELETE
*/

# qwe123회원이 1,2,3 게시글은 추천을, 4,5,6번 게시글을 비추천을 눌렀다.
INSERT INTO RECOMMEND(RE_STATE, RE_PO_NUM, RE_ME_ID) 
VALUES (1, 1, 'qwe123'),(1, 2, 'qwe123'),(1, 3, 'qwe123'),(-1, 4, 'qwe123'),
(-1, 5, 'qwe123'),(-1, 6, 'qwe123');
# def123회원이 3,4,5 게시글을 추천, 7,8 게시글을 비추천을 눌렀다.
INSERT INTO RECOMMEND(RE_STATE, RE_PO_NUM, RE_ME_ID) 
VALUES (1, 3, 'def123'),(1, 4, 'def123'),(1, 5, 'def123'),(-1, 7, 'def123'),
(-1, 8, 'def123');
# abc123회원이 1 ~ 8 게시글을 추천
INSERT INTO RECOMMEND(RE_STATE, RE_PO_NUM, RE_ME_ID) 
VALUES (1, 1, 'abc123'),(1, 2, 'abc123'),(1, 3, 'abc123'),(1, 4, 'abc123'),
(1, 5, 'abc123'),(1, 6, 'abc123'),(1, 7, 'abc123'),(1, 8, 'abc123');

# 1번 게시글에 각 회원이 다음 순서로 댓글을 작성. - 는 대댓글.
# abc123 : ㅇㅈ?
INSERT INTO COMMENT(CM_NUM, CM_CONTENT, CM_PO_NUM, CM_ORI_NUM, CM_ME_ID)
SELECT IFNULL(MAX(CM_NUM), 0) + 1, '인정해라', 1, IFNULL(MAX(CM_NUM), 0) + 1 , 'abc123' FROM COMMENT;
# - qwe123 : ㅇㅈ1
INSERT INTO COMMENT(CM_NUM, CM_CONTENT, CM_PO_NUM, CM_ORI_NUM, CM_ME_ID)
SELECT IFNULL(MAX(CM_NUM), 0) + 1, 'ㅇㅈ1', 1, 1 , 'qwe123' FROM COMMENT;
# - def123 : ㅇㅈ2
INSERT INTO COMMENT(CM_NUM, CM_CONTENT, CM_PO_NUM, CM_ORI_NUM, CM_ME_ID)
SELECT IFNULL(MAX(CM_NUM), 0) + 1, 'ㅇㅈ2', 1, 1 , 'def123' FROM COMMENT;
# qwe123 : 이건 인정이지
INSERT INTO COMMENT(CM_NUM, CM_CONTENT, CM_PO_NUM, CM_ORI_NUM, CM_ME_ID)
SELECT IFNULL(MAX(CM_NUM), 0) + 1, '이건 인정이지', 1, IFNULL(MAX(CM_NUM), 0) + 1 , 'qwe123' FROM COMMENT;
# def123 : 이건 인정이지2
INSERT INTO COMMENT(CM_NUM, CM_CONTENT, CM_PO_NUM, CM_ORI_NUM, CM_ME_ID)
SELECT IFNULL(MAX(CM_NUM), 0) + 1, '이건 인정이지2', 1, IFNULL(MAX(CM_NUM), 0) + 1 , 'def123' FROM COMMENT;
# abc123 : 이건 인정이지?
INSERT INTO COMMENT(CM_NUM, CM_CONTENT, CM_PO_NUM, CM_ORI_NUM, CM_ME_ID)
SELECT IFNULL(MAX(CM_NUM), 0) + 1, '이건 인정이지?', 1, IFNULL(MAX(CM_NUM), 0) + 1 , 'abc123' FROM COMMENT;

# 1번 게시글에서 6번 댓글을 '기타'로 qwe123회원이 신고
INSERT INTO REPORT(RP_ME_ID, RP_TABLE, RP_TARGET, RP_RT_NAME)
VALUES ('qwe123', 'comment', 6, '기타');

# 2번 게시글을 def123회원이 기타로 신고
INSERT INTO REPORT(RP_ME_ID, RP_TABLE, RP_TARGET, RP_RT_NAME)
VALUES ('def123', 'post', 2, '기타');