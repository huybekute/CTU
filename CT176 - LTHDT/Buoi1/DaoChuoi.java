package Buoi1;

import java.util.Scanner;
public class DaoChuoi {
	public static String daoChuoi(String s) {
		String str = new StringBuilder(s).reverse().toString();
		return str;
	}
	public static void main(String[] args) {
		System.out.print("Nhap chuoi: ");
		Scanner kb = new Scanner(System.in);
		String s = kb.nextLine();
		System.out.println("Chuoi dao nguoc : " + daoChuoi(s));
	}
}
