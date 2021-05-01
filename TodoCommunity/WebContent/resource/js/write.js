$(document).ready(function () {
    $('#btnWrite').click(function () {
        const reqData = {};
        reqData.contentText = $('#content').val();
        reqData.contentSubject = $('#title').val();
        reqData.file = '';
        reqData.cateIndex = 1;
        reqData.boardIndex = 1;
        alert(JSON.stringify(reqData));

        if(reqData.contentSubject.length < 1 || reqData.contentText.length < 1){
            alert("제목과 내용을 입력해주세요.");
        }else{
        // $.ajax({
        //     type: "POST",
        //     url: `${constants.REQUEST_URL}/board/contentWrite`,
        //     data: JSON.stringify(userData),
        //     contentType: 'application/json; UTF-8;',
        //     dataType: 'json',
        //     success: function (response) {
        //         if(response.result){
        //             $status.addClass('hide');
        //             goToMain();
        //         }else{
        //             $status.removeClass('hide').text('비밀번호를 다시 확인해주세요.');
        //         }
        //     },
        //     error: function (response) {
        //         alert("알 수 없는 오류가 발생하였습니다.");
        //     }
        // });
        }
    });
});