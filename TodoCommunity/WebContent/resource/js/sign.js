$(document).ready(function () {
    $('#loginBtn').on("click",function () {
        const userData = {};
        userData.id = $('#userId').val();
        userData.pw = $('#userPw').val();
        $.ajax({
            type: "POST",
            url: "/login",
            data: userData,
            dataType: "dataType",
            success: function (response) {
                console.log(JSON.stringify(response));
            }
        });
    });
});