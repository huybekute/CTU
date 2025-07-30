package Buoi3;
import java.util.Scanner;

public class SDSinhVien {
	public static void main(String[] args) {
//		SinhVien sv1 = new SinhVien();
//		sv1.nhap();
//		sv1.dangKyHP("LTHDT");
//		sv1.in();
		
		int n;
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap so luong sinh vien: ");
		n = kb.nextInt();
		kb.nextLine();
		SinhVien[] sv = new SinhVien[n];
		for(int i=0; i<n; i++) {
			sv[i] = new SinhVien();
			sv[i].nhap();
		}
		
		
		//Tim cac sv bi canh cao hoc vu
		
		boolean flag = false;
		for(int i=0; i<n; i++) {
			if(sv[i].tinhDiemTB() < 1.0) {
				flag = true;
				break;
			}
		}
		if(flag) System.out.println("Danh sach sinh vien bi canh cao hoc vu: ");
		for(int i=0; i<n; i++) {
			if(sv[i].tinhDiemTB() < 1.0) {
				System.out.println((i+1) + " - " + sv[i].getHoTen());
			}
		}
		
		
		double max = 0;
		int vitri = 0;
		System.out.println("Sinh vien co diem tb cao nhat lop: ");
		for(int i=0; i<n; i++) {
			if(sv[i].tinhDiemTB() > max) {
				max = sv[i].tinhDiemTB();
				vitri = i;
			}
		}
		sv[vitri].in();	
		
		//sx sinh vien theo alphabet
		System.out.println("Danh sach sinh vien xep theo thu tu A->Z");
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				String tenI = sv[i].tachTen(sv[i].getHoTen());
				String tenJ = sv[j].tachTen(sv[j].getHoTen());
				if(tenI.compareToIgnoreCase(tenJ) > 0) {
					SinhVien temp = sv[i];
					sv[i] = sv[j];
					sv[j] = temp;
				}
			}
		}

		
		for(int i=0; i<n; i++) {
			sv[i].in();
		}
		
	}
}
