package sachModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ketnoiModal.KetNoi;

public class SachDAO {
	public static int Count(String TheLoai,String TimKiem ) throws Exception{
		int total = 0;
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "SELECT COUNT(*) AS TongSoSach FROM sach                  \r\n"
				+ "    WHERE (ISNULL(?, '') = '' OR maloai = ?)    \r\n"
				+ "      AND (ISNULL(?, '') = '' OR tensach LIKE N'%' + ? + '%'); ";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, TheLoai);
		cmd.setString(2, TheLoai);
		cmd.setString(3, TimKiem);
		cmd.setString(4, TimKiem);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			 total = rs.getInt(1);
		}
		rs.close();
		kn.cn.close();
		return total;
	}
	public ArrayList<Sach> ListBooks(int index, String TheLoai, String TimKiem) throws Exception{
		ArrayList<Sach> lst = new ArrayList<Sach>();

		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "SELECT *                                         \r\n"
				+ "    FROM sach                                       \r\n"
				+ "    WHERE                                           \r\n"
				+ "        (ISNULL(?, '') = '' OR maloai = ?)          \r\n"
				+ "    AND (ISNULL(?, '') = '' OR tensach LIKE N'%' + ? + '%') \r\n"
				+ "    ORDER BY masach                                 \r\n"
				+ "    OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY;";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, TheLoai);
		cmd.setString(2, TheLoai);
		cmd.setString(3, TimKiem);
		cmd.setString(4, TimKiem);
		cmd.setInt(5, (index-1)*12);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String masach = rs.getString("masach");
			String tensach = rs.getString("tensach");
			String tacgia = rs.getString("tacgia");
			long soluong = rs.getLong("soluong");
			long gia = rs.getLong("gia");
			String anh = rs.getString("anh");
			String maloai = rs.getString("maloai");
			lst.add(new Sach(masach, tensach, tacgia, soluong, gia, anh, maloai));
		}
		rs.close();
		kn.cn.close();
		
		return lst;
	}
	public Sach getSachByName (String name) throws Exception, SQLException {
		Sach s = new Sach();
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "select * from sach where masach = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, name);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String masach = rs.getString("masach");
			String tensach = rs.getString("tensach");
			String tacgia = rs.getString("tacgia");
			long soluong = rs.getLong("soluong");
			long gia = rs.getLong("gia");
			String anh = rs.getString("anh");
			String maloai = rs.getString("maloai");
			s.setTenSach(tensach);
			s.setMaSach(masach);
			s.setTacGia(tacgia);
			s.setSoLuong(soluong);
			s.setGiaBan(gia);
			s.setAnh(anh);
			s.setMaLoai(maloai);
			break;
		}
		rs.close();
		
		kn.cn.close();
		return s;
	}
	public int DeleteSachByID(String id) throws Exception, SQLException {
		int ID = 0;
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "delete from sach where masach = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, id);
		ID = cmd.executeUpdate();
		kn.cn.close();
		return ID;
	}
	public boolean UpdateSachByID(Sach sach) throws Exception, SQLException {
		int ID = 0;
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "update sach "  // Dấu cách sau 'sach' là bắt buộc
		           + "set tensach = ?, soluong = ?, gia = ?, maloai = ?, anh = ?, tacgia = ? "
		           + "where masach = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, sach.getTenSach());
		cmd.setLong(2, sach.getSoLuong());
		cmd.setLong(3, sach.getGiaBan());
		cmd.setString(4, sach.getMaLoai());
		cmd.setString(5, sach.getAnh());
		cmd.setString(6, sach.getTacGia());
		cmd.setString(7, sach.getMaSach());
		ID = cmd.executeUpdate();

		
		kn.cn.close();
		return ID > 0;
	}
	public boolean Insert(Sach sach) throws Exception, SQLException {
		int ID = 0;
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "insert into sach(masach, tensach, soluong, gia, maloai, sotap, anh, NgayNhap, tacgia) "
				+ "values(?, ?, ?, ?, ?, 1, ?, getdate(), ?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, sach.getMaSach());
		cmd.setString(2, sach.getTenSach());
		cmd.setLong(3, sach.getSoLuong());
		cmd.setLong(4, sach.getGiaBan());
		cmd.setString(5, sach.getMaLoai());
		cmd.setString(6, sach.getAnh());
		cmd.setString(7, sach.getTacGia());
		ID = cmd.executeUpdate();
		
		kn.cn.close();
		return ID > 0;
	}
	public ArrayList<Sach> lstSach() throws Exception{
		ArrayList<Sach> lst = new ArrayList<Sach>();

		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "SELECT * FROM sach                                       \r\n";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String masach = rs.getString("masach");
			String tensach = rs.getString("tensach");
			String tacgia = rs.getString("tacgia");
			long soluong = rs.getLong("soluong");
			long gia = rs.getLong("gia");
			String anh = rs.getString("anh");
			String maloai = rs.getString("maloai");
			lst.add(new Sach(masach, tensach, tacgia, soluong, gia, anh, maloai));
		}
		rs.close();
		kn.cn.close();
		
		return lst;
	}
}
