/**
 * 登陆后台进行验证的js
 */
$(document).ready(function(){

	$(".button_submit").click(function(){
		var useraccount = $(".useracount").val();
		var userpass  = $(".userpass").val();
		alert(useraccount+","+userpass);
		$.post("checkuser?useraccount="+useraccount+"&userpass="+userpass, function(data){
			$(".result").text(data);
		});
	});
	
});