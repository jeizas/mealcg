$(function() {
	$.ajax({
		url:'/hotf',
		success:function(data){
			if(data.errorCode == 0){
				var str;
				$('#hotFood').empty();
				if(data.list == null || data.list.length <= 0){
					$('#hotFood').append('<div class="work-null-data"><img src="http://res.alltuu.com/static/images/photographer/noData.png"/><p>您还没有任何东西哦，赶快新增吧！</p></div>');
				}else{
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
                                +'<input type="hidden" value="'+data.list[i].id+'"/>'
								+'<button class="btn btn-large btn-block no-margin" '+data.list[i].isCart+' type="button">加入购物车</button>'
							+'</div>'
						+'</div>'
						$('#hotFood').append(str);
					}
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

$(document).on("click",".btn-block",function(e){
    var id = $(this).prev().val();
    addCart(id,e);
    $(this).attr('disabled',true);
});

function addCart(id,event){
	$.post("/addct", {foodId:id},function(data) {
		if(data.errorCode == 0){
            /*飞入购物车动画*/
            var offset = $(".badge").offset(),
                flyer = $('<img class="u-flyer" src="../favicon.ico"/>');
            flyer.fly({
                start:{
                    left: event.pageX,
                    top: event.pageY
                },
                end: {
                    left: offset.left,
                    top: 10,
                    width:20,
                    height:20,
                }
            });
            $('.badge').text(parseInt($('.badge').text()) + 1);

		}else{
			alert("网络连接错误，请稍候重试...");
		}
	});
}

