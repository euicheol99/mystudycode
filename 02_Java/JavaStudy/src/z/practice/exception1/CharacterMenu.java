package z.practice.exception1;

import java.util.Scanner;

public class CharacterMenu {
	Scanner sc=new Scanner(System.in);
	
	public void menu() {
		try {
		System.out.print("문자열 : ");
		String str=sc.nextLine();
		
		CharacterController cc=new CharacterController();
		System.out.println("'"+str+"'"+"에 포함된 영문자 개수 : "+
		cc.countAlpha(str));}catch(CharCheckException e) {
			e.printStackTrace();
		}
		System.out.println("종료합니다.");
	}
}
