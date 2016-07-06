$(document).ready(function(){
	$(".show_casetabls").show();
	$(".edit_caseinfor_div").hide();
	$(".delimg_all").hide();
	$(".upload_img_all").hide();

	$(".edit_caseinfor").click(function(){
		$(".show_casetabls").hide();
		$(".delimg_all").hide();
		$(".edit_caseinfor_div").show();
		$(".upload_img_all").hide();
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
});