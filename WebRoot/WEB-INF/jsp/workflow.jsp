<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>浩宇广告公司</title>
<link rel="bookmark" type="image/x-icon" href="http://7xrh7n.com1.z0.glb.clouddn.com/logo.jpg"/>
<link rel="shortcut icon" href="http://7xrh7n.com1.z0.glb.clouddn.com/logo.jpg"> 
<link rel="icon" href="http://7xrh7n.com1.z0.glb.clouddn.com/logo.jpg">

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!--导航-->
<link href="css/jq22.css" rel="stylesheet" type="text/css">
<link href="css/nav.css" rel="stylesheet" type="text/css">
<link href="css/workflow.css" rel="stylesheet" type="text/css">
<script src="js/jquery.movebg.js"></script>
<script src="js/nav.js"></script>
<script src="js/workflow.js"></script>
</head>
<body>
<div class="wfall">
	<div class="wangzhan_headlogo">
    	<img style="width:100%; height:100%;" alt="" src="http://7xrh7n.com1.z0.glb.clouddn.com/1.jpg">
  	</div>
	<!--导航start-->
   	<div class="wraper">
	        <div class="nav">
	            <ul>
	                <li class="nav-item"><a href="#" >网站首页</a></li>
	                <li class="nav-item cur"><a href="#">工作流程</a></li>
	                <li class="nav-item"><a href="#" >公司简介</a></li>
	                <li class="nav-item"><a href="#" >经典案例</a></li> 
	                <li class="nav-item"><a href="#" >主创团队</a></li> 
	                <li class="nav-item"><a href="#" >招兵买马</a></li>
	                <li class="nav-item"><a href="#">联系我们</a></li>
	            </ul>
	             <!--移动的滑动-->
	            <div class="move-bg"></div>
	            <!--移动的滑动 end-->
	        </div>
	</div>
	<!--导航end-->
	<!--工作流程介绍start-->
	<div class="wf">
		<img style="width:100%; height:100%;" alt="工作流程" src="http://7xrh7n.com1.z0.glb.clouddn.com/%E5%B7%A5%E4%BD%9C%E6%B5%81%E7%A8%8B.jpg"/>
	</div>
	<!--工作流程介绍end-->
	<!--片尾start-->
	<div class="allfoot">
	      <img style="width:100%; height:100%;" alt="尾部照片" src="http://7xrh7n.com1.z0.glb.clouddn.com/6.jpg">
	</div>
	<!--片尾end-->
</div>
<script>
$(function(){
    $(".nav").movebg({width:120/*滑块的大小*/,extra:40/*额外反弹的距离*/,speed:300/*滑块移动的速度*/,rebound_speed:400/*滑块反弹的速度*/});
})
</script>
<!-- 代码 结束 -->
</body>
</html>
