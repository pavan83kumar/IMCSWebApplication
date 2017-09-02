<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2  style="color:red;"> User with credentials doesn't exist</h2>
<form action = "/IMCSWebApp/login">
		<fieldset>
			<legend>IMCS GROUP</legend>
			<div style="text-align: center">
				<h2>Login here!</h2>
				Username: <input type="text" name="uname" required><br><br>
				 Password: <input type="password" name="pwd" required><br><br>
				 <input type="submit" value="submit">
			</div>
		</fieldset>
	</form>

</body>
</html>