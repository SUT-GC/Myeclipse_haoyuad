$(document).ready(function(){
	$(".show_casetabls").show();
	$(".edit_caseinfor_div").hide();
	$(".delimg_all").hide();
	$(".upload_img_all").hide();
	

	$(".edit_caseinfor").click(function(){
		$(".show_casetabls").hide();
		$(".delimg_all").hide();
		$(".upload_img_all").hide();
		$(".edit_caseinfor_div").show();
		
		var parentTr = $(this).parent().parent();
		var case_describe = parentTr.find(".case_describe").text();
		var case_name = parentTr.find(".case_name").text();
		$(".new_case_id").text(parentTr.find(".case_id").text());
		$(".new_case_name").val(case_name);
		$(".new_case_describe").val(case_describe);
		
	});
	$(".rollback_to_editcase").click(function(){
		$(".show_casetabls").show();
		$(".edit_caseinfor_div").hide();
		$(".delimg_all").hide();
		$(".upload_img_all").hide();
	});
	
	$(".del_img").click(function(){
		$(".show_casetabls").hide();
		$(".edit_caseinfor_div").hide();
		$(".delimg_all").show();
		$(".upload_img_all").hide();
		
		
		var $parentTr = $(this).parent().parent();
		$(".delimg_case_id").text($parentTr.find(".case_id").text());
		var case_images =$parentTr.find(".case_images").text();
		var image_urls = case_images.split(";");
//		alert(image_urls.length)
		$(".showimg_all").empty();
		for(var i = 0; i < image_urls.length-1; i++){
			$(".showimg_all").append('<div class="col-xs-6 col-md-3 each_img "><div class="thumbnail"><button class="glyphicon glyphicon-remove remove_a_image" aria-hidden="true"></button><img src="http://7xrh7n.com1.z0.glb.clouddn.com/'+image_urls[i]+'" alt="..."></div></div>');
		}
	});
	
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
	
	var headImgName;
	var bodyImgNames;
	$(".upload_img").click(function(){
		$(".show_casetabls").hide();
		$(".edit_caseinfor_div").hide();
		$(".delimg_all").hide();
		$(".upload_img_all").show();
		
		var parentTr = $(this).parent().parent();
		var caseid = parentTr.find(".case_id").text();
		$(".old_case_id").text(caseid);
		
		var spaceName = "http://7xrh7n.com1.z0.glb.clouddn.com";
		var imageSrc = spaceName+"/";
	
		var newBodyImgDiv = '<div class="each_img_fen" style="width:170px; height:190px; padding:5px;float:left; margin:10px;"><img style="width:170px; height:170px;"/><div class="each_img_fen_del" style=" height:15px;font-size:15px; " ><a class="delete_body_img">删除</a></div></div>';
		$(".each_head_uploaddiv").hide();
		
		
		$(".editcase_body_img").on("click",".delete_body_img",function(){
			$(this).parent().parent().remove();
			bodyImgNames = sumBodyImageName();
		});
		
		//七牛上传start
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
				        		$(".each_head_uploaddiv").text("正在上传....");
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
//						              var sourceLink = domain + res.key; 获取上传成功后的文件的Url
//						              alert(sourceLink);
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
				            });
				        },
				        'BeforeUpload': function(up, file) {
				        		$(".start_upload").text("正在准备上传......");
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
//						              var sourceLink = domain + res.key; 获取上传成功后的文件的Url
//						              alert(sourceLink);
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
			//七牛上传end
			
		
	});
	
	$("#editcaseimg_sub_button").click(function(){
		var imgNames = "";
		var headImg = "";
		if(headImgName == null || headImgName == ""){
			headImg = "0";
		}else{
			headImg = headImgName;
		}
		if(bodyImgNames == null || bodyImgNames.length == 0 || bodyImgNames == ""){
			imgNames = "0";
		}else{
			for(var i=0; i < bodyImgNames.length; i++){
				imgNames += bodyImgNames[i];
				imgNames += ";";
			}
		}
		
		var caseid = $(".old_case_id").text();
		alert(caseid+"\n"+headImg+"\n"+imgNames);
	
		$.post("uploadcaseimg?caseid="+caseid+"&HeadImg="+headImg+"&BodyImg="+imgNames, function(data){
			if(data == 1){
				alert("添加成功");
				window.location.href="backeditcase";
			}else if(data == -4){
				window.location.href="sessionout";
			}else{
				alert("添加失败！请重新添加！");
			}
		})
	});
	$(".input_file").change(function(){
		var input_imgs = document.getElementById("input_files");
		var imgs = input_imgs.files;
		var imgnames = "<br/>";
		$(this).parent().find(".show_imgnames").remove();
		for (var i = 0; i < imgs.length; i++){
			imgnames += imgs[i].name;
			imgnames += ";<br/> "
		}
		$(this).parent().prepend('<div class="show_imgnames" style="font-size:18px; margin-bottom:20px"> 图片名依次为：'+imgnames+'</div>');
	});

	$(".del_case").click(function(){
		if(!confirm("您确定要删除该项目么？")){
			return;
		}
		var parentTr = $(this).parent().parent();
		var caseid = parentTr.find(".case_id").text();
		if(caseid >= 0 && caseid<= 10000000){
			$.post("deletecase?caseid="+caseid, function(data){
				if(data == 1){
					alert("删除成功");
					parentTr.hide();
				}else if(data == -4){
					window.location.href="sessionout";
				}else{
					alert("出现异常");
				}
			});
		}else{
			alert("caseid不是数字或者超出范围");
		}
	});
	
	//设置一个没有选择的单选值
	var new_case_label_id = -1;
	$(".case_class_check").change(function(){
		new_case_label_id = $(this).val();
	});
	$(".editcase_sub_button").click(function(){
		if(!confirm("您确认要进行修改么?")){
			return;
		}
		var new_case_name = $(".new_case_name").val();
		var new_case_describe = $(".new_case_describe").val();
		var caseId = $(".new_case_id").text();
		var exp_space = /(^\s+)|(\s+$)/;
		if(new_case_name == "" || new_case_name.lenght == 0 || exp_space.test(new_case_name)){
			alert("项目名称必须输入并且输入内容不能以空格开头，空格结尾");
		}else{
			$.post("updatecaseinfo?caseId="+caseId+"&caseName="+new_case_name+"&caseDescribe="+new_case_describe+"&labelId="+new_case_label_id, function(data){
				if(data == 1){
					alert("修改成功");
					window.location.href="backeditcase";
				}else if(data == -4){
					window.location.href="sessionout";
				}else{
					alert("修改失败");
				}
			});
		}
	});
	$(".showimg_all").on("click",".remove_a_image",function(){
		if(!confirm("您确定要删除该图片么？")){
			return;
		}
		var $showimg_all = $(this).parents(".showimg_all");
		$(this).parents(".each_img").remove();
		var $new_allimage_urls = $showimg_all.find("img");
		var new_imageNames = "";
		for(var i = 0; i <$new_allimage_urls.length; i++ ){
			new_imageNames += $new_allimage_urls[i].src.split("7xrh7n.com1.z0.glb.clouddn.com/")[1];
			new_imageNames +=";";
		}
		var case_id = $(".delimg_case_id").text();
		$.post("delcasebodyimg?caseid="+case_id+"&imageNames="+new_imageNames, function(data){
			if(data == 1){
				alert("删除成功");
			}else if(data == -4){
				window.location.href="sessionout";
			}else{
				alert("删除失败");
			}
		})
	});
	
	
});