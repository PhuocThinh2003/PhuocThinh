package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import sachModal.Sach;
import sachModal.SachBO;
import theloaiModal.LoaiBO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			LoaiBO lBO = new LoaiBO();
			SachBO sBO = new SachBO();
			
			
			String maTheLoai = "";
			String tenSach = "";
			if(request.getParameter("maTheLoai") != null) {
				maTheLoai = request.getParameter("maTheLoai");
				System.out.println(maTheLoai);
			}
			if(request.getParameter("key") != null) {
				tenSach = request.getParameter("key");
			}
			String indexcurrent = request.getParameter("index");
			int index = 1;
			if(indexcurrent != null) {
				 index = Integer.parseInt(indexcurrent);
				 System.out.println(index);
			}
			int totalPage = sBO.gettotalPage(maTheLoai, tenSach);
			int Page = totalPage/12;
			if(totalPage % 12 !=0)
				Page +=1;
			
			ArrayList<Sach> lst = new ArrayList<Sach>();
			lst = sBO.ListBook(index, maTheLoai, tenSach);
			for(Sach item :lst) {
				System.out.println(item.getAnh());
				System.out.println(item.toString());
			}
			request.setAttribute("maTheLoai", maTheLoai);
			request.setAttribute("key", tenSach);
			request.setAttribute("lstTheLoai", lBO.getTheLoai());
			request.setAttribute("index", index);
			request.setAttribute("lstSach", lst);
			request.setAttribute("Page", Page);
			
			RequestDispatcher rd = request.getRequestDispatcher("Home2.jsp");
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
