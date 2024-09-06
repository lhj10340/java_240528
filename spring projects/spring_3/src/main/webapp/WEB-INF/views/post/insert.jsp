<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시글 등록 </title>

<link href="<c:url value="/resources/summernote/"/>summernote.min.css" rel="stylesheet">
<script src="<c:url value="/resources/summernote/"/>summernote.min.js"></script>

</head>
<body>

<h3 class="mt-3"> 게시글 등록 </h3>
	
	<form action="<c:url value="/post/insert/${co_num}"/>" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="po_title">제목:</label>
			<input type="text" class="form-control" id="po_title" name="po_title">
		</div>
		
		<div class="form-group">
			<label for="po_content">내용:</label>
			<textarea class="form-control" id="po_content" name="po_content"></textarea>
		</div>
		
		<div class="form-group">
			<label>첨부파일</label>
			<div class="form-group">
				<input type="file" class="form-control" name="fileList"/>
				<input type="file" class="form-control" name="fileList"/>
				<input type="file" class="form-control" name="fileList"/>
			</div>
		</div>
		
		<button type="submit" class="btn btn-outline-info col-12"> 게시글 등록 </button>
	</form>

	<script>
      $('#po_content').summernote({
        placeholder: '내용을 입력하세요.',
        tabsize: 2,
        height: 400
      });
    </script>

</body>
</html>