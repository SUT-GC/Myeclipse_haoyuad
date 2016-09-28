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

<!--网站导航栏start-->
<link href="css/jq22.css" rel="stylesheet" type="text/css">
<link href="css/nav.css" rel="stylesheet" type="text/css">
<script src="js/jquery.movebg.js"></script>
<script src="js/nav.js"></script>
<!--网站导航栏end-->
<!--recruit.js .css start-->
<!-- <script type="text/javascript" src="js/recruit.js"></script> -->
<link rel="stylesheet" type="text/css" href="css/tellme.css"/>
<!--tead.js .css end-->
<!--百度地图API start-->
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=6h0jOSEsOe6neCpcgwpocP6P"></script>
<!--百度地图API end-->
</head>
<body>
<div class="tellme_all">
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
                <li class="nav-item"><a href="#" >经典案例</a></li> 
                <li class="nav-item "><a href="#" >主创团队</a></li> 
                <li class="nav-item"><a href="#" >招兵买马</a></li>
                <li class="nav-item  cur"><a href="#">联系我们</a></li>
            </ul>
             <!--移动的滑动-->
            <div class="move-bg"></div>
            <!--移动的滑动 end-->
        </div>
    </div>
    <!--导航end-->
    <div class="tellme_body">
        <div class="tellme_infor">
            <span>联系电话: 18804036473</span> 
            <div>......</div>
        </div>
        <!--百度地图api start-->
        <div class="baidumap_api">
            <div style="width:700px;height:550px;border:#ccc solid 1px;font-size:12px" id="map"></div>
        </div>
        <!--百度地图api end-->
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
//百度地图pai spart
 //创建和初始化地图函数：
    function initMap(){
      createMap();//创建地图
      setMapEvent();//设置地图事件
      addMapControl();//向地图添加控件
      addMapOverlay();//向地图添加覆盖物
    }
    function createMap(){ 
      map = new BMap.Map("map"); 
      map.centerAndZoom(new BMap.Point(119.631194,41.403158),19);
    }
    function setMapEvent(){
      map.enableScrollWheelZoom();
      map.enableKeyboard();
      map.enableDragging();
      map.enableDoubleClickZoom()
    }
    function addClickHandler(target,window){
      target.addEventListener("click",function(){
        target.openInfoWindow(window);
      });
    }
    function addMapOverlay(){
      var markers = [
        {content:"电话:18804036473",title:"浩宇广告公司",imageOffset: {width:0,height:3},position:{lat:41.403067,lng:119.631207}}
      ];
      for(var index = 0; index < markers.length; index++ ){
        var point = new BMap.Point(markers[index].position.lng,markers[index].position.lat);
        var marker = new BMap.Marker(point,{icon:new BMap.Icon("http://api.map.baidu.com/lbsapi/createmap/images/icon.png",new BMap.Size(20,25),{
          imageOffset: new BMap.Size(markers[index].imageOffset.width,markers[index].imageOffset.height)
        })});
        var label = new BMap.Label(markers[index].title,{offset: new BMap.Size(25,5)});
        var opts = {
          width: 200,
          title: markers[index].title,
          enableMessage: false
        };
        var infoWindow = new BMap.InfoWindow(markers[index].content,opts);
        marker.setLabel(label);
        addClickHandler(marker,infoWindow);
        map.addOverlay(marker);
      };
    }
    //向地图添加控件
    function addMapControl(){
      var scaleControl = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
      scaleControl.setUnit(BMAP_UNIT_IMPERIAL);
      map.addControl(scaleControl);
      var navControl = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
      map.addControl(navControl);
      var overviewControl = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:true});
      map.addControl(overviewControl);
    }
    var map;
      initMap();
//百度地图pai end
</script>
<!-- 代码 结束 -->
</body>
</html>
