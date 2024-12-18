package userModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ketnoiModal.KetNoi;

public class UserDAO {
	public User kiemtradangnhap(String username, String password) throws Exception {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "select * from KhachHang where tendn =? and pass =?";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, username);
		cmd.setString(2, password);
		//result = cmd.execute();
		ResultSet rs = cmd.executeQuery();
		User kh = null;
		if(rs.next()) {// Dang nhap dung
			// tao ra một khách hàng
		
			 long maKh = rs.getLong("makh");
			 String hoTen = rs.getString("hoten");
			 String diachi = rs.getString("diachi");
			 String email = rs.getString("email");
			 String soDT = rs.getString("sodt");
			 
			 kh = new User(maKh, hoTen,  diachi,  soDT, email,  username, password);
			
		}
		kn.cn.close();
		return kh;
	}
	public int registerUser(User user) throws ClassNotFoundException, SQLException {
		int id = 0;
		KetNoi kn = new KetNoi();
		kn.KetNoi();

		String sql = "if exists(select * from KhachHang where tendn = ? or email = ?) "
		           + "select -1 "
		           + "else "
		           + "begin "
		           + "    insert into KhachHang(hoten, diachi, sodt, email, tendn, pass) "
		           + "    values(?,?,?,?,?,?); "
		           + "    select scope_identity(); "
		           + "end";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		// Set các tham số
		cmd.setString(1, user.getTenDangNhap());
		cmd.setString(2, user.getEmail());
		cmd.setString(3, user.getHoTen());
		cmd.setString(4, user.getDiaChi());
		cmd.setString(5, user.getSoDienThoai());
		cmd.setString(6, user.getEmail());
		cmd.setString(7, user.getTenDangNhap());
		cmd.setString(8, user.getMatKhau());

		// Sử dụng execute để xử lý cả SELECT và UPDATE
		boolean hasResultSet = cmd.execute();

		if (hasResultSet) {
		    // Lấy ResultSet khi có kết quả trả về
		    ResultSet rs = cmd.getResultSet();
		    if (rs.next()) {
		        id = rs.getInt(1); // Lấy giá trị scope_identity() hoặc -1
		    }
		} else {
		    // Trường hợp không có ResultSet
		    int affectedRows = cmd.getUpdateCount();
		    System.out.println("Số dòng bị ảnh hưởng: " + affectedRows);
		}

		kn.cn.close();
		return id;


	}
}

