<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Market Application - BackEnd</title>
	</head>
	<body>
		<form action="j_security_check" method="post">
			<label>Usu�rio</label><input type="text" id="j_username" name="j_username" />
			<label>Senha</label><input type="password" id="j_password" name="j_password" />
			<input type="submit" value="Log in" />
		</form>
		<br />
		<p>Erro: <strong>${params['erro']}</strong></p>
	</body>
</html>