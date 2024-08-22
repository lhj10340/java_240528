<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title> ... </title>

<jsp:include page="/WEB-INF/views/common/head.jsp"/>

</head>

<body>

<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<div class="container" style="min-height : calc(100vh - 240px)">
	
	<h1> 게시글 상세 </h1>
	
	<div class="form-group">
	  <label>제목 : </label>
	  <div class="form-control">${post.po_title }</div>
	</div>
	
	<div class="form-group">
	  <label>작성자 : </label>
	  <div class="form-control">${post.po_me_id }</div>
	</div>
	
	<div class="form-group">
	  <label>작성일 : </label>
	  <div class="form-control"><fmt:formatDate value="${post.po_date }" pattern="yyyy-MM-dd HH:mm:ss"/></div>
	</div>
	
	<div class="form-group">
	  <label>조회수 : </label>
	  <div class="form-control">${post.po_view }</div>
	</div>
	
	<div class="form-group">
	  <label>내용 : </label>
	  <div class="form-control" style="min-height: 400px; height: auto">${post.po_content }</div>
	</div>
	
	<!-- 작성자 본인만 수정버튼을 볼 수 있도록 c:if 가 필요. -->
	
	<c:if test="${user.me_id == post.po_me_id }">
		<a href="<c:url value="/post/update?po_num=${post.po_num }"/>" class="btn btn-outline-success">수정</a>
	</c:if>
	
</div>
    
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>