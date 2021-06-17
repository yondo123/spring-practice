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
	<link rel='stylesheet' type='text/css' media='screen' href='${path}/css/sign.css'>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous" />
	<script src='${path}/lib/jquery-3.6.js'></script>
	<script src='${path}/js/common/constants.js'></script>
	<script src='${path}/js/join.js'></script>
	<meta charset="UTF-8">
</head>

<body>
    <body>
        <main class="sign">
            <h1>회원가입</h1>
            <div class="app-logo">
                <img src="${path}/img/app_logo.png" alt="whattodo logo">
            </div>
            <div class="form">
                <div class="input-container">
                    <i class="font-awesome far far fa-user"></i>
                    <input type="text" id="userName" placeholder="your name">
                    <label for="userId">userName</label>
                </div>
                <div class="input-container">
                    <i class="font-awesome far fa-id-badge"></i>
                    <input type="text" id="userId" placeholder="id">
                    <label for="userId">userId</label>
                    <strong id="status"></strong>
                </div>
                <div class="input-container">
                    <i class="font-awesome fas fa-lock"></i>
                    <input type="password" id="userPw" placeholder="password..">
                    <label for="userPw">userPassword</label>
                </div>
                <div class="input-container">
                    <i class="font-awesome fas fa-lock"></i>
                    <input type="password" id="confirmPw" placeholder="confirm your password..">
                    <label for="userConfirmPw">passwordConfirm</label>
                </div>
                <div class="button-area">
                    <button type="button" class="btn-join" id="joinBtn">회원가입</button>
                    <button type="button" class="btn-login">로그인</button>
                </div>
            </div>
        </main>
    </body>
</body>
</html>
