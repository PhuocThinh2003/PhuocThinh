package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import giohangModal.GioHang;

/**
 * Servlet implementation class AddToCartController
 */
@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSach = request.getParameter("masach");
		String tenSach = request.getParameter("tensach");
		String giaBan = request.getParameter("giaban");
		if(maSach != null && tenSach != null && giaBan != null){
			GioHang gioHang = null;
			HttpSession session = request.getSession();
			if(session.getAttribute("GioHang")== null){
				gioHang = new GioHang();
			 	session.setAttribute("GioHang", gioHang);
			}
			gioHang = (GioHang)session.getAttribute("GioHang");
			long giaBan_long = Long.parseLong(giaBan);
			gioHang.Them(maSach, tenSach, (long)1, giaBan_long);
			session.setAttribute("GioHang", gioHang);

			response.sendRedirect("CartController");
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
