<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, minimum-scale=1.0,user-scalable=no" />
<title>饭来啦</title>
	<link rel="shortcut icon" type="image/ico" href="/favicon.ico" />
	
	<link href="static/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"> 
	 <link href="static/css/jquery.Jcrop.min.css" rel="stylesheet"> 
    <link href="static/css/style.css" rel="stylesheet">
    <link href="static/css/global.css" rel="stylesheet">
    <link href="static/css/addfood.css" rel="stylesheet">
    
    <script type="text/javascript" src="static/bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="static/js/addfood.js"></script>
	<script src="static/js/fileupload/moxie.js"></script>
	<script src="static/js/fileupload/plupload.dev.js"></script>
	<script src="static/js/jquery.Jcrop.min.js"></script>
	
	<script type="text/javascript">
		var foodId = "${food.id}";
	</script>
</head>
<body>
	<%@ include file="/WEB-INF/view/common/navb.jsp"%>
	<!-- 内容 -->
	<div class="container" id="addform">
	    <h2 style="margin:30px; ">美味蛋糕店</h2>
		<p style="border-bottom:1px solid #e3e3e3;"> </p>
		<form id="addfood" name="addfood" method="post" action="/addfood">
		 	<div class="col-lg-5 add-item">
			    <div class="thumbnail">
			      <img id="head" src="/static/img/cake.jpg" alt="...">
			    </div>
			  </div>
			  <div class="col-lg-12">
			  	<div class="input-group add-item">
			  		<span class="input-group-addon" id="basic-addon1">餐品名称：</span>
			  		<input type="hidden" name="id" value="${food.id }">
			  		<input type="text" class="form-control" placeholder="餐品名称" name="name" id="name" required aria-describedby="basic-addon1" value="">
				</div>
			  </div>
			
			  <div class="col-lg-8">
			    <div class="input-group add-item">
			  		<span class="input-group-addon">价格：¥</span>
			  		<input type="text" class="form-control" placeholder="0" id="money" aria-label="Amount (to the nearest dollar)" name="money" value="">
			  		<span class="input-group-addon">.00</span>
				</div><!-- /input-group -->
			  </div><!-- /.col-lg-6 -->
			
			  <div class="col-lg-6">
			    <div class="input-group add-item">
			      <span class="input-group-addon">
			        <input type="checkbox" aria-label="..." checked id="ischeck">
			        <input type="hidden" id="isNew" name="isNew" value="">
			      </span>
			      <span class="input-group-addon">该菜品是新品</span>
			    </div>
			  </div>
			
			  <div class="col-lg-12">
				<div class="input-group add-item">
				  <span class="input-group-addon" id="basic-addon1">餐品简介：</span>
				  <input type="text" class="form-control" placeholder="餐品简介" id="dsc" aria-describedby="basic-addon1" name="dsc" value="">
				</div>
			  </div>
			  <div class="col-lg-12 add-item">
			     <input type="button" class="btn btn-warning btn-lg btn-block" id="submitF" style="margin-top:30px;background-color:#FF744B" value="提交">
			  </div>
		</form>
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
	    <p>© copyright lily 2015.5</p></div>
	</footer>
	<!-- 这里是footer结束的地方 -->
</body>
<script type="text/javascript">
$('#submitF').click(function(){
	if($('#name').val() == ''){
		$('#name').css("border-color","red");
		return false;
	}
	if($('#money').val() == ''){
		$('#money').css("border-color","red");
		return false;
	}
	if($('#dsc').val() == ''){
		$('#dsc').css("border-color","red");
		return false;
	}
	if($('#name').val() == ''){
		$('#name').css("border-color","red");
		return false;
	}
 	if($('#ischeck').is(':checked')) {
		$('#isNew').val('1');
	} else {
		$('#isNew').val('0');
	} 
	$('#addfood').submit();
})
</script>
</html>