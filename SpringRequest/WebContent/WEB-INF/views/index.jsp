<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<head>
<meta charset="UTF-8">
<title>INDEX PAGE</title>
</head>
<body>
	<h2>index page</h2>
	<button id="request">request data</button>
	<p id="data"></p>
</body>
<script>
	$(function() {
		var button = document.getElementById('request');
		$.ajax({
			url : "getString",
			type : "GET",
			success : function(data) {
				alert('123');
				$('#data').text(data);
			},
			error : function() {
				alert("simpleWithObject err");
			}
		});
	});
</script>
</html>
