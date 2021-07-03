$(document).ready(function () {
    //카테고리 셋팅
    const boardInfo = JSON.parse(sessionStorage.getItem('board'));
    const boardType = boardInfo.name;
    let contentLength = 0;

    util.ui.setMenuClass(boardType);
    getCategoryList().then(setCategoryList);

    /**
     * 게시판 텍스트 명시
     */
    $('#boardHeading').text(function () {
        const fixText = '게시판';
        if(boardInfo.index === 1){
            return constants.STUDY_BOARD + fixText;
        }else{
            return constants.COMMUNITY_BOARD + fixText;
        }
    });

    /**
     * init summernote
     */
    $('#summernote').summernote({
        toolbar: [
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['fontsize', ['fontsize']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
            ['insert', ['link', 'picture']],
        ],
        focus: true,
        lang: "ko-KR",
        placeholder: '최대 1200자까지 쓸 수 있습니다',
        callbacks: {
            onKeyup: function (e) {
                return contentLength = e.currentTarget.innerText.length;
            },
            onPaste: function (e) {
                return contentLength = e.currentTarget.innerText.length;
            },
            onImageUpload: function (file) {
                contentLength += 1;
                return uploadImage(file[0]);
            }
        }
    });

    /**
     * 글쓰기 등록 이벤트
     */
    $('#btnWrite').click(function () {
        const postData = {};
        const $selectedCategory = $('#category option:selected');
        const subject = $('#title').val();
        const content = $("#summernote").summernote('code');
        const cateIndex = Number($selectedCategory.attr('type'));
        const uploadImageList = util.data.extractImageName(content);

        postData.contentContext = util.data.removeTempResource(content); //게시글
        postData.contentSubject = subject; //제목
        postData.cateIndex = cateIndex; //카테고리
        postData.boardIndex = boardInfo.index; //게시판 타입
        postData.uploadImageList = uploadImageList; //업로드 이미지

        if (validateContent(subject)) {
            $.ajax({
                type: "POST",
                url: `${constants.REQUEST_URL}/board/contentWrite`,
                data: JSON.stringify(postData),
                contentType: 'application/json; UTF-8;',
                dataType: 'json',
                success: function (response) {
                    if (response.result) {
                        alert('성공적으로 글을 등록하였습니다.');
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

    /**
     * 카테고리 목록 조회
     */
    function getCategoryList(){
        return new Promise(function (resolve, reject) {
            $.ajax({
                type: "GET",
                url: `${constants.REQUEST_URL}/board/category`,
                data: {
                    cateType: boardInfo.name
                },
                contentType: 'application/json; UTF-8;',
                dataType: 'json',
                success: function (response) {
                    return resolve(response.data);
                },
                error: function (response) {
                    alert("알 수 없는 오류가 발생하였습니다.");
                }
            });
        });
    }

    /**
     * 본문 내용 검사
     * @param {String} subject : 제목 
     * @returns {Boolean} : validate 결과
     */
    function validateContent(title) {
        if(!contentLength || !title.length){
            alert('제목과 내용을 입력해주세요.');
            return false;
        }else if(contentLength > 5000){
            alert('본문 내용은 최대 5000자 까지 가능합니다.');
            return false;
        }else{
            return true;
        }
    }

    /**
     * 카테고리 목록 생성
     * @param {Array} data : 카테고리 리스트 배열
     */
    function setCategoryList(data) {
        for (let i = 0; i < data.length; i++) {
            $('#category').append(`<option type=${data[i].cateIndex}>${data[i].cateName}</option>`);
        }
    }

    /**
     * 이미지 파일 에디터 삽입
     * @param {String} imageUrl : 이미지 URL
     * @param {Object} $editor  : 에디터 
     */
    function insertImage(imageUrl, $editor){
        return $editor.summernote('insertImage', imageUrl);
    }

    /**
     * 단일 이미지 업로드
     * @param {Object} file : upload File
     */
    function uploadImage(file){
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
});
