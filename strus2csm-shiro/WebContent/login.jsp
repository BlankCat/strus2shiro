<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/commons/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <style>
* {
	margin: 0 auto;
	font-size: 12px;
}

span {
	height: 20px;
	line-height: 20px;
	display: block;
	color: #FFFFFF;
	margin-bottom: 8px;
}

.dl {
	width: 1024px;
	height: 715px;
	position: relative;
}

p {
	width: 50px;
	float: left;
}

.weib {
	width: 250px;
	height: 80px;
	margin-bottom: 7px;
	position: absolute;
	left: 498px;
	top: 315px;
}

.text1 {
	height: 16px;
	width: 120px;
	float: left;
	border: 1px #0066FF solid;
	background-color: transparent;
	background: #fff;
}

.text2 {
	height: 16px;
	width: 60px;
	border: 1px #0066FF solid;
	background-color: transparent;
	background: #fff;
	float: left;
}

img {
	width: 60px;
	height: 19px;
}

.ann {
	width: 220px;
	position: absolute;
	left: 495px;
	top: 400px;
}

.btn1 {
	width: 75px;
	height: 25px;
	margin-right: 25px;
	cursor: pointer;
	border: none;
	background-color: transparent;
}

.btn2 {
	width: 75px;
	height: 25px;
	cursor: pointer;
	border: none;
	background-color: transparent;
}
</style>
<script type="text/javascript">
	function checkForm() {
		console.log("checkForm===");
		var msg = "";
		if (!$("#userCode").val()) {
			msg += "用户名不能为空!\n";
		}
		if (!$("#password").val()) {
			msg += "密码不能为空!\n";
		}
		if (!$("#verifyCode").val()) {
			msg += "校验码不能为空!\n";
		}
		if (msg) {
			alert(msg);
			return false;
		}
		return true;
	}
</script>
  
  <body  style="background: #0d3e8d">
  	<form id="loginForm" action="/admin/UserLogin/login.do" onsubmit="return checkForm();" method="post">
  	<div class="dl">
				<div class="weib">
					<span>
					<p>账&nbsp;&nbsp;号：</p> &nbsp;&nbsp;
  					<input type="text" name="user.userCode" cssClass="text1"/>
  					</span>
  	<br/>
  	<span>
	  	<p>密&nbsp;&nbsp;码：</p>&nbsp;&nbsp;
	  		<input  name="user.password" cssClass="text1" />
	  	</span>
  	<br/>
  	<span>
  	<p>校验码：</p>
  	<input name="verifyCode" id="verifyCode" type="text"  cssClass="text1" />
  	<img border=0 src="/admin/VerifyCode.do" />
  	</span>
  	<br/>
  	<input type="submit" value="登录"/>
  	</form>
  </body>
</html>
