package adminModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ketnoiModal.KetNoi;
import userModal.User;

public class AdminDAO {
	public String checkLogin(String username, String password) throws Exception {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "select * from DangNhap where TenDangNhap =? and MatKhau =?";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, username);
		cmd.setString(2, password);
		//result = cmd.execute();
		ResultSet rs = cmd.executeQuery();
		String tenDN = null;
		Admin admin = null;
		if(rs.next()) {
			
			 tenDN = username;
		}
		kn.cn.close();
		return tenDN;
	}
}
