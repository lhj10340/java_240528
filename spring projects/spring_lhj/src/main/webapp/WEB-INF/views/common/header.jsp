<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="<c:url value="/"/>">Home</a>
    </li>
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/post/list"/>">커뮤니티</a>
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
		
		<c:if test="${user != null }">
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/logout"/>">로그아웃</a>
			</li>
		</c:if>
	</ul>
</nav>

</body>
</html>