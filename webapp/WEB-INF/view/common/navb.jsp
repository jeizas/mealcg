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
        <a href="orderb" class="navbar-brand" style="border-right:1px solid #f6be6a;">饭来啦商家管理</a>
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
	var name =  "<%=session.getAttribute(SessionKeys.USER_NAME)%>";
	if(name != "null" ){
		$('.navbar-brand').text(name);
	}
	var flag = "<%=session.getAttribute(SessionKeys.BUS_FLAG)%>";
	if(flag == 1){
		$("#s3").attr("checked",true)
	}else{
		$("#s3").attr("checked",false)
	}
	
</script>