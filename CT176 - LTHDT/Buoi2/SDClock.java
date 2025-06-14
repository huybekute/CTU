package Buoi2;
import java.util.Scanner;

public class SDClock {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		Clock c1 = new Clock(12,65,90);
		c1.lamTron();
		System.out.print("Thoi gian cua Clock c1 la: ");
		c1.in();
		
		Clock c2 = new Clock();
		System.out.print("Nhap thoi gian c2: ");
		c2.nhap();
		c2.lamTron();
		System.out.print("Thoi gian cua Clock c2 la: ");
		c2.in();
		
		System.out.print("Nhap so phut n: ");
		int n = kb.nextInt();
		System.out.print("Thoi gian cua Clock c2 sau khi cong n phut la: " + c2.congPhut(n));
	}
}
