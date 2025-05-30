package Buoi1;

import java.util.Scanner;
public class UCLN {
	public static int uscln(int a, int b) {
		while(b!=0) {
			int x = a%b;
			a = b;
			b = x;
		}
		return Math.abs(a);
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap a: ");
		int a = kb.nextInt();
		System.out.print("Nhap b: ");
		int b = kb.nextInt();
		System.out.println("UCLN cua " + a + " va " + b + " la: " +  uscln(a, b));
	}
}
