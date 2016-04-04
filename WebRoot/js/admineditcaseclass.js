$(document).ready(function(){
	$(".editoneclass").hide();
	$(".showallclass").show();

	$(".button_editcaseclassno").click(function(){
		$(".editoneclass").hide();
		$(".showallclass").show();
	});

	$(".rollback").click(function(){
		$(".editoneclass").hide();
		$(".showallclass").show();
	});
	$(".button_editclass").click(function(){
		$(".editoneclass").show();
		$(".showallclass").hide();
		
		var parent = $(this).parent().parent();
		var oldlabelname = parent.find(".labelname").text();
		var oldlabelid = parent.find(".labelid").text();
		
		$(".old_label_name").text(oldlabelname);
		$(".old_label_id").text(oldlabelid);
	});

	$(".button_editcaseclassok").click(function(){
		$(".result").text("");
		var oldlabelid = $(".old_label_id").text();
		var checkhan = /[^\u4e00-\u9fa5]/;
		var newlabelname=$(".new_label_name").val();
		if(checkhan.exec(newlabelname) != null){
			alert("必须全是中文");
			$(".input_labelname").focus();
		}else if(newlabelname==""){
			alert("不能输入为空");
		}else{
			$.post("updatelabel?oldlabelid="+oldlabelid+"&newlabelname="+newlabelname, function(data){
				$(".result").text("正在修改......");
				if(data == 1){
					alert("修改成功");
					location.href="admineditcaseclass";
				}else if(data == -4){
					location.href="sessionout";
				}else if(data == -3){
					$(".result").text("新的分类名称不能为空 ! ");
				}else if(data == -1){
					$(".result").text("没有找到该分类名称");
				}else{
					$(".result").text(data);
				}
			});
		}
	});
	
});