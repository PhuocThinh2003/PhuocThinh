<%@page import="sachModal.Sach"%>
<%@page import="java.util.ArrayList"%>
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
    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="../layout/headerAdminDB.jsp"/>
        <div id="layoutSidenav">
        <jsp:include page="../layout/sidebarAdminDB.jsp"/>
            <div id="layoutSidenav_content">
               <main>
				   <div class="container-fluid px-4">
				      <h1 class="mt-4">Quản lý sản phẩm</h1>
				      <ol class="breadcrumb mb-4">
				         <li class="breadcrumb-item"><a href="DashBoardController">Dashboard</a></li>
				         <li class="breadcrumb-item active">Product</li>
				      </ol>
				
				      <div class="mt-5">
				         <div class="row">
				            <div class="col-12 col-lg-10 mx-auto">
				               <!-- Card hiển thị thông tin sách -->
				               <div class="card shadow">
				                  <div class="card-header d-flex justify-content-between align-items-center">
				                     <h3 class="card-title mb-0">Thông tin thể loại</h3>
				                     <a href="CategoryController?maloai=${loai.getMaLoai()}&action=edit" 
				                        class="btn btn-primary btn-sm" 
				                        title="Chỉnh sửa sách" 
				                        data-bs-toggle="tooltip" 
				                        data-bs-placement="top">
				                        <i class="fas fa-edit"></i> Chỉnh sửa
				                     </a>
				                  </div>
				                  <div class="card-body">
				                     <div class="row g-3">
				                        
				                        <div class="col-12 col-md-6">
				                           <label class="form-label fw-bold">Mã loại:</label>
				                           <p>${loai.getMaLoai()}</p>
				                        </div>
				
				                       
				                        <div class="col-12 col-md-6">
				                           <label class="form-label fw-bold">Tên thể loại:</label>
				                           <p>${loai.getTenLoai()}</p>
				                        </div>
				                     </div>
				                  </div>
				                  <!-- Footer của card -->
				                  <div class="card-footer text-end">
				                     <a href="ShowCategoryController" class="btn btn-secondary btn-sm">
				                        <i class="fas fa-arrow-left"></i> Quay lại
				                     </a>
				                  </div>
				               </div>
				            </div>
				         </div>
				      </div>
				   </div>
				</main>

                 
               <jsp:include page="../layout/footerAdminDB.jsp" />
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
