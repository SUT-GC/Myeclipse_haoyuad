/**
 * 超级管理员添加普通用户时对其进行的检查
 */
$(document).ready(function(){
	
	
	$(".button_submitadduser").click(function(){
		var newusername = $(".newusername").val();
		var newuseraccount = $(".newuseraccount").val();
		var newuserpass = $(".newuserpass").val();
		
		var checkhan = /[^\u4e00-\u9fa5]/;
		var checkacc = /[^0-9]/;
		var issubmit = false;
		if(checkhan.exec(newusername) != null){
			alert("用户名中不能出现非中文字符");
			$(".newusername").focus();
		}else if(newusername == ""){
			alert("用户名不能为空");
			$(".newusername").focus();
		}else if(checkacc.exec(newuseraccount) != null){
			alert("账号必须全是数字 且不能低于8位数")
			$(".newuseraccount").focus();
		}else if(newuseraccount < 1000000){
			alert("账号必须全是数字 且不能低于8位数")
			$(".newuseraccount").focus();
		}else if(newuserpass == ""){
			issubmit =  confirm("新用户密码没有填写，默认初始化为000000， 请问是否确认添加 ? ");
		}else{
			issubmit = true;
		}
		
		if(issubmit){
			$(".result").text("正在添加用户，请不要进行操作......");
			$.post("adduser?newusername="+newusername+"&newuseraccount="+newuseraccount+"&newuserpass="+newuserpass, function(data){
				if(data >= 1){
					alert("添加用户成功");
					$(".result").text("");
				}else 	if(data == -1){
					alert("添加用户失败，该用户账号已经存在");
					$(".result").text("");
				}else if(data == 0){
					alert("添加用户失败，服务器错误，请联系管理员");
					$(".result").text("");
				}else if(data == -2){
					location.href="sessionout";
				}else{
					$(".result").text(data);
				}
			})
		}
	});
	
});