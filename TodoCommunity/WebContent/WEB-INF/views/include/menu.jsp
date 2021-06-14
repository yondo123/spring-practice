<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}/resource" />
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<header>
	<div class="app-logo">
		<img src="${path}/img/app_logo.png" alt="logo">
	</div>
	<div class="app-header">
		<a href="#">
			<h1>WhatTodo</h1>
			<strong>당신의 할 일을 공유해보세요.</strong>
		</a>
		<nav>
			<ul class="main-menu" id="menuList">
				<c:choose>
					<c:when test="${loginUserInfo.isLogin==true}">
						<li>
							<a href="${root }/user/logout">로그아웃</a>
						</li>
						<li>
							<a href="${root }/board/write">글쓰기 테스트</a>
						</li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="${root }/user/join">회원가입</a>
						</li>
						<li>
							<a href="${root }/user/sign">로그인</a>
						</li>
					</c:otherwise>
				</c:choose>
				<li>
					<a href="${root }/board/study" type="study">스터디</a>
				</li>
				<li>
					<a href="${root }/board/community" type="com">커뮤니티</a>
				</li>
				<li>
					<a href="${root }/board/todo" type="todo">Todo</a>
				</li>
			</ul>
		</nav>
	</div>
</header>