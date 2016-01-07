$(function() {
	$.ajax({
		url:'/orderd',
		success:function(data){
			if(data.errorCode == 0){
				$('.row').empty();
				var str;
				for(var i=0;i<data.list.length;i++){
					str = ''
					+'<div class="col-sm-6 col-md-4">'
						+'<div class="thumbnail">'
							+'<img src="'+data.list.url+'" alt="...">'
							+'<div class="caption">'
								+'<h3>名称：'+data.list.url+'</h3>'
								+'<p>地址：'+data.list.url+'</p>'
								+'<p><a href="#" class="btn btn-primary" role="button">加入购物车</a> <a href="#" class="btn btn-default" role="button">评价</a></p>'
							+'</div>'
						+'</div>'
					+'</div>'
					$('.row').append(str);
				}
			}else{
				alert(errorCodes[data.errorCode]);
			}
		},
		error:function(){
			alert('获取数据失败');
		}
	});
})
function accOrder(id){
	$.post("/accod", {id:id},function(data) {
		if(data.errorCode == 0){
			window.location.reload()
		}else{
			alert("网络连接错误，请稍候重试...");
		}
	});
}
function rejOrder(id){
	$.post("/rejod", {id:id},function(data) {
		if(data.errorCode == 0){
			window.location.reload()
		}else{
			alert("网络连接错误，请稍候重试...");
		}
	});
}
function sucOrder(id){
	$.post("/sucod", {id:id},function(data) {
		if(data.errorCode == 0){
			window.location.reload()
		}else{
			alert("网络连接错误，请稍候重试...");
		}
	});
}