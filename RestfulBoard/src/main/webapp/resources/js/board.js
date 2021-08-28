$(function () {
    let requestPage = 1;
    getBoardList(requestPage);

    //팝업 오픈
    $("#btnWrite").click(function () {
        return togglePopup(true);
    });

    //취소
    $("#btnCancel").click(function () {
        return togglePopup(false);
    });

    //글작성
    $("#btnPostSend").click(function () {
        checkUserAccount().then(uploadPost);
    });

    /**
     * 팝업 토글
     * @param {Boolean} open : open 여부
     */
    function togglePopup(open) {
        const $background = $("header, main");
        const $popup = $("section");
        if (open) {
            $background.addClass("popup");
            $popup.removeClass("hide");
        } else {
            $background.removeClass("popup");
            $popup.addClass("hide");
        }
    }

    /**
     * 사용자 검증
     */
    function checkUserAccount() {
        return new Promise(function (resolve, reject) {
            const userData = {};
            const userId = $("#userId").val().trim();
            const userPw = $("#userPassword").val().trim();
            if (userId.length && userPw.length) {
                userData.id = userId;
                userData.password = userPw;
                $.ajax({
                    type: "POST",
                    url: "/user/signup",
                    data: JSON.stringify(userData),
                    dataType: "json",
                    contentType: "application/json; UTF-8;",
                    success: function (response) {
                        if (response.result) {
                            return resolve();
                        } else {
                            alert(response.message);
                        }
                    },
                });
            } else {
                alert("ID와 비밀번호를 모두 입력해주세요.");
            }
        });
    }

    /**
     * 게시글 업로드
     */
    function uploadPost() {
        const postData = {};
        const title = $("#title").val();
        const context = $("#post").val();
        if (title.trim().length && context.trim().length) {
            postData.title = title;
            postData.context = context;
            $.ajax({
                type: "POST",
                url: "/board/write",
                data: JSON.stringify(postData),
                dataType: "json",
                contentType: "application/json; UTF-8;",
                success: function (response) {
                    if (response.result) {
                        $("#userId, #userPassword, #title, #post").val("");
                        togglePopup(true);
                    } else {
                        alert(response.message);
                    }
                },
            });
        } else {
            alert("제목과 내용을 입력해주세요.");
        }
    }

    /**
     * 게시글 조회
     */
    function getBoardList() {
        $.ajax({
            type: "GET",
            url: "/board/list",
            data: { index: 1 },
            dataType: "json",
            contentType: "application/json; UTF-8;",
            success: function (response) {
                if (response.result) {
                    //@Todo : 데이터 0 일때 데이터 없음 처리
                    renderBoardList(response.data.items);
                }
            },
        });
    }

    /**
     * 게시글 렌더링
     * @param {Array} data : 게시글 목록
     */
    function renderBoardList(data) {
        data.forEach(item => {
            const listTemplate = `<li class="post-list">
                                        <details>
                                            <summary class="subject">${item.title}</summary>
                                            <p class="content">${item.context}</p>
                                        </details>
                                        <div class="post-info">
                                            <p><span class="author">${item.writer}</span> | <span class="date">${formattingDate(item.writeDate)}</span></p>
                                        </div>
                                    </li>`
            $('#boardList').append(listTemplate);
        });
    }

    
    /**
     * 날짜 형식 변경
     * @param {String} str : 날짜 형식
     */
    function formattingDate(str){
        let convert = '';
        if(str.length == 10){
            const dateArray = str.split('-');
            dateArray.forEach(function (item, index) {
                convert += index < 2 ? item + ' .' : item;
            });
        }
        return convert;
    }
});
