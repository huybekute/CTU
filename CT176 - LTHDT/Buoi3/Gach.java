package Buoi3;
import java.util.Scanner;
public class Gach {
	private String maso;
	private String mau;
	private int sl;
	private int dai;
	private int ngang;
	private long gia;
	
	public Gach() {
		maso = new String();
		mau = new String();
		sl = 0;
		dai = 0;
		ngang = 0;
		gia = 0;
	}
	
	public Gach(String maso, String mau, int sl, int dai, int ngang, int gia) {
		this.maso = new String(maso);
		this.mau = new String(mau);
		this.sl = sl;
		this.dai = dai;
		this.ngang = ngang;
		this.gia = gia;
	}
	
	public Gach(Gach a) {
		this.maso = new String(a.maso);
		this.mau = new String(a.mau);
		this.sl = a.sl;
		this.dai = a.dai;
		this.ngang = a.ngang;
		this.gia = a.gia;
	}
	
	public void makeCopy(Gach a) {
		this.maso = new String(a.maso);
		this.mau = new String(a.mau);
		this.sl = a.sl;
		this.dai = a.dai;
		this.ngang = a.ngang;
		this.gia = a.gia;
	}
	
	public void nhap() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap ma so: ");
		maso = kb.nextLine();
		System.out.print("Nhap mau: ");
		mau = kb.nextLine();
		System.out.print("Nhap so luong moi hop: ");
		sl = kb.nextInt();
		kb.nextLine();
		System.out.print("Nhap chieu dai: ");
		dai = kb.nextInt();
		kb.nextLine();
		System.out.print("Nhap chieu ngang: ");
		ngang = kb.nextInt();
		kb.nextLine();
		System.out.print("Nhap gia: ");
		gia = kb.nextInt();
		kb.nextLine();
	}
	
	public void in() {
		System.out.println("Ma so: " + maso);
		System.out.println("Mau: " + mau);
		System.out.println("So luong moi hop: " + sl);
		System.out.println("Chieu dai: " + dai);
		System.out.println("Chieu ngang: " + ngang);
		System.out.println("Gia: " + gia);
	}
	
	public float giaBanLe() {
		return (gia * 0.2f) /sl;
	}
	
	public float dienTichToiDa() {
		return (float) (dai)*ngang*sl;
	}
	
	public int soLuongHop(int D, int N) {
		int dienTich = D*N;
		float dienTichHop = dienTichToiDa();
		int soHop = (int)Math.ceil(dienTich/dienTichHop);
		return soHop;
	}
	
	
}
