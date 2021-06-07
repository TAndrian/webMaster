 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Servlet</title>
	</head>
	<body>
		
		<!-- The data's form (the username) will be sent to the servlet chat2  -->
		<form action="chat2"  method="post">
			Username : <input type="text" name="user" />
			<input type="submit" name="action" value="submit" />
		</form>
	</body>
</html>
