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
 * Servlet implementation class SaveEditCategoryController
 */
@WebServlet("/SaveEditCategoryController")
public class SaveEditCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveEditCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maloai = "";
		String tenloai= "";
		Loai loai = new Loai();
		LoaiBO lBO = new LoaiBO();
		if(request.getParameter("tenloai") != null) {
			try {
				maloai = (String)request.getParameter("maloai");
				tenloai = (String)request.getParameter("tenloai");
				int result = lBO.UpdateLoai(maloai, tenloai);
				if(result == -1) {
					
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("ShowCategoryController");
					rd.forward(request, response);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
