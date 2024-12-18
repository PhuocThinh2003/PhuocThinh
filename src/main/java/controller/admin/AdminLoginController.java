package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adminModal.Admin;
import adminModal.AdminBO;
import nl.captcha.Captcha;
import userModal.User;
import userModal.UserBO;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String username = request.getParameter("username");
			String pass = request.getParameter("password");
			String answer = request.getParameter("answer");
			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
			if(session.getAttribute("dem") != null) {
				int d = (int)session.getAttribute("dem");
				if(answer != null) 
					if(d>= 3 && captcha.isCorrect(answer) == false) {
						RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
						rd.forward(request, response);
					}
				
			}
			if(username != null && pass!= null){
				AdminBO adminBO = new AdminBO();
				String tenDangNhap = adminBO.checkLoginAdmin(username, pass);
				
				if(( tenDangNhap != null || tenDangNhap != null && captcha.isCorrect(answer))){
					session.setAttribute("admin",username);
					if(session.getAttribute("dem") != null) {
						session.removeAttribute("dem");
					}
					response.sendRedirect("DashBoardController");
					return;
				} 
				else{
					if(session.getAttribute("dem") == null) {
						session.setAttribute("dem", (int)0);
					}
					int d = (int)session.getAttribute("dem");
					d++;
					session.setAttribute("dem", d);
					request.setAttribute("error", "Ten dang nhap hoac mat khau sai!");
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
			rd.forward(request, response);
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
