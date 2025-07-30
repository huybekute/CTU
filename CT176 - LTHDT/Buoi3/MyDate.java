package Buoi3;
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
}
