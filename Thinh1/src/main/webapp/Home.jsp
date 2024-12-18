<%@page import="sachModal.Sach"%>
<%@page import="theloaiModal.Loai"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Website Bán Sách</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
     <style>
		 
		.card img {
		  max-width: 100%;
		  height: 250px; /* Đặt chiều cao cố định */
		  object-fit: cover; /* Giữ tỷ lệ ảnh, cắt bớt phần thừa */
		}
		.card p, h5 {
		  max-width: 100%;
		  height: 50px; /* Đặt chiều cao cố định */
		  
		}
        .navbar {
            background-color: #0056b3; /* Màu nền giống trang chủ */
            color: white;
        }
        footer {
            background-color: #0056b3; /* Màu nền giống trang chủ */
            color: white;
        }
    </style>
</head>
<body>
    <!-- Thanh Navigation -->
    <jsp:include page="layout/header.jsp"></jsp:include>

    <!-- Body -->
    <div class="container mt-4">
        <div class="row">
            <!-- Cột trái: Danh mục sách -->
            <div class="col-md-3">
                <h4>Danh mục sách</h4>
                <ul class="list-group">
                <% ArrayList<Loai> lst = (ArrayList<Loai>)request.getAttribute("lstTheLoai");
                for(Loai item : lst){
        		%>
                    <li class="list-group-item">
                        <a href ="HomeController?maTheLoai=<%=item.getMaLoai() %>">
						<%=item.getTenLoai() %>
					</a>
                    </li>
                 <%} %>
                </ul>
            </div>

            <!-- Cột phải: Sản phẩm -->
            <div class="col-md-9">
                <h4>Tất cả sách</h4>
                <!-- Form tìm kiếm -->
                <form class="mb-4" method="GET" action="HomeController">
                    <div class="input-group">
                        <input type="text" class="form-control" name="key" placeholder="Nhập tên sách cần tìm..." aria-label="Tìm kiếm tên sách">
                        <button class="btn btn-primary" type="submit">Tìm kiếm</button>
                    </div>
                </form>
                <%
					request.setCharacterEncoding("utf-8");
					response.setCharacterEncoding("utf-8");
					ArrayList<Sach> lstSach = (ArrayList<Sach>)request.getAttribute("lstSach");
					int n = lstSach.size();
					if(n>0){
						for(int i = 0; i<n; i++){
							Sach s = lstSach.get(i);
					%>
                <!-- Danh sách sản phẩm -->
                <div class="row">
                    <!-- Sản phẩm 1 -->
                    <div class="col-md-4 mb-4">
                        <div class="card">
                            <img src="<%=s.getAnh() %>" class="card-img-top" alt="Sách 1">
                            <div class="card-body">
                                <h5 class="card-title"><%=s.getTenSach() %></h5>
                                <p class="card-text">Tác giả: <%=s.getTacGia() %></p>
                                <p class="card-text">Giá: <%=s.getGiaBan() %>đ</p>
                                <a href="AddToCartController?tensach=<%=s.getTenSach() %>+&masach=<%=s.getMaSach() %>+&giaban=<%=s.getGiaBan() %>" class="btn btn-primary">Thêm vào giỏ</a>
                            </div>
                        </div>
                    </div>
                    <%i++;
				 	if(i<n){
					 	s=lstSach.get(i);%>
					 	<div class="col-md-4 mb-4">
                        <div class="card">
                            <img src="<%=s.getAnh() %>" class="card-img-top" alt="Sách 1">
                            <div class="card-body">
                                <h5 class="card-title"><%=s.getTenSach() %></h5>
                                <p class="card-text">Tác giả: <%=s.getTacGia() %></p>
                                <p class="card-text">Giá: <%=s.getGiaBan() %>đ</p>
                                <a href="AddToCartController?tensach=<%=s.getTenSach() %>+&masach=<%=s.getMaSach() %>+&giaban=<%= s.getGiaBan() %>" class="btn btn-primary">Thêm vào giỏ</a>
                            </div>
                        </div>
                    </div>
                    <%} %>
                    <%i++;
				 	if(i<n){
				 		s=lstSach.get(i);%>
                    <div class="col-md-4 mb-4">
                        <div class="card">
                            <img src="<%=s.getAnh() %>" class="card-img-top" alt="Sách 1">
                            <div class="card-body">
                                <h5 class="card-title"><%=s.getTenSach() %></h5>
                                <p class="card-text">Tác giả: <%=s.getTacGia() %></p>
                                <p class="card-text">Giá: <%=s.getGiaBan() %>đ</p>
                                <a href="AddToCartController?tensach=<%=s.getTenSach() %>+&masach=<%=s.getMaSach() %>+&giaban=<%=s.getGiaBan() %>" class="btn btn-primary">Thêm vào giỏ</a>
                            </div>
                        </div>
                    </div>
                    <%} %>
                </div>
                <%}
				}else{ %>
					<p class="card-text text-center">Không có dữ liệu</p>
				<%} %>
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
