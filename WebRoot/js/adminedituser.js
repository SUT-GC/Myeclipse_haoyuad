$(document).ready(function(){
	$(".showuser").show();
	$(".editoneuser").hide()

	$(".button_editoneuser").click(function(){
		$(".showuser").hide();
		$(".editoneuser").show()
	});
	$(".button_closeedituser").click(function(){
		$(".showuser").show();
		$(".editoneuser").hide()
	});

	$(".rollback").click(function(){
		$(".showuser").show();
		$(".editoneuser").hide()
	});


});