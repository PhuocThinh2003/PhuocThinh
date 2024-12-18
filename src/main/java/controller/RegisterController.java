package controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userModal.User;
import userModal.UserBO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }
    private String md5(String s) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(s.getBytes(), 0, s.length());
            BigInteger i = new BigInteger(1,m.digest());
            return String.format("%1$032x", i);         
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname = (request.getParameter("fullname") == null)?"":(String)request.getParameter("fullname");
		String username = (request.getParameter("username") == null)?"":(String)request.getParameter("username");
		String email = (request.getParameter("email") == null)?"":(String)request.getParameter("email");
		String address = (request.getParameter("address") == null)?"":(String)request.getParameter("address");
		String phone = (request.getParameter("phone") == null)?"":(String)request.getParameter("phone");
		String pass = (request.getParameter("password") == null)?"":(String)request.getParameter("password");
		String _pass = md5(pass);
		User user = new User(0, username, address, phone, email,username, _pass);
		UserBO uBO = new UserBO();
		try {
			int id = uBO.register(user);
			System.out.println(id +"id");
			if(id >= 0) {
				response.sendRedirect("HomeController");
				return;
			}
			else {
				request.setAttribute("error", "khach hang da ton tai!");
				RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
				rd.forward(request, response);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
