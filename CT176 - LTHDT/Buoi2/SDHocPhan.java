package Buoi2;

public class SDHocPhan {
	public static void main(String[] args) {
		HocPhan hp1 = new HocPhan("CT176", "Lap trinh huong doi tuong", "", 3, 30, 30);
		System.out.print("Thong tin hp1: ");
		hp1.in();
		
		HocPhan hp2 = new HocPhan("CT188", "Nhap mon lap trinh web", "HTQL", 3, 30, 30);
		System.out.print("Nhap thong tin hp2: ");
		hp2.nhap();
		System.out.print("Thong tin hp2: ");
		hp2.in();
		System.out.print("Thong tin hoc phi hp2: " + hp2.hocPhi());
	}
}
