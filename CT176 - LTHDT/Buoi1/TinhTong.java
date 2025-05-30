package Buoi1;

import java.util.Scanner;
public class TinhTong {	
	public static int Tong(int a, int b) {
		return a+b;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int a, b;
		while(true) {
			System.out.print("Nhap a : ");
			if(kb.hasNextInt()) {
				a = kb.nextInt();
				break;
			}
			else {
				System.out.println("Gia tri khong hop le, vui long nhap lai");
				kb.next();
			}
		}
		while(true) {
			System.out.print("Nhap b : ");
			if(kb.hasNextInt()) {
				b = kb.nextInt();
				break;
			}
			else {
				System.out.println("Gia tri khong hop le, vui long nhap lai");
				kb.next();
			}
		}
		System.out.println("Tong a + b = " + Tong(a, b));
	}
}
