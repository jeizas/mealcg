$(function() {
	$.ajax({
		url:'/hotf',
		success:function(data){
			if(data.errorCode == 0){
				var str;
				for(var i=0;i<data.list.length;i++){
					str = ''
					+'<div class="col-md-6">'
						+'<div class="thumbnail">'
							+'<img src="/resource/mealface/ '+data.list[i].id+' / '+data.list[i].img+' " class="pull-left" alt="" style="width:180px;height:180px;">'
							+'<div class="caption">'
								+'<h3 style="line-height:2px;">'+data.list[i].name+'</h3>'
								+'<small style="color:#f6be6a;">'+data.list[i].dsc+'</small>'
								+'<p class="sh ps">￥'+data.list[i].money+'</p>'
								+'<p class="sh">12元起送</p>'
								+'<p class="sh">月销量'+data.list[i].money+'份</p>'
							+'</div>'
							+'<button class="btn btn-large btn-block no-margin" type="button">加入购物车</button>'
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