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
    <script src='${path}/js/common/constants.js'></script>
    <script src='${path}/js/main.js'></script>
</head>

<body>
    <!-- title -->
    <header class="header">
        <jsp:include page="../include/menu.jsp" />
    </header>
    <!--board-->
    <section class="board">
        <!-- 상단게시판(좌) -->
        <section class="boardArea board-all">
            <h3 class="link">자유 게시판</h3>
            <ul class="board-list">
                <li class="post">
                    <div class="category"><img src="${path}/img/app_logo.png"></div>
                    <h5 class="content">공부내용 내용 내용 내용 내용</h5>
                    <p class="post-info">글쓴이 : yondo123 | 작성 날짜 : 2020-04-03 20:20:22</p>
                </li>
                <li class="post">
                    <div class="category"><img src="${path}/img/app_logo.png"></div>
                    <h5 class="content">공부내용 내용 내용 내용 내용</h5>
                    <p class="post-info">글쓴이 : yondo123 | 작성 날짜 : 2020-04-03 20:20:22</p>
                </li>
            </ul>
        </section>
    </section>

    <div class="paginationArea">
        <section class="buttonArea">
            <input type="button" value="글쓰기">
        </section>
        <div class="pagination">
            <a href="#"><i class="font-awesome fas fa-arrow-circle-left"></i></a>
            <a href="#">1</a>
            <a href="#" class="active">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#"><i class="font-awesome fas fa-arrow-circle-right"></i></a>
        </div>
    </div>
</body>
</html>