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
<script type="text/javascript" src="static/js/lib/jquery.fly.min.js"></script>

<script type="text/javascript" src="static/js/index.js"></script>
<script type="text/javascript" src="static/js/md5.js"></script>
<script type="text/javascript">
    var pageType = "${pageType }";
</script>
</head>
<body>
    <%@ include file="/WEB-INF/view/common/navbar.jsp"%>
<!-- 内容 -->
<div class="container" style="background-color:#fafafa;border:1px solid #e7e7e7;height:1130px;">
<div class="tabbable tabs-left tabs-below" id="tabb">
    <ul class="nav nav-tabs">
    <li class="active"><a href="#tab1" data-toggle="tab">人气餐品</a></li>    
    <li><a href="#tab2" data-toggle="tab">特价餐品</a></li>
    <li><a href="#tab3" data-toggle="tab">新增餐品</a></li>
    <li><a href="#tab4" data-toggle="tab">特别推荐</a></li>
    </ul>

    <div class="tab-content">
        <!-- <p>人气餐品内容</p> -->
        <div class="tab-pane active" id="tab1">
           <div class="row" style="margin-top:30px;" id="hotFood">
            <div class="col-md-6">
                <div class="thumbnail">
                    <img src="/static/img/cake.jpg" class="pull-left" alt="" style="width:180px;height:180px;">
                    <div class="caption">
                        <h3 style="line-height:2px;">蛋黄蛋糕</h3>
                        <small style="color:#1abc9c;">自家烘焙</small>
                        <p class="sh ps">￥8</p>
                        <p class="sh">12元起送</p>
                        <p class="sh">月销量11938份</p>
                    </div>
                    <button class="btn btn-large btn-block no-margin" type="button">加入购物车</button>
                </div>
            </div>
            
             <div class="col-md-6">
                <div class="thumbnail">
                    <img src="/static/img/cake.jpg" class="pull-left" alt="" style="width:180px;height:180px;">
                    <div class="caption">
                        <h3 style="line-height:2px;">蛋黄蛋糕</h3>
                        <small style="color:#1abc9c;">自家烘焙</small>
                        <p class="sh ps">￥8</p>
                        <p class="sh">12元起送</p>
                        <p class="sh">月销量11938份</p>
                    </div>
                    <button class="btn btn-large btn-block no-margin" type="button">加入购物车</button>
                </div>
            </div>
        </div>
     </div>


        <div class="tab-pane" id="tab2">
            <div class="work-null-data">
            	<img src="http://res.alltuu.com/static/images/photographer/noData.png"/>
            	<p>管理员太懒，还没有添加任何东西！</p>
            </div>
        </div>
         <div class="tab-pane" id="tab3">
            <div class="work-null-data">
            	<img src="http://res.alltuu.com/static/images/photographer/noData.png"/>
            	<p>管理员太懒，还没有添加任何东西！</p>
            </div>
        </div>
         <div class="tab-pane" id="tab4">
            <div class="work-null-data">
            	<img src="http://res.alltuu.com/static/images/photographer/noData.png"/>
            	<p>管理员太懒，还没有添加任何东西！</p>
            </div>
        </div>
        </div>
    </div>
</div>

<!-- 分页按钮 -->
<div class="container-fluid" id="pages">
	<div class="btn-toolbar" role="toolbar" aria-label="">
		<button href="#" class="btn btn-default"><i class="glyphicon glyphicon-menu-left"></i></button>
		<button href="#" class="btn btn-default">1</button>
		<button href="#" class="btn btn-default">2</button>
		<button href="#" class="btn btn-default">3</button>
		<button href="#" class="btn btn-default">4</button>
		<button href="#" class="btn btn-default"><i class="glyphicon glyphicon-menu-right"></i></button>
	</div>
</div>
	<%@ include file="/WEB-INF/view/common/login.jsp"%>
	<!-- 这里是footer开始的地方 -->
	<footer>
	    <div class="container-fluid btm-ftr">
	    <p>© copyright jeizas 2015.12</p></div>
	</footer>
	<!-- 这里是footer结束的地方 -->
</body>
</html>