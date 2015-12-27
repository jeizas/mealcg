$(function() {
	$('#modifyName').click(function(){
		var p = $(this).prev();
		var name = p.text();
		if(name != null && name != ''){
			p.html('<input type="text" id="name" value='+name+'>');
		}else{
			$.post("/namem", {name:$("#name").val()},function(data) {
				if(data.errorCode == 0){
					p.text($("#name").val());
				}
			});
		}
	})
	$('#modifyPhone').click(function(){
		var name = $(this).prev().text();
		if(name != null && name != ''){
			$(this).prev().html('<input type="text" id="phone" value='+name+'>');
		}else{
			$.post("/phonem", {name:$("#phone").val()},function(data) {
				p.text($("#photo").val());
			});
		}
	})
	$('#modifyAddr').click(function(){
		var name = $(this).prev().text();
		if(name != null && name != ''){
			$(this).prev().html('<input type="text" id="addr" value='+name+'>');
		}else{
			$.post("/addrm", {name:$("#addr").val()},function(data) {
				p.text($("#addr").val());
			});
		}
	})
})