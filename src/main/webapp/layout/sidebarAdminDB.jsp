<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <div class="sb-sidenav-menu-heading">Core</div>
                <a class="nav-link" href="DashBoardController">
                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                    Dashboard
                </a>
                <a class="nav-link" href="ShowUserController">
                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                    Users
                </a>
                <a class="nav-link" href="ShowProductController">
                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                    Products
                </a>
                <a class="nav-link" href="ShowOrderContrller">
                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                    Orders
                </a>
                <a class="nav-link" href="ShowCategoryController">
                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                    Category
                </a>
            </div>
        </div>
        <%
        String admin = (String)session.getAttribute("admin");
        %>
        <div class="sb-sidenav-footer">
            <div class="small">Logged in as:</div>
            <%=admin %>
        </div>
    </nav>
</div>