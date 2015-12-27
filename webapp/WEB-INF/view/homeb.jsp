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
	<script type="text/javascript" src="static/js/homeb.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/view/common/navb.jsp"%>
	<!-- 内容 -->

	<div class="container user">
	    <div class="row">
	    <img src="/static/img/cake.jpg" class="col-md-4 user-img ">
	    <div class="col-md-8 info">
	       <span class="title"><strong>店名：</strong></span><span class="info-con" id="busName">${user.name }</span><a href="javascript:;" id="modifyName"><small>［修改］</small></a>
	        <br><span class="title"><strong>手机号码：</strong></span><span class="info-con">${user.phone }</span><a href="javascript:;" id="modifyPhone"><small>［修改］</small></a>
	        <br><span class="title"><strong>总单数：</strong></span><span class="info-con">1200</span></div>
	    </div>
	    <div class="row info-sec">
	        <span class="title"><strong>餐馆地址：</strong></span><span class="info-con">${user.addr }</span><a href="javascript:;" id="modifyAddr"><small>［修改］</small></a>
	        <br><span class="title"><strong>热销商品：</strong></span>
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
	<!-- 这里是footer开始的地方 -->
	<footer>
	    <div class="container-fluid btm-ftr">
	    <p>© copyright lily 2015.5</p></div>
	</footer>
	<!-- 这里是footer结束的地方 -->
</body>
</html>