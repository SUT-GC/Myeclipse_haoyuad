<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/admineditcaseclass.css">
        <script type="text/javascript" src="js/admineditcaseclass.js"> </script>
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
                        </li >
                        <li class="active">
                            <a href="admineditcaseclass"><i class="glyphicon glyphicon-chevron-right"></i>管理案例分类</a>
                        </li>                       
                        <li>
                            <a href="adminadduser"><i class="glyphicon glyphicon-chevron-right"></i>添加普通用户</a>
                        </li>
                        <li>
                            <a href="adminedituser"><i class="glyphicon glyphicon-chevron-right"></i>管理普通用户</a>
                        </li>
                        <li>
                            <a href="adminselectlogs"><i class="glyphicon glyphicon-chevron-right"></i>查询操作记录</a>
                        </li>
                        
                    </ul>
                </div>

                <!-- content -->
                <div class="col-md-10">
                    <div class="row showallclass">
                        <div class="panel panel-default bootstrap-admin-no-table-panel">
                            <div class="panel-heading">
                                <div class="text-muted bootstrap-admin-box-title">管理案例分类</div>
                            </div>
                            <div class="bootstrap-admin-panel-content bootstrap-admin-no-table-panel-content collapse in">
                                <div class="showcase_all">
                                    <table class="table table-hover">
                                      <thead>
                                        <tr><td>#</td><td class="classname">分类名称</td><td class="editclass">编辑该分类</td><td class="delclass">删除该分类 </td></tr>
                                      </thead>
                                      <tbody>
                                      	<s:iterator value="list" status="st">
                                        	<tr><td class="labelid" style="display: none"> <s:property value="id"/> </td><td><s:property value="#st.index+1"/></td><td class="labelname"><s:property value="name"/> </td><td ><button type="button" class="btn button_editclass btn-primary">编辑</button></td><td><button type="button" class="btn button_delclass btn-danger">删除</button> </td></tr>
                                        </s:iterator>
                                      </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row editoneclass">
                        <div class="panel panel-default bootstrap-admin-no-table-panel">
                            <div class="panel-heading">
                                <div class="text-muted bootstrap-admin-box-title"><a href = "#" class="rollback">管理案例分类 </a>/ <a>编辑 </a> / <a> 校园文化 </a></div>
                            </div>
                            <div class="bootstrap-admin-panel-content bootstrap-admin-no-table-panel-content collapse in">
                            	<div style="font-size:25px; color:red">您正在修改分类名为 : <a class="old_label_name"></a><span style="display:none" class="old_label_id"></span></div>
                                <div class="editonecase_all">
                                    <div for="inputEmail3" class=" col-sm-3 input_classname control-label">请输入新的分类名：</div>
                                    <div class="col-sm-9">
                                      <input class="form-control new_label_name" placeholder="请输入分类名，其中不能包含空格或非法字符">
                                    </div>
                                    <button type="button" class="btn button_editcaseclassok btn-success">确认修改</button>
                                    <button type="button" class="btn button_editcaseclassno btn-primary">放弃修改</button>
                                </div>
                                <div class="result" style="font-size:20px; color:red; margin-top:20px;"></div>
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
