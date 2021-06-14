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
    <title>What-Todo</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='${path}/css/layout.css'>
    <link rel='stylesheet' type='text/css' media='screen' href='${path}/css/board.css'>
    <link rel='stylesheet' type='text/css' media='screen' href='${path}/css/todo.css'>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
        integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous" />
    <script src='${path}/js/lib/jquery-3.6.js'></script>
    <script src='${path}/js/common/template.js'></script>
    <script src='${path}/js/common/util.js'></script>
    <script src='${path}/js/common/constants.js'></script>
    <script src='${path}/js/write.js'></script>
</head>

<body>
    <!-- title -->
    <header class="header">
        <jsp:include page="../include/menu.jsp" />
    </header>
    <section class="board">
        <section class="boardArea writeArea">
            <div class="input_container">
                <h3>Title</h3>
                <input type="text" class="inputArea" id="title"/>
            </div>
            <div class="input_container">
                <h3>Subject</h3>
                <select class="selectArea" id="categoryList">
                </select>
            </div>
            <div class="input_container">
                <h3>Image</h3>
                <input type="file" class="inputArea" id="imageFile"/>
            </div>
            <div class="input_container">
                <h3>Content</h3>
                <textarea class="textArea" id="content"></textarea>
            </div>
        </section>
    </section>
    <section class="buttonArea">
        <input type="button" value="취소" id="btnCancle">
        <input type="button" value="등록" id="btnWrite">
    </section>
</body>