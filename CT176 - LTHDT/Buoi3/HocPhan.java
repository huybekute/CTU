package Buoi3;

import java.util.Scanner;
public class HocPhan {
	private String msHP;
	private String tenHP;
	private String dvQuanLy;
	private int soTinChi;
	private int soTietLT;
	private int soTietTH;
	
	public HocPhan() {
		msHP = new String();
		tenHP = new String();
		dvQuanLy = new String();
		soTinChi = 0;
		soTietLT = 0;
		soTietTH = 0;
	}
	
	public HocPhan(String ms, String ten, String dv, int tc, int lt, int th) {
		msHP = new String(ms);
		tenHP = new String(ten);
		dvQuanLy = new String(dv);
		soTinChi = tc;
		soTietLT = lt;
		soTietTH = th;
	}
	
	public HocPhan(HocPhan a) {
		msHP = new String(a.msHP);
		tenHP = new String(a.tenHP);
		dvQuanLy = new String(a.dvQuanLy);
		soTinChi = a.soTinChi;
		soTietLT = a.soTietLT;
		soTietTH = a.soTietTH;
	}
	
	public void nhap() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap ma so hoc phan : ");
		msHP = kb.nextLine();
		System.out.print("Nhap ten hoc phan : ");
		tenHP = kb.nextLine();
		System.out.print("Nhap dv quan ly : ");
		dvQuanLy = kb.nextLine();
		System.out.print("Nhap so tin chi : ");
		soTinChi = kb.nextInt();
		System.out.print("Nhap so tiet ly thuyet : ");
		soTietLT = kb.nextInt();
		System.out.print("Nhap so tiet thuc hanh : ");
		soTietTH = kb.nextInt();
	}
	
	public void in() {
		System.out.println("| " + msHP + " | " + tenHP + " | " + dvQuanLy + " | " + soTinChi + " | " + soTietLT + " | " + soTietTH + " |");
	}
	
	public int hocPhi() {
		return soTinChi*660000;
	}
	
	public String getmsHP() {
		return msHP;
	}
	
	public String gettenHP() {
		return tenHP;
	}
	
	public String getdvQuanLy() {
		return dvQuanLy;
	}
	
	public int getsoTinChi() {
		return soTinChi;
	}
	
	public int getsoTietLT() {
		return soTietLT;
	}
	
	public int getsoTietTH() {
		return soTietTH;
	}
}
