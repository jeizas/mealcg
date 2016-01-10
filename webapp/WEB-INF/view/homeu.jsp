<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>饭来啦-dfkj</title>
	<link rel="shortcut icon" type="image/ico" href="/favicon.ico" />
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="static/bootstrap/css/flat-ui.min.css" rel="stylesheet" type="text/css">
    <link href="static/css/jquery.Jcrop.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">
    <link href="static/css/login.css" rel="stylesheet">
    <link href="static/css/global.css" rel="stylesheet">
    <link href="static/css/addfood.css" rel="stylesheet">
    
    <script type="text/javascript" src="static/bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript" src="static/js/homeu.js"></script>
	<script src="static/js/fileupload/moxie.js"></script>
	<script src="static/js/fileupload/plupload.dev.js"></script>
	<script src="static/js/jquery.Jcrop.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/view/common/navbar.jsp"%>
	<!-- 内容 -->
	<div class="container user">
	    <div class="row">
	        <img id="head" src="${url }" class="col-md-4 user-img" onerror="imgError(this);">
		    <div class="col-md-6 info">
		       <span class="title"><strong>用户名</strong></span><span class="info-con">${user.nick }</span><a href="javascript:;" id="modifyName"><small>［修改］</small></a>
		        <br><span class="title"><strong>手机号码：</strong></span><span class="info-con">${user.phone }</span><a href="javascript:;" id="modifyPhone"><small>［修改］</small></a>
		        <br><span class="title"><strong>积分：</strong></span><span class="info-con">${user.phone }</span>
		    </div>
	        <div class="col-md-6 info-sec">
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
	</div>
	
	<div id="half_gray" class="hide"></div>
	<div id="upload_head" class="hide">
		<h4>头像设置<span class="head-cancel"> X </span></h4>
		<div id="left">
			<figure>
				<img id="target" src=""/>
			</figure>
		</div>
		<!-- <div id="right">
			<figure id="small" class="img-circle">
				<img class="head head-small" src=""/>
			</figure>
			<figure id="middle" class="img-circle">
				<img class="head head-middle" src=""/>
			</figure>
			<figure id="large">
				<img class="head head-large" src=""/>
			</figure>
		</div> -->
		<div id="head_choose" class="btn">选择图片</div>
		<div class="btn-wrapper clearfix">
			<div class="btns">
				<div id="head_ok" class="btn">确定</div><div id="head_cancel" class="btn">取消</div>
			</div>
		</div>
	</div>
	
	<!-- 这里是footer开始的地方 -->
	<footer>
	    <div class="container-fluid btm-ftr">
	    <p>© copyright jeizas 2015.12</p></div>
	</footer>
	<!-- 这里是footer结束的地方 -->
</body>
</html>