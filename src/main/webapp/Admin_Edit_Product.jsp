<%@page import="theloaiModal.Loai"%>
<%@page import="java.util.List"%>
<%@page import="theloaiModal.LoaiBO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Product edit</title>
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#avatarFile");
                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imgURL);
                            $("#avatarPreview").css({ "display": "block" });
                        });
                    });
                </script>
        <style type="text/css">
        	span{
        		color: red;
        	}
        </style>
    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="layout/headerAdminDB.jsp"/>
        <div id="layoutSidenav">
        <jsp:include page="layout/sidebarAdminDB.jsp"/>
            <div id="layoutSidenav_content">
                <main>
    <div class="container-fluid px-4">
        <!-- Header -->
        <h1 class="mt-4">Quản lý sách</h1>
        <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item"><a href="DashBoardController">Dashboard</a></li>
            <li class="breadcrumb-item"><a href="ShowProductController">Sản phẩm</a></li>
            <li class="breadcrumb-item active">Chỉnh sửa</li>
        </ol>

        <!-- Form chỉnh sửa sách -->
        <div class="card shadow-lg">
            <div class="card-header bg-primary text-white">
                <h3 class="mb-0">Chỉnh sửa sách: ${sach.getMaSach()}</h3>
            </div>
            <div class="card-body">
                <form action="SaveEditController" method="POST" enctype="multipart/form-data" class="row g-3">
                	<input type="hidden" name="masach" value="${sach.getMaSach()}" />
                    <!-- Tên sách -->
                    <div class="col-md-6">
                        <label for="tensach" class="form-label">Tên sách</label>
                        <input type="text" id="tensach" name="tensach" value="${sach.getTenSach()}" placeholder="Nhập tên sách" class="form-control"/>
                        <span>${errors.tensach}</span>
                    </div>
                    
                    <!-- Tác giả -->
                    <div class="col-md-6">
                        <label for="tacgia" class="form-label">Tác giả</label>
                        <input type="text" id="tacgia" name="tacgia" value="${sach.getTacGia()}" placeholder="Nhập tên tác giả" class="form-control"/>
                        <span>${errors.tacgia}</span>
                    </div>
                    
                    <!-- Số lượng -->
                    <div class="col-md-6">
                        <label for="soluong" class="form-label">Số lượng</label>
                        <input type="number" id="soluong" name="soluong" value="${sach.getSoLuong()}" placeholder="Nhập số lượng" class="form-control"/>
                        <span>${errors.soluong}</span>
                    </div>
                    
                    <!-- Giá bán -->
                    <div class="col-md-6">
                        <label for="giaban" class="form-label">Giá bán</label>
                        <input type="text" id="giaban" name="giaban" value="${sach.getGiaBan()}" placeholder="Nhập giá bán" class="form-control"/>
                        <span>${errors.giaban}</span>
                    </div>
                    
                    <!-- Mã loại -->
                    <div class="col-md-6">
                        <label for="maloai" class="form-label">Mã loại</label>
                        <select id="maloai" name="maloai" class="form-select">
                            <option value="0">-- Chọn mã loại --</option>
                            <c:forEach var="loai" items="${lstTheLoai}">
                                <option value="${loai.getMaLoai()}" ${sach.getMaLoai() == loai.getMaLoai() ? 'selected' : ''}>
                                    ${loai.getTenLoai()}
                                </option>
                            </c:forEach>
                        </select>
                        <span>${errors.maloai}</span>
                    </div>
                    
                    <!-- Ảnh -->
                    <div class="col-md-6">
                        <label for="avatarFile" class="form-label">Ảnh</label>
                        <input type="file" id="avatarFile" name="txtfile" class="form-control"/>
                        <span>${errors.uploadfile}</span>
                    </div>

                    <!-- Xem trước ảnh -->
                    <div class="col-md-12 text-center">
                        <img id="avatarPreview" src="${sach.getAnh()}" alt="Ảnh sách" class="img-thumbnail" style="max-height: 250px; display: ${sach.getAnh() ? 'block' : 'none'};">
                    </div>
                    
                    <!-- Nút lưu -->
                    <div class="col-md-12 text-end">
                        <button type="submit" class="btn btn-primary">
                            <i class="fas fa-save"></i> Lưu thay đổi
                        </button>
                        <a href="ShowProductController" class="btn btn-secondary btn-sm">
                        	<i class="fas fa-arrow-left"></i> Quay lại
                    	 </a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</main>

               <jsp:include page="layout/footerAdminDB.jsp" />
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="js/chart-area-demo.js"></script>
        <script src="js/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>
