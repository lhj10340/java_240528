<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<title> 복습 페이지 </title>

</head>

<body>

<!-- 이 파일을 추가하지 못 했었다. -->

<script type="text/javascript">

if('${msg}' != ''){
	alert('${msg}')
}

if('${url}' != ''){
	location.href = '<c:url value="${url}"/>'
}

</script>

</body>

</html>