package lichsuModal;

import java.util.Date;

public class LichSu {
	private String hoTen;
	private Date ngayMua;
	private long soLuongMua;
	private String tenSach;
	private long gia;
	private long thanhTien;
	public LichSu() {
		super();
	}
	public LichSu(String hoTen, Date ngayMua, long soLuongMua, String tenSach, long gia, long thanhTien) {
		super();
		this.hoTen = hoTen;
		this.ngayMua = ngayMua;
		this.soLuongMua = soLuongMua;
		this.tenSach = tenSach;
		this.gia = gia;
		this.thanhTien = thanhTien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Date getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}
	public long getSoLuongMua() {
		return soLuongMua;
	}
	public void setSoLuongMua(long soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(long thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public String toString() {
		return "LichSu [hoTen=" + hoTen + ", ngayMua=" + ngayMua + ", soLuongMua=" + soLuongMua + ", tenSach=" + tenSach
				+ ", gia=" + gia + ", thanhTien=" + thanhTien + "]";
	}	
}
