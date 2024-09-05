<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>

<h2 class="mt-3 mb-3"> 로그인 </h2>

<form action="<c:url value="/guest/login"/>" method="post" id="form">

  <div class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text"> 아이디 </span>
    </div>
    <input type="text" class="form-control" id="me_id" name="me_id" value="${id }">
  </div>
  
  <div class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text"> 비밀번호 </span>
    </div>
    <input type="password" class="form-control" id="me_pw" name="me_pw">
  </div>
  
  <button type="submit" class="btn btn-outline-success col-12"> 로그인 </button>
  
</form>

<script type="text/javascript">

// 아이디가 없으면 아이디 창을 활성화하고 아이디가 있으면 비번창을 활성화

var id = $('#me_id').val();

if(id == ''){
	$('#me_id').focus();
} else{
	$('#me_pw').focus();
}

// 아이디나 비번이 입력되지 않으면 알림을 띄우고, 해당 창을 활성화
$('#form').submit(function(){
	var id = $('#me_id').val
	var pw = $('#me_pw').val
	if(id == ''){
		alert('아이디를 입력하세요.');
		$('#me_id').focus();
		return false;
	}
	if(pw == ''){
		alert('비밀번호를 입력하세요.');
		$('#me_pw').focus();
		return false;
	}
})

</script>

</body>
</html>