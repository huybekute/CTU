package Buoi1;

import java.util.Scanner;
public class DanhSach {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap so phan tu cua danh sach: ");
		int n = kb.nextInt();
		float a[] = new float[n];
		System.out.println("Nhap cac phan tu cua danh sach: ");
		for(int i=0; i<n; i++) {
			while(true) {
				if(kb.hasNextFloat()) {
						a[i] = kb.nextFloat();
					break;
				}
				else {
					System.out.println("Tham so khong dung, vui long nhap lai");
					kb.next();
				}
			}
		}
		float max = 0;
		for(int i=0; i<n; i++) {
			if(max < a[i]) {
				max = a[i];
			}
		}
		System.out.println("So lon nhat trong DS la : " + max);
		float Tong = 0;
		for(int i=0; i<n; i++) {
			Tong += a[i];
		}
		System.out.println("Tong cac so tron DS la : " + Tong);
	}
}
