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

    //게시글 수정
    $('#btnModify').click(function () {
        return window.location.href = `${constants.POST_MODIFY_URL}contentIndex=${Number($('.post').data('postId'))}`;
    });
});