package Buoi3;
import java.util.Scanner;
import java.util.Date;
import java.text.*;

public class SinhVien {
	private String mssv;
	private String hoten;
	private Date ngaysinh;
	private int sl;
	private String[] tenHP;
	private String[] diem;
	
	public SinhVien() {
		this.mssv = new String();
		this.hoten = new String();
		this.ngaysinh = new Date();
		this.sl = 0;
		this.tenHP = new String[100];
		this.diem = new String[100];
	}
	
	public SinhVien(String mssv, String hoten, Date ngaysinh, int sl, String[] tenHP, String[] diem) {
		this.mssv = new String(mssv);
		this.hoten = new String(hoten);
		this.ngaysinh = new Date(ngaysinh.getTime());
		this.sl = sl;
		this.tenHP = tenHP;
		this.diem = diem;
	}
	
	public SinhVien(SinhVien a) {
		this.mssv = new String(a.mssv);
		this.hoten = new String(a.hoten);
		this.ngaysinh = new Date(a.ngaysinh.getTime());
		this.sl = a.sl;
		for(int i=0; i<100; i++) {
			this.tenHP[i] = new String(a.tenHP[i]);
			this.diem[i] = new String(a.diem[i]);
		}
	}
	
	public void makeCopy (SinhVien a) {
		this.mssv = new String(a.mssv);
		this.hoten = new String(a.hoten);
		this.ngaysinh = new Date(a.ngaysinh.getTime());
		this.sl = a.sl;
		for(int i=0; i<100; i++) {
			this.tenHP[i] = new String(a.tenHP[i]);
			this.diem[i] = new String(a.diem[i]);
		}
	}
	
	public void nhap() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap mssv: ");
		mssv = kb.nextLine();
		System.out.print("Nhap ho ten: ");
		hoten = kb.nextLine();
		System.out.print("Nhap ngay sinh: ");
		String nsTemp = kb.nextLine();
		try {
			SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
			ngaysinh = s.parse(nsTemp);
		}
		catch(ParseException e){
			System.out.print("ngay sinh ko hop le, gan vao ngay hien tại");
			ngaysinh = new Date();
		}
		System.out.print("Nhap so luong hoc phan dang ky");
		sl = kb.nextInt();
		kb.nextLine();
		System.out.println("Nhap ten HP va Diem HP");
		for(int i=0; i<sl; i++) {
			System.out.print("Ten HP thu " + (i+1) + ": ");
			tenHP[i] = kb.nextLine();
			System.out.print("Diem HP thu " + (i+1) + ": ");
			diem[i] = kb.nextLine();
		}
	}
	
	public void in() {
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("MSSV: "+ mssv);
		System.out.println("Ho ten: " + hoten);
		System.out.println("Ngay sinh: " +  s.format(ngaysinh));
		System.out.println("So luong hoc phan dang ky: " + sl);
		System.out.println("Danh sach cac hoc phan: ");
		for(int i=0; i<sl; i++) {
			System.out.println((i+1) + " - " + tenHP[i] + " - " + diem[i]);
		}
	}
	
	public String toString() {
		SimpleDateFormat s =  new SimpleDateFormat("dd/MM/yyyy");
		String result = (mssv + " - " + hoten + " - " + s.format(ngaysinh) + " - " + sl + " - ");
		for(int i=0; i<sl; i++) {
			result += ("[ " + tenHP[i] + " - " + diem[i] +  " ]");
		}
		return result;
	}
	
	public double tinhDiemTB() {
		double tong = 0.0;
		for(int i=0; i<sl; i++) {
			if(diem[i].equals("A") || diem[i].equals("a")) tong += 4.0;
			else if(diem[i].equals("B+") || diem[i].equals("b+")) tong += 3.5;
			else if(diem[i].equals("B") || diem[i].equals("b")) tong += 3.0;
			else if(diem[i].equals("C+") || diem[i].equals("c+")) tong += 2.5;
			else if(diem[i].equals("C") || diem[i].equals("c")) tong += 2.0;
			else if(diem[i].equals("D+") || diem[i].equals("d+")) tong += 1.5;
			else if(diem[i].equals("D") || diem[i].equals("d")) tong += 1;
			else tong+=0;
		}
		return tong/sl;
	}
	
	public boolean dangKyHP(String tenHocPhan) {
		for(int i=0; i<sl; i++) {
			if(tenHocPhan.equals(tenHP[i])) return false;
		}
		tenHP[sl] = tenHocPhan;
		diem[sl] = new String();
		sl++;
		return true;
	}
	
	public boolean xoaHP(String tenHocPhan) {
		for(int i=0; i<sl; i++) {
			if(tenHocPhan.equals(tenHP[i])) {
				for(int j=i; j<sl; j++) {
					tenHP[j] = tenHP[j+1];
					diem[j] = diem[j+1];
				}
				tenHP[sl] = null;
				diem[sl] = null;
				sl--;
				return true;
			}
		}
		return false;	
	}
	
	public String getMSSV() {
		return mssv;
	}
	
	public String getHoTen() {
		return hoten;
	}
	
	public int getSL() {
		return sl;
	}
	
	public String tachTen(String ten) {
		ten = ten.trim();
		return ten.substring(ten.lastIndexOf(" ") + 1);
	}
	

}
