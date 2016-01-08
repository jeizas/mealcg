<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>饭来啦-购物车</title>
	<link rel="shortcut icon" type="image/ico" href="/favicon.ico" />
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="static/bootstrap/css/flat-ui.min.css" rel="stylesheet" type="text/css">
    <link href="static/css/style.css" rel="stylesheet">
    <link href="static/css/global.css" rel="stylesheet">
    
    <script type="text/javascript" src="static/bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript" src="static/js/cartu.js"></script>
</head>
<body>
    <%@ include file="/WEB-INF/view/common/navbar.jsp"%>
	
	<!-- 内容 -->
	<div class="container shop-main">
		<c:forEach items="${carts }" var="o">
			<div class="row"  style="border-bottom:1px solid #e3e3e3;">
				<div class="col-md-6">
					<div class="thumbnail" style="height:150px;">
			            <img src="${o.url }" class="pull-left" alt="" style="width:140px;height:140px;">
			            <div class="caption">
			                <h3 style="line-height:2px;">${o.name }</h3>
			                <small style="color:#f6be6a;">${o.dsc }</small>
			                <p class="sh ps mon">￥<span class="money">${o.money }</span></p>
			            </div>
					</div>
				</div>
				
				<div class="col-md-2 count col-md-offset-1">
			        <button type="button" class="btn btn-default min" onclick="foodm(${o.id },${o.money })">-</button>
			        <input type="text" value="${o.count }" id="cnt${o.id }" class="amount">
			        <button type="button" class="btn btn-default plus" onclick="foodp(${o.id },${o.money })">+</button>
				</div>
				
				<div class="delete col-md-2 col-md-offset-1">
				    <button class="btn btn-default btn-xs" type="button" onclick="delorder(${o.id })">删除</button>
				</div>
			</div>
		</c:forEach>
	</div>
	<!-- 合计 -->
	<div class="input-group col-md-5 col-md-offset-7 checkall ">
	  <span class="input-group-addon"> 合计：   ￥</span>
	  <span class="input-group-addon check" id="sum">${sum }</span>
	  <span class="input-group-btn ">
	    <button type="button" class="btn checkbtn">立即下单</button>
	  </span>
	</div>
	
	<!-- 分页按钮 -->
	<!-- <div class="container-fluid" id="pages">
	<div class="btn-toolbar" role="toolbar" aria-label="">
	<button href="#" class="btn btn-default"><i class="glyphicon glyphicon-menu-left"></i></button>
	<button href="#" class="btn btn-default">1</button>
	<button href="#" class="btn btn-default">2</button>
	<button href="#" class="btn btn-default">3</button>
	<button href="#" class="btn btn-default">4</button>
	<button href="#" class="btn btn-default"><i class="glyphicon glyphicon-menu-right"></i></button>
	</div>
	</div> -->
	
	<%@ include file="/WEB-INF/view/common/login.jsp"%>
	<!-- 这里是footer开始的地方 -->
	<footer>
	    <div class="container-fluid btm-ftr">
	    <p>© copyright lily 2015.5</p></div>
	</footer>
	<!-- 这里是footer结束的地方 -->
</body>
</html>