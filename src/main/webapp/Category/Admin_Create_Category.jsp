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
        <style type="text/css">
        	span{
        		color: red;
        	}
        </style>
    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="../layout/headerAdminDB.jsp"/>
        <div id="layoutSidenav">
        <jsp:include page="../layout/sidebarAdminDB.jsp"/>
            <div id="layoutSidenav_content">
                <main>
                   <div class="container-fluid px-4">
                        <h1 class="mt-4">Manage Category</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"> <a href="DashBoardController">Dashboard</a></li>
                            <li class="breadcrumb-item active">Category</li>
                        </ol>
                        <div class="mt-5">
                            <div class="row">
                                <div class="col-md-6 col-12 mx-auto">
                                    <h2>Thêm mới</h2> <hr>
                                    <span style="color: red;">${errors.Existed }</span>
                                    <form class="row" action="SaveCategoryController" method="Post">
                                        <div class="mb-3 col-12 col-md-6">
                                          <label  class="form-label">Mã loại</label>
                                          <input type="text" name="maloai" value="${loai.getMaLoai()}" class="form-control" autofocus="autofocus"/>
                                          <span style="color: red;">${errors.maloai }</span>
                                        </div>
                                        <div class="mb-3 col-12 col-md-6">
                                          <label class="form-label">Tên Loại</label>
                                          <input type="text" name="tenloai" value="${loai.getTenLoai() }" class="form-control"/>
                                          <span style="color: red;">${errors.tenloai }</span>
                                        </div>
                                        <div class="col-12 mb-5">
                                          <button type="submit" class="btn btn-primary">Create</button>
                                          <a href="ShowCategoryController" class="btn btn-secondary text-end">
					                        <i class="fas fa-arrow-left"></i> Quay lại
					                     </a>
                                        </div>
                                      </form>
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
