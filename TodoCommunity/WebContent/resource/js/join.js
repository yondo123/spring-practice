$(document).ready(function () {
    $('#joinBtn').on("click",function () {
        const signData = {};
       	signData.USER_INDEX = 1;
        signData.USER_ID = $('#userId').val();
        signData.USER_PW = $('#userPw').val();
        signData.USER_NAME = $('#userName').val();
        $.ajax({
            type: "POST",
            url: "/TodoCommunity/user/signup",
            data: JSON.stringify(signData),
            contentType: 'application/json; UTF-8;',
            dataType: 'json',
            success: function (response) {
                console.log(JSON.stringify(response));
            }
        });
    });
});