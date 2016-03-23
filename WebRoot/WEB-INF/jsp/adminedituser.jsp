<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>浩宇广告公司后台</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
        <script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
        <!-- Bootstrap -->
        <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="<%=path %>/css/bootstrap-theme.min.css" rel="stylesheet" media="screen">

        <!-- Bootstrap Admin Theme -->
        <link href="<%=path %>/css/bootstrap-admin-theme.css" rel="stylesheet" media="screen">

        <!-- Vendors -->
        <link href="<%=path %>/vendors/easypiechart/jquery.easy-pie-chart.css" rel="stylesheet" media="screen">
        <link href="<%=path %>/vendors/easypiechart/jquery.easy-pie-chart_custom.css" rel="stylesheet" media="screen">

        <!--adminshowcase.css .js start-->
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/adminedituser.css">
        <script type="text/javascript" src="<%=path %>/js/adminedituser.js"></script>
        <!--adminshowcase.css .js end-->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
           <script type="text/javascript" src="js/html5shiv.js"></script>
           <script type="text/javascript" src="js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="bootstrap-admin-with-small-navbar">
     <nav class="navbar navbar-default navbar-inverse navbar-fixed-top " role="navigation">
	 <div class="container">
       <div class="row">
		  <!-- Brand and toggle get grouped for better mobile display -->
		  <div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			  <span class="sr-only">浩宇广告公司</span>
			  <span class="icon-bar"></span>
			  <span class="icon-bar"></span>
			  <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="adminindex">浩宇广告公司后台</a>
		  </div>
		  <!-- Collect the nav links, forms, and other content for toggling -->
		  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
			</ul>
			<ul class="nav navbar-nav navbar-right">
			  <li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">超级管理员：<s:property value="#session.username"/> <b class="caret"></b></a>
				<ul class="dropdown-menu">
				  <li><a href="#">账户中心</a></li>
                                                          <li class="divider"></li>
                                                          <li><a href="#">登陆记录</a></li>
				  <li class="divider"></li>
				  <li><a href="outlogin">退出登录</a></li>
				</ul>
			  </li>
			</ul>
		  </div><!-- /.navbar-collapse -->
		  </div>
		  </div>
		</nav>

        <div class="container">
            <!-- left, vertical navbar & content -->
            <div class="row">
                <!-- left, vertical navbar -->
                <div class="col-md-2 bootstrap-admin-col-left">
                     <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
                         <li >
                            <a href="adminindex"><i class="glyphicon glyphicon-chevron-right"></i> 使用帮助文档</a>
                        </li>
                        <li >
                            <a href="adminshowcase"><i class="glyphicon glyphicon-chevron-right"></i>案例首页展示</a>
                        </li>
	          <li >
                            <a href="adminaddcaseclass"><i class="glyphicon glyphicon-chevron-right"></i> 添加案例分类</a>
                        </li>
                        <li >
                            <a href="admineditcaseclass"><i class="glyphicon glyphicon-chevron-right"></i>管理案例分类</a>
                        </li>                       
                        <li >
                            <a href="adminadduser"><i class="glyphicon glyphicon-chevron-right"></i>添加普通用户</a>
                        </li>
                        <li class="active">
                            <a href="adminedituser"><i class="glyphicon glyphicon-chevron-right"></i>管理普通用户</a>
                        </li>
                        <li>
                            <a href="adminselectlogs"><i class="glyphicon glyphicon-chevron-right"></i>查询操作记录</a>
                        </li>
                        
                    </ul>
                </div>

                <!-- content -->
                <div class="col-md-10">
                    <div class="row showuser">
                        <div class="panel panel-default bootstrap-admin-no-table-panel">
                            <div class="panel-heading">
                                <div class="text-muted bootstrap-admin-box-title">管理普通用户</div>
                            </div>
                            <div class="bootstrap-admin-panel-content bootstrap-admin-no-table-panel-content collapse in">
                                 <div class="showuser_all">
                                    <table class="table table-hover">
                                      <thead>
                                        <tr><td>#</td><td class="username">用户姓名</td><td class="userid">用户账号</td><td class="edituser">修改密码</td><td class="deluser">删除用户</td></tr>
                                       </thead>
                                       <tbody>
                                       	<s:iterator value="list" status="st">
                                       		<tr><td><s:property value="#st.index+1"/> </td><td class="username"><s:property value="name"/> </td><td class="useraccount"><s:property value="account"/> </td><td><button class="button_editoneuser"><span class="glyphicon  glyphicon-pencil"></span></button><td><button class="removeuser"><span class="glyphicon glyphicon-remove"></span></button></td></tr>	
                                       	</s:iterator>
                                       </tbody>
                                     </table>
                                 </div>
                            </div>
                        </div>
                    </div>
                    <div class="row editoneuser">
                        <div class="panel panel-default bootstrap-admin-no-table-panel">
                            <div class="panel-heading">
                                <div class="text-muted bootstrap-admin-box-title"><a href="#" class="rollback" >管理普通用户</a> / <a >修改密码</a> /<a >勾超</a></div>
                            </div>
                            <div class="bootstrap-admin-panel-content bootstrap-admin-no-table-panel-content collapse in">
                                 <div class="editoneuser_all">
                                 	<h3 style="color:red;">您现在正在修改账号是:<a class="edituseracc"></a>的密码</h3>
                                    <div class="line row">
                                        <div class="line_left col-md-3">
                                            <span>请输入新密码：</span>
                                        </div>
                                        <div class="line_right col-md-9">
                                            <input type="password" class="form-control input_newpass"  placeholder="请输入新的用户密码，密码由英文字母与数字组成，密码不能为空">
                                        </div>
                                    </div>
                                    <div class="line row">
                                        <div class="line_left col-md-3">
                                            <span>请再次输入新密码：<span>
                                        </div>
                                        <div class="line_right col-md-9">
                                            <input type="password" class="form-control tinput_newpass" placeholder="请输入再次新的用户密码，密码由英文字母与数字组成，密码不能为空">
                                        </div>
                                    </div>
                                    <div class="result" style="font-size:20px; color:red; margin-top:20px;"></div>
                                    <div class="line">
                                        <button type="button" class="btn  button_submitedituser btn-success">确认修改</button>
                                         <button type="button" class="btn  button_closeedituser btn-primary">取消修改</button>
                                    </div>
                                 </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <hr>
                <footer role="contentinfo">
                    <p>&copy; 2016 <a href="" target="_blank">朝阳浩宇广告有限公司</a></p>
                </footer>
            </div>
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script type="text/javascript" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>

        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script type="text/javascript" src="<%=path %>/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="<%=path %>/vendors/easypiechart/jquery.easy-pie-chart.js"></script>

        <script type="text/javascript">
            $(function() {
                // Easy pie charts
                $('.easyPieChart').easyPieChart({animate: 1000});
            });
        </script>
    </body>
</html>
