package Buoi4;

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
		System.out.print("Nhap x: ");
		x = kb.nextInt();
		System.out.print("Nhap y: ");
		y = kb.nextInt();
	}
	
	public void in() {
		System.out.print("( " + x + ", " + y + " )");
	}
	
	public void doiDiem(int dx, int dy) {
		x+=dx;
		y+=dy;
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
	
	public boolean equals(Diem d) {
		if(this.x == d.x && this.y == d.y) return true;
		return false;	
	}
}
