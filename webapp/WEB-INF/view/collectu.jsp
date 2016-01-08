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
    <link href="static/css/global.css" rel="stylesheet">
    
    <script type="text/javascript" src="static/bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript" src="static/js/collectu.js"></script>
</head>
<body>
    <%@ include file="/WEB-INF/view/common/navbar.jsp"%>
	<!-- 内容 -->
	<div class="container user3">
	   <br> <span class="title info-collect2"><strong>我的收藏：</strong></span>
	    <div class="row">
		  <div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
		      <img src="/static/img/cake.jpg" alt="...">
		      <div class="caption">
		        <h3>蛋黄蛋糕</h3>
		        <p>地址：大西门五排六号</p>
		        <p><a href="#" class="btn btn-default" role="button">删除</a></p>
		      </div>
		    </div>
		  </div>
	  </div>
	</div><!-- row -->  
	<%@ include file="/WEB-INF/view/common/login.jsp"%>
	<!-- 这里是footer开始的地方 -->
	<footer>
	    <div class="container-fluid btm-ftr">
	    <p>© copyright lily 2015.5</p></div>
	</footer>
	<!-- 这里是footer结束的地方 -->
</body>
</html>