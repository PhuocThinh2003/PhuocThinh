package giohangModal;

import java.util.ArrayList;

public class GioHang {
	public ArrayList<Hang> ds = new ArrayList<Hang>();
	public void Them(String maSach, String tenSach, long soLuong, long giaBan) {
		for(Hang h : ds) {
			if(h.getMaHang().equals(maSach)) {
				h.setSoLuong(h.getSoLuong()+ soLuong);
			return;
			}
		}
		Hang tam = new Hang(maSach, tenSach, soLuong, giaBan);
		ds.add(tam);
	}
	 public void xoa(String masach) {
		  for(Hang h: ds)
				 if(h.getMaHang().trim().equals(masach.trim())) {
					 ds.remove(h);break;
				 }
	  }
	public long TongTien() {
		long tongtien = 0;
		for(Hang h : ds) {
			tongtien +=h.getThanhTien();
		}
		return tongtien;
	}
	public ArrayList<Hang> getDs() {
		return ds;
	}

}
