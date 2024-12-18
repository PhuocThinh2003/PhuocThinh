package userModal;

import java.sql.SQLException;

public class UserBO {
	UserDAO uDAO = new UserDAO();
	public User check(String username, String password) throws Exception {
		return uDAO.kiemtradangnhap(username, password);
	}
	public int register(User user) throws ClassNotFoundException, SQLException {
		return uDAO.registerUser(user);
	}
}
