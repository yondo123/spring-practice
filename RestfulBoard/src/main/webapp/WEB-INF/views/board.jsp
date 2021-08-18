<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}/resources"/>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>POST BOX</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" type="text/css" media="screen" href="${path}/css/style.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="${path}/css/board.css" />
        <link
                rel="stylesheet"
                href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
                integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
                crossorigin="anonymous"
        />
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,4min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="${path}/js/pagination.js"></script>
        <script src="${path}/js/board.js"></script>
</head>
<body>
<c:out value="${pageContext.request.contextPath}"/>
<!--header, main -> popup, section -> hide-->
<header>
    <a href="#">
        <i class="fas fa-4x fa-envelope"></i>
        <h1>Welcome to POST BOX.</h1>
        <strong>write your message.</strong>
    </a>
    <button id="btnWrite" type="button">Write</button>
</header>
<main>
    <h2 class="hide">Recent POST</h2>
    <ol class="list">
        <li class="post-list">
            <details>
                <summary>제목제목제목제목제목</summary>
                <p>내용입니다. 내용입니다. 내용입니다.</p>
            </details>
            <div class="post-info">
                <p><span class="author">admin</span> | <span class="date">2021. 08. 16</span></p>
            </div>
        </li>
    </ol>
</main>
<section class="write-wrap hide">
    <div class="article-info">
        <i class="fas fa-user"></i>
        <input type="text" name="author" id="userId" placeholder="your id" maxlength="10"/>
        <label for="userId" class="hide">User Id</label>
        <i class="fas fa-key"></i>
        <input type="password" name="author" id="userPassword" placeholder="your password.." maxlength="12"/>
        <label for="userPassword" class="hide">User Password</label>
    </div>
    <input type="text" class="title" name="post-title" id="title" placeholder="Title.." maxlength="50">
    <label for="title" class="hide">Title</label>
    <textarea name="review" id="post" cols="15" rows="10"> </textarea>
    <div class="article-button">
        <button type="button" id="btnPostSend" class="write">send</button>
        <button type="button" id="btnCancel" class="cancel">cancel</button>
    </div>
</section>
<footer>
    <h2 class="hide">pagination</h2>
    <div id="pagination"></div>
</footer>
</body>
</html>
