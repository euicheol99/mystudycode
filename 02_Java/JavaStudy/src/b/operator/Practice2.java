package b.operator;

import java.util.Scanner;

public class Practice2 {
	/*
	 * 키보드로 정수 2개를 입력받아 두 수의 합,차,곱,나누기 값을 출력해라
	 *
	 * [출력창]
	 * 첫번째 정수: (키보드 입력)
	 * 두번째 정수: (키보드 입력)
	 *
	 * 더하기 : n
	 * 빼기 : n
	 * 곱하기 : n
	 * 나누기 : n
	 * */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 정수:");
		int a = sc.nextInt();
		
		System.out.println("두번쨰 정수:");
		int b = sc.nextInt();
		
		System.out.printf("더하기: %d \n",a+b);
		System.out.printf("빼기: %d \n",a-b);
		System.out.printf("곱하기: %d \n",a*b);
		System.out.printf("나누기: %d \n",a/b);
		
		
		
	}

}
