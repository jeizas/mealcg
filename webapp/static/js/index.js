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
})