<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>饭来啦</title>
	<link rel="shortcut icon" type="image/ico" href="/favicon.ico" />
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="static/bootstrap/css/flat-ui.min.css" rel="stylesheet" type="text/css">
    <link href="static/css/style.css" rel="stylesheet">
    <link href="static/css/global.css" rel="stylesheet">
    
    <script type="text/javascript" src="static/bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript" src="static/js/md5.js"></script>
</head>
<body>
    <%@ include file="/WEB-INF/view/common/navbar.jsp"%>
	<!-- 内容 -->
	<div class="container user">
	    <div class="row">
	    <img src="/static/img/cake.jpg" class="col-md-4 user-img ">
	    <div class="col-md-8 info">
	       <span class="title"><strong>用户：</strong></span><span class="info-con">wuyisha</span>
	        <br><span class="title"><strong>手机号码：</strong></span><span class="info-con">1582345806</span>
	        <br><span class="title"><strong>积分：</strong></span><span class="info-con">1200</span></div>
	    </div>
	    <div class="row info-sec">
	        <span class="title"><strong>收货地址：</strong></span><span class="info-con">环城北路88号B10-417宿舍</span>
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
	<%@ include file="/WEB-INF/view/common/login.jsp"%>
	<!-- 这里是footer开始的地方 -->
	<footer>
	    <div class="container-fluid btm-ftr">
	    <p>© copyright lily 2015.5</p></div>
	</footer>
	<!-- 这里是footer结束的地方 -->
</body>
</html>