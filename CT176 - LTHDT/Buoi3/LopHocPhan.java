package Buoi3;

import java.util.Scanner;
public class LopHocPhan {
	private String malop;
	private HocPhan hp;
	private int siSo;
	private GiangVien gv;
	private String phongHoc;
	private String thoiGian;
	
	public LopHocPhan() {
		malop = new String();
		hp = new HocPhan();
		siSo = 0;
		gv = new GiangVien();
		phongHoc = new String();
		thoiGian = new String();
	}
	
	public LopHocPhan(String ms, HocPhan h, int ss, GiangVien g, String p, String tg) {
		malop = new String(ms);
		hp = new HocPhan(h);
		siSo = ss;
		gv = new GiangVien(g);
		phongHoc = new String(p);
		thoiGian = new String(tg);
	}
	
	public LopHocPhan(LopHocPhan a) {
		malop = new String(a.malop);
		hp = new HocPhan(a.hp);
		siSo = a.siSo;
		gv = new GiangVien(a.gv);
		phongHoc = new String(a.phongHoc);
		thoiGian = new String(a.thoiGian);
	}
	
	public void makeCopy(LopHocPhan a) {
		malop = a.malop;
		hp = a.hp;
		siSo = a.siSo;
		gv = a.gv;
		phongHoc = a.phongHoc;
		thoiGian = a.thoiGian;
	}
	
	public void nhap() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap ma lop: ");
		malop = kb.nextLine();
		System.out.print("Nhap thong tin hoc phan: ");
		hp.nhap();
		System.out.print("Nhap si so: ");
		siSo = kb.nextInt();
		kb.nextLine();
		gv = new GiangVien();
		System.out.print("Nhap phong hoc: ");
		phongHoc = kb.nextLine();
		System.out.print("Nhap thoi gian: ");
		thoiGian = kb.nextLine();
	}	
	
	public void in() {
		System.out.println("ma lop: " + malop);
		System.out.println("thong tin hoc phan: ");
		hp.in();
		System.out.println("si so: " + siSo);
		System.out.println("thong tin giang vien: ");
		gv.in();
		System.out.println("phong hoc: " + phongHoc);
		System.out.println("thoi gian: " + thoiGian);
	}
	
	public void phanCongGV(GiangVien g) {
		gv = new GiangVien(g);
	}
	
	public void tangSiSo(int n) {
		siSo += n;
	}
	
	public String getMaLop() {
		return malop;
	}
	
	public HocPhan getHP() {
		return hp;
	}
	
	public int getSiSo() {
		return siSo;
	}
	
	public GiangVien getGV() {
		return gv;
	}
	
	public String getPhongHoc() {
		return phongHoc;
	}
	
	public String getThoiGian() {
		return thoiGian;
	}
}
