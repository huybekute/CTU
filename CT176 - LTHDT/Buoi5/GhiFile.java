package Buoi5;
import java.util.Scanner;
import java.io.*;

public class GhiFile {
	public static void main(String[] args) {
		try {
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap chuoi can ghi vao file: ");
			String a = kb.nextLine();
			FileOutputStream f1 = new FileOutputStream("Bai2.bin");
			ObjectOutputStream o1  = new ObjectOutputStream(f1);
			
			o1.writeObject(a);
			o1.close();
			f1.close();
			System.out.print("Ghi file thanh cong");
		}
		catch(Exception e) {
			System.out.println("Loi ghi file");
		}
	}
}
