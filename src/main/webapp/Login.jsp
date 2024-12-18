<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Nhập</title>
    <!-- Bootstrap CSS -->
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
	<jsp:include page="layout/header.jsp"></jsp:include>
    <div class="container">
        <div class="row justify-content-center align-items-center vh-100">
            <div class="col-md-6 col-lg-4">
                <div class="card p-4">
                    <h3 class="text-center mb-4">Đăng Nhập</h3>
                    <div style="color: red;"><%=error %></div>
                    <form action="LoginController" method="get">
                        <div class="mb-3">
                            <label for="username" class="form-label">Tên đăng nhập:</label>
                            <input type="text" class="form-control" id="username" name="username" placeholder="Nhập tên đăng nhập" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Mật khẩu:</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Nhập mật khẩu" required>
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Đăng Nhập</button>
                    </form>
                    <p class="text-center mt-3">
                        Chưa có tài khoản? <a href="Register.jsp">Đăng ký ngay</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
	<jsp:include page="layout/footer.jsp"></jsp:include>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
