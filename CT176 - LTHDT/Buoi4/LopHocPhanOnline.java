package Buoi4;

import java.util.Scanner;
public class LopHocPhanOnline extends LopHocPhan{
	private int tietonline;
	private String linklop;
	private String linkthi;
	
	public LopHocPhanOnline() {
		super();
		tietonline = 0;
		linklop = new String();
		linkthi = new String();
	}
	
	//them hamxd co nhieu tham so
	public LopHocPhanOnline(LopHocPhan a, int tietonline, String linklop, String linkthi) {
		super(a);
		this.tietonline = tietonline;
		this.linklop = linklop;
		this.linkthi = linkthi;
	}
	
	public LopHocPhanOnline(LopHocPhanOnline a) {
		super(a);
		tietonline = a.tietonline;
		this.linklop = new String(a.linklop);
		this.linkthi = new String(a.linkthi);
	}
	
	public void makeCopy(LopHocPhanOnline a) {
		super.makeCopy(a);
		tietonline = a.tietonline;
		this.linklop = new String(a.linklop);
		this.linkthi = new String(a.linkthi);
	}
	
	public void nhap() {
		Scanner kb = new Scanner(System.in);
		super.nhap();
		System.out.print("Nhap so tiet online: ");
		tietonline = kb.nextInt();
		kb.nextLine();
		System.out.print("Nhap link lop: ");
		linklop = kb.nextLine();
		System.out.print("Nhap link thi: ");
		linkthi = kb.nextLine();
	}
	
	public void in() {
		super.in();
		System.out.println("so tiet online: " + tietonline);
		System.out.println("link lop: " + linklop);
		System.out.println("link thi:  " + linkthi	);
	}
	
	public int layTietOnline() {
		return tietonline;
	}
	
	public String layLinkLop() {
		return linklop;
	}
	
	public String layLinkThi() {
		return linkthi;
	}
	
	public double tinhTyLeOnline() {
		int tongTiet = this.getHP().getsoTietLT() + this.getHP().getsoTietTH();
		if(tongTiet == 0) return 0;
		return (tietonline * 100.0) / tongTiet;
	}
}
