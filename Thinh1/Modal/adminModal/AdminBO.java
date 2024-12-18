package adminModal;

public class AdminBO {
	AdminDAO adminDAO = new AdminDAO();
	public String checkLoginAdmin(String tendn, String mk) throws Exception {
		return adminDAO.checkLogin(tendn, mk);
	}
}
