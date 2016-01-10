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
	<script type="text/javascript" src="static/js/orderb.js"></script>
</head>
<body>
    <%@ include file="/WEB-INF/view/common/navb.jsp"%>
	<div class="container" style="background-color:#fafafa;border:1px solid #e7e7e7;height:1330px;">
		<div class="tabbable tabs-left tabs-below" id="tabb">
		    <ul class="nav nav-tabs">
			    <li class="active"><a href="#tab1" data-toggle="tab">收到的订单</a></li>    
			    <li><a href="#tab2" data-toggle="tab">已确认的订单</a></li>
			    <li><a href="#tab3" data-toggle="tab">已完成的订单</a></li>
		    </ul>
		</div>
	
	    <div class="tab-content">
		    <div class="tab-pane active" id="tab1">
			    <div class="row">
				  <div class="col-sm-4 col-md-3">
				    <div class="thumbnail">
				      <img src="/static/img/cake.jpg" alt="..." >
				      <div class="caption">
				        <h3>¥10</h3><h4>蛋黄蛋糕</h4>
				        <p>地址：B区公寓10</p>
				        <p>信息：武依莎 1586665555</p>
				        <p><a href="#" class="btn btn-primary" role="button" style="margin-top:10px">确认订单</a> <a href="#" class="btn btn-default" role="button" style="margin-top:10px">取消订单</a></p>
				      </div>
				    </div>
				  </div>
			  </div>
			</div>
	 	  <!-- /*tab1结尾*/ -->
	
		  <div class="tab-pane " id="tab2">
				<div class="row">
				  	<div class="col-sm-4 col-md-3">
					    <div class="thumbnail">
					      <img src="/static/img/cake.jpg" alt="...">
					      <div class="caption">
					        <h3>¥10</h3><h4>蛋黄蛋糕</h4>
					        <p>地址：B区公寓10</p>
					        <p>信息：武依莎 1586665555</p>
					        <p><a href="#" class="btn btn-default" role="button" style="margin-top:10px">取消订单</a></p>
					      </div>
					   </div>
				  </div>
			  </div>
		 </div>
		<!-- tab2结尾 -->
		 <div class="tab-pane  " id="tab3">
			<div class="row">
			  	<div class="col-sm-4 col-md-3">
				    <div class="thumbnail">
				      <img src="/static/img/cake.jpg" alt="...">
				      <div class="caption" style= "padding:15px;">
				        <h3>¥10</h3><h4>蛋黄蛋糕</h4>
				        <p>地址：B区公寓10</p>
				        <p>信息：武依莎 1586665555</p>
				      </div>
				    </div>
			  </div>
		 	</div>
		   </div>
		   <!-- tab3结尾 -->
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