package Buoi3E;
import java.io.Serializable;
import java.util.Scanner;
public class MyDate implements Serializable {
	private int ngay;
	private int thang;
	private int nam;
	
	public MyDate() {
		ngay = 31;
		thang = 5;
		nam = 2005;
	}
	
	public MyDate(int d, int m, int y) {
		ngay = d;
		thang = m;
		nam = y;
	}
	
	public MyDate(MyDate d) {
		this.ngay = d.ngay;
		this.thang = d.thang;
		this.nam = d.nam;
	}
	
	public void makeCopy(MyDate d) {
		this.ngay = d.ngay;
		this.thang = d.thang;
		this.nam = d.nam;
	}
	
	public void hienThi() {
		System.out.println(ngay + "/" + thang + "/" + nam);
	}
	
	public void nhap() {
		Scanner kb = new Scanner(System.in);
		do {
			System.out.print("Nhap ngay: ");
			ngay = kb.nextInt();
			System.out.print("Nhap thang: ");
			thang = kb.nextInt();
			System.out.print("Nhap nam: ");
			nam = kb.nextInt();
			if(!kiemtra()) {
				System.out.println("Vui long nhap dung dinh dang");
			}
		}
		while(!kiemtra());
	}
	
	public boolean kiemtra() {
		if(thang > 12) return false;
		int[] max = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(nam % 400 == 0 || (nam %4 == 0 && nam % 100 != 0)) {
			max[1] = 29;
		}
		return (ngay <= max[thang-1]);
	}
	
	public MyDate ngayHomSau() {
		MyDate kq = new MyDate(ngay, thang, nam);
		kq.ngay += 1;
		if(!kq.kiemtra()) {
			kq.ngay = 1;
			kq.thang = (kq.thang == 12) ? 1 : kq.thang + 1;
			kq.nam = (kq.thang == 1) ? kq.nam + 1 : kq.nam;
		}
		return kq;
	}
	
	public MyDate congNgay(int n) {
		MyDate kqCong = new MyDate(ngay, thang, nam);
		for(int i=0; i<n; i++) {
			kqCong = kqCong.ngayHomSau();
		}
		return kqCong;
	}
	
	public String toString() {
		return ngay + "/" + thang + "/" + nam;
	}
	
	public boolean equals(MyDate d1) {
		return this.ngay == d1.ngay && this.thang == d1.thang && this.nam == d1.nam;
	}
	
	public int getNgay() {
		return ngay;
	}
	
	public int getThang() {
		return thang;
	}
	
	public int getNam() {
		return nam;
	}
	
	public int soSanh(MyDate a) {
		if(this.nam != a.nam) return this.nam - a.nam;
		if(this.thang != a.thang) return this.thang - a.thang;
		return this.ngay - a.ngay;
	}
}
