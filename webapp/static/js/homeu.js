$(function() {
	/*用户修改信息*/
	$('#modifyName').click(function(){
		var p = $(this).prev();
		var name = p.text();
		if(name != null && name != ''){
			p.html('<input type="text" id="name" value='+name+'>');
		}else{
			$.post("/namem", {name:$("#name").val()},function(data) {
				if(data.errorCode == 0){
					p.text($("#name").val());
				}else{
					window.location.href='/homeu';
				}
			});
		}
	})
	$('#modifyPhone').click(function(){
		var p = $(this).prev();
		var name = p.text();
		if(name != null && name != ''){
			p.html('<input type="text" id="phone" value='+name+'>');
		}else{
			$.post("/phonem", {phone:$("#phone").val()},function(data) {
				if(data.errorCode == 0){
					p.text($("#phone").val());
				}else{
					window.location.href='/homeu';
				}
			});
		}
	})
	$('#modifyAddr').click(function(){
		var p = $(this).prev();
		var name = p.text();
		if(name != null && name != ''){
			p.html('<input type="text" id="addr" value='+name+'>');
		}else{
			$.post("/addrm", {addr:$("#addr").val()},function(data) {
				if(data.errorCode == 0){
					p.text($("#addr").val());
				}else{
					window.location.href='/homeu';
				}
			});
		}
	})
})
$(function() {
	var api;//裁剪头像的函数对象
	var notInit = true;
	/*打开上传图片的弹窗*/
	$("#head").click(function(){
		if ($(window).width() < 760) {
			alert("为了您的体验，请使用平板设备或者个人电脑。");
			return;
		}
		$("#upload_head").removeClass("hide");
		$("#half_gray").removeClass("hide");
		$("#upload_head").animate({"zoom":"100%","opacity":1}, 200);
		if (notInit ) {
			uploaderHead.init();
			notInit = false;
		}
	});
	/*点击选择图片按钮， 这里面会调用ajaxUploadhead()方法。*/
	$("#head_choose").click(function(){
		if (api) {
			api.destroy();
			$("#upload_head img").attr("src","");
			$("#upload_head img").css("display","none");
		}
	});
	function headCut() {
		$("#target").css({"width":0,"height":0});
		var boundx,boundy,
	    $pimg1 = $('#small img'),$pimg2 = $('#middle img'),$pimg3 = $('#large img'),
	    smallX = 30,smallY = 30,midX = 80,midY = 80,lgX = 120,lgY = 120;
	    $('#target').Jcrop({
			bgOpacity:0.5,bgColor:'black',
			onChange:updatePreview,onSelect:updatePreview,
			aspectRatio:1
	    },function(){
	    	var bounds = this.getBounds();boundx = bounds[0];boundy = bounds[1];
			api = this;
			api.setOptions({ bgFade: true });
			api.ui.selection.addClass('jcrop-selection');
			api.setSelect([50,30,300,280]);
	    });
	    function updatePreview(c) {
			if (parseInt(c.w) > 0) {
				$("#x").val(c.x);$("#y").val(c.y);$("#w").val(c.w);$("#h").val(c.h);
				var rx1 = smallX / c.w;var ry1 = smallY / c.h;var rx2 = midX / c.w;var ry2 = midY / c.h;var rx3 = lgX / c.w;var ry3 = lgY / c.h;
				$pimg1.css({width:Math.round(rx1 * boundx) + 'px',height:Math.round(ry1 * boundy) + 'px',marginLeft:'-' + Math.round(rx1 * c.x) + 'px',marginTop:'-' + Math.round(ry1 * c.y) + 'px'});
				$pimg2.css({width:Math.round(rx2 * boundx) + 'px',height:Math.round(ry2 * boundy) + 'px',marginLeft:'-' + Math.round(rx2 * c.x) + 'px',marginTop:'-' + Math.round(ry2 * c.y) + 'px'});
				$pimg3.css({width:Math.round(rx3 * boundx) + 'px',height:Math.round(ry3 * boundy) + 'px',marginLeft:'-' + Math.round(rx3 * c.x) + 'px',marginTop:'-' + Math.round(ry3 * c.y) + 'px'});
			}
	    };
	};
	var uploaderHead = new plupload.Uploader({
        browse_button:'head_choose',
        url:'/profile',//服务器端的上传页面地址
        multi_selection:false,
        flash_swf_url:'static/js/fileupload/Moxie.swf',
        silverlight_xap_url:'static/js/fileupload/Moxie.xap',
        filters:{
        	  mime_types:[ //只允许上传图片
        	    { title:"Image files", extensions : "jpg,png" }
        	  ],
        	  max_file_size:'10mb' //最大只能上传10MB的文件
        },
        init:{
        	FilesAdded: function (up, files) {
        		$("#target").attr("src","http://alltuu-static-web.oss-cn-hangzhou.aliyuncs.com/static/images/bgn/loading.gif");
        		$("#target").css({"width":300,"height":300});
        		$("#head_choose").addClass("down");
        		$("#upload_head img").css("display","block");
        		this.start();
            },
            FileUploaded: function (up, file,response) {
            	eval("data = " + response.response);
            	if (data.errorCode == 0) {
    				var src = data.url;
    				$("#head").attr("src", src);
    				$("#upload_head img").attr("src", src);
    				/*var i = new Image();
    				i.src = src;
    				i.onload = function(){
    					headCut();
    				}*/
            	}else {
            		console.log(data.errorCode);
            	}
            },
            Error: function (up, err) {
            	if (err.code == -600) {
            		alert("头像文件尺寸超过10M，请重新选一个小尺寸的照片");
            	} else {
            		alert("\上传作品错误，请刷新重试， #" + err.code + ": " + err.message);
            	}
            }
        }
    });
	function close(){
		$("#half_gray").addClass("hide");
		$("#upload_head").animate({"zoom":"80%","opacity":"0.2"}, 200);
		setTimeout(function(){
			$("#upload_head").css("opacity",1);
			$("#upload_head").addClass("hide");
		}, 200)
		if (api) {
			api.destroy();
			$("#upload_head img").attr("src","");
			$("#upload_head img").css("display","none");
		}
		$("#head_choose").removeClass("down");
	}
	/*关闭上传图片的弹窗之一*/
	$("#half_gray, #head_cancel, .head-cancel").on('click',function(){
		close();
	});
	/*点击确定头像按钮*/
	$("#head_ok").click(function(){
		close();
	});
})