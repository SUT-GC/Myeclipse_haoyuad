$(document).ready(function(){

	//轮播速度
	$('.carousel').carousel({
	  interval: 4000
	})

	winwidthall = $(window).width()-80;
	workwidth= winwidthall/5;
	
	$(".works_body li").css('width',workwidth);
	$(".works_body li").css('height',workwidth+40);
	$(".works_img").css('width',workwidth-10);
	$(".works_img").css('height',workwidth-10);
	$(".works_img_dis").css('width',workwidth-20);
	$(".works_pre").css('height',workwidth);
	$(".works_pre").find("span").css("padding-top",workwidth/2-20)


});