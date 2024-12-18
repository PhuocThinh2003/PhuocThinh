<%@page import="giohangModal.Hang"%>
<%@page import="giohangModal.GioHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ Hàng</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Đảm bảo body và html chiếm toàn bộ chiều cao */
        html, body {
            height: 100%;
            margin: 0;
            display: flex;
            flex-direction: column;
        }

        /* Nội dung chính chiếm toàn bộ không gian */
        .content {
            flex: 1;
        }

        /* Footer luôn ở cuối trang */
        footer {
            background-color: #0056b3; /* Màu nền giống trang chủ */
            color: white;
            text-align: center;
            padding: 10px 0;
        }

        .navbar {
            background-color: #0056b3; /* Màu nền giống trang chủ */
        }

        .btn-group {
            display: flex;
            gap: 10px;
        }
    </style>
</head>
<body>
    <!-- NavBar -->
    <jsp:include page="layout/header.jsp"></jsp:include>

    <!-- Content -->
    <div class="content container my-5">
        <h2 class="text-left mb-4">Giỏ Hàng</h2><hr>
        <div class="row">
            <!-- Bên trái: Danh sách sản phẩm -->
            <div class="col-lg-8">
                <form id="cartForm" action="EditCartController" method="get">
                    <table class="table table-bordered table-hover">
                        <thead class="table-warning">
                            <tr>
                            	<td></td>
                            	<td>Mã hàng</td>	
                                <th>Tên Sản Phẩm</th>
                                <th>Số Lượng</th>
                                <th></th>
                                <th>Giá</th>
                                <th>Thành Tiền</th>
                                <th>Hành Động</th>
                            </tr>
                        </thead>
                        <tbody id="cartTableBody">
                        <c:if test="${sessionScope.GioHang != null }">
                        	<c:forEach var="item" items="${sessionScope.GioHang.getDs() }">
                            <tr>
                                <td><input type="checkbox" name="ck" value="${item.getMaHang()}" class="productCheckbox" /></td>
                                <td>${item.getMaHang() }</td>
                                <td>${item.getTenHang()}</td>
                                <td>${item.getSoLuong()}</td>
                                <td>
                                	<input type="number" name="${item.getMaHang() }" value="0" style="width: 50px" class="form-control">
									<button type="submit" name="butsuasl" value="${item.getMaHang() }" class="btn btn-info">Edit</button>             
                                </td>
                                <td>${item.getGiaBan() }VNĐ</td>
                                <td>${item.getThanhTien() }VNĐ</td>
                                <td>
                                    <a type="button" href="EditCartController?msxoa=${ item.getMaHang()}" class="btn btn-danger btn-sm deleteProduct">Xóa</a>
                                </td>
                            </tr>
                            </c:forEach>
                            </c:if>
                 		<c:if test="${sessionScope.GioHang == null }">
                 		<tr>
                 			<td colspan="8" class="text-center">Không có sản phẩm</td>
                 		</tr>
                 		</c:if>
                        </tbody>
                        
                    </table>
                   <div class="text-left">
					<input type="submit" name="xoachon" value="Xoa da chon" <c:if test="${sessionScope.GioHang.getDs().size() == 0 }"> disabled </c:if> id="deleteSelected" class="btn btn-danger">
					<input type="submit" name="xoaall" value="Xoa gio hang" <c:if test="${sessionScope.GioHang.getDs().size() == 0 }"> disabled </c:if> id="deleteAll" class="btn btn-danger">
					</div>
                </form>
            </div>

            <!-- Bên phải: Thông tin thanh toán -->
            <div class="col-lg-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Tổng Cộng</h5>
                        <p class="card-text">
                            <strong>Tổng tiền:</strong> ${sessionScope.GioHang.TongTien() }
                        </p>
                        <a href="ConfirmOrderController" id="thanhtoan" <c:if test="${sessionScope.GioHang.getDs().size() == 0 }"> style="pointer-events: none; opacity: 0.5; cursor: not-allowed;" onclick="return false"; </c:if> class="btn btn-success btn-block">Đặt hàng</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
        <jsp:include page="layout/footer.jsp"></jsp:include>
 <script type="text/javascript">
 	document.addEventListener('DOMContentLoaded', function () {
	  const checkboxes = document.querySelectorAll('.productCheckbox'); // Lấy tất cả checkbox sản phẩm
	  const deleteSelectedButton = document.getElementById('deleteSelected'); // Lấy nút "Xóa đã chọn"

	  // Hàm kiểm tra trạng thái và cập nhật nút "Xóa đã chọn"
	  function updateDeleteSelectedButtonState() {
	    const isAnyChecked = Array.from(checkboxes).some(checkbox => checkbox.checked); // Kiểm tra nếu có ít nhất 1 checkbox được chọn
	    deleteSelectedButton.disabled = !isAnyChecked; // Vô hiệu hóa nút nếu không có checkbox nào được chọn
	  }

	  // Gắn sự kiện "change" cho tất cả checkbox để cập nhật nút
	  checkboxes.forEach(checkbox => {
	    checkbox.addEventListener('change', updateDeleteSelectedButtonState);
	  });

	  // Kiểm tra trạng thái nút ngay khi tải trang
	  updateDeleteSelectedButtonState();
	});

 </script>
</body>
</html>
    