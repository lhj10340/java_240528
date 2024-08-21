<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
 
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<jsp:include page="/WEB-INF/views/common/head.jsp"/>

<title>복습 로그인 페이지</title>

</head>

<body>

<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<div class="container" style="min-height: calc(100vh - 240px)">

<h1>로그인</h1>

<form action="<c:url value="/login"/>" method="post" id="form">

	<div class="form-group">
	  <label for="id">아이디 :</label>
	  <input type="text" class="form-control" id="id" name="me_id">
	</div>
	
	<div class="form-group">
	  <label for="pw">비밀번호 :</label>
	  <input type="password" class="form-control" id="pw" name="me_pw">
	</div>
	<button type="submit" class="btn btn-outline-success col-12" >로그인</button>
	
	<!-- button 의 type 과 class 를 적지 못했다. button 까지는 적었다. -->
	
</form>

</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>