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
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" media="screen">

        <!-- Bootstrap Admin Theme -->
        <link href="css/bootstrap-admin-theme.css" rel="stylesheet" media="screen">

        <!-- Vendors -->
        <link href="vendors/easypiechart/jquery.easy-pie-chart.css" rel="stylesheet" media="screen">
        <link href="vendors/easypiechart/jquery.easy-pie-chart_custom.css" rel="stylesheet" media="screen">
        
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
           <script type="text/javascript" src="js/html5shiv.js"></script>
           <script type="text/javascript" src="js/respond.min.js"></script>
        <![endif]-->
        <!--引入backeditcase.js .css start-->
        <link rel="stylesheet" type="text/css" href="css/backeditimg.css">
        <script type="text/javascript" src = "js/backeditcase.js"></script>
        <!--引入backeditcase.js .css end-->
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
            <a class="navbar-brand" href="#">浩宇广告公司后台</a>
          </div>
          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">管理员: <s:property value="#session.username"/> <b class="caret"></b></a>
                <ul class="dropdown-menu">
                   <li><a href="#">账户中心</a></li>
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
                            <a href="normalindex"><i class="glyphicon glyphicon-chevron-right"></i> 使用帮助文档</a>
                        </li>
                        <li >
                            <a href="backaddcase"><i class="glyphicon glyphicon-chevron-right"></i> 添加项目案例</a>
                        </li>                       
                        <li class="active">
                            <a href="backeditcase"><i class="glyphicon glyphicon-chevron-right"></i> 修改项目案例</a>
                        </li>
                    </ul>
                </div>

                <!-- content -->
                <div class="col-md-10">
                    <div class="row show_casetabls">
                        <!--显示table-->
                        <div class="panel panel-default bootstrap-admin-no-table-panel">
                            <div class="panel-heading">
                                <div class="text-muted bootstrap-admin-box-title">修改项目案例</div>
                            </div>
                            <div class="bootstrap-admin-panel-content bootstrap-admin-no-table-panel-content collapse in">  
                                <table class="table table-hover showallcase">
                                  <thead>
                                    <tr><td>#</td><td>项目名称</td><td class="createtime">创建时间</td><td class="imgbutton">编辑信息</td><td class="imgbutton">删除图片</td><td class="imgbutton">上传图片</td><td class="imgbutton">删除项目</td></tr>
                                  </thead>
                                  <tbody>
                                  	<s:iterator value="list" status="st">
                                  		<tr><td class="case_id"  style="display:none;"><s:property value="id"/></td><td class="case_describe"  style="display:none;"><s:property value="describe"/> </td><td><s:property value="#st.index+1"/></td><td class="case_name"><s:property value="name"/></td><td><s:property value="timestamp"/> </td><td><button class="edit_caseinfor"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></td><td><button class="del_img"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></td><td><button class="upload_img"><span class="glyphicon glyphicon-upload" aria-hidden="true"></span></button></td><td><button class="del_case"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></td></tr>
                                  	</s:iterator>
                                  </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row edit_caseinfor_div ">
                        <div class="panel panel-default bootstrap-admin-no-table-panel">
                            <div class="panel-heading">
                                <div class="text-muted bootstrap-admin-box-title"><a class="rollback_to_editcase" href="#">修改项目案例</a> &nbsp;&nbsp;/&nbsp;&nbsp;<a>向阳中学走廊设计</a>/&nbsp;&nbsp;<a>编辑信息</a></div>
                            </div>
                            <div class=" editcaseinfor_all">
                                    <div class="each_line row">
                                        <div class="editcase_head_left col-md-2">
                                            <span>项目名称：</span>
                                        </div>
                                        <div class="editcase_head_right col-md-10">
                                            <input   type="text" class="form-control new_case_name" id="exampleInputName2" placeholder="必须添加项目名称，内容中不能存在空格">
                                            <div class="new_case_id" style="display:none;"></div>
                                        </div>
                                    </div>
                                    <hr/>
                                    <div class="each_line row">
                                        <div class="editcase_head_left col-md-2">
                                            <span>项目描述：</span>
                                        </div>
                                        <div class="editcase_head_right col-md-10">
                                            <textarea  class="form-control new_case_describe" rows="3" placeholder="项目描述可以选填，显示在项目展示处"></textarea>
                                        </div>
                                    </div>
                                    <hr/>
                                    <div class="each_line row">
                                        <div class="editcase_head_left    col-md-2">
                                            <span>项目分类：</span>
                                        </div>
                                        <div class="editcase_head_right  case_class col-md-10">
                                        	<s:iterator value="labels">
                                        		<label class="radio-inline">
                                              		<input type="radio" class="case_class_check"  name="inlineRadioOptions" id="inlineRadio1" value='<s:property value="id"/>'><s:property value="name"/>
                                           		 </label>
                                        	</s:iterator>
                                        </div>
                                    </div>
                                    <hr/>
                                    <div class="each_line">
                                       <button type="button" class="btn btn-success editcase_sub_button">确认修改</button>
                                    </div>
                                </div>
                        </div>
                    </div> 
                    <div class="row delimg_all ">
                        <div class="panel panel-default bootstrap-admin-no-table-panel">
                            <div class="panel-heading">
                               <div class="text-muted bootstrap-admin-box-title"><a class="rollback_to_editcase" href="#">修改项目案例</a> &nbsp;&nbsp;/&nbsp;&nbsp;<a>向阳中学走廊设计</a>/&nbsp;&nbsp;<a>删除照片</a></div>
                            </div>
                            <div class="showimg_all">
                              <!--显示单个img div  start-->
                              <div class="col-xs-6 col-md-3 each_img">
                                <div class="thumbnail">
                                  <button class="glyphicon glyphicon-remove" aria-hidden="true"></button>
                                  <img src="images/1.png" alt="...">
                                </div>
                              </div>
                              <!--显示单个img div  end-->
                              <!--显示单个img div  start-->
                              <div class="col-xs-6 col-md-3 each_img">
                                <div class="thumbnail">
                                  <button class="glyphicon glyphicon-remove" aria-hidden="true"></button>
                                  <img src="images/1.png" alt="...">
                                </div>
                              </div>
                              <!--显示单个img div  end-->
                              <!--显示单个img div  start-->
                              <div class="col-xs-6 col-md-3 each_img">
                                <div class="thumbnail">
                                  <button class="glyphicon glyphicon-remove" aria-hidden="true"></button>
                                  <img src="images/1.png" alt="...">
                                </div>
                              </div>
                              <!--显示单个img div  end-->
                              <!--显示单个img div  start-->
                              <div class="col-xs-6 col-md-3 each_img">
                                <div class="thumbnail">
                                  <button class="glyphicon glyphicon-remove" aria-hidden="true"></button>
                                  <img src="images/1.png" alt="...">
                                </div>
                              </div>
                              <!--显示单个img div  end-->
                              <!--显示单个img div  start-->
                              <div class="col-xs-6 col-md-3 each_img">
                                <div class="thumbnail">
                                  <button class="glyphicon glyphicon-remove" aria-hidden="true"></button>
                                  <img src="images/1.png" alt="...">
                                </div>
                              </div>
                              <!--显示单个img div  end-->
                              <!--显示单个img div  start-->
                              <div class="col-xs-6 col-md-3 each_img">
                                <div class="thumbnail">
                                  <button class="glyphicon glyphicon-remove" aria-hidden="true"></button>
                                  <img src="images/1.png" alt="...">
                                </div>
                              </div>
                              <!--显示单个img div  end-->
                              <!--显示单个img div  start-->
                              <div class="col-xs-6 col-md-3 each_img">
                                <div class="thumbnail">
                                  <button class="glyphicon glyphicon-remove" aria-hidden="true"></button>
                                  <img src="images/1.png" alt="...">
                                </div>
                              </div>
                              <!--显示单个img div  end-->
                            </div>
                        </div>
                      </div>
                      <div class="row upload_img_all ">
                        <div class="panel panel-default bootstrap-admin-no-table-panel">
                            <div class="panel-heading">
                               <div class="text-muted bootstrap-admin-box-title"><a class="rollback_to_editcase" href="#">修改项目案例</a> &nbsp;&nbsp;/&nbsp;&nbsp;<a>向阳中学走廊设计</a>/&nbsp;&nbsp;<a>上传图片</a></div>
                            </div>
                            <div class="upload_img_div">
                              <div class="each_line row">
                                  <div class="addcase_head_left col-md-2">
                                      <span>项目首图：</span>
                                  </div>
                                  <div class="addcase_head_right  col-md-10">
                                     <input class="input_head_img" id="input_head_img" accept="image/*" type="file" id="exampleInputFile">
                                  </div>
                                </div>
                                <hr/>
                                <div class="each_line row">
                                  <div class="addcase_head_left col-md-2">
                                      <span>项目分图</span>
                                  </div>
                                  <div class="addcase_head_right  col-md-10">
                                    <div class="each_img_fen">
                                         <input class="input_file" id="input_files" multiple accept="image/*" type="file" id="exampleInputFile">
                                     </div>
                                  </div>
                                </div>
                                <div class="each_line">
                                       <button type="button" class="btn btn-success editcase_sub_button">提交图片</button>
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
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="vendors/easypiechart/jquery.easy-pie-chart.js"></script>

        <script type="text/javascript">
            $(function() {
                // Easy pie charts
                $('.easyPieChart').easyPieChart({animate: 1000});
            });
        </script>
    </body>
</html>
