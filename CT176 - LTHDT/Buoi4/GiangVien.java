package Buoi4;

import java.util.Scanner;
public class GiangVien {
	private String mscb;
	private String hoTen;
	private String hocVi;
	private String donVi;
	private int thamNien;
	private HocPhan[] dsHP;
	
	public GiangVien() {
		mscb = new String();
		hoTen = new String();
		hocVi = new String();
		donVi = new String();
		thamNien = 0;
		dsHP = new HocPhan[100];
	}
	
	public GiangVien(String ms, String ht, String hv, String dv, int tn) {
		mscb = new String(ms);
		hoTen = new String(ht);
		hocVi = new String(hv);
		donVi = new String(dv);
		thamNien = tn;
		dsHP = new HocPhan[100];
	}
	
	public GiangVien(GiangVien a) {
		mscb = new String(a.mscb);
		hoTen = new String(a.hoTen);
		hocVi = new String(a.hocVi);
		donVi = new String(a.donVi);
		thamNien = a.thamNien;
		dsHP = new HocPhan[100];
		for(int i=0; i<dsHP.length; i++) {
			if(a.dsHP[i]!=null) dsHP[i] = new HocPhan(a.dsHP[i]);
		}
	}
	
	public void makeCopy(GiangVien a) {
		mscb = a.mscb;
		hoTen = a.hoTen;
		hocVi = a.hocVi;
		donVi = a.donVi;
		thamNien = a.thamNien;
		for(int i=0; i<dsHP.length; i++) {
			if(a.dsHP[i] != null) dsHP[i] = new HocPhan(a.dsHP[i]);
		}
	}
	
	public void nhap() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap mscb: ");
		mscb = kb.nextLine();
		System.out.print("Nhap ho ten: ");
		hoTen = kb.nextLine();
		System.out.print("Nhap hoc vi: ");
		hocVi = kb.nextLine();
		System.out.print("Nhap don vi: ");
		donVi = kb.nextLine();
		System.out.print("Nhap tham nien: ");
		thamNien = kb.nextInt();
	}
	
	public void in() {
		System.out.println("| " + mscb + " | "  + hoTen + " | " + hocVi + " | " + donVi + " | " + thamNien + " |");
		System.out.println("Danh sach hoc phan giang day: ");
		for(int i=0; i<dsHP.length; i++) {
			if(dsHP[i] != null) {
				System.out.println(" " + (i+1) + ". " + dsHP[i]);
			}
		}
	}
	
	public boolean themHP(HocPhan h) {
		for(int i=0; i<dsHP.length; i++) {
			if(dsHP[i] == null) {
				dsHP[i] =  new HocPhan(h);
				return true;
			}
		}
		return false;
	}
	
	public boolean xoaHP(HocPhan h) {
		for(int i=0; i<dsHP.length; i++) {
			if(dsHP[i] != null && dsHP[i].equals(h)) {
				dsHP[i] = null;
				return true;
			}
		}
		return false;
	}
	
	public HocPhan layHPGD(int i) {
		if(dsHP[i] != null) return dsHP[i];
		else return null;
	}
	
	public String getMSCB() {
		return mscb;
	}
	
	public String getHoTen() {
		return hoTen;
	}
	
	public String getHocVi() {
		return hocVi;
	}
	
	public String getDonVi() {
		return donVi;
	}
	
	public int getThamNien() {
		return thamNien;
	}
}
