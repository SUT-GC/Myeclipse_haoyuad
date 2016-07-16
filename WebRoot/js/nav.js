$(document).ready(function(){
	
	windowwight = $(window).width();
	$(".wangzhan_headlogo").css("width",windowwight);

	//导航栏pading-left的宽度
	winwidth = $(window).width()/2
	
	if(winwidth - 420 < 0){
		winwidth = 0;
	}else{
		winwidth = winwidth - 420;
	}
	$('.nav').css('margin-left',winwidth);

	$(".nav").find("a").click(function(){
		name = this.text;
		if(name=="网站首页"){
			window.location.href="index";
		}
		if(name=="工作流程"){
			window.location.href="workflow";
		}
		if(name=="公司简介"){
			window.location.href="companyinfor";
		}
		if(name=="经典案例"){
			window.location.href="case";
		}
		if(name=="主创团队"){
			window.location.href="team";
		}
		if(name=="招兵买马"){
			window.location.href="recruit";
		}
		if(name=="联系我们"){
			window.location.href="tellme";
		}
	});

});