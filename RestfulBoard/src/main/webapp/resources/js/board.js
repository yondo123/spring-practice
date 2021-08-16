$(function () {
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
                    console.log(JSON.stringify(response));
                },
            });
        } else {
            alert("ID와 비밀번호를 모두 입력해주세요.");
        }
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
});
