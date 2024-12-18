package controller.admin.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sachModal.Sach;
import sachModal.SachBO;
import theloaiModal.LoaiBO;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String masach = "";
			String action = "";
			SachBO sBO = new SachBO();
			LoaiBO lBO = new LoaiBO();
			Sach sach = new Sach();
			Map<String, String> errors = new HashMap();
			
			if(request.getParameter("action") != null || request.getParameter("masach") != null) {
				HttpSession session = request.getSession();
				action = request.getParameter("action");
				masach = request.getParameter("masach");
				if(action.equals("create")) {
					if(request.getAttribute("errors") != null ) {
						errors = (Map<String,String>)request.getAttribute("errors");
						for (Map.Entry<String, String> entry : errors.entrySet()) {
					        System.out.println(entry.getKey() + ": " + entry.getValue());
					    }
					}
					if(request.getAttribute("sach") != null)
						sach = (Sach)request.getAttribute("sach");
					//System.out.println(sach.toString());
					request.setAttribute("errors", errors);
			        request.setAttribute("sach", sach);
					request.setAttribute("lstTheLoai", lBO.getTheLoai());
					RequestDispatcher rd = request.getRequestDispatcher("Admin_Create_Product.jsp");
					rd.forward(request, response);
				}
				else if(action.equals("detail")) {
					sach = sBO.getSachByName(masach);
					request.setAttribute("Sach", sach);
					RequestDispatcher rd = request.getRequestDispatcher("Admin_Detail_Product.jsp");
					rd.forward(request, response);					
				}
				else if(action.equals("edit")) {
					if(request.getAttribute("errors") != null ) {
						errors = (Map<String,String>)request.getAttribute("errors");
						for (Map.Entry<String, String> entry : errors.entrySet()) {
					        System.out.println(entry.getKey() + ": " + entry.getValue());
					    }
					}
					if(request.getAttribute("sach") != null) {
						sach = (Sach)request.getAttribute("sach");
						System.out.println(masach+"---------");
						System.out.println(sach.getMaSach()+"---------");
					}
					else {
						sach = sBO.getSachByName(masach);
						System.out.println(masach+"---------");
						System.out.println(sach.getMaSach()+"---------");
					}

					//sBO.UpdateByID(sach);
					System.out.println(sach.toString());
					request.setAttribute("errors", errors);
			        request.setAttribute("sach", sach);
			        
					request.setAttribute("lstTheLoai", lBO.getTheLoai());
					RequestDispatcher rd = request.getRequestDispatcher("Admin_Edit_Product.jsp");
					rd.forward(request, response);					
				}
				else if(action.equals("delete")) {
					sBO.deleteByID(masach);
					response.sendRedirect("ShowProductController");
					return;
					}
				}
			}
		catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
