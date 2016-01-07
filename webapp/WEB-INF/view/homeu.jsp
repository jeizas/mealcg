<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>饭来啦</title>
	<link rel="shortcut icon" type="image/ico" href="/favicon.ico" />
	<link href="static/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">  
    <link href="static/css/style.css" rel="stylesheet">
    <link href="static/css/login.css" rel="stylesheet">
    <link href="static/css/global.css" rel="stylesheet">
    
    <script type="text/javascript" src="static/bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript" src="static/js/homeu.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/view/common/navbar.jsp"%>
	<!-- 内容 -->
	<div class="container user">
	    <div class="row">
	    <img src="/static/img/cake.jpg" class="col-md-4 user-img">
		    <div class="col-md-8 info">
		       <span class="title"><strong>用户名</strong></span><span class="info-con">${user.nick }</span><a href="javascript:;" id="modifyName"><small>［修改］</small></a>
		        <br><span class="title"><strong>手机号码：</strong></span><span class="info-con">${user.phone }</span><a href="javascript:;" id="modifyPhone"><small>［修改］</small></a>
		        <br><span class="title"><strong>积分：</strong></span><span class="info-con">${user.phone }</span>
		    </div>
	    </div>
	    <div class="row info-sec">
	        <span class="title"><strong>收货地址：</strong></span><span class="info-con">${user.addr }</span><a href="javascript:;" id="modifyAddr"><small>［修改］</small></a>
	        <br><span class="title"><strong>最近订单：</strong></span>
	            <ul class="info-order">
	                <li><a href="">张麻子大饼</a></li>
	                <li><a href="">张麻子鸡蛋汤</a></li>
	                <li><a href="">北门蛋炒饭</a></li>
	                <li><a href="">汉堡王汉堡</a></li>
	                <li><a href="">张阿姨奶茶</a></li>
	                <li><a href="">more……</a></li>
	            </ul>
	    </div>
	</div>
	<div class="container user2">
	   <br> <span class="title info-collect"><strong>我的收藏：</strong></span>
	    <div class="row">
		  <div class="col-sm-6 col-md-3">
		    <div class="thumbnail">
		      <img src="/static/img/cake.jpg" alt="...">
		      <div class="caption">
		        <h3>蛋黄蛋糕</h3>
		        <p>地址：大西门五排六号</p>
		        <p><a href="#" class="btn btn-primary" role="button">购买</a> <a href="#" class="btn btn-default" role="button">删除</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-6 col-md-3">
		    <div class="thumbnail">
		      <img src="/static/img/cake.jpg" alt="...">
		      <div class="caption">
		        <h3>蛋黄蛋糕</h3>
		        <p>地址：大西门五排六号</p>
		        <p><a href="#" class="btn btn-primary" role="button">购买</a> <a href="#" class="btn btn-default" role="button">删除</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-6 col-md-3">
		    <div class="thumbnail">
		      <img src="/static/img/cake.jpg" alt="...">
		      <div class="caption">
		        <h3>蛋黄蛋糕</h3>
		        <p>地址：大西门五排六号</p>
		        <p><a href="#" class="btn btn-primary" role="button">购买</a> <a href="#" class="btn btn-default" role="button">删除</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-6 col-md-3">
		    <div class="thumbnail">
		      <img src="/static/img/cake.jpg" alt="...">
		      <div class="caption">
		        <h3>蛋黄蛋糕</h3>
		        <p>地址：大西门五排六号</p>
		        <p><a href="#" class="btn btn-primary" role="button">购买</a> <a href="#" class="btn btn-default" role="button">删除</a></p>
		      </div>
		    </div>
		  </div>
		</div><!-- row -->
		<br>   
		<a href="collection.html" class="pull-right">More……</a>
	</div>
	<%@ include file="/WEB-INF/view/common/navbar.jsp"%>
	<!-- 这里是footer开始的地方 -->
	<footer>
	    <div class="container-fluid btm-ftr">
	    <p>© copyright lily 2015.5</p></div>
	</footer>
	<!-- 这里是footer结束的地方 -->
</body>
</html>