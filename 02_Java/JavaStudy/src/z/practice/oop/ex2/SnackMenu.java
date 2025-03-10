package z.practice.oop.ex2;

import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;

public class SnackMenu {
	private Scanner sc=new Scanner(System.in);
	
	private SnackController scr=new SnackController();
	
	public void menu() {
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		String kind=sc.nextLine();
		System.out.print("이름 : ");
		String name=sc.nextLine();
		System.out.print("맛 : ");
		String flavor=sc.nextLine();
		System.out.print("갯수 : ");
		int numOf=sc.nextInt();
		System.out.print("가격 : ");
		int price=sc.nextInt();
		
		SnackController sc1=new SnackController();
		sc1.savaData(kind,name,flavor,numOf,price);
		
		System.out.println("저장한 정보를 확인하시겠습니까?(y/n) : ");
		char a=sc.next().charAt(0);
		switch(a) {
			case 'y': System.out.println(sc1.confirmData());  
					break;
			case 'n': break;
		}
	}
}
