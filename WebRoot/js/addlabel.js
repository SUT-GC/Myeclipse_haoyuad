/**
 * 添加label
 */
$(document).ready(function(){
	var checkhan = /[^\u4e00-\u9fa5]/;
	$(".button_addcaseclass").click(function(){
		var labelname = $(".input_labelname").val();
		if(checkhan.exec(labelname) != null){
			alert("必须全是中文");
			$(".input_labelname").focus();
		}else if(labelname==""){
			alert("不能输入为空");
		}else{
			$.post("addlabel?labelname="+labelname, function(data){
				if(data == -2){
					location.href="sessionout";
				}else if(data == -1){
					alert("数据库操作失败，请联系管理员");
				}else if(data == -3){
					alert("输入内容中不能有空格");
				}else if(data == -4){
					alert("您输入的分类名字已经存在");
				}else if(data >= 0){
					alert("添加成功");
				}else {
					alert(data);
				}
			});
		}
	});
});