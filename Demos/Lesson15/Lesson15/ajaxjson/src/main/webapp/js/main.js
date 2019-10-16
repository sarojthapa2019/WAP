$(document).ready(function() {
	$('#userName').keyup(function(event) {
		var name = $('#userName').val();
		$.get('GetUserServlet', {
			userName : name
		}, function(responseText) {
			$('#ajaxGetUserServletResponse').text(responseText);
		});
	});
});