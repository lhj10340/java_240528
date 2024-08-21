<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

<style type="text/css">
	.list-group{
	text-align : center;
}
</style>

</head>
<body>

<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="<c:url value="/"/>">Home</a>
    </li>
    <!-- 여기서 user 는 login servlet 에서 session 으로 넣어준 user.
    user 의 정보가 있다면 로그인을 한 것이니 회원가입과 로그인이 필요가 없으므로 보여주지 않는다. -->
    
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/community"/>">커뮤니티</a>
			</li>
			
			<li class="nav-item dropdown">
		      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
		        커뮤니티
		      </a>
		      <div class="dropdown-menu" id="community-list">
		        <a class="dropdown-item" href="#">Link 1</a>
		      </div>
    		</li>
    		
		<c:if test="${user == null }">
	
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/signup"/>">회원가입</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/login"/>">로그인</a>
			</li>
		</c:if>
		
	<!-- 이 부분은 잘 진행했다, 로그아웃 메뉴 만들고 로그인 했을 때만 보이게하기! -->
		<c:if test="${user != null }">
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/logout"/>">로그아웃</a>
			</li>
		</c:if>
		
	</ul>
</nav>

<script type="text/javascript">
	
	// 드롭 다운과 ajax 를 통한 커뮤니티 목록 구현
	
	$.ajax({
		url : '<c:url value="/community"/>',
		method : 'post',
		data  : {},
		success : function(data){
			var str ='';
			var list = data.list;
			
			for(co of list){
				str += `<a class="dropdown-item" href="<c:url value="/post/list?co_num=\${co.co_num}"/>">
						\${co.co_name}
						</a>`;
			}
			$("#community-list").html(str);
		},
		error : function(xhr){
			console.log(xhr)
		}
	});

</script>

</body>
</html>