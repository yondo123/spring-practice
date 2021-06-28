$(document).ready(function () {
    //카테고리 변경 비활성화
    $('#category').attr('disabled', true);

    /**
     * 글쓰기 수정 이벤트
     */
    $('#btnWrite').click(function () {
        //patch - code
    });

    $('#btnCancel').click(function () {
       if(confirm("게시글 수정을 취소하시겠습니까?")){
           return window.history.back();
       } 
    });
});