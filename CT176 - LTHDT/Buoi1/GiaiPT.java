package Buoi1;

import java.util.Scanner;
public class GiaiPT {
	public static void giaiPTbac1(int a, int b) {
		if(a==0) {
			if(b==0) {
				System.out.println("Phuong trinh vo so nghiem");
			}
			else {
				System.out.println("Phuong trinh vo nghiem");
			}
		}
		else {
			System.out.println("Phuong trinh co nghiem duy nhat: " + (float)(-b)/a);
		}
	}
	public static void giaiPTbac2(int a, int b, int c) {
		float delta = b*b-4*a*c;
		if(delta < 0) {
			System.out.println("Phuong trinh vo nghiem");
		}
		else if(delta == 0) {
			System.out.println("Phuong trinh co nghiem kep x1 = x2 = " + (float)(-b)/(2*a));
		}
		else {
			System.out.println("Phuong trinh co 2 nghiem: ");
			System.out.println("x1 = " + (float)(-b+Math.sqrt(delta))/(2*a));
			System.out.println("x1 = " + (float)(-b-Math.sqrt(delta))/(2*a));
		}
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap tham so a : ");
		int a = kb.nextInt();
		System.out.print("Nhap tham so b : ");
		int b = kb.nextInt();
		System.out.print("Nhap tham so c : ");
		int c = kb.nextInt();
		giaiPTbac1(a, b);
		giaiPTbac2(a, b, c);
	}
}
