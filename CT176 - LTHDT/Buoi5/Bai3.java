package Buoi5;
import java.io.*;
public class Bai3 {
	public static void main(String[] args) {
		try {
			FileInputStream f1 = new FileInputStream("Bai2.bin");
			ObjectInputStream o1 = new ObjectInputStream(f1);
			String a = (String) o1.readObject();
			System.out.print("Chuoi doc duoc trong file: ");
			System.out.println(a);
			o1.close();
			f1.close();
			
			//ghi vao file khac
			FileOutputStream fGhi =  new FileOutputStream("Bai3.bin");
			ObjectOutputStream oGhi = new ObjectOutputStream(fGhi);
			
			oGhi.writeObject(a);
			oGhi.close();
			fGhi.close();
			System.out.print("Da ghi chuoi a vao file Bai3.bin");
		}
		catch(Exception e) {
			System.out.print("Loi " + e.getMessage());
		}
	}
}
