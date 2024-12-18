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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <style>
            /* Custom styling for better aesthetics */
            body {
                background: #f0f4f8;
                font-family: 'Arial', sans-serif;
            }

            .breadcrumb-item a {
                color: #5c6bc0;
            }
            .breadcrumb-item.active {
                color: #283593;
                font-weight: bold;
            }

            h1 {
                font-size: 2.5rem;
                color: #283593;
                font-weight: 700;
            }

            .card {
                border-radius: 12px;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                transition: transform 0.3s ease;
            }
            .card:hover {
                transform: translateY(-10px);
            }

            .card-header {
                background: linear-gradient(to right, #6a11cb, #2575fc);
                color: #fff;
                font-size: 1.25rem;
                padding: 15px;
                border-radius: 12px 12px 0 0;
                font-weight: 600;
            }

            .card-body {
                padding: 20px;
            }

            .table th {
                background-color: #f4f6f9;
                font-weight: bold;
                color: #6c757d;
            }

            .table-bordered td, .table-bordered th {
                border: 1px solid #ddd;
            }

            .table-striped tbody tr:nth-of-type(odd) {
                background-color: #f8f9fa;
            }

            .pagination .page-item.active .page-link {
                background-color: #283593;
                border-color: #283593;
                color: white;
            }

            .pagination .page-item .page-link {
                color: #6c757d;
                border-radius: 50%;
                padding: 10px 15px;
            }

            .pagination .page-item:hover .page-link {
                background-color: #283593;
                color: white;
            }

            .btn {
                transition: all 0.3s ease;
                border-radius: 10px;
            }
            .btn:hover {
                transform: translateY(-2px);
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.15);
            }

            .btn-primary {
                background-color: #6a11cb;
                border: none;
            }
            .btn-primary:hover {
                background-color: #2575fc;
            }

            .btn-success {
                background-color: #28a745;
                border: none;
            }
            .btn-info {
                background-color: #17a2b8;
                border: none;
            }
            .btn-danger {
                background-color: #dc3545;
                border: none;
            }

            .container-fluid {
                margin-top: 30px;
            }

            .footer {
                text-align: center;
                padding: 20px;
                background-color: #283593;
                color: white;
                margin-top: 50px;
                border-radius: 10px;
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
                        <!-- Title and breadcrumb -->
                        <h1 class="mt-4">Quản lý thể loại</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="DashBoardController">Dashboard</a></li>
                            <li class="breadcrumb-item active">Category</li>
                        </ol>

                        <!-- Category management card -->
                        <div class="card shadow-lg mb-4">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <h3 class="card-title mb-0">Danh sách thể loại</h3>
                                <a href="CategoryController?action=create" class="btn btn-primary">
                                    <i class="fas fa-plus"></i> Thêm mới
                                </a>
                            </div>
                            <div class="card-body">
                                <!-- Category list table -->
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead class="text-center">
                                            <tr>
                                                <th scope="col">Mã thể loại</th>
                                                <th scope="col">Tên thể loại</th>
                                                <th scope="col" style="width: 20%;">Hành động</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <!-- Check and display data -->
                                            <c:if test="${lstTheLoai.size() > 0}">
                                                <c:forEach var="l" items="${lstTheLoai}">
                                                    <tr>
                                                        <td>${l.getMaLoai()}</td>
                                                        <td>${l.getTenLoai()}</td>
                                                        <td class="text-center">
                                                            <a class="btn btn-success btn-sm" href="CategoryController?maloai=${l.getMaLoai()}&action=detail" title="Xem chi tiết">
                                                                <i class="fas fa-eye"></i> Xem
                                                            </a>
                                                            <a class="btn btn-info btn-sm" href="CategoryController?maloai=${l.getMaLoai()}&action=edit" title="Chỉnh sửa">
                                                                <i class="fas fa-edit"></i> Sửa
                                                            </a>
                                                            <a class="btn btn-danger btn-sm" href="CategoryController?maloai=${l.getMaLoai()}&action=delete" title="Xóa" onclick="return confirm('Bạn có chắc chắn muốn xóa thể loại này?')">
                                                                <i class="fas fa-trash-alt"></i> Xóa
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${lstTheLoai.size() == 0}">
                                                <tr>
                                                    <td colspan="3" class="text-center">Không có dữ liệu</td>
                                                </tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <!-- Pagination -->
                        <nav aria-label="Page navigation" class="mt-4">
                            <ul class="pagination justify-content-center">
                                <c:forEach var="i" begin="1" end="${page}">
                                    <li class="page-item ${index == i ? 'active' : ''}">
                                        <a class="page-link" href="ShowCategoryController?index=${i}">${i}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </nav>
                    </div>
                </main>
                <div class="footer">
                    <p>&copy; 2024 All rights reserved</p>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
