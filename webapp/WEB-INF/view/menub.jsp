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
	<script type="text/javascript" src="static/js/md5.js"></script>
</head>
<body>
    <%@ include file="/WEB-INF/view/common/navb.jsp"%>
	<!-- 内容 -->
	<h2 style="margin:50px; ">美味蛋糕店<p style="float:right;"><a style=" background-color:orange;border:1px solid orange;" href="/addf" role="button" class="btn btn-primary btn-lg">添加新菜品</a></p> </h2>
	<div class="container shop-main">
		<div class="row"  style="border-bottom:1px solid #e3e3e3;">
			<div class="col-md-6">
				<div class="thumbnail" style="height:150px;margin-top:24px;">
				                    <img src="/static/img/cake.jpg" class="pull-left" alt="" style="width:140px;height:140px;">
				                    <div class="caption">
				                        <h3 style="line-height:2px;">蛋黄蛋糕</h3>
				                        <small style="color:#f6be6a;">本店主打餐品，香味浓郁，销量最高</small>
				                        <p class="sh ps mon">￥8</p>
				                        <small>销量：</small><span>100</span>
				                    </div>
				</div>
			</div>
			<div class="delete col-md-2 col-md-offset-1">
			    <button class="btn btn-default btn-xs" type="button">删除</button>
			     <button class="btn btn-default btn-xs" type="button" style="margin-top:5px;">修改</button>
			</div>
		</div>
		<div class="row" style="border-bottom:1px solid #e3e3e3;">
			<div class="col-md-6">
				<div class="thumbnail" style="height:150px;margin-top:24px;">
		            <img src="/static/img/cake.jpg" class="pull-left" alt="" style="width:140px;height:140px;">
		            <div class="caption">
		                <h3 style="line-height:2px;">蛋黄蛋糕</h3>
		                <small style="color:#f6be6a;">本店主打餐品，香味浓郁，销量最高</small>
		                <p class="sh ps mon">￥8</p>
		                <small>销量：</small><span>100</span>
		            </div>
				</div>
			</div>
		
			<div class="delete col-md-2 col-md-offset-1">
			    <button class="btn btn-default btn-xs" type="button">删除</button>
			     <button class="btn btn-default btn-xs" type="button" style="margin-top:5px;">修改</button>
			</div>
		</div>
		<div class="row"  style="border-bottom:1px solid #e3e3e3;">
			<div class="col-md-6">
				<div class="thumbnail" style="height:150px;margin-top:24px;">
                    <img src="/static/img/cake.jpg" class="pull-left" alt="" style="width:140px;height:140px;">
                    <div class="caption">
                        <h3 style="line-height:2px;">蛋黄蛋糕</h3>
                        <small style="color:#f6be6a;">本店主打餐品，香味浓郁，销量最高</small>
                        <p class="sh ps mon">￥8</p>
                          <small>销量：</small><span>100</span>
                    </div>
				</div>
			</div>
			<div class="delete col-md-2 col-md-offset-1">
			    <button class="btn btn-default btn-xs" type="button">删除</button>
			     <button class="btn btn-default btn-xs" type="button" style="margin-top:5px;">修改</button>
			</div>
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