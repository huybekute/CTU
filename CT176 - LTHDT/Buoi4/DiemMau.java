package Buoi4;
import java.util.Scanner;
public class DiemMau extends Diem{
	private String mau;
	
	public DiemMau() {
		super();
		mau = new String();
	}
	
	public DiemMau(Diem x, String a) {
		super(x);
		mau = new String(a);
	}
	
	public DiemMau(int x, int y, String a) {
		super(x, y);
		mau = new String(a);
	}
	
	public DiemMau (DiemMau a) {
		super(a);
		mau = new String(a.mau);
	}
	
	public void ganMau(String mau) {
		this.mau = mau;
	}
	
	public void nhap() {
		super.nhap();
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap mau: ");
		mau = kb.nextLine();
	}
	
	public void in() {
		super.in();
		System.out.println(" va co mau " + mau);
	}
	
	public String getMau() {
		return mau;
	}
	
}
