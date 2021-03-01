<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX PAGE</title>
</head>
<body>
	<a href="test?data1=100&data2=200">GET Request TEST</a>
	<hr/>
	<a href="test?dupData=username&dupData=username2">GET USERNAME</a>
	<hr/>
	<form action="postResult" method="post">
		username : <input type="text" name="userName"><br/>
		userid	 : <input type="text" name="userId"><br/>
		hobby    : <input type="checkbox" name="hobby" value="sports">스포츠
				   <input type="checkbox" namae="hobby" value="game">게임<br/>
		<button type="submit">SUBMIT</button>		
	</form> 
	<hr/>
	<a href="webReqTest?data1=100&data2=200">GET Reqeust TEST - WebParameter</a>
	<hr/>
	<a href="board/sports/football">FOOTBALL BOARD</a>
	<hr/>
	<a href="football?post=1&user=id">POST REQUEST</a>
	<hr/>
</body>
</html>