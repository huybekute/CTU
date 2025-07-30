package Buoi3E;
import java.io.Serializable;
import java.util.Scanner;

public class ThueBaoInternet implements Serializable {
	private String taikhoan;
	private String hoten;
	private String cccd;
	private String diachi;
	private MyDate ngaydk;
	private int tocdo;
	
	public ThueBaoInternet() {
		taikhoan = new String();
		hoten = new String();
		cccd = new String();
		diachi = new String();
		ngaydk = new MyDate();
		tocdo = 0;
	}
	
	public ThueBaoInternet(String taikhoan, String hoten, String cccd, String diachi, MyDate ngaydk, int tocdo) {
		this.taikhoan = new String(taikhoan);
		this.hoten = new String(hoten);
		this.cccd = new String(cccd);
		this.diachi = new String(diachi);
		this.ngaydk = new MyDate(ngaydk);
		this.tocdo = tocdo;
	}
	
	public ThueBaoInternet(ThueBaoInternet a) {
		this.taikhoan = new String(a.taikhoan);
		this.hoten = new String(a.hoten);
		this.cccd = new String(a.cccd);
		this.diachi = new String(a.diachi);
		this.ngaydk = new MyDate(a.ngaydk);
		this.tocdo = a.tocdo;
	}
	
	public void makeCopy(ThueBaoInternet a) {
		this.taikhoan = new String(a.taikhoan);
		this.hoten = new String(a.hoten);
		this.cccd = new String(a.cccd);
		this.diachi = new String(a.diachi);
		this.ngaydk = new MyDate(a.ngaydk);
		this.tocdo = a.tocdo;
	}
	
	public void nhap() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap ten tai khoan: ");
		taikhoan = kb.nextLine();
		System.out.print("Nhap ho ten: ");
		hoten = kb.nextLine();
		System.out.print("Nhap so cccd: ");
		cccd = kb.nextLine();
		System.out.print("Nhap dia chi: ");
		diachi = kb.nextLine();
		System.out.println("Nhap ngay dang ky: ");
		ngaydk.nhap();
		System.out.print("Nhap toc do: ");
		tocdo = kb.nextInt();
		kb.nextLine();
	}
	
	public void in() {
		System.out.println("ten tai khoan: " + taikhoan);
		System.out.println("ho ten: " + hoten);
		System.out.println("so cccd: " + cccd);
		System.out.println("dia chi: " + diachi);
		System.out.println("ngay dang ky: " + ngaydk.toString());
		System.out.println("toc do: " + tocdo);
	}
	
	public int tinhCuoc() {
		if(tocdo == 60) return 165000;
		else if(tocdo == 80) return 180000;
		else if(tocdo == 110) return 230000;
		else if(tocdo == 140) return 280000;
		else if(tocdo == 250) return 480000;
		else return 0;
	}
	
	public boolean tocDoCaoHon(ThueBaoInternet tb) {
		if(tocdo > tb.tocdo) return true;
		return false;
	}
	
	public MyDate layNgayDangKy() {
		return new MyDate(ngaydk);
	}
	
	public String getTK() {
		return taikhoan;
	}
	
	public String getHoTen() {
		return hoten;
	}
	
	public String getCCCD() {
		return cccd;
	}
	
	public String getDiaChi() {
		return diachi;
	}
	
	public int getTocDo() {
		return tocdo;
	}
}
