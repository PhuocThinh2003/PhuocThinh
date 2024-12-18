package controller.admin.Category;

import java.io.IOException;
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
import theloaiModal.Loai;
import theloaiModal.LoaiBO;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String maloai = "";
			String tenloai="";
			String action = "";
			SachBO sBO = new SachBO();
			LoaiBO lBO = new LoaiBO();
			Loai loai = new Loai();
			Sach sach = new Sach();
			
			Map<String, String> errors = null;
			
			if(request.getParameter("action") != null || request.getParameter("maloai") != null) {
				HttpSession session = request.getSession();
				action = request.getParameter("action");
				maloai = request.getParameter("maloai");
				if(action.equals("create")) {
					if(request.getAttribute("errors") != null ) {
						errors = new HashMap<String, String>();
						errors = (Map<String,String>)request.getAttribute("errors");
						for (Map.Entry<String, String> entry : errors.entrySet()) {
					        System.out.println(entry.getKey() + ": " + entry.getValue());
					    }
					}
					if(request.getAttribute("loai") != null)
						loai = (Loai)request.getAttribute("loai");
					//System.out.println(sach.toString());
					request.setAttribute("errors", errors);
			        request.setAttribute("loai", loai);
					RequestDispatcher rd = request.getRequestDispatcher("Category/Admin_Create_Category.jsp");
					rd.forward(request, response);
				}
				else if(action.equals("detail")) {
					loai = lBO.getLoaiByID(maloai);
					System.out.println(lBO.getLoaiByID(maloai).toString());
					request.setAttribute("loai", loai);
					RequestDispatcher rd = request.getRequestDispatcher("Category/Admin_Detail_Category.jsp");
					rd.forward(request, response);					
				}
				else if(action.equals("edit")) {
					if(request.getAttribute("loai") != null)
						loai = (Loai)request.getAttribute("loai");
					else {
						maloai = request.getParameter("maloai");
						loai = lBO.getLoaiByID(maloai);
					}
					System.out.println("ma loai:"+ loai.getMaLoai());
					System.out.println(loai.toString());
			        request.setAttribute("loai", loai);
					RequestDispatcher rd = request.getRequestDispatcher("Category/Admin_Edit_Category.jsp");
					rd.forward(request, response);					
				}
				else if(action.equals("delete")) {
					lBO.Delete(maloai);
					response.sendRedirect("ShowCategoryController");
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
