$(document).ready(function () {
    $.ajax({
        type: "POST",
        url: `${constants.REQUEST_URL}/board/getBoardList`,
        data: JSON.stringify({boardIndex: 1}),
        contentType: 'application/json; UTF-8;',
        dataType: 'json',
        success: function (response) {
            console.log(JSON.stringify(response))
            if (response.result) {
                return renderBoardList(response.data)
            } else {
                $status.removeClass('hide').text('비밀번호를 다시 확인해주세요.');
            }
        },
        error: function (response) {
            alert("알 수 없는 오류가 발생하였습니다.");
        }
    });

    function renderBoardList(data) {
        for (let i = 0; i < data.length; i++) {
            let $listTemplate = $(template.BOARD_ITEM);
            let postInfo = '글쓴이 : ' + data[i].writerId + ' | 작성날짜 : ' + data[i].writeDate;
            $listTemplate.find('img').attr('src', '/TodoCommunity/resource/img/app_logo.png');
            $listTemplate.find('.content').text(data[i].contentSubject);
            $listTemplate.find('.post-info').text(postInfo);
            $listTemplate.appendTo('.board-list');
        }
    }
});