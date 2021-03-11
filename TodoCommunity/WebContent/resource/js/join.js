$(document).ready(function () {
	//ID중복체크
    $('#joinBtn').on("click",function () {
        const signData = {};
        signData.userId = $('#userId').val();
        signData.userPw = $('#userPw').val();
        signData.userName = $('#userName').val();
        $.ajax({
            type: "POST",
            url: "/TodoCommunity/user/signup",
            data: JSON.stringify(signData),
            contentType: 'application/json; UTF-8;',
            dataType: 'json',
            success: function (response) {
                console.log(JSON.stringify(response));
            }
        });
    });
    
    //회원가입 
    $('#idChkBtn').on('click', function(){
    	const userId = $('#userId').val();
    	$.ajax({
    		type:"GET",
    		url:"/TodoCommunity/user/identity/"+userId,
    		dataType: 'text',
    		success: function(response){
    			console.log(response);
    		}
    	});
    });
});