$(document).ready(function () {
    let enableJoin = false;

	//ID중복체크
    $('#joinBtn').on("click",function () {
        const signData = {};
        signData.userId = $('#userId').val();
        signData.userPw = $('#userPw').val();
        signData.confirmPw = $('#confirmPw').val();
        signData.userName = $('#userName').val();
        signData.isUserCheck = enableJoin;
        if(enableJoin){
            $.ajax({
                type: "POST",
                url: `${constants.REQUEST_URL}/user/signup`,
                data: JSON.stringify(signData),
                contentType: 'application/json; UTF-8;',
                dataType: 'json',
                success: function (response) {
                    if(response.result){
                        alert("가입이 완료되었습니다.");
                        location.href = `${constants.REQUEST_URL}/user/sign`;
                    }else{
                        alert(response.message);
                    }
                },
                error: function (response) {
                    alert("알 수 없는 오류가 발생하였습니다.");
                }
            });
        }else{
            alert("사용 불가능한 ID 입니다.");
        }
    });
    
    //회원가입 
    $('#userId').on('blur', function(){
        const userId = $(this).val();
        const $status = $('#status'); 
        if(userId.trim().length > 0){
            $.ajax({
                type:"GET",
                url:`${constants.REQUEST_URL}/user/identity/${userId}`,
                dataType: 'json',
                success: function(response){
                    console.log(response);
                    if(response.result){
                        enableJoin = true;
                        $status.removeClass('hide').addClass('success').text("사용하실 수 있는 ID 입니다.");
                        if(!$status.hasClass('error')){
                            $status.addClass('success');
                        }
                    }else{
                        enableJoin = false;
                        $status.removeClass('hide').addClass('error').text('이미 존재하는 아이디 입니다.');
                        if($status.hasClass('success')){
                            $status.removeClass('success');
                        }
                    }
                }
            });
        }else{
            $status.addClass('hide');
        }
    });
});