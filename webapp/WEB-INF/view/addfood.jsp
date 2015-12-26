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
	<script type="text/javascript" src="static/js/md5.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/view/common/navb.jsp"%>
	<!-- 内容 -->
	<div class="container" id="addform">
	    <h2 style="margin:30px; ">美味蛋糕店</h2>
		<p style="border-bottom:1px solid #e3e3e3;"> </p>
	 	<div class="col-lg-5 add-item">
		    <div class="thumbnail">
		      <img src="/static/img/cake.jpg" alt="...">
		        <button class="btn btn-default btn-block btn-xs" role="button"> 添加图片</button>
		    </div>
	  </div>
	  <div class="col-lg-12">
	  	<div class="input-group add-item">
	  		<span class="input-group-addon" id="basic-addon1">餐品名称：</span>
	  		<input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
		</div>
	  </div>
	
	  <div class="col-lg-8">
	    <div class="input-group add-item">
	  		<span class="input-group-addon">价格：¥</span>
	  		<input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
	  		<span class="input-group-addon">.00</span>
		</div><!-- /input-group -->
	  </div><!-- /.col-lg-6 -->
	
	  <div class="col-lg-6">
	    <div class="input-group add-item">
	      <span class="input-group-addon">
	        <input type="checkbox" aria-label="...">
	      </span>
	      <span class="input-group-addon">该菜品是新品</span>
	    </div>
	  </div>
	
	  <div class="col-lg-12">
		<div class="input-group add-item">
		  <span class="input-group-addon" id="basic-addon1">餐品简介：</span>
		  <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
		</div>
	  </div>
	
	  
	  <div class="col-lg-12 add-item">
	     <button class="btn btn-warning btn-lg btn-block" role="button" style="margin-top:30px;"> 提交</button>
	  </div>
	</div>
	<!-- 这里是footer开始的地方 -->
	<footer>
	    <div class="container-fluid btm-ftr">
	    <p>© copyright lily 2015.5</p></div>
	</footer>
	<!-- 这里是footer结束的地方 -->
</body>
</html>