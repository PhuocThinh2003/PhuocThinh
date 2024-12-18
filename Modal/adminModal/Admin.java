package adminModal;

public class Admin {
	private String tenDangNhap;
	private String matKhau;
	private int quyen;
	public Admin(String tenDangNhap, String matKhau, int quyen) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.quyen = quyen;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public int getQuyen() {
		return quyen;
	}
	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}
	
	
}
