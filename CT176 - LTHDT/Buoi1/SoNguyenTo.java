package Buoi1;

import java.util.Scanner;
public class SoNguyenTo {
	public static boolean SNT(int n) {
		if(n <= 2) {
			return false;
		}
		else {
			for(int i=2; i<=Math.sqrt(n); i++) {
				if(n%i==0) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap n = ");
		int n = kb.nextInt();
		boolean a = SNT(n);
		if(a) {
			System.out.println(n + " la so nguyen to");
		}
		else {
			System.out.println(n + " khong phai la so nguyen to");
		}
	}
}
