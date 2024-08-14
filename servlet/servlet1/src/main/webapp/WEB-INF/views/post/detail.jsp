<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>

<jsp:include page="/WEB-INF/views/common/head.jsp"/>
<style type="text/css">
.comment-list{
	list-style : none; padding: 0;
}
.comment-list>.comment-item{
	margin-bottom: 20px;
}
.comment-list>.comment-item.reply{
	padding-left: 50px;
}
</style>
</head>
<body>

<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<div class="container">
	<h1>게시글 상세</h1>
		<div class="form-group">
			<label for="title">제목 :</label> 
			<input type="text" class="form-control"  value="${post.po_title}">
		</div>
		<div class="form-group">
			<label for="title">작성자 :</label> 
			<input type="text" class="form-control"  value="${post.po_me_id}">
		</div>
		<div class="form-group">
			<label for="title">작성일 :</label> 
			<input type="text" class="form-control"  value="<fmt:formatDate value="${post.po_date}" pattern="yyyy-MM-dd HH:mm:ss" />">
		</div>
		<div class="form-group">
			<label for="title">조회수 :</label> 
			<input type="text" class="form-control"  value="${post.po_view}">
		</div>
		<div style="text-center">
		
			<a href="#" data-state="1"
				 class="btn-up btn btn<c:if test="${re.re_state ne 1 }">-outline</c:if>-danger">추천(<span>${post.po_up }</span>)</a>
			<a href="#" data-state="-1"
				 class="btn-down btn btn<c:if test="${re.re_state ne -1 }">-outline</c:if>-danger">비추천(<span>${post.po_down }</span>)</a>
				 
		</div>
		<div class="form-group">
			<label for="content">내용 :</label> 
			<div class="form-control" style="min-height: 400px">${post.po_content}</div>
		</div>
		<hr>
		<div>
		<h3>댓글 목록</h3>
			<ul class="comment-list">
				<li class="comment-item">
					<div>작성자 아이디(시간)</div>
					<div>댓글 내용</div>
				</li>
				<li class="comment-item reply">
					<div>작성자 아이디(시간)</div>
					<div>대댓글 내용</div>
				</li>
			</ul>
			<div class="comment-pagination"></div>
		</div>
		
		<a href="<c:url value="/post/list?co_num=${post.po_co_num }"/>" class="btn btn-outline-primary">목록</a>
		<c:if test="${user ne null && post.po_me_id eq user.me_id }">
			<a href="<c:url value="/post/update?po_num=${post.po_num }"/>" class="btn btn-outline-warning">수정</a>
		</c:if>
		<c:if test="${user ne null && post.po_me_id eq user.me_id }">
			<a href="<c:url value="/post/delete?po_num=${post.po_num }"/>" class="btn btn-outline-danger">삭제</a>
		</c:if>
</div>
<script type="text/javascript">
var cri = {
		num : '${post.po_num}',
		page : 1
}

getCommentList(cri);

// 추천과 비추천 버튼 클릭이벤트
	$('.btn-up, .btn-down').click(function(e){
		// preventDefault 는 태그의 고유 속성을 없애준다.
		e.preventDefault()
		
		if('${user.me_id}' == ''){
			if(confirm('로그인이 필요한 서비스입니다. \n 로그인 페이지로 이동하시겠습니까?')){
				location.href = '<c:url value="/login"/>';
				return;
			}else{
				return;
				}
			}
		
		let state = $(this).data('state');
		let num = '${post.po_num}';
		$.ajax({
			url : '<c:url value="/post/recommend"/>',
			method : "get", //원하는 방식 선택
			data : { //보낸 데이터를 객체로
				state : state,
				num : num
			},
			success : function(data){
				let res = data.result;
				if(res == 1){
					alert('추천했습니다.');
				}else if(res == -1){
					alert('비추천했습니다.');
				}else{
					alert(`\${state == 1?'추천':'비추천'}을 취소했습니다.`);
				}
				checkRecommendBtns(res);
				let post = JSON.parse(data.post);
				$('.btn-up span').text(post.po_up);
				$('.btn-down span').text(post.po_down);
			}, 
			error : function(xhr, status, error){
				//xhr : XHLHttpRequest 객체, 요청과 관련된 정보를 제공
				//status :HTTP 상태 코드, 요청이 실패한 원인
				//error : 에러에 대한 추가 정보
				console.log("error")
			}
		});
	})
	
// 댓글 페이지네이션 클릭 이벤트
$(document).on('click', ".pagination .page-item", function(){
	if($(this).hasClass('disabled')){
		return;
	}
	let page = $(this).data('page');
	cri.page = page;
	getCommentList(cri);
	});
	
	
	
	
// 해당 게시글의 추천/비추천에 따라 각 버튼의 색상을 채워주는 함수
function checkRecommendBtns(state){
		$('.btn-up, .btn-down').removeClass('btn-danger');
		$('.btn-up, .btn-down').removeClass('btn-outline-danger');
		if(state != 0){
			$(state == 1?'.btn-up':'.btn-down').removeClass('btn-outline-danger')
			$(state == 1?'.btn-up':'.btn-down').addClass('btn-danger')
		}
	}
	
function getCommentList(cri){
	console.log(cri)
	$.ajax({
		url : '<c:url value="/comment/list"/>',
		method : "post",
		// 그냥 입력하는 것과 객체를 입력하는 것과는 다르다. 변경이 가능하다. cri.page = 2 와 같이 ...
		data : cri,
		success : function(data){
			let list = data.list;
			console.log(data);
			displayCommentList(list);
			let pm = JSON.parse(data.pm);
			displayPagnation(pm);
		}, 
		error : function(xhr, status, error){
			console.log("에러 발생");
			// 404 get 지원하지 않을 때,
			// 405 post 지원하지 않을 때,
			console.log(xhr.responseText);
		}
	});
}

function displayPagnation(pm){
	if(pm.totalCount == 0){
		return;
	}
	console.log(pm)
	str = `
	<ul class="pagination justify-content-center">`;
	
	var disabled = pm.prev ? '' : 'disabled'
		str +=
	    `<li class="page-item \${disabled}" data-page="\${pm.startPage-1}">
	    	<a class="page-link" href="javascript:void(0);">이전</a>
	    </li>`;
	
	    // javascript:void(0); 는 preventDefault 와 동일한 효과 : 동작을 안하게 한다.
	    
	for(var i = pm.startPage; i<=pm.endPage; i++){
		var active = pm.cri.page == i ? 'active' : '';
		str +=
	    `<li class="page-item \${active}"  data-page="\${i}">
	    	<a class="page-link" href="javascript:void(0);">\${i}</a>
	    </li>`;
	}
	
	var disabled = pm.next ? '' : 'disabled'
		str+=
	  ` <li class="page-item \${disabled}" data-page="\${pm.endPage+1}">
	    	<a class="page-link" href="javascript:void(0);">다음</a>
	    </li>`;
	   
	   
	   str+=
  	`</ul>`;
  		  $('.comment-pagination').html(str);
}


function displayCommentList(list){
	var str = '';
	if(list.length == 0){
		str = `<li>등록된 댓글이 없습니다.</li>`;
		$('.comment-list').html(str);
		return;
	}
	
	
	for(co of list){
		// 댓글이면
		if(co.com_num == co.com_ori_num){
			str += `
			<li class="comment-item">
			<div>\${co.cm_me_id}(\${co.cm_date})</div>
			<div>\${co.cm_content}</div>
		</li>
		`;
		}
		//대댓이면
		else{
			str += `
			<li class="comment-item reply">
				<div>\${co.cm_me_id}(\${co.cm_date})</div>
				<div>${co.cm_content}</div>
			</li>
			`;
			}
		}
		$('.comment-list').html(str);
	}

</script>
</body>
</html>