 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Chat anonyme</title>
	</head>
	<body>
	
		<pre>Hello !</pre>

		<p>
			<%= request.getAttribute("content") %>
		</p>
		
		<form name= "chatForm" action= "chat" method="post">
			<input type="text" name="ligne" value=""/>
			<input type="submit" name="action" value="submit"/>
			<input type="submit" name="action" value="refresh" />
		</form>
	</body>
</html>
