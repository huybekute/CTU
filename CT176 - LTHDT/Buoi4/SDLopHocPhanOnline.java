package Buoi4;

import java.util.Scanner;
public class SDLopHocPhanOnline {
	public static void main(String[] args) {
		LopHocPhanOnline l1 = new LopHocPhanOnline();
		l1.nhap();
		l1.in();
		
		//nhap ds lophp online
		Scanner kb = new Scanner(System.in);
		int n;
		System.out.print("Nhap so lop hoc phan online");
		n = kb.nextInt();
		kb.nextLine();
		LopHocPhanOnline[] lhpo = new LopHocPhanOnline[n];
		for(int i=0; i<n; i++) {	
			lhpo[i] = new LopHocPhanOnline();
			lhpo[i].nhap();
		}
		
		System.out.println("Danh sach cac lop hoc phan online:");
		for(int i=0; i<n; i++) {
			lhpo[i].in();
		}
		
	}
}
