$(function() {
	//登录弹框
	$('.dropdown-menu li').eq(0).click(function(){
		$('#alogin').removeClass("hide");
		$('#half_gray').removeClass("hide");
	});
	
	//点击阴影关闭弹框
	$('#half_gray').click(function(){
		$('#alogin').addClass("hide");
		$('#half_gray').addClass("hide");
	});
	$('#btn-log').click(function(){
		var email = $('#email').val();
		var password = hex_md5($('#password').val());
//		console.log(email+"--"+password);
		$.ajax({
    		type:"post",
    		asyn:false,
    		url:"/alogin",
    		data:{email:email,pwd:password},
    		dataType: "json",
    		success:function(data){
    			switch(data.errorCode){
    				case 0: alert('success'); break;
    				case 1: alert("参数错误！"); break;
    				case 2: $alert("没有登录！"); break;
    				case 3: alert("没有如此的用户！"); break;
    			}
    		},
    	});
	})
	$('#btn-reg').click(function(){
		var email = $('#email').val();
		var password = hex_md5($('#password').val());
		$.ajax({
    		type:"post",
    		asyn:false,
    		url:"/aregest",
    		data:{email:email,pwd:password},
    		dataType: "json",
    		success:function(data){
    			switch(data.errorCode){
    				case 0: alert('success'); break;
    				case 1: alert("参数错误！"); break;
    				case 2: $alert("没有登录！"); break;
    				case 3: alert("没有如此的用户！"); break;
    			}
    		},
    	});
	})
})