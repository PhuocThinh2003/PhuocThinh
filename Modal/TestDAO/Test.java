package TestDAO;

import java.util.ArrayList;
import java.util.List;

import lichsuModal.LichSu;
import lichsuModal.LichSuBO;
import sachModal.Sach;
import sachModal.SachBO;
import sachModal.SachDAO;
import theloaiModal.Loai;
import theloaiModal.LoaiBO;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SachBO s = new SachBO();
		LoaiBO lBO = new LoaiBO();
		LichSuBO lsBO = new LichSuBO();
		int count = s.gettotalPage("Bi quyet cuoc song", null);
		System.out.println(count);
		ArrayList<Sach> lst = new ArrayList<Sach>();
		lst = s.ListBook(2, "Khoa hoc", null);
		for(Sach item : lst) {
			System.out.println(item.toString());
		}
		ArrayList<Loai> lstTheLoai = new ArrayList<Loai>();
		lstTheLoai = lBO.getTheLoai();
		for(Loai item : lstTheLoai) {
			System.out.println(item.getTenLoai());
		}
		
		List<LichSu> lstLichSu = lsBO.get("nkchung",1);
		for(LichSu item : lstLichSu) {
			System.out.println(item.toString());
		}
		System.out.println(s.getSachByName("b1").toString());
		System.out.println(s.generateUniqueBookCode(s.getAll()));
		ArrayList<Loai> lstCategory = new ArrayList<Loai>();
		lstTheLoai = lBO.getCategory(2);
		for(Loai item : lstTheLoai) {
			System.out.println(item.getTenLoai());
		}
		System.out.println(lBO.getTotal());
		System.out.println(lBO.getCategory(1).size());
		System.out.println(lBO.getLoaiByID("Chinh tri").toString());
		Loai l = new Loai("Loi", "TienLoi");
		int id = lBO.Insert(l);
		System.out.println(id);
	}

}
