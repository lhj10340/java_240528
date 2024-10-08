<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시글 수정 </title>

<link href="<c:url value="/resources/summernote/"/>summernote.min.css" rel="stylesheet">
<script src="<c:url value="/resources/summernote/"/>summernote.min.js"></script>

</head>
<body>

<h3 class="mt-3"> 게시글 수정 </h3>
	
	<form action="<c:url value="/post/update/${post.po_num}"/>" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="po_title">제목:</label>
			<input type="text" class="form-control" id="po_title" name="po_title" value="${post.po_title }">
		</div>
		
		<div class="form-group">
			<label for="po_content">내용:</label>
			<textarea class="form-control" id="po_content" name="po_content">${post.po_content } </textarea>
		</div>
		
		<div class="form-group box-att">
			<label>첨부파일</label>
			
			<c:forEach items="${list}" var="file">
				<div class="form-control d-flex justify-content-between">
				<span>${file.fi_ori_name}</span>
				<a href="javascript:void(0);" class="btn-del" data-num="${file.fi_num}"> x </a>
				</div>
			</c:forEach>
			
			<c:forEach begin="1" end="${3 - list.size()}">
				<input type="file" class="form-control" name="fileList">
			</c:forEach>
			
		</div>
		
		<button type="submit" class="btn btn-outline-info col-12"> 게시글 수정 </button>
	</form>

	<script>
      $('#po_content').summernote({
        placeholder: '내용을 입력하세요.',
        tabsize: 2,
        height: 400
      });
    </script>
	
	<script type="text/javascript">
		$('.btn-del').click(function(){
			
			var fi_num = $(this).data('num');
			
			var str1 = `
			<input type="hidden" name="nums" value="\${fi_num}">`;
			
			var str2 = `<input type="file" class="form-control" name="fileList">`;
			
			$('.box-att').append(str1);
			$('.box-att').append(str2);
			$(this).parent().remove();
		})
	</script>
	
</body>
</html>