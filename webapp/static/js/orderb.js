$(function() {
	$.ajax({
		url:'/orderd',
		success:function(data){
			if(data.errorCode == 0){
				$('#tab1').children().empty();
				var str;
				for(var i=0;i<data.list.length;i++){
					str = ''
					+'<div class="col-sm-4 col-md-3" >'
						+'<div class="thumbnail">'
							+'<img src="'+data.list[i].url+'" alt="..." style= "margin:15px;">'
							+'<div class="caption" style= "margin:15px;">'
								+'<h3>¥10</h3><h4>'+data.list[i].name+'</h4>'
								+'<p>'+data.list[i].addr+'</p>'
								+'<p>'+data.list[i].user+'</p>'
								+'<p><a href="#" class="btn btn-primary" role="button" style="margin-top:10px" onclick="accOrder('+data.list[i].id+')">确认订单</a> <a href="#" class="btn btn-default" role="button" style="margin-top:10px" onclick="rejOrder('+data.list[i].id+')">取消订单</a></p>'
							+'</div>'
						+'</div>'
					+'</div>';
					$('#tab1').children().append(str);
				}
			}else{
				alert(errorCodes[data.errorCode]);
			}
		},
		error:function(){
			alert('获取数据失败');
		}
	});
	
	$.ajax({
		url:'/ordera',
		success:function(data){
			if(data.errorCode == 0){
				var str;
				$('#tab2').children().empty();
				for(var i=0;i<data.list.length;i++){
					str = ''
						+'<div class="col-sm-4 col-md-3">'
						+'<div class="thumbnail">'
							+'<img src="'+data.list[i].url+'" alt="..." style= "margin:15px;">'
							+'<div class="caption" style= "margin:15px;">'
								+'<h3>¥10</h3><h4>'+data.list[i].name+'</h4>'
								+'<p>'+data.list[i].addr+'</p>'
								+'<p>'+data.list[i].user+'</p>'
								+'<p><a href="#" class="btn btn-primary" role="button" style="margin-top:10px" onclick="sucOrder('+data.list[i].id+')">完成订单</a> <a href="#" class="btn btn-default" role="button" style="margin-top:10px" onclick="rejOrder('+data.list[i].id+')">取消订单</a></p>'
							+'</div>'
						+'</div>'
					+'</div>';
					$('#tab2').children().append(str);
				}
			}else{
				alert(errorCodes[data.errorCode]);
			}
		},
		error:function(){
			alert('获取数据失败');
		}
	});
	
	$.ajax({
		url:'/orders',
		success:function(data){
			if(data.errorCode == 0){
				var str;
				$('#tab3').children().empty();
				for(var i=0;i<data.list.length;i++){
					str = ''
						+'<div class="col-sm-4 col-md-3">'
						+'<div class="thumbnail">'
							+'<img src="'+data.list[i].url+'" alt="..." style= "margin:15px;">'
							+'<div class="caption" style= "margin:15px;">'
								+'<h3>¥10</h3><h4>'+data.list[i].name+'</h4>'
								+'<p>'+data.list[i].addr+'</p>'
								+'<p>'+data.list[i].user+'</p>'
								+'<p> <a href="#" class="btn btn-default" role="button" style="margin-top:10px" onclick="rejOrder('+data.list[i].id+')">删除订单</a></p>'
							+'</div>'
						+'</div>'
					+'</div>';
					$('#tab3').children().append(str);
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