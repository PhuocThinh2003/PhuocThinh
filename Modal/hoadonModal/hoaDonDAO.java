package hoadonModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ketnoiModal.KetNoi;

public class hoaDonDAO {
	public int insert(long makh) throws ClassNotFoundException, SQLException {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql ="insert into hoadon(makh,NgayMua,damua)\r\n"
				+ "	values(?,getdate(),1)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, makh);
		int kq = cmd.executeUpdate();
		return kq;
	}
	public long getMaxHoaDonID() throws ClassNotFoundException, SQLException{
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql ="select max(MaHoaDon) as MaxHD from hoadon";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		long max = 0;
		if(rs.next())
			max = rs.getLong("MaxHD");
		return max;
	}
	
}
