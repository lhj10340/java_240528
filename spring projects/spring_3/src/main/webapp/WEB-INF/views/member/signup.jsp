<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.additional-methods.min.js"/>"></script>

<style type="text/css">
	.error{
		color : red;
	}
	.error.id-ok{
		color : green;
	}
	</style>

</head>
<body>

<h2 class="mt-3 mb-3"> 회원가입 </h2>

<form action="<c:url value="/guest/signup"/>" method="post" id="form">

  <div class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text"> 아이디 </span>
    </div>
    <input type="text" class="form-control" id="me_id" name="me_id">
  </div>
  
  <div>
	  <label id="me_id-error" class="error" for="me_id" style=""></label>
  </div>
  
  <div class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text"> 비밀번호 </span>
    </div>
    <input type="password" class="form-control" id="me_pw" name="me_pw">
  </div>
  
  <div>
	  <label id="me_pw-error" class="error" for="me_pw" style=""></label>
  </div>
  
  <div class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text"> 비밀번호 확인 </span>
    </div>
    <input type="password" class="form-control" id="me_pw2" name="me_pw2">
  </div>
  
   <div class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text"> 이메일 </span>
    </div>
    <input type="text" class="form-control" id="me_email" name="me_email">
  </div>
  
  <div>
	  <label id="me_email-error" class="error" for="me_email" style=""></label>
  </div>
  
  <button type="submit" class="btn btn-outline-success col-12">등록</button>
  
</form>

<script type="text/javascript">

		var flag = false;
		
				$('#form').validate({
					rules : {
						me_id : {
							required : true,
							regex : /^\w{6,13}$/
						},
						me_pw : {
							required : true,
							regex : /^[a-zA-Z0-9!@#$]{6,15}$/
						},
						me_pw2 : {
							equalTo : me_pw
						},
						me_email : {
							required : true,
							email : true
						}
					},
					messages : {
						me_id : {
							required : '필수 항목입니다.',
							regex : '아이디는 영어, 숫자만 가능하며, 6~13자이어야 합니다.'
						},
						me_pw : {
							required : '필수 항목입니다.',
							regex : '비밀번호는 영어, 숫자, 특수문자(!@#$)만 가능하며, 6~15자이어야 합니다.'
						},
						me_pw2 : {
							equalTo : '비번과 일치하지 않습니다.'
						},
						me_email : {
							required : '필수 항목입니다.',
							email : 'email 형식이 아닙니다'
						}
					},
					submitHandler : function() {
						var id = $("#id").val();
						var res = checkId(id);
						if(res == 0){
							displayCheckId(res);
							alert('이미 사용중인 아이디입니다.');
							return false;
						}
						return true;
					}
				});
				$.validator.addMethod('regex', function(value, element, regex) {
					var re = new RegExp(regex);
					return this.optional(element) || re.test(value);
				}, "정규표현식을 확인하세요.");
		
</script>

</body>
</html>