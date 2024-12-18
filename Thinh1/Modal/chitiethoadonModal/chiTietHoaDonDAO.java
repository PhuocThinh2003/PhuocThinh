package chitiethoadonModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ketnoiModal.KetNoi;


public class chiTietHoaDonDAO {
	public int insert(String masach, long slmua, long mahoadon ) throws ClassNotFoundException, SQLException {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql ="insert into ChiTietHoaDon(MaSach,SoLuongMua,MaHoaDon)\r\n"
				+ "	values(?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		cmd.setLong(2, slmua);
		cmd.setLong(3, mahoadon);
		int kq = cmd.executeUpdate();
		return kq;
	}


}
