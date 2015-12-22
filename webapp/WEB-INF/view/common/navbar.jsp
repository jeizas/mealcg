<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	        <a href="order.html" class="navbar-brand" style="border-right:1px solid #f6be6a;">饭来啦</a>
	    </div> 
	    <div class="collapse navbar-collapse" id="bs-Dropdown-navbar-collapse-1">
	        <ul class="nav navbar-nav">
	            <li ><a href="/index">首页</a></li>
	            <li><a href="shopping-trolly.html">购物车 <span class=badge>0</span> </a> </li>
	
	            <!-- 下拉菜单 -->
	            <li class="dropdown active">
	          <a href="javascript:;" id="username" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"> 登录/注册 <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>登录/注册</li>
	            <li><span class="glyphicon glyphicon-user" aria-hidden="true"> </span> 个人中心 </li>
	            <li><span class="glyphicon glyphicon-file" aria-hidden="true"></span>   我的订单</li>
	            <li class="divider"></li>
	            <li><span class="glyphicon glyphicon-star" aria-hidden="true"></span> 我的收藏  </li>
	            <li><span class="glyphicon glyphicon-flag" aria-hidden="true"></span>  我的地址 </li>
	            <li class="divider"></li> 
	            <li><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>退出登录</li>
	            </ul>
	        </ul>
	        <!-- 搜索功能 -->
	        <form class="navbar-search pull-right" style="display:inline;margin-top:12px;margin-right:20px;border:1px solid #f6be6a;">
	        <input type="text" class="span2" style="height:30px;padding:0px;margin:0px;border:0px;">
	        <button type="button" class="btn" style="height:30px;width:40px;background-color:#f6be6a;margin-left:-5px;margin-top:-2px;opacity:0.8;padding:0px;border-radius:0px;">搜索</button>
	        </form> 
	    </div>
    </div>  
</nav>