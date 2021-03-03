<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>indexPage</h2>
	<p>hello spring!</p>
	<hr />
	<form action="result" method="post">
		<input type="text" name="userId" /><br />
		<spring:hasBindErrors name="dataBean">
			<c:if test="${errors.hasFieldErrors('userId') }">
				<spring:message code="${errors.getFieldError('userId').codes[0] }"></spring:message><br/>
			</c:if>
		</spring:hasBindErrors>
		<input type="password" name="userPw" />
		<spring:hasBindErrors name="dataBean">
			<c:if test="${errors.hasFieldErrors('userPw') }">
				<spring:message code="${errors.getFieldError('userPw').codes[0] }"></spring:message><br/>
			</c:if>
		</spring:hasBindErrors>
		<button type="submit">Submit</button>
	</form>
</body>
</html>