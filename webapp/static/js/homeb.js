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
					window.location.href='/bus';
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
					window.location.href='/bus';
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
					window.location.href='/bus';
				}
			});
		}
	})
})