<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sessionout.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <h1>您进行的操作失败! </h1><br/><h1>原因：账号登陆过期，请重新进行登陆操作</h1>
    <div style="font-size:20px;" class="body_time">
          <span  style="color:red;" id="showtimes"></span> &nbsp;<span>秒之后自动跳转</span>
        </div>
        <div class="body_link">
          <span><a href="backlogin">立即跳转</a></span>
        </div>
   <!--javascript-->
    <script type="text/javascript">  
      //设定倒数秒数  
      var t = 10;  
      //显示倒数秒数  
      function showTime(){  
          t -= 1;  
          document.getElementById('showtimes').innerHTML= t;  
          if(t==0){  
              location.href='backlogin';  
          }  
          //每秒执行一次,showTime()  
          setTimeout("showTime()",1000);  
      }  
      //执行showTime()  
      showTime();  
      </script>
  </body>
  
</html>
