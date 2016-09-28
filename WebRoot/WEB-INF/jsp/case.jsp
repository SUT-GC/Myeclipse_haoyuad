<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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

<!--网站导航栏start-->
<link href="css/jq22.css" rel="stylesheet" type="text/css">
<link href="css/nav.css" rel="stylesheet" type="text/css">
<script src="js/jquery.movebg.js"></script>
<script src="js/nav.js"></script>
<!--网站导航栏end-->
<!--tead.js .css start-->
<script type="text/javascript" src="js/case.js"></script>
<link rel="stylesheet" type="text/css" href="css/case.css"/>
<!--tead.js .css end-->
<!--作品展示start-->
<script src="js/zoom.js"></script>
<link rel="stylesheet"  href="css/zoom.css" media="all" />
<!--作品展示end-->
<style type="text/css">

</style>

</head>
<body>
<div class="cominfor_all">
<!--网站页首start-->
<div class="wangzhan_headlogo">
<img style="width:100%; height:100%;" alt="" src="http://7xrh7n.com1.z0.glb.clouddn.com/1.jpg">
</div>
<!--网站页首end-->
<!--导航start-->
    <div class="wraper">
        <div class="nav">
            <ul>
                <li class="nav-item"><a href="#" >网站首页</a></li>
                <li class="nav-item"><a href="#">工作流程</a></li>
                <li class="nav-item"><a href="#" >公司简介</a></li>
                <li class="nav-item   cur"><a href="#" >经典案例</a></li> 
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
    <div class="case_body ">
    	<div class="case_nav ">
    		<div class="alert alert-success case_cloud" role="alert">案例分类</div>
    		<div class="list-group">
			  <a href="case" class="list-group-item  active" id="allcase_label">全部 </a>
				<s:iterator value="labelList">
			  		<a href="#" class="list-group-item caselabel" ><s:property value="name"/></a><span style="display:none;" class="label_id"><s:property value="id"/></span>
			   </s:iterator>
		</div>
	</div>
	<!-- <div class="col-md-1"></div> -->
    	<div class="case_show ">
    		<s:iterator value="caseList">
	    		<div class="each_case">
	    			<a href="#">
	    				<div class="case_id" style="display:none"><s:property value="id"/></div>
		    			<div class="case_img">
		    				<img src='http://7xrh7n.com1.z0.glb.clouddn.com/<s:property value="headimg"/>'/>
		    			</div>
		    			<div class="case_infor">
		    				<s:property value="name"/>
		    			</div>
		    		</a>
	    		</div>
    		</s:iterator>
    	</div>
    	
    	<!--点击显示详细图片 start-->
	<div class="show_eachcase_all">
		<div class="show_eachcase_nav"><span class="eachcase_nav_first" ><a href="#">校园文化</a> &nbsp;&nbsp;>>&nbsp;&nbsp;</span><span><a >建平二高中</a></span></div>
		
		<div class="show_eachcase_info">
			<pre></pre>
		</div>

		<div class="container">

			<ul class="gallery">
				<li><a href="images/gallery/DSC_0008-660x441.jpg"><img src="images/gallery/DSC_0008-660x441.jpg" /></a></li>
				<li><a href="images/gallery/DSC_0008-660x441.jpg"><img src="images/gallery/DSC_0008-660x441.jpg" /></a></li>
				<li><a href="images/gallery/DSC_0008-660x441.jpg"><img src="images/gallery/DSC_0008-660x441.jpg" /></a></li>
				<li><a href="images/gallery/DSC_0008-660x441.jpg"><img src="images/gallery/DSC_0008-660x441.jpg" /></a></li>
				<li><a href="images/gallery/DSC_0014-660x441.jpg"><img src="images/gallery/DSC_0014-660x441.jpg" /></a></li>
				<li><a href="images/gallery/DSC_0019-660x441.jpg"><img src="images/gallery/DSC_0019-660x441.jpg" /></a></li>
				<li><a href="images/gallery/DSC_0008-660x441.jpg"><img src="images/gallery/DSC_0008-660x441.jpg" /></a></li>
				<li><a href="images/gallery/DSC_0061-660x441.jpg"><img src="images/gallery/DSC_0061-660x441.jpg" /></a></li>
				<li><a href="images/gallery/DSC_0063-441x660.jpg"><img src="images/gallery/DSC_0063-441x660.jpg" /></a></li>
				<li><a href="images/gallery/DSC_0090-660x441.jpg"><img src="images/gallery/DSC_0090-660x441.jpg" /></a></li>
				<li><a href="images/gallery/DSC_0222-660x441.jpg"><img src="images/gallery/DSC_0222-660x441.jpg" /></a></li>
			</ul>
			<div class="clear"></div>
		
		</div>
	</div>
	<!--点击显示详细图片 end-->
	<div class="clear"></div>
    </div>
</div>

<!--网站页脚start-->
<div class="allfoot">
<img style="width:100%; height:100%;" alt="尾部照片" src="http://7xrh7n.com1.z0.glb.clouddn.com/6.jpg">
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
