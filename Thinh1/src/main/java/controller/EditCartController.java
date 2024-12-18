package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import giohangModal.GioHang;

/**
 * Servlet implementation class EditCartController
 */
@WebServlet("/EditCartController")
public class EditCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			GioHang giohang = (GioHang)session.getAttribute("GioHang");
			//giohangbo gh=(giohangbo)session.getAttribute("gh");
		    String[] gtck=request.getParameterValues("ck");
			if(request.getParameter("xoachon")!=null){//Can xoa cac sach da chon
				for(String ms: gtck)
					giohang.xoa(ms);
			}
			if(request.getParameter("xacnhan")!=null) {
				response.sendRedirect("ConfirmOrderController");
				return;
			}
			
			
			String mahang_sua=request.getParameter("butsuasl"); // lấy value
			String slsua=request.getParameter(mahang_sua);
			if(mahang_sua!=null){//Can sua sl
				giohang.Them(mahang_sua, "",Long.parseLong(slsua), (long)0);
			}
			String msxoa = request.getParameter("msxoa");
			if(msxoa != null){
				giohang.xoa(msxoa);
			}
		 	session.setAttribute("GioHang",giohang);
		 	RequestDispatcher rd = request.getRequestDispatcher("Cart.jsp");
		 	rd.forward(request, response);
		 	//response.sendRedirect("cart.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
