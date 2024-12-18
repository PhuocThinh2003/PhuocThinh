<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .form-label {
            font-weight: bold;
        }
    </style>
</head>
<body>
<%
	String error = "";
	String er = (String)request.getAttribute("error");
	if(er != null){
		error = er;	
	}
	%>
	<div class="container">
        <div class="row justify-content-center align-items-center vh-100">
            <div class="col-md-6 col-lg-4">
                <div class="card p-4">
                    <h3 class="text-center mb-4">Đăng Nhập(Admin)</h3>
                    <div style="color: red;"><%=error %></div>
                    <form action="AdminLoginController" method="get">
                        <div class="mb-3">
                            <label for="username" class="form-label">Tên đăng nhập:</label>
                            <input type="text" class="form-control" id="username" name="username" placeholder="Nhập tên đăng nhập" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Mật khẩu:</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Nhập mật khẩu" required>
                        </div>
                        <%if(session.getAttribute("dem")!= null){
                        	int dem =(int)session.getAttribute("dem");
                        	if(dem >=3){
                        	%>
                        <img src="simpleCaptcha.jpg" />
                        <input type="text" name="answer" /><br>
                        <%} }%>
                        <button type="submit" class="btn btn-primary w-100">Đăng Nhập</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>