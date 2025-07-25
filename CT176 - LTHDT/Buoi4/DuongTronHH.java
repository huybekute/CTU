package Buoi4;
import java.util.Scanner;

public class DuongTronHH extends DuongTron {
	private String maubien;
	private String maunen;
	
	public DuongTronHH() {
		super();
		maubien = new String();
		maunen = new String();
	}
	
	public DuongTronHH(Diem tam, int bankinh, String maubien, String maunen) {
		super(tam, bankinh);
		this.maubien = maubien;
		this.maunen = maunen;
	}
	
	public DuongTronHH(int x, int y, int bankinh, String maubien, String maunen) {
		super(x, y, bankinh);
		this.maubien = maubien;
		this.maunen = maunen;
	}
	
	public DuongTronHH(DuongTronHH a) {
		super(a);
		maubien = new String(a.maubien);
		maunen = new String(a.maunen);
	}
	
	public void makeCopy(DuongTronHH a) {
		super.makeCopy(a);
		maubien = new String(a.maubien);
		maunen = new String(a.maunen);
	}
	
	public void nhap() {
		Scanner kb = new Scanner(System.in);
		super.nhap();
		System.out.print("Nhap mau bien: ");
		maubien = kb.nextLine();
		System.out.print("Nhap mau nen: ");
		maunen = kb.nextLine();
	}
	
	public void in() {
		super.in();
		System.out.println(" co mau bien la " + maubien + " va mau nen la " + maunen);
	}
	
	public boolean equals(DuongTronHH a) {
		return (super.equals(a) && this.maubien.equals(a.maubien) && this.maunen.equals(a.maunen));
	}
	
	public String layMauBien() {
		return maubien;
	}
	
	public String layMauNen() {
		return maunen;
	}

}
