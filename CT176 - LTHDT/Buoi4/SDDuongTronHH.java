package Buoi4;

public class SDDuongTronHH {
	public static void main(String[] args) {
		Diem d1 = new Diem(2, 5);
		DuongTronHH gc1 = new DuongTronHH(d1, 6, "den", "xanh");
		gc1.in();
		
		DuongTronHH gc2 = new DuongTronHH();
		gc2.nhap();
		gc2.in();
		System.out.println("Chu vi duong tron gc2 la: " + Math.round(gc2.chuVi()*100.0)/100.0);
		System.out.println("Dien tich duong tron gc2 la: " + Math.round(gc2.dienTich()*100.0)/100.0);
		
		gc2.doiDuongTron(1, 2);
		if(gc1.catNhau(gc2)) {
			System.out.println("gc1 va gc2 cat nhau");
		}
		else {
			System.out.println("gc1 va gc2 ko cat nhau");
		}
		
		if(gc1.equals(gc2)) {
			System.out.println("gc1 va gc2 bang nhau (trung nhau)");
		}
		else {
			System.out.println("gc1 va gc2 ko bang nhau (ko trung nhau)");
		}
	}
}
