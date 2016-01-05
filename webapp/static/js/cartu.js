$(function() {
	$('.checkbtn').click(function(){
		alert("支付宝转账到13332420972");
	})
})
function foodm(id,money){
	var cnt = $('#cnt'+id+'').val();
	if(cnt != null && cnt > 0){
		cnt = (parseInt(cnt) - 1);
		money = parseInt($('#sum').text())-parseInt(money);
		changeCount(id,cnt,money)
	}
}
function foodp(id,money){
	var cnt = $('#cnt'+id+'').val();
	if(cnt != null && cnt > 0){
		cnt = (parseInt(cnt) + 1);
		money = parseInt($('#sum').text())+parseInt(money);
		changeCount(id,cnt,money)
	}
}
function changeCount(id,cnt,money){
	$.post("/foodm", {id:id,count:cnt},function(data) {
		if(data.errorCode == 0){
			$('#cnt'+id+'').val(cnt);
			$('#sum').text(money);
			alert("操作成功!");
		}else{
			alert("网络连接错误，请稍候重试...");
		}
	});
}
function delorder(id){
	$.post("/orderd", {id:id},function(data) {
		if(data.errorCode == 0){
			$('#cnt'+id+'').parent().parent().empty();
			$('#sum').text(parseInt($('#sum').text())-parseInt(data.money));
			alert("操作成功!");
		}else{
			alert("网络连接错误，请稍候重试...");
		}
	});
}