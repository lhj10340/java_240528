<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>

<h1 class="mt-3"> 로그인 </h1>

  <form action="<c:url value="/login"/>" method="post" class="mb-3" id="form">
    <div class="form-group">
      <label for="id">아이디 :</label>
      <input type="text" class="form-control" id="id" name="me_id">
    </div>
    <div class="form-group">
      <label for="pw">비밀번호 :</label>
      <input type="password" class="form-control" id="pw" name="me_pw">
    </div>
    <button class="btn btn-outline-success col-12"> 로그인 </button>
  </form>

</body>
</html>