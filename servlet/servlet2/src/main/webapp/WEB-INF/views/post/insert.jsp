<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title> 게시글 등록 </title>

<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>

</head>

<body>

<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

<div class="container">

	<h1>게시글 작성</h1>
	
	<!-- form 태그의 action 과 method 를 적지 않았다. -->
	
	<form action="<c:url value="/post/insert"/>" method="post">
		
		<input type="hidden" name="po_co_num" value="${co_num}">
		
	<!-- input 의 id, name 을 적지 않았다, textarea 의 class 를 적지 않았다. -->
	
		<div class="form-group">
			<label for="title">제목 :</label> 
			<input type="text" class="form-control" name="po_title" placeholder="제목을 입력해주세요." id="title" name="po_title">
		</div>
		
		<div class="form-group">
			<label for="content">내용 :</label> 
			<textarea class="form-control" id="content" name="po_content"></textarea>
		</div>
		
			<button type="submit" class="btn btn-outline-success col-12">게시글 등록</button>
		
	</form>
		
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

	<script>
		$('#content').summernote({
			placeholder : '게시글을 작성해주세요.',
			tabsize : 2,
			height : 400
		});
	</script>

</body>
</html>