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
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<!--网站导航栏start-->
<link href="css/jq22.css" rel="stylesheet" type="text/css">
<link href="css/nav.css" rel="stylesheet" type="text/css">
<script src="js/jquery.movebg.js"></script>
<script src="js/nav.js"></script>
<!--网站导航栏end-->
<!--company.js .css start-->
<script type="text/javascript" src="js/companyinfor.js"></script>
<link rel="stylesheet" type="text/css" href="css/companyinfor.css">
<!--company.js .css end-->
</head>
<body>
<div class="cominfor_all">
<!--网站页首start-->
<div class="wangzhan_headlogo">
</div>
<!--网站页首end-->
<!--导航start-->
    <div class="wraper">
        <div class="nav">
            <ul>
                <li class="nav-item"><a href="#" >网站首页</a></li>
                <li class="nav-item"><a href="#">工作流程</a></li>
                <li class="nav-item  cur"><a href="#" >公司简介</a></li>
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
    <div class="cominfor_body">
    	<span>这里是公司简介内容地方</span><br/>
    	<img style="width:800px; height:500px;" src="http://7xrh7n.com1.z0.glb.clouddn.com/2016-02-10%2009:53:31%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE.png"/>
    </div>

    <!--网站页脚start-->
    <div class="allfoot">
    </div>
    <!--网站页脚end-->
</div>


<script>
//导航栏js start
$(function(){
    $(".nav").movebg({width:120/*滑块的大小*/,extra:40/*额外反弹的距离*/,speed:300/*滑块移动的速度*/,rebound_speed:400/*滑块反弹的速度*/});
})
</script>
<!-- 代码 结束 -->
</body>
</html>
