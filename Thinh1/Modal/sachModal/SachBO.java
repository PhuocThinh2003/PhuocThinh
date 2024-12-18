package sachModal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SachBO {
	SachDAO sDAO = new SachDAO();
	public int gettotalPage(String TheLoai, String TimKiem) throws Exception {
		int count = sDAO.Count(TheLoai, TimKiem);
		return count;
	}
	public ArrayList<Sach> ListBook(int index, String TheLoai, String TimKiem) throws Exception{
		return sDAO.ListBooks(index, TheLoai, TimKiem);
	}
	public ArrayList<Sach> getAll() throws Exception{
		return sDAO.lstSach();
	}
	public Sach getSachByName(String name) throws SQLException, Exception {
		return sDAO.getSachByName(name);
	}
	public int deleteByID(String id) throws SQLException, Exception {
		return sDAO.DeleteSachByID(id);
	}
	public boolean UpdateByID(Sach s) throws SQLException, Exception {
		return sDAO.UpdateSachByID(s);
	}
	public boolean Insert(Sach s) throws SQLException, Exception {
		return sDAO.Insert(s);
	}
	public  String generateRandomBookCode() {
        // Tập hợp các ký tự cho phép trong mã sách
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();

        // Tạo chuỗi ngẫu nhiên có độ dài 5
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(characters.length());
            code.append(characters.charAt(index));
        }

        return code.toString();
    }
	public  String generateUniqueBookCode(List<Sach> books) throws Exception {
        String newCode;
        do {
            newCode = generateRandomBookCode();
        } while (isCodeExists(books, newCode));

        return newCode;
    }
	public  boolean isCodeExists(List<Sach> books, String code) throws Exception {
        for (Sach book : books) {
            if (book.getMaSach().equals(code)) {
                return true;
            }
        }
        return false;
    }
}
