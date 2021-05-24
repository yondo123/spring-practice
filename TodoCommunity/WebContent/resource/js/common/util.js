//util.js
const util = (function () {
    function method() {
        //private 스코프
        const private = {
            dateFormat: '10'
        }

        //public 스코프
        const date = {};
        const array = {};
        const data = {};
        const ui = {};

        /**
         * 임시코드 발급
         * @param {String} str : attach String  
         * @returns 
         */
        data.createTempCode = function (str) {
            return (str ? str : '') + new Date().toISOString().substr(18, 5).replace(/[^0-9]/g, "")
        }

        /**
         * 메뉴 별 카테고리 리스트 조회
         */
        data.getBoardCategory = function () {
            $.ajax({
                type: "POST",
                url: `${constants.REQUEST_URL}/board/getCategoryList`,
                data: JSON.stringify({
                    cateType: sessionStorage.getItem('board')
                }),
                contentType: 'application/json; UTF-8;',
                dataType: 'json',
                success: function (response) {
                    return response.data;
                },
                error: function (response) {
                    alert("알 수 없는 오류가 발생하였습니다.");
                }
            });
        }


        /**
         * 아이콘 이미지 파일 리턴
         * @param {Number} index : 카테고리 번호
         */
        data.getIconImagePath = function (index) {
            let iconImagePath = '/TodoCommunity/resource/img/';
            switch (index) {
                case 1:
                    iconImagePath += constants.JS_ICON_FILE;
                    break;
                case 2:
                    iconImagePath += constants.JAVA_ICON_FILE;
                    break;
                case 3:
                    iconImagePath += constants.HTML_ICON_FILE;
                    break;
                case 4:
                    iconImagePath += constants.PHP_ICON_FILE;
                    break;
                case 5:
                    iconImagePath += constants.PYTHON_ICON_FILE;
                    break;
                case 6:
                    iconImagePath += constants.SQL_ICON_FILE;
                    break;
                case 7:
                    iconImagePath += constants.MOBILE_ICON_FILE;
                    break;
                case 8:
                    iconImagePath += constants.ETC_ICON_FILE;
                    break;
            }
            return iconImagePath;
        }

        /**
         * 날짜 형식 변환
         * @param {String} date : Stringify Date (YYYYMMDD) 
         * @param {String} type : 구분자 (default : .) 
         */
        date.formatToDate = function (date, type) {
            if (date.length == 8) {
                const separate = type ? type : '.';
                const harfDate = date.replace(/(\d)(?=(?:\d{4})+(?!\d))/g, "$1" + separate);
                return harfDate.substr(0, 5) + harfDate.split(separate)[1].replace(/(\d)(?=(?:\d{2})+(?!\d))/g, '$1' + separate);
            }
        }

        /**
         * 현재 시간 구하기
         */
        date.getCurrentTime = function () {
            return new Date().toISOString().substr(0, private.dateFormat);
        }

        /**
         * String To Date
         * @param {String} date : stringify date (YYYYMMDD)
         * @returns 
         */
        date.dateToStr = function (date) {
            if (typeof date == 'string' && date.length == 8) {
                const year = Number(date.substr(0, 4));
                const month = Number(date.substr(4, 2));
                const day = Number(date.substr(6, 2));
                return new Date(year, month - 1, day);
            }
        }

        /**
         * Date To String (YYYYMMDD)
         * @param {date} date : date 객체 
         */
        date.strToDate = function (date) {
            const year = (date.getFullYear()).toString();
            const month = date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1).toString() : (date.getMonth() + 1).toString();
            const day = date.getDate() < 10 ? '0' + date.getDate().toString() : date.getDate();
            return year + month + day;
        }

        /**
         * 두 개의 배열 비교
         * @param {Array} arrA 
         * @param {Array} arrB 
         */
        array.compareArray = function (arrA, arrB) {
            if (arrA == null || arrB == null) return false;
            if (arrA.length != arrB.length) return false;
            for (let i = 0; i < arrA.length; i++) {
                if (arrA[i] !== arrB[i]) return false;
            }
            return true;
        }

        /**
         * 선택 클래스 추가
         * @param {String} menu : 메뉴 타입 
         */
        ui.addSelectMenuClass = function (menu) {
            $('#menuList a').each(function (idx, item) {
                if($(item).attr('type') == menu){
                    $(item).addClass('select');
                    return $(item).siblings().removeClass('select');
                }
            });
        }

        /**
         * 페이지 영역 렌더링
         * @param {Object} param : 페이징 data 객체
         * 			 {Number} listCnt    : 리스트 총 갯수
         * 			 {Number} viewCnt 	 : 리스트에 렌더 할 갯수 
         * 	 		 {Number} loopCnt    : 페이지 버튼 렌더 갯수 	 
         * 	  	     {Number} reqPage 	 : 요청 페이지
         * 		     {Object} page 	 	 : 페이징 영역 Jquery Selector
         */
        ui.setPagingArea = function (param) {
            const listCount = Number(param.listCnt);
            const loopCount = Number(param.loopCnt);
            const viewCnt = param.viewCnt;
            const pagingLength = Math.ceil(listCount / Number(viewCnt));
            const reqPage = Number(param.reqPage);
            const $page = param.page;
            const $seqPage = $page.find('li').not('.pageCtrl'); //실제 페이지 영역
            const firstPage = Number($seqPage.first().attr('pageSeq')) ? Number($seqPage.first().attr('pageSeq')) : 0;
            const lastPage = Number($seqPage.last().attr('pageSeq')) ? Number($seqPage.last().attr('pageSeq')) : 0;

            if (listCount > 0 && typeof loopCount == 'number' && $page.length && typeof reqPage == 'number') {
                //실제 페이지 그리는 함수
                function renderPage() {
                    $seqPage.remove();
                    const startIndex = reqPage <= loopCount ? reqPage : reqPage - (reqPage % loopCount == 0 ? loopCount - 1 : reqPage % loopCount);

                    for (let i = startIndex; i < startIndex + loopCount; i++) {
                        if (i <= pagingLength) {
                            const activeClass = (i == reqPage) ? "<li class='active'>" + i + "</li>" : "<li>" + i + "</li>";
                            $(activeClass).attr('pageSeq', i);
                            $page.find('.pageCtrl[type=next]').before(activeClass);
                        }
                    }
                }

                if (reqPage == 1 || listCount == 1) {
                    return renderPage();
                }

                if (firstPage > 0 && lastPage > 0) { //페이지 영역 존재 여부 
                    if (reqPage >= firstPage && reqPage <= lastPage && reqPage <= pagingLength) { //요청 번호가 이미 페이지에 존재
                        $seqPage.removeClass('active'); //기존 select class 제거
                        $page.find('li [pageSeq =' + reqPage + ']').addClass('active');
                    } else {
                        return renderPage();
                    }
                } else {
                    return renderPage();
                }
            }
        }

        /**
         * 메뉴 active 클래스 설정
         * @param {Sting} menu : 메뉴 
         */
        ui.setMenuClass =function (menu) {
            $('#menuList a').each(function(idx, item){
                const menuType = $(item).attr('type') || '';
                $(item).removeClass('select');
                if(menuType && menuType == menu){
                    return $(item).addClass('select');
                }
            });
        }

        return {
            date: date,
            array: array,
            data: data,
            ui: ui
        };
    }

    return method();
})()