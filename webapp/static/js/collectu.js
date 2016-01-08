$(function() {
	$.ajax({
		url:'/dtll',
		success:function(data){
			if(data.errorCode == 0){
				$('.row').empty();
				var str;
				for(var i=0;i<data.list.length;i++){
					str = ''
					+'<div class="col-sm-6 col-md-4">'
						+'<div class="thumbnail">'
							+'<img src="'+data.list[i].url+'" alt="...">'
							+'<div class="caption">'
								+'<h3>名称：'+data.list[i].name+'</h3>'
								+'<p>地址：'+data.list[i].addr+'</p>'
								+'<a href="#" class="btn btn-default" role="button" onclick="likeIt('+data.list[i].id+')">取消收藏</a></p>'
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
function likeIt(id){
	$.post("/like", {id:id},function(data) {
		if(data.errorCode == 0){
			alert("添加收藏成功！");
		}else{
			alert("网络连接错误，请稍候重试...");
		}
	});
}