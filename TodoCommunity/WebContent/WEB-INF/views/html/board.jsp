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
    <link rel='stylesheet' type='text/css' media='screen' href='${path}/css/style.css'>
    <link rel='stylesheet' type='text/css' media='screen' href='${path}/css/header.css'>
    <link rel='stylesheet' type='text/css' media='screen' href='${path}/css/board.css'>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
        integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous" />
    <script src='${path}/lib/jquery-3.6.js'></script>
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
    <main>
        <h1 class="title" type=${cateType} id="board">${cateName} 게시판</h1>
        <div class="write-button">
            <button type="button" id="btnWrite">글쓰기</button>
        </div>
        <ol id="boardList">
        </ol>
    </main>
    <section>
        <ol class="pagination" id="pagingList">
            <li class="pageCtrl" type="prev">
                    Pre
            </li>
            <li class="pageCtrl" type="next">
                    Next
            </li>
        </ol>

    </section>
    <!--footer-->
    <jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>