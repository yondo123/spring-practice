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
    <link rel='stylesheet' type='text/css' media='screen' href='${path}/css/post.css'>
    <link rel='stylesheet' type='text/css' media='screen' href='${path}/lib/summernote-lite.css'>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
        integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous" />
    <script src='${path}/lib/jquery-3.6.js'></script>
    <script src='${path}/lib/summernote-lite.js'></script>
    <script src='${path}/lib/summernote-ko-KR.js'></script>
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
    <main>
        <div class="post-info">
            <h1 class="heading">글쓰기</h1>
            <strong class="board-type" id="boardHeading"></strong>
        </div>
        <div class="post">
            <dl>
                <div class="post-detail">
                    <dt class="subject">제목</dt>
                    <dd>
                        <input type="text" id="title" placeholder="제목을 입력해주세요." maxlength="500">
                        <label for="title">글쓰기 제목</label>
                    </dd>
                </div>
                <div class="post-detail">
                    <dt class="category">카테고리 선택</dt>
                    <dd>
                        <select id="category">
                        </select>
                        <label for="category">카테고리</label>
                    </dd>
                </div>
                <div class="post-detail">
                    <dt class="content">내용</dt>
                    <dd class="summernote">
                        <div id="summernote"></div>
                    </dd>
                </div>
            </dl>
        </div>
        <div class="post-buttons">
            <button type="button" id="btnWrite">글쓰기</button>
            <button type="button" id="btnCancel">취소</button>
        </div>
    </main>
    <jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>