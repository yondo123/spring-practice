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
    <link rel='stylesheet' type='text/css' media='screen' href='${path}/css/main.css'>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous" />
	<script src='${path}/lib/jquery-3.6.js'></script>
    <script src='${path}/js/common/constants.js'></script>
	<script src='${path}/js/main.js'></script>
</head>

<body>
    <!-- title -->
    <header class="header">
        <jsp:include page="../include/menu.jsp"/>
    </header>
    <!-- main -->
    <main>
        <section class="board">
            <a href="#">
                <h1>스터디</h1>
            </a>
            <ol>
                <li>
                    <img src="../img/Html_logo.png" alt="html">
                    <a href="#">
                        <h2>질문 사항 입니다.</h2>
                        <p>내용 내용 내용 내용 내용 내용 내용 내용 내용 내용</p>
                    </a>
                </li>
                <li>
                    <img src="../img/Html_logo.png" alt="html">
                    <a href="#">
                        <h2>질문 사항 입니다.</h2>
                        <p>내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용</p>
                    </a>
                </li>
                <li>
                    <img src="../img/Html_logo.png" alt="html">
                    <a href="#">
                        <h2>질문 사항 입니다.</h2>
                        <p>내용 내용 내용 내용 내용 내용 내용 내용 내용 내용</p>
                    </a>
                </li>
                <li>
                    <img src="../img/Html_logo.png" alt="html">
                    <a href="#">
                        <h2>질문 사항 입니다.</h2>
                        <p>내용 내용 내용 내용 내용 내용 내용 내용 내용 내용</p>
                    </a>
                </li>
                <li>
                    <img src="../img/Html_logo.png" alt="html">
                    <a href="#">
                        <h2>질문 사항 입니다.</h2>
                        <p>내용 내용 내용 내용 내용 내용 내용 내용 내용 내용</p>
                    </a>
                </li>
            </ol>
        </section>
        <section class="board">
            <a href="#">
                <h1>커뮤니티</h1>
            </a>
            <ol>
                <li>
                    <img src="../img/JS_logo.png" alt="javascript">
                    <a href="#">
                        <h2>질문 사항 입니다.</h2>
                        <p>내용 내용 내용 내용 내용 내용 내용 내용 내용 내용</p>
                    </a>
                </li>
                <li>
                    <img src="../img/JS_logo.png" alt="javascript">
                    <a href="#">
                        <h2>질문 사항 입니다.</h2>
                        <p>내용 내용 내용 내용 내용 내용 내용 내용 내용 내용</p>
                    </a>
                </li>
                <li>
                    <img src="../img/JS_logo.png" alt="javascript">
                    <a href="#">
                        <h2>질문 사항 입니다.</h2>
                        <p>내용 내용 내용 내용 내용 내용 내용 내용 내용 내용</p>
                    </a>
                </li>
                <li>
                    <img src="../img/JS_logo.png" alt="javascript">
                    <a href="#">
                        <h2>질문 사항 입니다.</h2>
                        <p>내용 내용 내용 내용 내용 내용 내용 내용 내용 내용</p>
                    </a>
                </li>
                <li>
                    <img src="../img/JS_logo.png" alt="javascript">
                    <a href="#">
                        <h2>질문 사항 입니다.</h2>
                        <p>내용 내용 내용 내용 내용 내용 내용 내용 내용 내용내용 내용 내용 내용 내용 내용 내용 내용 내용 내용내용 내용 내용 내용 내용 내용 내용 내용 내용 내용내용 내용 내용 내용 내용 내용 내용 내용 내용 내용</p>
                    </a>
                </li>
            </ol>
        </section>
    </main>
    <section class="todo">
        <a href="#">
            <h1>Todo</h1>
        </a>
        <table>
            <colgroup>
                <col width="10%" />
                <col width="20%" />
                <col width="60%" />
                <col width="20%" />
            </colgroup>
            <thead>
                <tr>
                    <th rowspan="col">status</th>
                    <th rowspan="col">writer</th>
                    <th rowspan="col">item</th>
                    <th rowspan="col">date</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <span class="status-done"></span>
                    </td>
                    <td>
                        admin
                    </td>
                    <td>
                        vue study..
                    </td>
                    <td>
                        2020. 06. 19
                    </td>
                </tr>
                <tr>
                    <td>
                        <span class="status-doing"></span>
                    </td>
                    <td>
                        admin
                    </td>
                    <td>
                        vue study..
                    </td>
                    <td>
                        2020. 06. 19
                    </td>
                </tr>
                <tr>
                    <td>
                        <span class="status-done"></span>
                    </td>
                    <td>
                        admin
                    </td>
                    <td>
                        vue study..
                    </td>
                    <td>
                        2020. 06. 19
                    </td>
                </tr>
                <tr>
                    <td>
                        <span class="status-done"></span>
                    </td>
                    <td>
                        admin
                    </td>
                    <td>
                        vue study..
                    </td>
                    <td>
                        2020. 06. 19
                    </td>
                </tr>
                <tr>
                    <td>
                        <span class="status-todo"></span>
                    </td>
                    <td>
                        admin
                    </td>
                    <td>
                        vue study..
                    </td>
                    <td>
                        2020. 06. 19
                    </td>
                </tr>
            </tbody>
        </table>
    </section>
    <!--footer-->
    <jsp:include page="../include/footer.jsp"></jsp:include>
</body>

</html>