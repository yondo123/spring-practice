$(document).ready(function () {
    let reqPageNumber = 1;
    let totalPageCount = 0;
    const boardType = $('#board').attr('type');
    const boardIndex = boardType == constants.STUDY_BOARD_ID ? 1 : 2;
    
    util.ui.setMenuClass(boardType);

    sessionStorage.setItem('board', JSON.stringify({
        index : boardIndex,
        name  : boardType
    }));

    getBoardList();

    /**
     * 페이징 버튼 클릭 event
     */
    $('#pagingList').on('click', 'li', function () {
        if($(this).hasClass('pageCtrl')){
            const targetPage = Number($('#pagingList').find('.selected').text());
            const moveType = $(this).attr('type');
            const $seqPage = $('#pagingList').find('li').not('.pageCtrl');
            if(moveType === 'prev'){
                reqPageNumber = Number($seqPage.first().text()) > 1 ? targetPage - 1 : 1;
                return getBoardList();
            }else{
                reqPageNumber = totalPageCount > Number($seqPage.last().text()) * 4 ? targetPage + 1 : targetPage;
                return getBoardList();
            }
        }else{
            reqPageNumber = Number($(this).text());
            return getBoardList();
        }
    });

    /**
     * 글쓰기 페이지 이동
     */
    $('#btnWrite').click(function () {
       return util.ui.locatePage('write');
    });

    /**
     * 게시글 조회
     */
    function getBoardList(){
        $.ajax({
            type: "GET",
            url: `${constants.REQUEST_URL}/board/list`,
            data: {
                boardIndex: boardIndex,
                reqPage: reqPageNumber
            },
            contentType: 'application/json; UTF-8;',
            dataType: 'json',
            success: function (response) {
                console.log(response.data);
                if (response.result) {
                    totalPageCount = response.data.totalCount;
                    return renderBoardList(response.data)
                }
            },
            error: function (response) {
                alert("알 수 없는 오류가 발생하였습니다.");
            }
        });
    }

    /**
     * 글쓰기 렌더링
     * @param {Array} data 
     */
    function renderBoardList(data) {
        $('#boardList').empty();
        const listArray = data.items;
        const listSize = listArray.length;

        for (let i = 0; i < listSize; i++) {
            let $listTemplate = $(template.BOARD_ITEM);
            let icon = util.data.getIconImagePath(listArray[i].cateIndex);
            let postInfo = '글쓴이 : ' + listArray[i].writerId + ' | 작성날짜 : ' + util.date.formatToDate(listArray[i].writeDate);
            $listTemplate.find('img').attr('src', icon.path).attr('alt', icon.name);
            $listTemplate.find('a').attr('href', `${constants.POST_URL}contentIndex=${listArray[i].contentIndex}&cateIndex=${listArray[i].cateIndex}` );
            $listTemplate.find('.content').text(listArray[i].contentSubject);
            $listTemplate.find('.detail').text(postInfo);
            $listTemplate.appendTo('#boardList');
        }

        util.ui.setPagingArea({
            listCnt : data.totalCount,
            viewCnt : constants.BOARD_COUNT,
            loopCnt : constants.PAGINATION_COUNT,
            reqPage : reqPageNumber,
            page    : $('#pagingList')
        });
    }
});