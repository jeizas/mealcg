<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.jeizas.utils.SessionKeys"%>
<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
    <!-- 用于响应式网页，缩小的时候导航栏变为按钮 -->
    <div class="container-fluid">
        <div class="navbar-header">
	        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-Dropdown-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
	      	</button>
	        <a href="/" class="navbar-brand" style="">饭来啦</a>
	    </div> 
	    <div class="collapse navbar-collapse" id="bs-Dropdown-navbar-collapse-1">
	        <ul class="nav navbar-nav">
	            <li class="active"><a href="/index">首页</a></li>
	            <li><a href="cartu">购物车 <span class=badge>0</span> </a> </li>
                <!-- 搜索功能 -->
                <form class="navbar-search pull-right" style="display:inline;margin-top:12px;margin-right:20px;border:1px solid #1abc9c;">
                    <input type="text" class="span2" style="height:30px;padding:0px;margin:0px;border:0px;">
                    <button type="button" class="btn" style="height:30px;width:40px;background-color:#1abc9c;margin-left:-5px;margin-top:-2px;opacity:0.8;padding:0px;border-radius:0px;">搜索</button>
                </form>
	        </ul>
    <!-- 下拉菜单 -->

            <div class="dropdown pull-right">
                <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span id="username">登录/注册</span><span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="javascript:;"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span><span>登录/注册</span></a></li>
                    <li><a href="/homeu"><span class="glyphicon glyphicon-user" aria-hidden="true"> </span><span> 个人中心</span> </a></li>
                    <li><a href="/orderu"><span class="glyphicon glyphicon-file" aria-hidden="true"></span> <span>  我的订单</span></a></li>
                    <li class="divider"></li>
                    <li><a href="/collectu"><span class="glyphicon glyphicon-star" aria-hidden="true"></span><span> 我的收藏 </span> </a></li>
                    <li><a href="addru"><span class="glyphicon glyphicon-flag" aria-hidden="true"></span><span>  我的地址</span> </a></li>
                    <li class="divider"></li>
                    <li><a href="/alogout"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span><span>退出登录</span></a></li>
                </ul>
            </div>
	    </div>
    </div>  
</nav>
<script type="text/javascript">
	var nick =  "<%=session.getAttribute(SessionKeys.USER_NICK)%>";
	if(nick != "null" ){
		$('#username').text(nick);
		$('.glyphicon-log-in').next("span").text('用户已登录');
	}
	$('.navbar-nav li a').click(function(e){
		<%--$('.navbar-nav li').removeClass("active");--%>
		$(this).parents("li").siblings().removeClass("active").addClass("active");
	})
</script>