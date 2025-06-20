package Buoi3;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		HocPhan h1 = new HocPhan();
		HocPhan h2 = new HocPhan();
		HocPhan h3 = new HocPhan();
		HocPhan h4 = new HocPhan();
		System.out.println("Hoc phan 1");
		h1.nhap();
		System.out.println("Hoc phan 2");
		h2.nhap();
		System.out.println("Hoc phan 3");
		h3.nhap();
		System.out.println("Hoc phan 4");
		h4.nhap();
		
		GiangVien gv1 = new GiangVien();
		GiangVien gv2 = new GiangVien();
		GiangVien gv3 = new GiangVien();
		System.out.println("Giang vien 1");
		gv1.nhap();
		System.out.println("Giang vien 2");
		gv2.nhap();
		System.out.println("Giang vien 3");
		gv3.nhap();
		
		System.out.print("Nhap so lop hoc phan: ");
		int n = kb.nextInt();
		kb.nextLine();
		LopHocPhan[] danhSach = new LopHocPhan[n];
		for(int i=0; i<n; i++) {
			danhSach[i] = new LopHocPhan();
			danhSach[i].nhap();
			if(n%3==0) danhSach[i].phanCongGV(gv1);
			else if(n%3==1) danhSach[i].phanCongGV(gv2);
			else danhSach[i].phanCongGV(gv3);
		}
		
		for(int i=0; i<n; i++) {
			System.out.println("Lop hoc phan thu: " + (i+1));
			danhSach[i].in();
			System.out.println();
		}
		
	}
}
