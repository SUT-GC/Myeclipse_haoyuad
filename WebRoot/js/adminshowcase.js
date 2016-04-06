/**
 * 更新case是否显示
 */
$(document).ready(function(){
	$(".checkisshow").change(function(){
		var check = $(this);
		var show = 0;
		var labelid = $(this).parent().parent().parent().find(".labelid").text();
		if(check.prop("checked")){
			show = 1;
		}else{
			show = 0;
		}
		$.post("caseshowcheck?id="+labelid+"&show="+show, function(data){
			if(data == -1){
				alert("对不起，首页展示不能超过三个分类");
				check.prop("checked",false);
			}else if(data == 1){
				alert("操作成功");
			}else if(data == 0){
				alert("操作失败，请联系开发者");
			}else if(data == -4){
				location.href="sessionout";
			}else{
				alert(data);
			}
		})
	});
});