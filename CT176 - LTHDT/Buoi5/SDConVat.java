package Buoi5;
import java.util.Scanner;

public class SDConVat {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap so con vat: ");
		int sl = kb.nextInt();
		ConVat[] cv = new ConVat[sl];
		for(int i=0; i<sl; i++) {
			System.out.print("Nhap ten con vat: ( 1:Bo, 2: De, 3:Heo, 4: Ga) " );
			int loai = kb.nextInt();
			kb.nextLine();
			if(loai == 1) {
				cv[i] = new Bo();
			}
			else if(loai == 2) {
				cv[i] = new De();
			}
			else if(loai == 3) {
				cv[i] = new Heo();
			}
			else if(loai == 4) {
				cv[i] = new Ga();
			}
			else {
				System.out.print("Ten con vat ko hop le, vui long nhap lai");
				i--;
				continue;
			}
			cv[i].nhap();
		}
		
		System.out.println("DS con vat");
		for(int i=0; i<sl; i++) {
			System.out.println("Con vat thu " + (i + 1) + ":");
			cv[i].in();
			System.out.print("Tieng keu: ");
			cv[i].keu();
		}
	}
}
