$(document).ready(function () {
    $('#loginBtn').on("click", function () {
        const $status = $('#status');
        const userData = {};
        userData.userId = $('#userId').val();
        userData.userPw = $('#userPw').val();
        userData.confirmPw = userData.userPw;
        userData.isUserCheck = true;
        
        $.ajax({
            type: "POST",
            url: `${constants.REQUEST_URL}/user/signin`,
            data: JSON.stringify(userData),
            contentType: 'application/json; UTF-8;',
            dataType: 'json',
            success: function (response) {
                return response.result ? goToMain() : $status.attr('class', 'error-text').show();
            },
            error: function (response) {
                alert("알 수 없는 오류가 발생하였습니다.");
            }
        });
    });

    function goToMain() {
        return location.href = `${constants.REQUEST_URL}`;
    }
});