/**
 * 登陆后台进行验证的js
 */
$(document).ready(function(){

	$(".button_submit").click(function(){
		$(".result").text("登陆中.......");
		var useraccount = $(".useracount").val();
		var userpass  = $(".userpass").val();
		var checkaccount = /[^0-9]/;
		/*
		 * 0:服务器异常
		 * 1:登陆成功，超级管理员
		 * 2:密码错误
		 * 3:账号不存在
		 * 4:账号为空
		 * 5:密码为空
		 * 6:账号必须全是数字
		 * 7:查询结果不为一，请联系管理员
		 * 8:普通管理员管理员
		 */
		var errmessage = ["服务器异常","登陆成功","密码错误","账号不存在","账号不能为空","密码不能为空","账号必须全是数字","查询结果不为一，请联系管理员" ];
		var result = 0;
		if(userpass == ""){
			result = 5;
		}else if(useraccount == ""){
			result = 4;
		}else if(checkaccount.exec(useraccount) != null){
			result = 6;
		}else{
			result = 1;
		}
		if(result == 1){
			$.post("checkuser?useraccount="+useraccount+"&userpass="+userpass, function(data){
				if(data == 1){
					window.location.href="adminindex"
				}else if(data == 8){
					alert("普通管理员");
				}else{
					$(".result").text(errmessage[data]);
				}
				
			});
		}else{
			$(".result").text(errmessage[result]);
		}

	});
	
});