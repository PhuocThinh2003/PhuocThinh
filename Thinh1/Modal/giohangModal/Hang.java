package giohangModal;

public class Hang {
	private String maHang;
	private String tenHang;
	private Long soLuong;
	private Long giaBan;
	private Long thanhTien;
	public Hang() {
		super();
	}
	public Hang(String maHang, String tenHang, Long soLuong, Long giaBan) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
	}
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	public Long getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(Long soLuong) {
		this.soLuong = soLuong;
	}
	public Long getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(Long giaBan) {
		this.giaBan = giaBan;
	}
	public Long getThanhTien() {
		return giaBan*soLuong;
	}
	public void setThanhTien(Long thanhTien) {
		this.thanhTien = thanhTien;
	}
	

}
