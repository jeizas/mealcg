<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jeizas.utils.SessionKeys"%>
<nav class="navbar navbar-default navbar-static-top" role="navigation">
    <!-- 用于响应式网页，缩小的时候导航栏变为按钮 -->
    <div class="container-fluid">
        <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-Dropdown-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
        <a href="orderb" class="navbar-brand" style="">饭来啦商家管理</a>
        </div> 
        <div class="collapse navbar-collapse" id="bs-Dropdown-navbar-collapse-1">
	        <ul class="nav navbar-nav">
	            <li class="active"><a href="orderb">订单管理<span class=badge>5</span> </a></li>
	            <li > <a href="menub">餐品管理 </a> </li>
	            <li><a href="homeb"> 商家信息 </a></li>
	        </ul>   
		   <p class="jd"> 是否接单</p>
		   <div class="wrap">
			  	<input type="checkbox" id="s3" style="margin-top:20px;display:none"> 
				<label class="slider-v2" for="s3" style="margin-top:20px"> </label>  
 		   </div>
 		</div>  
 	</div>
</nav>
<script type="text/javascript">
	var role = "<%=session.getAttribute(SessionKeys.USER_ROLE)%>";
	var name =  "<%=session.getAttribute(SessionKeys.USER_NAME)%>";
	
	if(role == 2 && name != "null" ){
		$('.navbar-brand').text(name);
	}
	var flag = "<%=session.getAttribute(SessionKeys.BUS_FLAG)%>";
	if(flag == 1){
		$("#s3").attr("checked",true)
	}else{
		$("#s3").attr("checked",false)
	}
	$('#s3').click(function(){
		if($('#s3').is(':checked')) {
			flag = 1;
		} else {
			flag = 0;
		}
		$.post("/recive", {flag:flag},function(data) {
			if(data.errorCode == 0){
				alert("操作成功!");
			}else{
				alert("网络连接错误，请稍候重试...");
			}
		});
	})
</script>