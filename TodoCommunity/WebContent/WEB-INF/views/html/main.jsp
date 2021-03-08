<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}/resource" />
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
    <script src='../js/main.js'></script>
    <meta charset="UTF-8">
</head>

<body>
    <header>
        <div class="container">
            <div class="container-mobile">
                <a href="main.jsp" class="main-header">
                   저한먹
                </a>

                <button type="button" class="btnToggle">
                    <span class="fa fa-bars" title="MENU"></span>
                </button>
            </div>
            <c:import url="/WEB-INF/views/include/menu.jsp"></c:import>
        </div>
    </header>

    <section class="post">
        <div class="container">
            <li class="item">
                <a href="#">
                    <div class="thumb" style="background-image: url(../img/contents/sampe-fish.jpg);"></div>
                    <div class="text">
                        <h2 class="title">오늘 저한먹!</h2>
                        <p class="contents">내용내용내용내용내용</p>
                    </div>
                </a>
            </li>
        </div>
    </section>
</body>

</html>
