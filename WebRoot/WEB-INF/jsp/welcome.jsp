<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>浩宇广告公司</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
	.all{
		text-align: center;
	}
	body, h2, h3{
		color:#666;
	}
	body{
		background-image: url(<%=path %>/images/bg.jpg);
	}
</style>
  </head>
  
  <body>
	<div class="all">
		<div class="img">
			<img alt="网站正在建设中......" src="<%=path %>/images/zhengzaijianshe.jpg">
		</div>
		<div class="word">
			<h2>我们正在努力建设中，感谢您的到访！</h2>
			<h3>浩宇广告公司联系电话：18204239678</h3>
			<h3>网站开发人员联系电话：18804036473</h3>
		</div>
	</div>
  </body>
</html>
