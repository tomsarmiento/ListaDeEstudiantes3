$(document).ready(function() {
	$('.selectdorm').change(function() {
		var action = $(this).val();
		$(".form1").attr("action", "/dorms/" + action);
	})
	$('.selectclass').change(function() {
		var action = $(this).val();
		$('.form2').attr("action", "/classes/" + action);
	})
});