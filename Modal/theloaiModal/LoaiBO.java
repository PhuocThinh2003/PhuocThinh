package theloaiModal;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoaiBO {
	LoaiDAO lDAO = new LoaiDAO();
	ArrayList<Loai> lst;
	public ArrayList<Loai> getTheLoai() throws Exception{
		return lDAO.getTheLoai();
	}
	public int getTotal() throws Exception {
		return lDAO.Count();
	}
	public ArrayList<Loai> getCategory(int index) throws Exception{
		return lDAO.ListCategory(index);
	}
	public Loai getLoaiByID(String maLoai) throws Exception, Exception {
		return lDAO.getLoaiByID(maLoai);
	}
	public int Insert(Loai loai) throws SQLException, Exception {
		return lDAO.Insert(loai);
	}
	public int UpdateLoai(String maloai, String tenloai) throws SQLException, Exception {
		return lDAO.UpdateLoaiByID(maloai,tenloai);
	}
	public boolean Delete(String maloai) throws SQLException, Exception {
		return lDAO.DeleteLoaiByID(maloai);
	}
}
