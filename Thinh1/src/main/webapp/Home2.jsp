<%@page import="sachModal.Sach"%>
<%@page import="theloaiModal.Loai"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Website Bán Sách</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Tùy chỉnh chung cho tất cả phần tử */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f7fc;
            color: #333;
        }

        /* Navbar đẹp */
        .navbar {
            background-color: #0056b3;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .navbar a {
            color: white;
            font-weight: bold;
            text-decoration: none;
        }

        .navbar a:hover {
            color: #d4e0ff;
        }

        /* Tùy chỉnh cho card sản phẩm */
        .card {
            border: none;
            border-radius: 10px;
            overflow: hidden;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);
        }

        .card img {
            width: 100%;
            height: 250px;
            object-fit: cover;
            transition: transform 0.3s ease;
        }

        .card-body {
            padding: 20px;
            background-color: #fff;
            border-radius: 0 0 10px 10px;
        }

        .card-body h5 {
            font-size: 1.2rem;
            font-weight: bold;
            color: #333;
        }

        .card-body p {
            font-size: 1rem;
            color: #777;
            margin: 10px 0;
        }

        /* Nút "Thêm vào giỏ" */
        .btn-primary {
            background-color: #0056b3;
            border: none;
            padding: 10px 20px;
            font-weight: 600;
            text-transform: uppercase;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .btn-primary:hover {
            background-color: #00408a;
        }

        /* Phân trang đẹp hơn */
        .pagination {
            justify-content: center;
            margin-top: 30px;
        }

        .pagination .page-item.active .page-link {
            background-color: #0056b3;
            border-color: #0056b3;
            font-weight: bold;
        }

        .pagination .page-item .page-link {
            color: #0056b3;
            font-weight: 600;
            text-transform: uppercase;
        }

        .pagination .page-item:hover .page-link {
            background-color: #f1f1f1;
            border-color: #ddd;
        }

        /* Footer */
        footer {
            background-color: #0056b3;
            color: white;
            padding: 1.5rem;
            text-align: center;
            font-size: 1rem;
            box-shadow: 0 -4px 10px rgba(0, 0, 0, 0.1);
        }

        /* Tùy chỉnh cho sidebar */
        .list-group-item {
            background-color: #f9f9f9;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 1rem;
            color: #333;
            transition: background-color 0.3s ease;
        }

        .list-group-item:hover {
            background-color: #e0e0e0;
        }

        .list-group-item a {
            color: #0056b3;
            text-decoration: none;
            font-weight: 600;
        }

        .list-group-item a:hover {
            color: #003366;
        }

        /* Các hiệu ứng hover cho input và button tìm kiếm */
        .input-group input {
            border-radius: 30px;
            border: 1px solid #ccc;
            transition: border 0.3s;
        }

        .input-group input:focus {
            border-color: #0056b3;
            outline: none;
        }

        .input-group button {
            border-radius: 30px;
            background-color: #0056b3;
            border: none;
            color: white;
        }

        .input-group button:hover {
            background-color: #00408a;
        }

        /* Khoảng cách các phần tử */
        .container {
            margin-top: 50px;
        }

        .list-group {
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
    <!-- Thanh Navigation -->
    <jsp:include page="layout/header.jsp"></jsp:include>

    <!-- Body -->
    <div class="container">
        <div class="row">
            <!-- Cột trái: Danh mục sách -->
            <div class="col-md-3">
                <h4 class="mb-4">Danh mục sách</h4>
                <ul class="list-group">
                    <c:forEach var="item" items="${lstTheLoai}">
                        <li class="list-group-item">
                            <a href="HomeController?maTheLoai=${item.getMaLoai()}">${item.getTenLoai()}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <!-- Cột phải: Sản phẩm -->
            <div class="col-md-9">
                <h4 class="mb-4">Tất cả sách</h4>

                <!-- Form tìm kiếm -->
                <form class="mb-4" method="GET" action="HomeController">
                    <div class="input-group">
                        <input type="text" class="form-control" name="key" placeholder="Nhập tên sách cần tìm..." aria-label="Tìm kiếm tên sách">
                        <button class="btn btn-primary" type="submit">Tìm kiếm</button>
                    </div>
                </form>

                <!-- Danh sách sản phẩm -->
                <div class="row">
                    <c:if test="${lstSach.size() > 0}">
                        <c:forEach var="s" items="${lstSach}">
                            <div class="col-md-4 mb-4">
                                <div class="card shadow-sm border-light">
                                    <img src="${s.getAnh()}" class="card-img-top" alt="Sách 1">
                                    <div class="card-body">
                                        <h5 class="card-title">${s.getTenSach()}</h5>
                                        <p class="card-text">Tác giả: ${s.getTacGia()}</p>
                                        <p class="card-text">Giá: ${s.getGiaBan()}đ</p>
                                        <a href="AddToCartController?tensach=${s.getTenSach()}&masach=${s.getMaSach()}&giaban=${s.getGiaBan()}" class="btn btn-primary">Thêm vào giỏ</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>

                    <c:if test="${lstSach.size() == 0}">
                        <p class="text-center w-100">Không có dữ liệu</p>
                    </c:if>
                </div>

                <!-- Phân trang -->
                <nav aria-label="Page navigation example">
				  <ul class="pagination justify-content-center">
				  <%
				  	int maxPage = (int)request.getAttribute("Page"); 
				    String maTheLoai = ((String)request.getParameter("maTheLoai")==null)?"":(String)request.getParameter("maTheLoai");
				    String tenSach = ((String)request.getParameter("key")==null)?"":(String)request.getParameter("key");
					int index = (int)request.getAttribute("index");

					for(int i = 1; i<= maxPage; i++){
						if(index==i){
				%>
							<li class="page-item active"><a class="page-link" href="#"><%=i%></a></li>
							<%}else{ %>
				 			<li class="page-item" ><a class="page-link" href="HomeController?index=<%=i%>&maTheLoai=<%=maTheLoai%>&key=<%=tenSach%>"><%=i %></a></li>
				<%				}	
					} 
				%>
				  </ul>
				</nav>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <jsp:include page="layout/footer.jsp"></jsp:include>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
