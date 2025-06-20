package Buoi3;

import java.util.Scanner;
public class Diem {
	private int x;
	private int y;
	
	public Diem() {
		x = 0;
		y = 0;
	}
	
	public Diem(int a, int b) {
		x = a;
		y = b;
	}
	
	public Diem(Diem a) {
		x = a.x;
		y = a.y;
	}
	
	public void nhap() {
		Scanner kb = new Scanner(System.in);
		x = kb.nextInt();
		y = kb.nextInt();
	}
	
	public void in() {
		System.out.println("( " + x + ", " + y + " )");
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public double khoangcach(Diem d) {
		return Math.sqrt(Math.pow(x-d.getX(), 2) + Math.pow(y-d.getY(), 2));
	}
}
