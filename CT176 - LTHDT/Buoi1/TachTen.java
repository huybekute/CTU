package Buoi1;

import java.util.Scanner;
public class TachTen {
	public static String layTen(String hoten) {
		hoten = hoten.trim();
		return hoten.substring(hoten.lastIndexOf(" ") + 1);
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap ho va ten: ");
		String n = kb.nextLine();
		System.out.println(layTen(n));
	}
}
