$(document).ready(function(){
	windowwidth = $(window).width();

	case_each_width = windowwidth*0.8*0.77*0.3;
	case_each_height = case_each_width + 70;

	$(".each_case").css("width",case_each_width);
	$(".each_case").css("height",case_each_height);	

	$(".case_img").find("img").css("width",case_each_width-2);
	$(".case_img").find("img").css("height",case_each_width);

	// $(".case_infor").css("height",70);		
	$(".show_eachcase_all").css("width",windowwidth*0.6);

	// alert(case_eachimg_width)
	$(".show_eachcase_all").hide();


	$(document).on('click','.each_case',function(){
		
		var id=$(this).find(".case_id").text();
		if(id==""||id.length==0||isNaN(id)==true){
			alert("项目id出错，请联系开发人员！");
			return;
		}
		$.post("selectcase",{
			caseid:id
		},function(data){
			var acase = eval('('+data+')');
			var labelname = $(".active").text();
			$(".show_eachcase_all .show_eachcase_nav span:first a").text(labelname);
			$(".show_eachcase_all .show_eachcase_nav span:last a").text(acase.name);
			$(".show_eachcase_all .show_eachcase_info pre").text(acase.describe);
			var caseimgs = acase.caseimgs.split(";");
			var qiniuURL = "http://7xrh7n.com1.z0.glb.clouddn.com/";
			$(".container .gallery").empty();
			for(var i = 0; i < caseimgs.length-1; i++){
				$(".container .gallery").append("<li><a href="+qiniuURL+caseimgs[i]+"><img src="+qiniuURL+caseimgs[i]+" /></a></li>")
			}
		}
		);
		$(".show_eachcase_all").show();
		$(".case_show").hide();
	});
	
	$(".eachcase_nav_first").click(function(){
		$(".show_eachcase_all").hide();
		$(".case_show").show();
	});
	
	$(".caselabel").click(function(){
		$(".show_eachcase_all").hide();
		$(".case_show").show();
		var labelid = $(this).next(".label_id").text();
		$(".active").removeClass("active");
		$(this).addClass("active");
		
		$.post("selectcases",{
			'labelid':labelid
		},function(data){
			var cases = eval('('+data+')');
			$(".case_show ").empty();
			for(var i = 0; i < cases.length-1; i++){
				var new_case = '<div class="each_case" style="width:'+case_each_width+';height:'+case_each_height+';" ><a href="#"><div class="case_id" style="display:none">'+cases[i].id+'</div><div class="case_img"><img style="width:'+(case_each_width-2)+';height:'+case_each_width+';" src="http://7xrh7n.com1.z0.glb.clouddn.com/'+cases[i].headimg+'"/></div><div class="case_infor">'+cases[i].name+'</div></a></div>';
				$(".case_show ").append(new_case);
			}
		})
	});
});