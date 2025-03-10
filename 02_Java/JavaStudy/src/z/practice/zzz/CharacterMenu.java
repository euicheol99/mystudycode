package z.practice.zzz;

import java.util.Scanner;

public class CharacterMenu {
	public void menu() {
		CharacterController cc = new CharacterController();
		Scanner sc = new Scanner(System.in);

		System.out.print("문자열 : ");
		String str = sc.next();
		
		try {
			System.out.println("'" + str + "'에 포함된 영문자 개수 : " + cc.countAlpha(str));
		} catch (CharCheckException e) {
			e.printStackTrace();
		}
		System.out.println("종료됩니다.");
	}
}
