$(document).ready(function () {
    let reqPageNumber = 1;
    const boardType = $('#board').attr('type');
    const boardIndex = boardType == constants.STUDY_BOARD_ID ? 1 : 2;
    
    util.ui.setMenuClass(boardType);
    sessionStorage.setItem('board', JSON.stringify({
        index : boardIndex,
        name  : boardType
    }));
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

    /**
     * 글쓰기 렌더링
     * @param {Array} data 
     */
    function renderBoardList(data) {
        const listArray = data.items;
        for (let i = 0; i < listArray.length; i++) {
            let $listTemplate = $(template.BOARD_ITEM);
            let postInfo = '글쓴이 : ' + listArray[i].writerId + ' | 작성날짜 : ' + util.date.formatToDate(listArray[i].writeDate);
            $listTemplate.find('img').attr('src', util.data.getIconImagePath(listArray[i].cateIndex));
            $listTemplate.find('.content').text(listArray[i].contentSubject);
            $listTemplate.find('.post-info').text(postInfo);
            $listTemplate.appendTo('.board-list');
        }

        util.ui.setPagingArea({
            listCnt : data.totalCount,
            viewCnt : constants.BOARD_COUNT,
            loopCnt : constants.PAGINATION_COUNT,
            reqPage : reqPageNumber,
            page    : $('#pagingList')
        })
    }
});