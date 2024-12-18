package controller.admin.Category;

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

import theloaiModal.Loai;
import theloaiModal.LoaiBO;

/**
 * Servlet implementation class SaveCategoryController
 */
@WebServlet("/SaveCategoryController")
public class SaveCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String maloai = "";
			String tenloai = "";
			LoaiBO lBO = new LoaiBO();
			Loai loai = null;
			Map<String, String> errors = new HashMap<String, String>();
			if(request.getParameter("maloai") == null || request.getParameter("maloai").trim().isEmpty())
				errors.put("maloai", "Vui lòng nhập mã loại");
			if(request.getParameter("tenloai") == null || request.getParameter("tenloai").trim().isEmpty())
				errors.put("tenloai", "Vui lòng nhập tên loại");
			if(errors.isEmpty() == false) {
				request.setAttribute("errors", errors);
				RequestDispatcher rd = request.getRequestDispatcher("CategoryController?action=create");
				rd.forward(request, response);
				return;
			}
			if(request.getParameter("maloai").trim() != null && request.getParameter("tenloai") != null) {
					maloai = (String)request.getParameter("maloai");
					tenloai = (String)request.getParameter("tenloai");
					loai = new Loai(maloai, tenloai);
					int id = lBO.Insert(loai);
					System.out.println(id);
					if(id == -1) {
						errors.put("Existed", "Mã loại đã tồn tại");
						request.setAttribute("loai", loai);
						request.setAttribute("errors", errors);
						RequestDispatcher rd = request.getRequestDispatcher("CategoryController?action=create");
						rd.forward(request, response);
						return;
					}
					else if(id >= 0) {
						RequestDispatcher rd = request.getRequestDispatcher("ShowCategoryController");
						rd.forward(request, response);
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
