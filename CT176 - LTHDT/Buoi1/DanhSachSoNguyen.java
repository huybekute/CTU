package Buoi1;

import java.util.Scanner;

public class DanhSachSoNguyen {
	public static Scanner kb = new Scanner(System.in);
	public static void nhapDS(int a[], int n) {
		System.out.println("Nhap cac phan tu cua DS: ");
		for(int i=0; i<n; i++) {
			while(true) {
				if(kb.hasNextInt()) {
					a[i] = kb.nextInt();
					break;
				}
				else {
					System.out.println("khong phai so nguyen, vui long nhap lai");
					kb.next();
				}
			}
		}
	}
	public static int dem(int a[], int x, int n) {
		int count = 0;
		for(int i=0; i<n; i++) {
			if(a[i] == x) {
				count++;
			}
		}
		return count;
	}
	public static void sapXep(int a[], int n) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i] < a[j]) {
					int tam = a[i];
					a[i] = a[j];
					a[j] = tam;
				}
			}
		}
	}
	public static void inDS(int a[], int n) {
		for(int i=0; i<n; i++) {
			System.out.print(a[i] + " ");
		}
	}
	public static void main(String[] args) {
		System.out.print("Nhap so phan tu cua DS: ");
		int n = kb.nextInt();
		int a[] = new int[n];
		nhapDS(a, n);
		int x = kb.nextInt();
		System.out.println(dem(a, x, n));
		sapXep(a, n);
		inDS(a, n);
	}
}
