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
    <script src='${path}/js/board.js'></script>
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
            <h3 id="board" class="link" type=${cateType}>${cateName}</h3>
            <ul class="board-list">
            </ul>
        </section>
    </section>

    <div class="paginationArea">
        <section class="buttonArea">
            <input type="button" value="글쓰기">
        </section>

        <ul class="pagination" id="pagingList">
            <li class="pageCtrl prevPage"><i class="font-awesome fas fa-arrow-circle-left"></i></li>
            <li class="pageCtrl nextPage"><i class="font-awesome fas fa-arrow-circle-right"></i></li>
        </ul>        
    </div>
</body>
</html>