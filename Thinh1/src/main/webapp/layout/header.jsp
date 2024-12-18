<%@page import="giohangModal.GioHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <nav class="navbar navbar-expand-lg navbar-light bg-red" >
        <div class="container">
            <a class="navbar-brand" href="HomeController">Bán Sách Online</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <%
					 	int count;
						if(session.getAttribute("GioHang")==null)
							count = 0;
						else{
							GioHang gh = (GioHang)session.getAttribute("GioHang");
							count = gh.ds.size();
						}
					%>
            <div class="collapse navbar-collapse" id="navbarNav" >
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item">
                        <a class="nav-link active" href="HomeController">Trang chủ</a>
                    </li>
                     <li class="nav-item">
                        <a class="nav-link" href="OrderedController">Xác nhận mua hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="OrderedController">Lịch sử mua hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CartController">Giỏ hàng<span class="badge bg-secondary">${sessionScope.GioHang.getDs().size() }</span></a>
                    </li>
                </ul>
                <ul class="navbar-nav">
                <c:if test="${sessionScope.user == null }">
                <li class="nav-item"><a class="nav-link" href="Login.jsp"><span class="glyphicon glyphicon-user"></span>Login </a> </li>
                </c:if>
                <c:if test="${sessionScope.user != null }">
               		<li class="nav-item"><a class="nav-link" href="#"><span class="glyphicon glyphicon-log-in"></span> Xin chao: ${sessionScope.user.getHoTen()}</a></li>
					<li class="nav-item"><a class="nav-link" href="LogoutController?username=${sessionScope.user.getHoTen()}"><span class="glyphicon glyphicon-user"></span>Logout </a> </li>
                </c:if>				  	    
               </ul>
            </div>
        </div>
    </nav>
