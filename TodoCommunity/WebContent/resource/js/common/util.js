//util.js
const util = (function () {
    function method() {
        //private 스코프
        const private = {
            dateFormat: '10',
        }

        //공용 스코프
        const dateUtil = {};
        const arrayUtil = {};
        const mainUtil = {};
        const utility = {};

        /**
         * 임시코드 발급
         * @param {String} str : attach String  
         * @returns 
         */
        utility.createTempCode = function (str) {
            return (str ? str : '') + new Date().toISOString().substr(18, 5).replace(/[^0-9]/g, "")
        }

        /**
         * 날짜 형식 변환
         * @param {String} date : Stringify Date (YYYYMMDD) 
         * @param {String} type : 구분자 (default : .) 
         */
        dateUtil.formatToDate = function (date, type) {
            if (date.length == 8) {
                const separate = type ? type : '.';
                const harfDate = date.replace(/(\d)(?=(?:\d{4})+(?!\d))/g, "$1" + separate);
                return harfDate.substr(0, 5) + harfDate.split(separate)[1].replace(/(\d)(?=(?:\d{2})+(?!\d))/g, '$1' + separate);
            }
        }
        
        /**
         * 현재 시간 구하기
         */
        dateUtil.getCurrentTime = function () {
            return new Date().toISOString().substr(0, private.dateFormat);
        }

        /**
         * String To Date
         * @param {String} date : stringify date (YYYYMMDD)
         * @returns 
         */
        dateUtil.dateToStr = function (date) {
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
        dateUtil.strToDate = function (date) {
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
        arrayUtil.compareArray = function (arrA, arrB) {
            if (arrA == null || arrB == null) return false;
            if (arrA.length != arrB.length) return false;
            for (var i = 0; i < arrA.length; i++) {
                if (arrA[i] !== arrB[i]) return false;
            }
            return true;
        }

        return {
            dateUtil: dateUtil,
            arrayUtil: arrayUtil,
            mainUtil: mainUtil
        };
    }

    return method();
})()