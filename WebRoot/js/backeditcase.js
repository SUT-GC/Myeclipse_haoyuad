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
	});
	$(".upload_img").click(function(){
		$(".show_casetabls").hide();
		$(".edit_caseinfor_div").hide();
		$(".delimg_all").hide();
		$(".upload_img_all").show();
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
});