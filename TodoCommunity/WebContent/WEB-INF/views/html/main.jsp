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
        <jsp:include page="../include/menu.jsp"/>
    </header>
    <!--board-->
    <section class="board">
        <!-- 상단게시판(좌) -->
        <section class="boardArea">
            <h3 id="leftTitle" class="btnBoard link">스터디</h3>
            <ul class="board-list">
                <li class="post">
                    <div class="category"><img src="${path}/img/app_logo.png"></div>
                    <h5 class="title">오늘 공부 후기(1)</h5>
                    <p>공부내용 내용 내용 내용 내용</p>
                </li>
                <li class="post">
                    <div class="category"></div>
                    <h5 class="title">오늘 공부 후기(1)</h5>
                    <p>공부내용 내용 내용 내용 내용</p>
                </li>
                <li class="post">
                    <div class="category"></div>
                    <h5 class="title">오늘 공부 후기(1)</h5>
                    <p>공부내용 내용 내용 내용 내용</p>
                </li>
                <li class="post">
                    <div class="category"></div>
                    <h5 class="title">오늘 공부 후기(1)</h5>
                    <p>공부내용 내용 내용 내용 내용</p>
                </li>
            </ul>
        </section>
        <!-- 하단게시판(우) -->
        <section class="boardArea">
            <h3 id="rightTitle" class="btnBoard link">커뮤니티</h3>
            <ul class="board-list">
                <li class="post">
                    <div class="category"></div>
                    <h5 class="title">오늘 공부 후기(1)</h5>
                    <p>공부내용 내용 내용 내용 내용</p>
                </li>
                <li class="post">
                    <div class="category"></div>
                    <h5 class="title">오늘 공부 후기(1)</h5>
                    <p>공부내용 내용 내용 내용 내용</p>
                </li>
                <li class="post">
                    <div class="category"></div>
                    <h5 class="title">오늘 공부 후기(1)</h5>
                    <p>공부내용 내용 내용 내용 내용</p>
                </li>
                <li class="post">
                    <div class="category"></div>
                    <h5 class="title">오늘 공부 후기(1)</h5>
                    <p>공부내용 내용 내용 내용 내용</p>
                </li>
            </ul>
        </section>
    </section>
    <!--Todo List-->
    <!--flag 1 :  &bigotimes; flag 0 :&bigodot;-->
    <section class="mainTodo">
        <h3 class="btnBoard link">Todo</h3>
        <table class="todo-list">
            <colgroup>
                <col width="10%" />
                <col width="20%" />
                <col width="50%" />
                <col width="20%" />
            </colgroup>
            <thead>
                <tr>
                    <th wi>flag</th>
                    <th>writer</th>
                    <th>item</th>
                    <th>date</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><i class="font-awesome fas fa-check-circle done"></i></td>
                    <td>admin</td>
                    <td>test data!</td>
                    <td>2021/03/04</td>
                </tr>
                <tr class="completed">
                    <td><i class="font-awesome far fa-check-circle"></i></td>
                    <td>admin</td>
                    <td>test data!</td>
                    <td>2021/03/05</td>
                </tr>
            </tbody>
        </table>
    </section>
    <!--footer-->
    <footer>
        <jsp:include page="../include/footer.jsp"></jsp:include>
    </footer>
</body>

</html>