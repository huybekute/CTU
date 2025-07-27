package Buoi5;
import java.util.Scanner;

public abstract class ConVat {	
	private String giong;
	private String maulong;
	private double cannang;	
	
	public ConVat() {
		giong = new String();
		maulong = new String();
		cannang = 0;
	}
	
	public ConVat(String giong, String maulong, double cannang) {
		this.giong = new String(giong);
		this.maulong = new String(maulong);
		this.cannang = cannang;
	}
	
	public ConVat(ConVat a) {
		this.giong = new String(a.giong);
		this.maulong = new String(a.maulong);
		this.cannang = a.cannang;
	}
	
	public void makeCopy(ConVat a) {
		giong = new String(a.giong);
		maulong = new String(a.maulong);
		cannang = a.cannang;
	}
	
	public void nhap() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap giong: " );
		giong = kb.nextLine();
		System.out.print("Nhap mau long: " );
		maulong = kb.nextLine();
		System.out.print("Nhap can nang: " );
		cannang = kb.nextDouble();
		kb.nextLine();
	}
	
	public void in() {
		System.out.println("Giong: " + giong);
		System.out.println("Mau long: " + maulong);
		System.out.println("Can nang: " + cannang);
	}
	
	public abstract void keu();
	
	public String getGiong() {
		return giong;
	}
	
	public String getMauLong() {
		return maulong;
	}
	
	public double getCanNang() {
		return cannang;
	}
}
