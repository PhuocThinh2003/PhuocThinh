package lichsuModal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ketnoiModal.KetNoi;

public class LichSuDAO {
	public List<LichSu> get(String khachhang, int damua) throws ClassNotFoundException, SQLException{
		List<LichSu> lst = new ArrayList<LichSu>();
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "SELECT TOP (1000) [hoten]\r\n"
				+ "      ,[NgayMua]\r\n"
				+ "      ,[SoLuongMua]\r\n"
				+ "      ,[tensach]\r\n"
				+ "      ,[gia]\r\n"
				+ "      ,[thanhtien]\r\n"
				+ "  FROM [QuanLySach].[dbo].[LichSuMuaHang]\r\n"
				+ "  where tendn = ? and damua=?;";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, khachhang);
		cmd.setInt(2, damua);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String hoten = rs.getString(1);
			Date ngayMua = rs.getDate(2);
			long soLuongMua = rs.getLong(3);
			String tenSach = rs.getString(4);
			long gia = rs.getLong(5);
			long thanhtien = rs.getLong(6);
			lst.add(new LichSu(khachhang, ngayMua,soLuongMua, tenSach, gia, thanhtien));
		}
		return lst;
	}
}
