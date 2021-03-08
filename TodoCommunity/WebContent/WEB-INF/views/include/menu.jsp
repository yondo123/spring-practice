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
<link rel='stylesheet' type='text/css' media='screen'
	href='${path}/css/style.css'>
<link rel='stylesheet' type='text/css' media='screen'
	href='${path}/css/main.css'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='${path}/js/menu.js'></script>
<meta charset="UTF-8">
</head>
<body>
	<nav class="main-menu">
		<ul>
			<c:forEach var="obj" items="${menuList}">
				<li>
					<a href="${root}board/main?board_info_index=${obj.BOARD_INFO_INDEX}">${obj.BOARD_INFO_NAME}</a>
				</li>
			</c:forEach>
			<li><a href="${root }/user/sign">로그인</a></li>
			<li><a href="${root }/user/join">회원가입</a></li>
			<li><a href="${root }/user/join">로그아웃</a></li>
			<li>
				<span><input type="text"></span>
				<button>검색</button>
			</li>
		</ul>
	</nav>
</body>
</html>
