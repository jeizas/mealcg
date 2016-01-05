function delFod(id){
	$.post("/delfood", {id:id},function(data) {
		if(data.errorCode == 0){
			window.location.reload()
		}else{
			alert("网络连接错误，请稍候重试...");
		}
	});
}