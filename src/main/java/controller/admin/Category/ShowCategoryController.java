package controller.admin.Category;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import theloaiModal.Loai;
import theloaiModal.LoaiBO;

/**
 * Servlet implementation class ShowCategoryController
 */
@WebServlet("/ShowCategoryController")
public class ShowCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			LoaiBO lBO = new LoaiBO();
			int index = 1;
			if((String)request.getParameter("index") != null) {
				index = Integer.parseInt(request.getParameter("index"));
			}
			int totalPage = lBO.getTotal();
			int page = totalPage / 10;
			if(totalPage % 10 != 0)
				page += 1;
			ArrayList<Loai> lstTheLoai = lBO.getCategory(index);
			
			request.setAttribute("lstTheLoai", lstTheLoai);
			request.setAttribute("index", index);
			request.setAttribute("page", page);
			
			RequestDispatcher rd = request.getRequestDispatcher("Category/Admin_Category.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
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
