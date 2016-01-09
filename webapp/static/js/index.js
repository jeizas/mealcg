$(function() {
	$.ajax({
		url:'/hotf',
		success:function(data){
			if(data.errorCode == 0){
				var str;
				$('#hotFood').empty();
				for(var i=0;i<data.list.length;i++){
					str = ''
					+'<div class="col-md-6">'
						+'<div class="thumbnail">'
							+'<img src="'+data.list[i].url+'" class="pull-left" alt="" style="width:180px;height:180px;">'
							+'<div class="caption">'
								+'<h5 style="line-height:2px;">'+data.list[i].name+'</h5>'
								+'<small style="color:#1abc9c;">'+data.list[i].dsc+'</small>'
								+'<p class="sh ps">￥'+data.list[i].money+'</p>'
								+'<p class="sh">12元起送</p>'
								+'<p class="sh">月销量'+data.list[i].money+'份</p>'
							+'</div>'
							+'<button class="btn btn-large btn-block no-margin" onclick="addCart('+data.list[i].id+')" type="button">加入购物车</button>'
						+'</div>'
					+'</div>'
					$('#hotFood').append(str);
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

function addCart(id){
	$.post("/addct", {foodId:id},function(data) {
		if(data.errorCode == 0){
			$('.badge').text(parseInt($('.badge').text()) + 1);
			alert("操作成功!");
		}else{
			alert("网络连接错误，请稍候重试...");
		}
	});
}
