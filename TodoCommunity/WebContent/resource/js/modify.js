$(document).ready(function () {
    const boardInfo = JSON.parse(sessionStorage.getItem('board'));
    let contentLength = 0;
    //카테고리 변경 비활성화
    $('#category').attr('disabled', true);

    /**
     * 글쓰기 수정 이벤트
     */
    $('#btnModify').click(function () {
        postData = {};
        const cateIndex = Number($('#category option:selected').attr('type'));
        const subject = $('#title').val();
        const content = $('#summernote').summernote('code');
        const uploadImageList = util.data.extractImageName(content);

        postData.contentContext = util.data.removeTempResource(content); //게시글
        postData.contentSubject = subject; //제목
        postData.cateIndex = cateIndex; //카테고리
        postData.contentIndex = Number($('.post').data('postId')); //게시판 타입
        postData.uploadImageList = uploadImageList; //업로드 이미지

        if (validateContent(subject, content)) {
            $.ajax({
                type: "PATCH",
                url: `${constants.REQUEST_URL}/board/modify-post`,
                data: JSON.stringify(postData),
                contentType: 'application/json; UTF-8;',
                dataType: 'json',
                success: function (response) {
                    if (response.result) {
                        alert('성공적으로 글을 수정하였습니다.');
                        return util.ui.locatePage(boardInfo.name);
                    } else {
                        alert("알 수 없는 오류가 발생하였습니다.");
                    }
                },
                error: function (response) {
                    alert("알 수 없는 오류가 발생하였습니다.");
                }
            });
        }
    });


    //목록 이동
    $('#btnCancel').click(function () {
        if (confirm("게시글 수정을 취소하시겠습니까?")) {
            return window.history.back();
        }
    });

    /**
     * 단일 이미지 업로드
     * @param {Object} file : upload File
     */
    function uploadImage(file) {
        const reqData = new FormData();
        reqData.append("uploadFile", file);
        $.ajax({
            type: "POST",
            url: `${constants.REQUEST_URL}/board/image`,
            data: reqData,
            processData: false,
            contentType: false,
            success: function (response) {
                if (response.result) {
                    return insertImage(constants.REQUEST_URL + constants.TEMP_IMAGE_URL + response.data, $('#summernote'));
                } else {
                    alert('이미지 파일 업로드에 실패하였습니다.\n잠시후 다시 시도해주세요.');
                }
            },
            error: function (response) {
                alert('이미지 파일 업로드에 실패하였습니다.\n잠시후 다시 시도해주세요.');
            }
        });
    }

    /**
     * 본문 내용 검사
     * @param {String} subject : 제목 
     * @param {String} content : 본문
     * @returns {Boolean} : validate 결과
     */
    function validateContent(title, content) {
        if (!content.length || !title.length) {
            alert('제목과 내용을 입력해주세요.');
            return false;
        } else if (contentLength > 5000) {
            alert('본문 내용은 최대 5000자 까지 가능합니다.');
            return false;
        } else {
            return true;
        }
    }
});