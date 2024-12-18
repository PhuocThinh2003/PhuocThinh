package chitiethoadonModal;

import java.sql.PreparedStatement;
import java.sql.SQLException;



public class chiTietHoaDonBO {
	chiTietHoaDonDAO cthdDAO = new chiTietHoaDonDAO();
	public int insert(String masach, long slmua, long mahoadon ) throws ClassNotFoundException, SQLException {
		return cthdDAO.insert(masach, slmua, mahoadon);
	}
}
