package controller.admin.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sachModal.Sach;
import sachModal.SachBO;

/**
 * Servlet implementation class ShowProductController
 */
@WebServlet("/ShowProductController")
public class ShowProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			SachBO sBO = new SachBO();
			String indexcurrent = request.getParameter("index");
			int index = 1;
			if(indexcurrent != null) {
				 index = Integer.parseInt(indexcurrent);
				 System.out.println(index);
			}
			int totalPage = sBO.gettotalPage("", "");
			int Page = totalPage/12;
			if(totalPage % 12 !=0)
				Page +=1;
			
			ArrayList<Sach> lst = sBO.ListBook(index, "", "");
			request.setAttribute("index", index);
			request.setAttribute("lstSach", lst);
			request.setAttribute("Page", Page);
			RequestDispatcher rd = request.getRequestDispatcher("Admin_Product.jsp");
			rd.forward(request, response);
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
