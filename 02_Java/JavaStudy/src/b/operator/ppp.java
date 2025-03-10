package b.operator;

import java.util.Scanner;

public class ppp {
	 /* 키보드로 가로, 세로 값을 실수형으로 입력받아 사각형의 면적과 둘레를 계산하여 출력
	 * 면적 : 가로 * 세로
	 * 둘레 : (가로 + 세로) *2
	 * 
	 * [출력창]
	 * 가로 : (키보드로 입력)
	 * 세로 : (키보드로 입력)
	 * 
	 * 면적 : ~
	 * 둘레 : ~
	 * + 소수점 2번째자리까지만 출력
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.printf("가로 :");
		float a = sc.nextFloat();
				
		System.out.printf("세로 :");
		float b = sc.nextFloat();
		
		float c= a*b;
		float d=((a+b)*2);
		System.out.printf("면적 :%.2f",c );
		System.out.printf("둘레 :%.2f",d);
		
	}
}
