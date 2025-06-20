package Buoi3;

import java.util.Scanner;
public class SDDuongTron {
	public static void main(String[] args) {
		System.out.println("Duong tron dt1");
		Diem d1 = new Diem(2, 5);
		DuongTron dt1 = new DuongTron(d1, 6);
		dt1.in();
		
		System.out.println("Duong tron dt2");
		DuongTron dt2 = new DuongTron();
		dt2.nhap();
		dt2.in();
		System.out.println("Chu vi duong tron dt2 la: " + dt2.chuVi());
		System.out.println("Dien tich duong tron dt2 la: " + dt2.dienTich());
		
		dt2.doiDuongTron(1, 2);
		System.out.println("Toa do duong tron dt2 sau khi doi la: ");
		dt2.in();
		if(dt2.catNhau(dt1)) System.out.println("Hai duong tron dt2 va dt1 cat nhau");
		else System.out.println("Hai duong tron dt2 va dt1 khong cat nhau");
	}
}
