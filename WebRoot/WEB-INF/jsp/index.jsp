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
<script type="text/javascript" src="js/base64.js"></script>
<script src="js/nav.js"></script>
<!--网站导航栏end-->
<link href="css/haoyuadindex.css" rel="stylesheet" type="text/css">
<script src="js/haoyuadindex.js"></script>

<style type="text/css">
        body{
            background-image: url('images/background.png');
            /*background-image: url(images/qiangzhi.jpg);*/
            /*background-color: #99FFFF;*/
        }
        #works1, #works2, #works3{
        	display:none;
        }
        .works img:hover{
        	transform: scale(1.3);
			-ms-transform: scale(1.3);	/* IE 9 */
			-webkit-transform: scale(1.3);	/* Safari 和 Chrome */
			-o-transform: scale(1.3);	/* Opera */
			-moz-transform: scale(1.3);	/* Firefox */
        }
         .works img{
        	transition: all 1s;
			-moz-transition: all 1s;	/* Firefox 4 */
			-webkit-transition: all 1s;	/* Safari 和 Chrome */
			-o-transition: all 1s;
        }
        .works ul li div{
        	box-sizing:border-box;
			-moz-box-sizing:border-box; /* Firefox */
			-webkit-box-sizing:border-box; /* Safari */
			overflow:hidden;
        }
       .works ul li div a:link{
       		color:#000;
       		text-decoration: none;
       }
        .works ul li div a:visited{
       		color:#000;
       		text-decoration: none;
       }
        .works ul li div a:hover{
       		color:#0088ce;
       		text-decoration: underline;
       }
</style>
</head>

<body>
<div class='all'>
  <div class="wangzhan_headlogo">
    
  </div>
<!--导航start-->
    <div class="wraper">
        <div class="nav">
            <ul>
                <li class="nav-item  cur"><a href="#" >网站首页</a></li>
                <li class="nav-item"><a href="#">工作流程</a></li>
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

    <!--轮幕start-->
    <div class="lunmu">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
          <!-- Indicators -->
          <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
          </ol>

          <!-- Wrapper for slides -->
          <div class="carousel-inner" role="listbox">
            <div class="item active">
              <img src="images/1.png" alt="">
              <div class="carousel-caption">
              </div>
            </div>
            <div class="item">
              <img src="images/1.png" alt="">
              <div class="carousel-caption">
              </div>
            </div>
             <div class="item">
              <img src="images/1.png" alt="">
              <div class="carousel-caption">
              </div>
            </div>
          </div>

          <!-- Controls -->
          <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
    </div>
    <!--轮幕end-->
    <!--介绍业务的图片 start -->
    <div class='indeximg'>
    </div>
    <!--介绍业务的图片 end -->
    <!--公司图片展示区start-->
    <div class="showworks">
      <!--列出三个展示 start-->
      <div id="works1" class="works01 works">
        <div  class="works_head works01_head">
          <span id="label_name_1">校园文化展板</span>
        </div>
        <div class="works_body works01_body">
          <div class="works_pre"><img src=""></div>
          <ul>
              <li>
                <div>
                	<a href="case">
	                  <img id="works_img_11" class="works_img" src="images/background.png">
	                  <div class="works_img_dis" id="works_img_dis_11">
	                    东北大秧歌
	                  </div>
                 	 </a>
                </div>
              </li>
              <li>
                <div>
                <a href="case">
                  <img id="works_img_12"  class="works_img" src="images/background.png">
                  <div class="works_img_dis"  id="works_img_dis_12">
                    向阳中学战狼
                  </div>
                  </a>
                </div>
              </li>
              <li>
                <div>
                <a href="case">
                  <img  id="works_img_13" class="works_img" src="images/background.png">
                  <div  id="works_img_dis_13" class="works_img_dis">
                    ssssssssssssssssssssssssssssssssssssssssss
                  </div>
                  </a>
                </div>
              </li>
              <li>
                <div>
                <a href="case">
                  <img  id="works_img_14" class="works_img" src="images/background.png">
                  <div class="works_img_dis"  id="works_img_dis_14">
                    ssssssssssssssssssssssssssssssssssssssssss
                  </div>
                  </a>
                </div>
              </li>
              <li>
                <div>
                <a href="case">
                  <img  id="works_img_15" class="works_img" src="images/background.png">
                  <div  id="works_img_dis_15" class="works_img_dis">
                    ssssssssssssssssssssssssssssssssssssssssss
                  </div>
                  </a>
                </div>
              </li>
          </ul>
          <div class="works_next"></div>
        </div>
        <div class="clear"></div>
      </div>
      <div  id="works2"  class="works02 works">
         <div class="works_head works02_head">
            <span id="label_name_2">head</span>
          </div>
          <div class="works_body works02_body">
             <div class="works_pre">d</div>
             <ul>
              <li>
                <div>
                <a href="case">
                  <img id="works_img_21" class="works_img" src="images/background.png">
                  <div class="works_img_dis" id="works_img_dis_21">
                    东北大秧歌
                  </div>
                  </a>
                </div>
              </li>
              <li>
                <div>
                <a href="case">
                  <img id="works_img_22"  class="works_img" src="images/background.png">
                  <div class="works_img_dis"  id="works_img_dis_22">
                    向阳中学战狼
                  </div>
                  </a>
                </div>
              </li>
              <li>
                <div>
                <a href="case">
                  <img  id="works_img_23" class="works_img" src="images/background.png">
                  <div  id="works_img_dis_23" class="works_img_dis">
                    ssssssssssssssssssssssssssssssssssssssssss
                  </div>
                  </a>
                </div>
              </li>
              <li>
                <div>
                <a href="case">
                  <img  id="works_img_24" class="works_img" src="images/background.png">
                  <div class="works_img_dis"  id="works_img_dis_24">
                    ssssssssssssssssssssssssssssssssssssssssss
                  </div>
                  </a>
                </div>
              </li>
              <li>
                <div>
                <a href="case">
                  <img  id="works_img_25" class="works_img" src="images/background.png">
                  <div  id="works_img_dis_25" class="works_img_dis">
                    ssssssssssssssssssssssssssssssssssssssssss
                  </div>
                  </a>
                </div>
              </li>
          </ul>
            <div class="works_next">d</div>
         </div>
         <div class="clear"></div>
      </div>
      <div  id="works3"  class="works03 works">
         <div class="works_head works02_head">
            <span id="label_name_3">head</span>
         </div>
         <div class="works_body works02_body">
            <div class="works_pre">d</div>
             <ul>
              <li>
                <div>
                <a href="case">
                  <img id="works_img_31" class="works_img" src="images/background.png">
                  <div class="works_img_dis" id="works_img_dis_31">
                    东北大秧歌
                  </div>
                  </a>
                </div>
              </li>
              <li>
                <div>
                <a href="case">
                  <img id="works_img_32"  class="works_img" src="images/background.png">
                  <div class="works_img_dis"  id="works_img_dis_32">
                    向阳中学战狼
                  </div>
                  </a>
                </div>
              </li>
              <li>
                <div>
                <a href="case">
                  <img  id="works_img_33" class="works_img" src="images/background.png">
                  <div  id="works_img_dis_33" class="works_img_dis">
                    ssssssssssssssssssssssssssssssssssssssssss
                  </div>
                  </a>
                </div>
              </li>
              <li>
                <div>
                <a href="case">
                  <img  id="works_img_34" class="works_img" src="images/background.png">
                  <div class="works_img_dis"  id="works_img_dis_34">
                    ssssssssssssssssssssssssssssssssssssssssss
                  </div>
                  </a>
                </div>
              </li>
              <li>
                <div>
                <a href="case">
                  <img  id="works_img_35" class="works_img" src="images/background.png">
                  <div  id="works_img_dis_35" class="works_img_dis">
                    ssssssssssssssssssssssssssssssssssssssssss
                  </div>
                  </a>
                </div>
              </li>
          </ul>
            <div class="works_next">d</div>
          </div>
          <div class="clear"></div>
      </div>
       <!--列出三个展示 end-->
    </div>
    <!--公司图片展示区end-->
    <!--片尾start-->
    <div class="allfoot">
      
    </div>
    <!--片尾end-->
</div>


<script>
$(function(){
    $(".nav").movebg({width:120/*滑块的大小*/,extra:40/*额外反弹的距离*/,speed:300/*滑块移动的速度*/,rebound_speed:400/*滑块反弹的速度*/});
})


var jsonCases;
var jsonLabels;
jsonLabels = ${labelsJSON}
jsonCases = ${casesJSON}

for(var i = 1; i <= jsonLabels.length; i++){
	var id = "works"+i;
	var imgId = "works_img_"+i;
	var desId =  "works_img_dis_"+i;
	var qiniuRootUrl = "http://7xrh7n.com1.z0.glb.clouddn.com/";
	document.getElementById(id).style.display="block";
	var label_name_id = "label_name_"+i; 
	document.getElementById(label_name_id).innerHTML = Base64.decode(jsonLabels[i-1].labelName);
	for(var j = 1; j < jsonCases[i-1].cases.length; j++){
		for(var k = 1; k <= 5; k++){
			if(k % j == 0){
				var allImgId = imgId + k;
				var allDesId = desId + k;
				document.getElementById(allImgId).src=qiniuRootUrl+jsonCases[i-1].cases[j-1].caseHeadImg;
				document.getElementById(allDesId).innerHTML =Base64.decode( jsonCases[i-1].cases[j-1].caseName);
			}
		}
	}
}
</script>
<!-- 代码 结束 -->


</body>
</html>
