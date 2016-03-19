$(document).ready(function(){
	$(".input_file").change(function(){
		var input_imgs = document.getElementById("input_files");
		var imgs = input_imgs.files;
		var imgnames = "<br/>";
		$(this).parent().find(".show_imgnames").remove();
		for (var i = 0; i < imgs.length; i++){
			imgnames += imgs[i].name;
			imgnames += ";<br/> "
		}
		$(this).parent().prepend('<div class="show_imgnames" style="font-size:18px; margin-bottom:20px"> 图片名依次为：'+imgnames+'</div>');
	});
});