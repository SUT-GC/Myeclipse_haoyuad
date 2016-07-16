$(document).ready(function(){
	var spaceName = "http://7xrh7n.com1.z0.glb.clouddn.com";
	var imageSrc = spaceName+"/";
	var headImgName;
	var bodyImgNames;
	var newBodyImgDiv = '<div class="each_img_fen" style="width:170px; height:190px; padding:5px; "><img style="width:170px; height:170px;"/><div class="each_img_fen_del" style=" height:15px;font-size:15px; " ><a class="delete_body_img">删除</a></div></div>';
	$(".each_head_uploaddiv").hide();
//	$(".input_file").change(function(){
//		var input_imgs = document.getElementById("input_files");
//		var imgs = input_imgs.files;
//		var imgnames = "<br/>";
//		$(this).parent().find(".show_imgnames").remove();
//		for (var i = 0; i < imgs.length; i++){
//			imgnames += imgs[i].name;
//			imgnames += ";<br/> "
//		}
//		$(this).parent().prepend('<div class="show_imgnames" style="font-size:18px; margin-bottom:20px"> 图片名依次为：'+imgnames+'</div>');
//	});
//
	var option1 = {
		runtimes: 'html5,flash,html4',      // 上传模式，依次退化
		 browse_button: 'select_head_img_a', 
		 uptoken_url : 'getUoloadToken',
		  get_new_uptoken: false,  
		  max_file_size: '10mb',
		  max_retries: 3,        
		  save_key: true,
		  dragdrop: true,         
		  auto_start: true,      
		  domain: 'haoyuad',
		  init: {
		        'FilesAdded': function(up, files) {
		            plupload.each(files, function(file) {
		                // 文件添加进队列后，处理相关的事情
		            });
		        },
		        'BeforeUpload': function(up, file) {
		        		$(".each_head_uploaddiv").show();
		               // 每个文件上传前，处理相关的事情
		        },
		        'UploadProgress': function(up, file) {
		               // 每个文件上传时，处理相关的事情
		        },
		        'FileUploaded': function(up, file, info) {
		        	var imgBackName = eval("("+info+")");
		        	headImgName = imgBackName.key; 
		        	document.getElementById("each_img_head").src = imageSrc+imgBackName.key;;
		        	document.getElementById("select_head_img_a").innerHTML="重新选择";
		      
		        	
		               // 每个文件上传成功后，处理相关的事情
		               // 其中info是文件上传成功后，服务端返回的json，形式如：
		               // {
		               //    "hash": "Fh8xVqod2MQ1mocfI4S4KpRL6D98",
		               //    "key": "gogopher.jpg"
		               //  }
		               // 查看简单反馈
		               // var domain = up.getOption('domain');
		               // var res = parseJSON(info);
//			              var sourceLink = domain + res.key; 获取上传成功后的文件的Url
//			              alert(sourceLink);
		        },
		        'Error': function(up, err, errTip) {
		        	alert("上传出错");
		               //上传出错时，处理相关的事情
		        },
		        'UploadComplete': function() {
		        	$(".each_head_uploaddiv").hide();
		               //队列文件处理完毕后，处理相关的事情
		        },
		        'Key': function(up, file) {
		            // 若想在前端对每个文件的key进行个性化处理，可以配置该函数
		            // 该配置必须要在unique_names: false，save_key: false时才生效

		            var key = "";
		            // do something with key here
		            return key
		        }
		    }
	}
	var option2 = {
			runtimes: 'html5,flash,html4',      // 上传模式，依次退化
			 browse_button: 'select_body_img_a2', 
			 uptoken_url : 'getUoloadToken',
			  get_new_uptoken: false,  
			  max_file_size: '10mb',
			  max_retries: 3,        
			  save_key: true,
			  dragdrop: true,         
			  auto_start: true,      
			  domain: 'haoyuad',
			  init: {
			        'FilesAdded': function(up, files) {
			            plupload.each(files, function(file) {
			                // 文件添加进队列后，处理相关的事情
			            	$(".start_upload").text("正在准备上传......");
			            });
			        },
			        'BeforeUpload': function(up, file) {
			        	$(".start_upload").text("正在上传中......");
			               // 每个文件上传前，处理相关的事情
			        },
			        'UploadProgress': function(up, file) {
			               // 每个文件上传时，处理相关的事情
			        },
			        'FileUploaded': function(up, file, info) {
			        	$(".start_upload").text("上传完成");
			        	var imgBackName = eval("("+info+")");
			        	$(".select_body_img_a2").after(newBodyImgDiv);
			        	var nextDiv = $(".select_body_img_a2").next();
			        	nextDiv.find("img").attr("src",imageSrc+imgBackName.key);
			        	bodyImgNames = sumBodyImageName();
			        	
			               // 每个文件上传成功后，处理相关的事情
			               // 其中info是文件上传成功后，服务端返回的json，形式如：
			               // {
			               //    "hash": "Fh8xVqod2MQ1mocfI4S4KpRL6D98",
			               //    "key": "gogopher.jpg"
			               //  }
			               // 查看简单反馈
			               // var domain = up.getOption('domain');
			               // var res = parseJSON(info);
//				              var sourceLink = domain + res.key; 获取上传成功后的文件的Url
//				              alert(sourceLink);
			        },
			        'Error': function(up, err, errTip) {
			        	alert("上传出错");
			               //上传出错时，处理相关的事情
			        },
			        'UploadComplete': function() {
			               //队列文件处理完毕后，处理相关的事情
			        },
			        'Key': function(up, file) {
			            // 若想在前端对每个文件的key进行个性化处理，可以配置该函数
			            // 该配置必须要在unique_names: false，save_key: false时才生效

			            var key = "";
			            // do something with key here
			            return key
			        }
			    }
		}
	var upload = Qiniu.uploader(option1);
	
	var Qiniu2 = new QiniuJsSDK();
	var upload =  Qiniu2.uploader(option2);
	
	
	var sumBodyImageName = function(){
		var bodyImgNames = new Array();
		$(".each_img_fen").each(function(){
			var imageUrl = $(this).find("img").attr("src");
			var imagePaths  = $(this).find("img").attr("src").split("/");
			var imageName = imagePaths[imagePaths.length-1]
			bodyImgNames.push(imageName);
		});
		return bodyImgNames;
	} 
	
	
	$(".addcase_body_right").on("click",".delete_body_img",function(){
		$(this).parent().parent().remove();
		bodyImgNames = sumBodyImageName();
	});
	
	
	//单选按钮获取内容
	var input_case_check = "";
	$(".case_class_check").change(function(){
		input_case_check = $(this).val();
	});
	//提交按钮
	$(".addcase_sub_button").click(function(){
		var input_case_name = $(".input_case_name").val();
		var input_case_describe = $(".input_case_describe").val();
		var exp_space = /(^\s+)|(\s+$)/;
//		alert(exp_space.test(input_case_name));
		if(input_case_name == "" || input_case_name.lenght == 0 || exp_space.test(input_case_name)){
			alert("项目名称必须输入并且输入内容不能以空格开头，空格结尾");
		}else if(input_case_check == ""){
			alert("请选择一个项目分类");
		}else if(headImgName == null){
			alert("必须上传项目首图");
		}else if(bodyImgNames == null || bodyImgNames.length == 0){
			alert("请上传项目分图")
		}else{
			var imgNames = "";
			for(var i=0; i < bodyImgNames.length; i++){
				imgNames += bodyImgNames[i];
				imgNames += ";";
			}
			alert("正在添加，添加的ajax为: \n addcase?caseName="+input_case_name+"&caseDescribe="+input_case_describe+"&labelId="+input_case_check+"&imageHeadName="+headImgName+"&imageBodyNames="+imgNames)
			$.post("addcase",{
				caseName:Base64.encode(input_case_name),
				caseDescribe:Base64.encode(input_case_describe),
				labelId:input_case_check,
				imageHeadName:headImgName,
				imageBodyNames:imgNames
			}, function(data){
				if(data >= 1){
					alert("添加成功");
					window.location.href="backeditcase";
				}else if(data == -2){
					window.location.href="sessionout";
				}else if(data == 0){
					alert("添加失败");
				}
			});
		}
//		alert(headImgName+"\n"+bodyImgNames+"\n"+"---"+input_case_name+"---"+"\n"+input_case_describe+"\n"+input_case_check);
	});
});
