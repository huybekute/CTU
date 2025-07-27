package Buoi4;
import java.util.Scanner;
public class SDDiemMau {
	public static void main(String[] args) {
		DiemMau a = new DiemMau(5, 10, "trang");
		System.out.println("Thong tin diem mau a: ");
		a.in();
		
		DiemMau b = new DiemMau();
		System.out.println("Nhap thong tin diem b: ");
		b.nhap();
		b.doiDiem(10, 8);
		System.out.println("Thong tin diem mau b: ");
		b.in();
		
		b.ganMau("vang");
		System.out.println("Thong tin diem mau b sau khi gan lai mau: ");
		b.in();
	}
}
