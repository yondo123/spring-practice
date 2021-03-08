<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}/resource" />
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>
	<meta charset='utf-8'>
	<meta http-equiv='X-UA-Compatible' content='IE=edge'>
	<title>저녁먹고 한거 뭐야!?</title>
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link rel='stylesheet' type='text/css' media='screen' href='${path}/css/style.css'>
	<link rel='stylesheet' type='text/css' media='screen' href='${path}/css/main.css'>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src='${path}/js/lib/jquery-3.6.js'></script>
	<script src='${path}/js/join.js'></script>
	<meta charset="UTF-8">
</head>

<body>
	<div>
        <sapn>이름 : </sapn><input type="text" id="userName"><br/>
        <sapn>아이디 : </sapn><input type="text" id="userId"><br/>
        <input type="button" value="중복확인" id="idChkBtn"></input><br/>
        <sapn>비밀번호 : </sapn><input type="text" id="userPw"><br/>
        <sapn>비밀번호 확인 : </sapn><input type="text" id=""><br/>
		<input type="button" value="Sign Up" id="joinBtn"></input>

	</div>
</body>
</html>
