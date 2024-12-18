package hoadonModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class hoadonBO {
	hoaDonDAO hdDAO = new hoaDonDAO();
	public int insert(long makh) throws ClassNotFoundException, SQLException {
		return hdDAO.insert(makh);
	}
	public long getMaxHoaDonID() throws ClassNotFoundException, SQLException{
		return hdDAO.getMaxHoaDonID();
	}
}
