<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>饭来了</title>
	<link rel="shortcut icon" type="image/ico" href="/favicon.ico" />
	<link href="static/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">  
    <link href="static/css/style.css" rel="stylesheet">
    <link href="static/css/login.css" rel="stylesheet">
    <link href="static/css/global.css" rel="stylesheet">
</head>
<body>
    <%@ include file="/WEB-INF/view/common/navbar.jsp"%>
	<!-- 内容 -->
	<div class="container user3">
   		<br> <span class="title info-collect2"><strong>我的订单：</strong></span>
    	<div class="row">
 			 <div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img src="static/img/cake.jpg" alt="...">
			      <div class="caption">
			        <h3>蛋黄蛋糕</h3>
			        <p>地址：大西门五排六号</p>
			        <p><a href="#" class="btn btn-primary" role="button">加入购物车</a> <a href="#" class="btn btn-default" role="button">评价</a></p>
			      </div>
			    </div>
  			</div>
			<div class="col-sm-6 col-md-4">
			   <div class="thumbnail">
			      <img src="static/img/cake.jpg" alt="...">
			      <div class="caption">
			        <h3>蛋黄蛋糕</h3>
			        <p>地址：大西门五排六号</p>
			        <p><a href="#" class="btn btn-primary" role="button">加入购物车</a> <a href="#" class="btn btn-default" role="button">评价</a></p>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img src="static/img/cake.jpg" alt="...">
			      <div class="caption">
			        <h3>蛋黄蛋糕</h3>
			        <p>地址：大西门五排六号</p>
			        <p><a href="#" class="btn btn-primary" role="button">加入购物车</a> <a href="#" class="btn btn-default" role="button">评价</a></p>
			      </div>
			    </div>
			  </div>
 			</div>
			<div class="row">
			  <div class="col-sm-6 col-md-4">
				    <div class="thumbnail">
					      <img src="./static/img/cake.jpg" alt="...">
					      <div class="caption">
						        <h3>蛋黄蛋糕</h3>
						        <p>地址：大西门五排六号</p>
						        <p><a href="#" class="btn btn-primary" role="button">加入购物车</a> <a href="#" class="btn btn-default" role="button">评价</a></p>
					      </div>
				    </div>
			   </div>
			  <div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img src="static/img/cake.jpg" alt="...">
			      <div class="caption">
			        <h3>蛋黄蛋糕</h3>
			        <p>地址：大西门五排六号</p>
			        <p><a href="#" class="btn btn-primary" role="button">加入购物车</a> <a href="#" class="btn btn-default" role="button">评价</a></p>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img src="static/img/cake.jpg" alt="...">
			      <div class="caption">
			        <h3>蛋黄蛋糕</h3>
			        <p>地址：大西门五排六号</p>
			        <p><a href="#" class="btn btn-primary" role="button">加入购物车</a> <a href="#" class="btn btn-default" role="button">评价</a></p>
			      </div>
			    </div>
			  </div>
			</div>
		    <div class="row">
			  <div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img src="static/img/cake.jpg" alt="...">
			      <div class="caption">
			        <h3>蛋黄蛋糕</h3>
			        <p>地址：大西门五排六号</p>
			        <p><a href="#" class="btn btn-primary" role="button">加入购物车</a> <a href="#" class="btn btn-default" role="button">评价</a></p>
			      </div>
			    </div>
			</div>
			<div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img src="static/img/cake.jpg" alt="...">
			      <div class="caption">
			        <h3>蛋黄蛋糕</h3>
			        <p>地址：大西门五排六号</p>
			        <p><a href="#" class="btn btn-primary" role="button">加入购物车</a> <a href="#" class="btn btn-default" role="button">评价</a></p>
			      </div>
			    </div>
			</div>
	  	</div>
	</div>
	<!-- 登录div -->
	<div id="half_gray" class="hide"></div>
	<div id="alogin" class="hide">
		<img src="static/img/bg-login.jpg" style="height:100%; width:100%;posision:fixed"/>
		<div id="window">
			<p>登录</p>
			<div class="in"><td><input id="email" type="text"placeholder="邮箱"  style="padding-left:10px;font-size:16px;color:grey;"class="textInput"/></td></div>
			<div id="blank"></div>
			<div class="in"><td><input type="text" id="password"  placeholder="密码"  style="padding-left:10px;font-size:16px;color:grey;"class="textInput"/></td></div>
			<a href="#"><div id="btn-log" class="login">登陆</div></a>
			<a href="#"><div id="new" class="login">注册</div></a>	
		</div>
	</div>
	<!-- 这里是footer开始的地方 -->
	<footer>
	    <div class="container-fluid btm-ftr">
	    <p>© copyright lily 2015.5</p></div>
	</footer>
	<!-- 这里是footer结束的地方 -->
	<script type="text/javascript" src="static/bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript" src="static/js/md5.js"></script>
</body>
</html>