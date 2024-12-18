<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
		<h3>Vd CAPTCHA </h3>
	<img src="simpleCaptcha.jpg" />
	<form action="TestServlet" method="post">
	<input type="text" name="answer" /><br>
	<input type="submit" value="Submit"></form>
	</center>

</body>
</html>