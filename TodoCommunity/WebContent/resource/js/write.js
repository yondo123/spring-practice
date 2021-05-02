$(document).ready(function () {
    /**
     * post 등록 이벤트
     */
    $('#btnWrite').click(function () {
        let reqData = new FormData();
        const subject = $('#title').val();
        const content = $('#content').val();
        // const body = {};
        // body.contentText = $('#content').val();
        // body.contentSubject = $('#title').val();
        // body.cateIndex = 1;
        // body.boardIndex = 1;
        reqData.append('uploadFile', $('#imageFile')[0].files[0]);
        reqData.append('contentText', content);
        reqData.append('contentSubject',subject);
        reqData.append('cateIndex',1);
        reqData.append('boardIndex', 1);

        if (subject.length < 1 || content.length < 1) {
            alert("제목과 내용을 입력해주세요.");
        } else {
            $.ajax({
                type: "POST",
                url: `${constants.REQUEST_URL}/board/contentWrite`,
                data: reqData,
                processData: false,
                contentType: false,
                dataType: 'json',
                success: function (response) {
                    if(response.result){
                        alert('성공적으로 글을 등록하였습니다.')
                    }else{
                        alert("알 수 없는 오류가 발생하였습니다.");
                    }
                },
                error: function (response) {
                    alert("알 수 없는 오류가 발생하였습니다.");
                }
            });
        }
    });
});