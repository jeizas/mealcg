<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.jeizas.utils.SessionKeys"%>
<!-- 登录div -->
	<link href="static/css/login.css" rel="stylesheet">
	
	<div id="half_gray" class="hide"></div>
	<div id="alogin" class="hide">
		<img src="static/img/bg-login.jpg" style="height:100%; width:100%;posision:fixed"/>
		<div id="window">
			<p>登录</p>
			<div class="in"><td><input id="email" type="text"placeholder="邮箱"  style="padding-left:10px;font-size:16px;color:grey;"class="textInput"/></td></div>
			<div id="blank"></div>
			<div class="in"><td><input type="password" id="password"  placeholder="密码"  style="padding-left:10px;font-size:16px;color:grey;"class="textInput"/></td></div>
			<span class="error" style="color:red;margin:10px 0 0 0;display:block;padding:0;border:none;font-size:12px;margin-left:40px">&nbsp;</span>
			<a href="#"><div id="btn-log" class="login">登录</div></a>
			<a href="#"><div id="btn-reg" class="login">注册</div></a>	
		</div>
	</div>
<script type="text/javascript">
$(function() {
	//登录弹框
	$('.dropdown-menu li').eq(0).click(function(){
		$('#alogin').removeClass("hide");
		$('#half_gray').removeClass("hide");
	});
	
	//点击阴影关闭弹框
	$('#half_gray').click(function(){
		$('#alogin').addClass("hide");
		$('#half_gray').addClass("hide");
	});
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
    		data:{email:email,pwd:password,type:1},
    		dataType: "json",
    		success:function(data){
    			switch(data.errorCode){
    				case 0:
    					$('#alogin').addClass("hide");
    					$('#half_gray').addClass("hide"); 
    					var name = email.split("@");
    					$('#username').text(name[0]);
    					break;
    				case 1: $('.error').text("参数错误！"); break;
    				case 2: $('.error').text("没有登录！"); break;
    				case 3: $('.error').text("用户名或密码错误！"); break;
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
    		data:{email:email,pwd:password,type:1},
    		dataType: "json",
    		success:function(data){
    			switch(data.errorCode){
    				case 0: 
    					$('#alogin').addClass("hide");
						$('#half_gray').addClass("hide"); 
						var name = email.split("@");
						$('#username').text(name[0]);
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