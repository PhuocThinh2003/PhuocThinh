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
        <title>Product Management</title>
        <!-- Include Bootstrap and custom styles -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <style>
            /* Custom styles for modern, clean design */
            body {
                background-color: #f8f9fa;
                font-family: 'Arial', sans-serif;
            }

            h1, h3 {
                color: #2a3d7f;
                font-weight: bold;
            }

            .breadcrumb-item a {
                color: #007bff;
            }
            .breadcrumb-item.active {
                color: #5a5a5a;
            }

            .card {
                border-radius: 10px;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
                margin-bottom: 30px;
                transition: transform 0.3s ease;
            }

            .card:hover {
                transform: translateY(-5px);
            }

            .card-header {
                background: #6c757d;
                color: white;
                border-radius: 10px 10px 0 0;
                font-size: 1.5rem;
                padding: 15px;
            }

            .card-body {
                padding: 20px;
            }

            .table th {
                background-color: #f1f1f1;
                font-weight: bold;
                color: #495057;
            }

            .table-striped tbody tr:nth-child(odd) {
                background-color: #f9f9f9;
            }

            .table-bordered td, .table-bordered th {
                border: 1px solid #ddd;
            }

            .table-hover tbody tr:hover {
                background-color: #e9ecef;
                cursor: pointer;
            }

            .btn {
                transition: all 0.3s ease;
                border-radius: 5px;
            }

            .btn:hover {
                transform: translateY(-2px);
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
            }

            .btn-primary {
                background-color: #007bff;
                border: none;
            }

            .btn-primary:hover {
                background-color: #0056b3;
            }

            .btn-success {
                background-color: #28a745;
                border: none;
            }

            .btn-danger {
                background-color: #dc3545;
                border: none;
            }

            .btn-info {
                background-color: #17a2b8;
                border: none;
            }

            .pagination .page-item.active .page-link {
                background-color: #007bff;
                border-color: #007bff;
                color: white;
            }

            .pagination .page-item .page-link {
                color: #495057;
            }

            .pagination .page-item:hover .page-link {
                background-color: #e2e6ea;
                color: #007bff;
            }

            .footer {
                text-align: center;
                padding: 20px;
                background-color: #6c757d;
                color: white;
                margin-top: 40px;
                border-radius: 5px;
            }

            .container-fluid {
                margin-top: 30px;
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
                        <h1 class="mt-4">Quản lý sản phẩm</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="DashBoardController">Dashboard</a></li>
                            <li class="breadcrumb-item active">Sản phẩm</li>
                        </ol>
                        
                        <!-- Product List Card -->
                        <div class="card shadow">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <h3 class="card-title mb-0">Danh sách sách</h3>
                                <a href="ProductController?action=create" class="btn btn-primary">
                                    <i class="fas fa-plus"></i> Thêm sách mới
                                </a>
                            </div>
                            <div class="card-body">
                                <!-- Product Table -->
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                            <tr class="text-center">
                                                <th>Ảnh</th>
                                                <th>Tên sách</th>
                                                <th>Mã loại</th>
                                                <th>Số lượng</th>
                                                <th>Giá bán</th>
                                                <th>Tác giả</th>
                                                <th>Hành động</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:if test="${lstSach.size() > 0}">
                                                <c:forEach var="s" items="${lstSach}">
                                                    <tr>
                                                        <td class="text-center">
                                                            <img src="${s.getAnh()}" alt="Ảnh sách" style="height: 100px; width: 100px;">
                                                        </td>
                                                        <td>${s.getTenSach()}</td>
                                                        <td>${s.getMaLoai()}</td>
                                                        <td>${s.getSoLuong()}</td>
                                                        <td>${s.getGiaBan()}</td>
                                                        <td>${s.getTacGia()}</td>
                                                        <td class="text-center">
                                                            <a href="ProductController?masach=${s.getMaSach()}&action=detail" class="btn btn-info btn-sm" title="Xem chi tiết">
                                                                <i class="fas fa-eye"></i> Xem
                                                            </a>
                                                            <a href="ProductController?masach=${s.getMaSach()}&action=edit" class="btn btn-success btn-sm" title="Chỉnh sửa">
                                                                <i class="fas fa-edit"></i> Sửa
                                                            </a>
                                                            <a href="ProductController?masach=${s.getMaSach()}&action=delete" class="btn btn-danger btn-sm" title="Xóa" onclick="return confirm('Bạn có chắc chắn muốn xóa sách này?')">
                                                                <i class="fas fa-trash-alt"></i> Xóa
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${lstSach.size() == 0}">
                                                <tr>
                                                    <td colspan="7" class="text-center">Không có dữ liệu</td>
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
                                <c:forEach var="i" begin="1" end="${Page}">
                                    <li class="page-item ${index == i ? 'active' : ''}">
                                        <a class="page-link" href="ShowProductController?index=${i}&maTheLoai=&key=">${i}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </nav>
                    </div>
                </main>
                <div class="footer">
                    <p>&copy; 2024 Product Management. All Rights Reserved.</p>
                </div>
            </div>
        </div>

        <!-- Scripts -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
