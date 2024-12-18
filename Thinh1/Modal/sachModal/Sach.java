package sachModal;

public class Sach {
	private String maSach;
	private String tenSach;
	private String tacGia;
	private Long giaBan;
	private Long soLuong;
	private String anh;
	private String maLoai;
	public Sach() {
		super();
	}
	public Sach(String maSach, String tenSach, String tacGia, Long giaBan, Long soLuong, String anh, String maLoai) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.anh = anh;
		this.maLoai = maLoai;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public Long getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(Long giaBan) {
		this.giaBan = giaBan;
	}
	public Long getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(Long soLuong) {
		this.soLuong = soLuong;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tenSach=" + tenSach + ", tacGia=" + tacGia + ", giaBan=" + giaBan
				+ ", soLuong=" + soLuong + ", anh=" + anh + ", maLoai=" + maLoai + "]";
	}

	

}
