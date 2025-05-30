package Buoi1;

import java.util.Scanner;
public class degree {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n;
		System.out.print("Nhap x: ");
		float x = kb.nextFloat();
		while(true) {
			System.out.print("Nhap n : ");
			if(kb.hasNextInt()) {
				n = kb.nextInt();
				break;
			}
			else {
				System.out.println("Gia tri khong hop le, vui long nhap lai");
				kb.next();
			}
		}
		System.out.println("x^n = " + Math.pow(x, n));
	}
}
