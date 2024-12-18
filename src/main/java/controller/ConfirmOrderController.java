package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chitiethoadonModal.chiTietHoaDonBO;
import giohangModal.GioHang;
import giohangModal.Hang;
import hoadonModal.hoadonBO;
import userModal.User;


/**
 * Servlet implementation class ConfirmController
 */
@WebServlet("/ConfirmOrderController")
public class ConfirmOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("user")==null) {
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
				return;
			}
			else {
				GioHang gh = (GioHang)session.getAttribute("GioHang");
				User kh = (User)session.getAttribute("user");
				hoadonBO hdBO = new hoadonBO();
				hdBO.insert(kh.getMaKhachHang());
				long maxhd = hdBO.getMaxHoaDonID();
				chiTietHoaDonBO cthd = new chiTietHoaDonBO();
				for(Hang h: gh.ds) 
					cthd.insert(h.getMaHang(), h.getSoLuong(), maxhd);
				session.removeAttribute("GioHang");
				RequestDispatcher rd = request.getRequestDispatcher("OrderedController");
				rd.forward(request, response);
				return;
				}
			}catch(Exception e){
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