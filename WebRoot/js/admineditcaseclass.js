$(document).ready(function(){
	$(".editoneclass").hide();
	$(".showallclass").show();

	$(".button_editcaseclassno").click(function(){
		$(".editoneclass").hide();
		$(".showallclass").show();
	});

	$(".rollback").click(function(){
		$(".editoneclass").hide();
		$(".showallclass").show();
	});
	$(".button_editclass").click(function(){
		$(".editoneclass").show();
		$(".showallclass").hide();
	});

});