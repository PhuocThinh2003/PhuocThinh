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
        <title>Product - SB Admin</title>
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
                        <h1 class="mt-4">Manage product</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"> <a href="DashBoardController">Dashboard</a></li>
                            <li class="breadcrumb-item active">Product</li>
                        </ol>
                        <div class="mt-5">
                            <div class="row">
                                <div class="col-md-6 col-12 mx-auto">
                                    <h2>Create book</h2> <hr>
                                    <form class="row" action="SaveBookController" method="Post" enctype="multipart/form-data">
                                        <div class="mb-3 col-12 col-md-6">
                                          <label  class="form-label">Tên sách</label>
                                          <input type="text" name="tensach" value="${sach.getTenSach()}" class="form-control""/>
                                          <span style="color: red;">${errors.tensach }</span>
                                        </div>
                                        <div class="mb-3 col-12 col-md-6">
                                          <label class="form-label">Tác giả</label>
                                          <input type="text" name="tacgia" value="${sach.getTacGia() }" class="form-control"/>
                                          <span style="color: red;">${errors.tacgia }</span>
                                        </div>
                                        <div class="mb-3 col-12 col-md-6">
                                          <label for="phoneNumber" class="form-label">Số lượng</label>
                                          <input type="number" name="soluong" value="${sach.getSoLuong()}" class="form-control" />
                                          <span style="color: red;">${errors.soluong }</span>
                                        </div>
                                        <div class="mb-3 col-12 col-md-6">
                                          <label class="form-label">Giá bán</label>
                                          <input type="text" name="giaban" value="${sach.getGiaBan()}" class="form-control"/>
                                          <span style="color: red;">${errors.giaban }</span>
                                        </div>
                                        <div class="mb-3 col-12 col-md-6">
                                          <label for="role" class="form-label">Mã loại</label>
                                          <select id="role" class="form-select" name="maloai">
	                                          	<option value="0">-- chọn mã loại --</option>                                       
	                                          <c:forEach var="loai" items="${lstTheLoai }">
	                                          	<c:if test="${sach.getMaLoai() == loai.getMaLoai() }">
	                                          		<option selected="selected" value="${loai.getMaLoai()}">${loai.getTenLoai() }</option>
	                                          	</c:if>
	                                          	
	                                            <c:if test="${sach.getMaLoai() != loai.getMaLoai() }">
	                                          		<option value="${loai.getMaLoai()}">${loai.getTenLoai() }</option>
	                                          	</c:if>
	                                           </c:forEach>
                                          </select>
                                          <span>${errors.maloai }</span>
                                        </div>
                                        <div class="mb-3 col-12 col-md-6">
                                            <label for="avatarFile" class="form-label">Ảnh</label>
                                            <input type="file" id="avatarFile" name="txtfile"/>
                                            <span>${errors.uploadfile}</span>
                                        </div>
                                        <div class="mb-3 col-12">
                                           <img style="max-height: 250px; display: none;" alt="avatar preview"
                                                id="avatarPreview">
                                        </div>
                       
                                        <div class="col-12 mb-5">
                                          <button type="submit" class="btn btn-primary">Create</button>
                                          <a href="ShowProductController" class="btn btn-secondary">
					                        <i class="fas fa-arrow-left"></i> Quay lại
					                     </a>
                                        </div>
                                      </form>
                                </div>
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
