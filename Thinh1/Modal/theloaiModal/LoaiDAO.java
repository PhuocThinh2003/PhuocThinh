package theloaiModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ketnoiModal.KetNoi;
import sachModal.Sach;

public class LoaiDAO {
	public ArrayList<Loai> getTheLoai () throws Exception{
		ArrayList<Loai> lst = new ArrayList<Loai>();
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "select * from loai";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String maloai = rs.getString("maloai");
			String tenloai  = rs.getString("tenloai");
			lst.add(new Loai(maloai, tenloai));
		}
		rs.close();
		kn.cn.close();
		return lst;
	}
	public static int Count() throws Exception{
		int total = 0;
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "SELECT COUNT(*) AS TongSoTheLoai FROM loai";
				
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			total = rs.getInt(1);
		}
		rs.close();
		kn.cn.close();
		return total;
	}
	public ArrayList<Loai> ListCategory(int index) throws Exception{
		ArrayList<Loai> lst = new ArrayList<Loai>();

		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "SELECT *                                         \r\n"
				+ "    FROM loai                                       \r\n"
				+ "    ORDER BY maloai                                 \r\n"
				+ "    OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY;";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, (index-1)*10);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String maloai = rs.getString("maloai");
			String tenloai = rs.getString("tenloai");
			lst.add(new Loai(maloai, tenloai));
		}
		rs.close();
		kn.cn.close();
		
		return lst;
	}
	public Loai getLoaiByID(String maloai) throws SQLException, Exception {
		Loai loai = new Loai();
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "SELECT *                                         \r\n"
				+ "    FROM loai                                       \r\n"
				+ "    Where maloai = ?                                 \r\n";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String _maloai = rs.getString("maloai");
			String _tenloai = rs.getString("tenloai");
			loai.setMaLoai(_maloai);
			loai.setTenLoai(_tenloai);
			break;
		}
		rs.close();
		
		kn.cn.close();
		
		return loai;
		
	}
	public int Insert(Loai loai) throws Exception, SQLException {
		int result = -1;
		KetNoi kn = new KetNoi();
		kn.KetNoi();

		String sql = "IF NOT EXISTS (SELECT -1 FROM loai WHERE maloai = ?) "
		           + "BEGIN "
		           + "    INSERT INTO loai (maloai, tenloai) VALUES (?, ?); "
		           + "END;";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		
		cmd.setString(1, loai.getMaLoai()); 
		cmd.setString(2, loai.getMaLoai()); 
		cmd.setString(3, loai.getTenLoai()); 

		result = cmd.executeUpdate();
		kn.cn.close();
		return result;


	}
	public int UpdateLoaiByID(String maloai, String tenloai) throws Exception, SQLException {
		int ID = -1;
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "update loai "  // Dấu cách sau 'sach' là bắt buộc
		           + "set tenloai = ? "
		           + "where maloai = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tenloai);
		cmd.setString(2, maloai);
		ID = cmd.executeUpdate();

		
		kn.cn.close();
		return ID ;
	}
	public boolean DeleteLoaiByID(String id) throws Exception, SQLException {
		int ID = 0;
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "delete from loai where maloai = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, id);
		ID = cmd.executeUpdate();
		kn.cn.close();
		return ID > 0;
	}
}
