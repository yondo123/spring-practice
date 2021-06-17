$(document).ready(function () {
    //카테고리 셋팅
    const boardInfo = JSON.parse(sessionStorage.getItem('board'));
    getCategoryList().then(setCategoryList);

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
                console.log(e.currentTarget.innerText.length);
            },
            onPaste: function (e) {
                console.log(e.currentTarget.innerText.length);
            },
            onImageUpload: function (file) {
                return uploadImage(file[0]);
            }
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
     * 카테고리 목록 생성
     * @param {Array} data : 카테고리 리스트 배열
     */
    function setCategoryList(data) {
        for (let i = 0; i < data.length; i++) {
            $('#category').append(`<option type=${data[i].cateIndex}>${data[i].cateName}</option>`);
        }
    }

    /**
     * 단일 이미지 업로드
     * @param {Object} file 
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
                    alert('성공적으로 글을 등록하였습니다.')
                } else {
                    alert("업로드에 실패하였습니다.");
                }
            },
            error: function (response) {
                alert("업로드에 실패하였습니다.");
            }
        });
    }

    /**
     * post 등록 이벤트
     */
    $('#btnWrite').click(function () {
        let reqData = new FormData();
        const $selectedCategory = $('#category option:selected');
        const file = $('#imageFile')[0].files[0];
        const subject = $('#title').val();
        const content = $('#content').val();
        const cateIndex = Number($selectedCategory.attr('type'));


        reqData.append('contentText', content);
        reqData.append('contentSubject', subject);
        reqData.append('cateIndex', cateIndex);
        reqData.append('boardIndex', boardInfo.index);

        if (file) {
            reqData.append('uploadFile', file);
        }

        if (subject.length < 1 || content.length < 1) {
            alert("제목과 내용을 입력해주세요.");
        } else {
            $.ajax({
                type: "POST",
                url: `${constants.REQUEST_URL}/board/contentWrite`,
                data: reqData,
                processData: false,
                contentType: false,
                success: function (response) {
                    if (response.result) {
                        alert('성공적으로 글을 등록하였습니다.')
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
});
