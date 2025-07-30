package Buoi3E;
import java.util.Scanner;
import java.io.*;

public class SDThueBaoInternet {
	public static void main(String[] args) {
		//Tạo 1 thuê bao a tổng quát. Nhập thông tin cho a. Hiển thị thông tin của thuê bao a.
		ThueBaoInternet a = new ThueBaoInternet();
		a.nhap();
		a.in();
		
		// Nhập 1 danh sách (mảng) gồm n thuê bao (n: nhập từ bàn phím)
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap so thue bao internet: ");
		int n = kb.nextInt();
		kb.nextLine();
		ThueBaoInternet[] tb = new ThueBaoInternet[n];
		for(int i=0; i<n; i++) {
			tb[i] = new ThueBaoInternet();
			tb[i].nhap();
		}
		
		//Tìm thuê bao có tiền cước phải trả hàng tháng cao nhất trong danh sách.
		int max = 0;
		int vitri = 0;
		for(int i=0; i<n; i++) {
			if(tb[i].tinhCuoc() > max) {
				max = tb[i].tinhCuoc();
				vitri = i;
			}
		}
		System.out.println("Thue bao co tien cuoc phai tra hang thang cao nhat: ");
		tb[vitri].in();
		
		//Tính tổng tiền cước phải thu cho danh sách thuê bao trên,.
		
		int tong  = 0;
		for(int i=0; i<n; i++) {
			tong += tb[i].tinhCuoc();
		}
		System.out.println("Tong tien cuoc cho danh sach thue bao la: " + tong);
		
		//Hiển thị ra màn hình thông tin thuê bao được sắp xếp theo ngày đăng ký tăng dần.
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(tb[i].layNgayDangKy().soSanh(tb[j].layNgayDangKy()) > 0) {
					ThueBaoInternet temp = tb[i];
					tb[i] = tb[j];
					tb[j] = temp;
				}
			}
		}
		
		//Nhập 1 số CCCD  x. Tìm thông tin các thuê bao của CCCD đó.
		
		System.out.print("Nhap so cccd can tim: ");
		String cc = kb.nextLine();
		for(int i=0; i<n; i++) {
			if(cc.equals(tb[i].getCCCD())) {
				tb[i].in();
			}
		}
		
		// Lưu danh sách trên vào file TBInternet.ser theo tuần tự hóa đối tượng.
		
		try {
			FileOutputStream f1 = new FileOutputStream("TBInternet.ser");
			ObjectOutputStream o1 = new ObjectOutputStream(f1);
			
			for(int i=0; i<n; i++) {
				o1.writeObject(tb[i]);
			}
			
			o1.close();
			f1.close();
			System.out.println("Ghi file thanh cong");
		}
		catch(Exception e) {
			System.out.println("Loi ghi file");
		}
		
		//Tìm họ tên người đăng ký nhiều tài khoản thuê bao Internet nhất trong danh sách.
		int maxDem = 0;
		String hotenMax = "";
		for(int i=0; i<n; i++) {
			String hotenI = tb[i].getHoTen();
			int dem = 0;
			for(int j=0; j<n; j++) {
				if(j!=i && hotenI.equals(tb[j].getHoTen())) {
					dem++;
				}
			}
			if(dem > maxDem) {
				maxDem = dem;
				hotenMax = hotenI;
			}
		}
		System.out.print("Ho ten nguoi dang ky nhieu tai khoan thue bao Internet nhat la : "+ hotenMax);
	}
}
