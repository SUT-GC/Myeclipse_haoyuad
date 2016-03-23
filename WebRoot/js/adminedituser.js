$(document).ready(function(){
	$(".showuser").show();
	$(".editoneuser").hide()

	$(".button_editoneuser").click(function(){
		var useraccount = $(this).parent().parent().find(".useraccount").text();	
		$(".input_newpass").val("");
		$(".tinput_newpass").val("");
		$(".result").text("");
		$(".showuser").hide();
		$(".editoneuser").show()
		$(".edituseracc").text(useraccount);
	});
	
	$(".button_closeedituser").click(function(){
		$(".showuser").show();
		$(".editoneuser").hide()
	});

	$(".rollback").click(function(){
		$(".showuser").show();
		$(".editoneuser").hide()
	});

	$(".button_submitedituser").click(function(){
		var useraccount = $(".edituseracc").text();
		var newpass = $(".input_newpass").val();
		var tnewpass = $(".tinput_newpass").val();
		if(newpass == ""){
			alert("对不起，新密码不能为空");
			$(".newpass").focus();
		}else if(newpass != tnewpass){
			alert("对不起，两次输入密码不一致");
			$(".tnewpass").focus();
		}else if(newpass != "" && tnewpass != "" && newpass == tnewpass){
			var issubmit = confirm("您确定要提交修改么？");
			if(issubmit == true){
				$(".button_submitedituser").attr("disabled","true");
				$(".button_closeedituser").attr("disabled","true");
				$(".result").text("正在修改中，请勿进行别的操作......");
				$.post("updateuserpass?useraccount="+useraccount+"&newuserpass="+newpass,function(data){
					$(".result").text("");
					if(data == -4){
						location.href="sessionout";
					}else if(data == -3){
						alert("对不起，您输入的密码不能为空");
					}else if(data == -1){
						alert("对不起，没有你要修改的账号!");
					}else if(data == -2){
						$(".result").text("查询结果不为一，请联系管理员");
					}else if(data == 1){
						$(".result").text("恭喜您，修改成功 !!!");
						alert("恭喜您，修改成功 !!!")
						$(".showuser").show();
						$(".editoneuser").hide()
						$(".button_submitedituser").removeAttr("disabled");
						$(".button_closeedituser").removeAttr("disabled");
					}else if(data == 0){
						alert("数据库操作异常");
					}else{
						$(".result").text(data);
					}
				})
			}
		}else{
			alert("输入不合法");
		}
	});

	$(".removeuser").click(function(){
		var useraccount = $(this).parent().parent().find(".useraccount").text();	
		var issubmit = confirm("您确定要删除这个用户么?");
		var pparent = $(this).parent().parent();
		if(issubmit == true){
			$.post("deleteuser?useraccount="+useraccount, function(data){
				if(data == 1){
					alert("删除成功");
					pparent.hide();
				}else if(data == -1){
					alert("操作失败，数据库没有此人");
					pparent.hide();
				}else if(data == -2){
					alert("对不起，查询结果不为一，请联系管理员");
				}else if(data == 0){
					alert("对不起，数据库操作异常，请联系管理员");
				}else if(data == -3){
					alert("操作失败，用户账号为空");
					pparent.hide();
				}else if(data == -4){
					location.href="sessionout";
				}else{
					alert(data);
				}
			})
		}
	});
});