<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jeizas.utils.Constants"%>
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
	<script type="text/javascript" src="static/js/menub.js"></script>
</head>
<body>
    <%@ include file="/WEB-INF/view/common/navb.jsp"%>
	<!-- 内容 -->
	<p style="float:right;margin:100px 95px; 0;"><a style=" background-color:#1abc9c;border:1px solid #1abc9c;" href="/addf" role="button" class="btn btn-primary btn-lg">添加新菜品</a></p>
	<div class="container shop-main">
	    <c:forEach items="${foods }" var="f">
			<div class="row"  style="border-bottom:1px solid #e3e3e3;">
				<div class="col-md-6">
					<div class="thumbnail" style="height:150px;margin-top:24px;">
	                    <img src="<%=Constants.FOOD_URL%>${f.id }/${f.img }" class="pull-left" alt="" style="width:140px;height:140px;">
	                    <div class="caption">
	                        <h5 style="line-height:2px;">${f.name }</h5>
	                        <small style="color:#1abc9c;">${f.dsc }</small>
	                        <p class="sh ps mon">￥${f.money }</p>
	                        <small>销量：</small><span>${f.money }</span>
	                    </div>
					</div>
				</div>
				<div class="delete col-md-2 col-md-offset-1">
				    <button class="btn btn-default btn-xs" type="button" onclick="delFod(${f.id })">删除</button>
				     <button class="btn btn-default btn-xs" type="button" style="margin-top:5px;">修改</button>
				</div>
			</div>
		</c:forEach>
	</div>
	<!-- 这里是footer开始的地方 -->
	<footer>
	    <div class="container-fluid btm-ftr">
	    <p>© copyright jeizas 2015.12</p></div>
	</footer>
	<!-- 这里是footer结束的地方 -->
</body>
</html>