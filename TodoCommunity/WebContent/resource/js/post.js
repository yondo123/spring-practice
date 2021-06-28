$(document).ready(function () {
    const boardInfo = JSON.parse(sessionStorage.getItem('board'));
    
    //목록 이동
    $('#btnBoard').click(function () {
        let boardPath = boardInfo.name;
        if(!boardPath){
            boardPath = $(this).attr('type') === 1 ? constants.STUDY_BOARD_ID : constants.COMMUNITY_BOARD_ID;
        }
        return util.ui.locatePage(boardPath);
    });

    
    // function getBoardList(){
    //     $.ajax({
    //         type: "GET",
    //         url: `${constants.REQUEST_URL}/board/list`,
    //         data: {
    //             boardIndex: boardIndex,
    //             reqPage: reqPageNumber
    //         },
    //         contentType: 'application/json; UTF-8;',
    //         dataType: 'json',
    //         success: function (response) {
    //             if (response.result) {
    //                 totalPageCount = response.data.totalCount;
    //                 return renderBoardList(response.data)
    //             }
    //         },
    //         error: function (response) {
    //             alert("알 수 없는 오류가 발생하였습니다.");
    //         }
    //     });
    // }
});