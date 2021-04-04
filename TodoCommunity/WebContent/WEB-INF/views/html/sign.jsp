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
	<link rel='stylesheet' type='text/css' media='screen' href='${path}/css/layout.css'>
	<link rel='stylesheet' type='text/css' media='screen' href='${path}/css/sign.css'>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous" />
	<script src='${path}/js/lib/jquery-3.6.js'></script>
	<script src='${path}/js/common/constants.js'></script>
	<script src='${path}/js/sign.js'></script>
	<meta charset="UTF-8">
</head>
<body>
    <body>
        <div id="form_wrapper">
            <div id="form_left">
                <img src="${path}/img/app_logo.png" />
            </div>
            <div id="form_right">
                <h1>로그인</h1>
                <div class="input_container">
                    <i class="font-awesome far fa-id-badge"></i>
                    <input placeholder="ID" type="text" name="Email" id="userId" class="inputArea" />
                </div>
                <div class="input_container">
                    <i class="font-awesome fas fa-lock"></i>
                    <input placeholder="Password" type="password" name="userPw" id="userPw"
                        class="inputArea" />
                </div>
                <p id="status" class="error hide"></p>
                <input type="button" value="Login" id="loginBtn" class="inputArea signArea" />
                <span id="signBtn">
                    <a href="#">회원가입 ➡ </a>
                </span>
            </div>
        </div>
    </body>
</body>
</html>
