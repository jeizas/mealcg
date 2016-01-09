<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>饭来啦</title>

	<link rel="shortcut icon" type="image/ico" href="/favicon.ico" />
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="static/bootstrap/css/flat-ui.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="static/bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="static/js/md5.js"></script>
<style type="text/css">
	#bg{
		overflow: hidden;
	}
	#window{
		position: fixed;
		top:10%;
		left: 40%;
		width: 300px;
		height: 371px;
		background-color: #1abc9c;
		border-radius: 10px;
		opacity: 0.9;
	}
	#window p{
		font-size: 26px;
		color: #504034;
		padding: 40px 50px 30px ;
		border-bottom: 2px dotted #dad7d0;
	}
	/**/
	#user{
		margin-top: 30px;

	}
	.in{
		margin-left: 40px;
	}
	#blank{
		height: 30px;
		width: 220px;
	}
	.denglu{
		width: 110px;
		height: 20px;
		background-color: #fbe1cd;
		margin: 0 auto;
		float: left;
		padding-top: 55px;
	}
	.in input{
		height: 50px;
		width: 220px;
	}
	.login{
		float:left;
	}
	#new{
		margin-left: 1px;
	}
	#btn-log{
		margin-left: 40px;
	}
 	a:hover{
		background-color: #e79860;
		color: white;
	}
	.login{padding: 8px 38px 267px;}
</style>

<body>
	<div id="bg">
		<img src="/static/img/bg.jpg" style="height:100%; width:100%;"/>
		<div id="window">
			<p>商家登录</p>
			<div class="in"><td><input id="email" type="text" placeholder="手机号／邮箱／用户名"  style="padding-left:10px;font-size:16px;color:grey;"class="textInput"/></td></div>
			<div id="blank"></div>
			<div class="in"><td><input type="password" id="password" placeholder="密码" style="padding-left:10px;font-size:16px;color:grey;"class="textInput"/></td></div>
			<span class="error" style="color:red;margin:10px 0 0 0;display:block;padding:0;border:none;font-size:12px;margin-left:40px">&nbsp;</span>
			<a href="#"><div id="btn-log" class="login">登录</div></a>
			<a href="#"><div id="btn-reg" class="login">注册</div></a>	
		</div>
	</div>
</body>
<script type="text/javascript">
$(function() {
	//登录
	$('#btn-log').click(function(){
		var email = $('#email').val();
		var password = hex_md5($('#password').val());
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		if(!reg.test(email.trim())){
			$('.error').text("邮箱格式不正确！");
			return false;
		}
		$.ajax({
    		type:"post",
    		asyn:false,
    		url:"/alogin",
    		data:{email:email,pwd:password,type:"2"},
    		dataType: "json",
    		success:function(data){
    			switch(data.errorCode){
    				case 0:
    					location.href="/orderb";
    					break;
    				case 1: $('.error').text("参数错误！"); break;
    				case 2: $('.error').text("没有登录！"); break;
    				case 3: $('.error').text("登录名或密码错误！"); break;
    			}
    		},
    	});
	})
	//注册
	$('#btn-reg').click(function(){
		var email = $('#email').val();
		var password = hex_md5($('#password').val());
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		if(!reg.test(email.trim())){
			$('.error').text("邮箱格式不正确！");
			return false;
		}
		$.ajax({
    		type:"post",
    		asyn:false,
    		url:"/aregest",
    		data:{email:email,pwd:password,type:"2"},
    		dataType: "json",
    		success:function(data){
    			switch(data.errorCode){
    				case 0: 
    					location.href="/orderb";
    					break;
    				case 1: $('.error').text("参数错误！"); break;
    				case 2: $('.error').text("没有登录！"); break;
    				case 3: $('.error').text("没有如此的用户！"); break;
    				case 11: $('.error').text("该邮箱已经注册！"); break;
    			}
    		},
    	});
	})
})
</script>
</html>