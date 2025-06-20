package Buoi3;

import java.util.Scanner;
public class DuongTron {
	private Diem tam;
	private int bankinh;
	
	public DuongTron() {
		tam = new Diem(0, 0);
		bankinh = 0;
	}
	
	public DuongTron(Diem tam, int bankinh) {
		this.tam = new Diem(tam.getX(), tam.getY());
		this.bankinh = bankinh;
	}
	
	public DuongTron(int x, int y, int bk) {
		tam = new Diem(x, y);
		bankinh = bk;
	}
	
	public DuongTron(DuongTron a) {
		tam = a.tam;
		bankinh = a.bankinh;
	}
	
	public void makeCopy(DuongTron a) {
		tam = new Diem(a.tam.getX(), a.tam.getY());
		bankinh = a.bankinh;
	}
	
	public void nhap() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap hoanh do x cua tam: ");
		int x = kb.nextInt();
		System.out.print("Nhap tung do y cua tam: ");
		int y = kb.nextInt();
		tam = new Diem(x, y);
		System.out.print("Nhap ban kinh: ");
		bankinh = kb.nextInt();
	}
	
	public void in() {
		System.out.println("Tam O(" + tam.getX() + ", " + tam.getY() + ") co ban kinh R = " + bankinh);
	}
	
	public void doiDuongTron(int dx, int dy) {
		tam.setX(tam.getX() + dx);
		tam.setY(tam.getY() + dy);
	}
	
	public double dienTich() {
		return bankinh*bankinh*Math.PI;
	}
	
	public double chuVi() {
		return bankinh*2*Math.PI;
	}
	
	
	public boolean trongDuongTron(Diem d) {
		if(d.khoangcach(tam) < bankinh) return true;
		return false;
	}
	
	public boolean catNhau(DuongTron dt) {
		if(bankinh-dt.bankinh < tam.khoangcach(dt.tam) && tam.khoangcach(dt.tam) < bankinh+dt.bankinh) return true;
		return false;
	}
	
	public Diem layTam() {
		return tam;
	}
	
	public int layBanKinh() {
		return bankinh;
	}

}
