<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}/resource" />
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<div class="logoArea">
	<img src="${path}/img/app_logo.png" class="logo"></img> <a href="#">WhatTodo
		<br> 당신의 할 일을 공유해보세요.
	</a>
</div>
<nav class="menu-right">
	<c:choose>
		<c:when test="${loginUserInfo.isLogin==true}">
			<a href="${root }/user/logout">로그아웃</a>
			<a href="${root }/board/study">스터디</a>
			<a href="${root }/board/community">커뮤니티</a>
			<a href="${root }/board/write">글쓰기 테스트</a>
		</c:when>
		<c:otherwise>
			<a href="${root }/user/sign">로그인</a>
			<a href="${root }/user/join">회원가입</a>
			<a href="${root }/board/study">스터디</a>
			<a href="${root }/board/community">커뮤니티</a>
		</c:otherwise>
	</c:choose>
	<!-- <c:forEach var="obj" items="${menuList}">
		<a href="${root}board/main?board_info_index=${obj.BOARD_INFO_INDEX}">${obj.BOARD_INFO_NAME}</a>
	</c:forEach> -->
	<a class="select" href="#">TODO</a>
</nav>