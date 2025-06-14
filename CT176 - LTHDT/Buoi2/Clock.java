package Buoi2;

import java.util.Scanner;
public class Clock {
	private int gio;
	private int phut;
	private int giay;
	
	public Clock() {
		gio = 0;
		phut = 0;
		giay = 0;
	}
	
	public Clock(int h, int m, int s) {
		gio = h;
		phut = m;
		giay = s;
	}
	
	public void nhap() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap gio: ");
		gio = kb.nextInt();
		System.out.print("Nhap phut: ");
		phut = kb.nextInt();
		System.out.print("Nhap giay: ");
		giay = kb.nextInt();
	}
	
	public void in() {
		System.out.println(gio +":" + phut + ":" + giay);
	}
	
	public void lamTron() {
		phut += giay / 60;
		giay = giay % 60;
		gio += phut / 60;
		phut = phut % 60;
	}
	
	public String toString() {
		return  gio + ":" + phut + ":" + giay;
	}
	
	public Clock congPhut(int n) {
		Clock kq = new Clock(gio, phut + n, giay);
		kq.lamTron();
		return kq;
	}
	
	public int giatriGio() {
		return gio;
	}
	
	public int giatriPhut() {
		return phut;
	}
	
	public int giatriGiay() {
		return giay;
	}
}
