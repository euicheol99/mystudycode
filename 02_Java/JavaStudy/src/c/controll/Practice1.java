package c.controll;

import java.util.Scanner;

public class Practice1 {
		/*
		 * 나이를 입력받아
		 * 13세이하면:어린이
		 * 13세초과 19세 이하: 청소년
		 * 19세 초과: 성인
		 * 
		 * [출력문]
		 * 나이를 입력:xx
		 * xx세는 xx에 속합니다.
		 * */
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("나이를 입력:");
//		int age=sc.nextInt();
//		
//		if (age<=13) {
//			System.out.printf("%d세는 어린이에 속합니다.",age);
//		}
//		else if(age>13 && age<=19){
//			System.out.printf("%d세는 청소년에 속합니다.",age);
//		}
//		else {
//			System.out.printf("%d세는 성인에 속합니다.",age);
//		}
//				
//	}
	public static void main(String[] args) {
		/*
		 * 성별을 (m/f)(대소문자 상관x)로 입력받아 남학생인지 여학생인지
		 * 출력하는 프로그램을 작성하세요.
		 * 
		 * [출력문]
		 * 성별(m/f) : x
		 * 여학생입니다 / 남학생입니다 / 잘못입력하셨습니다.
		 * */
		Scanner sc = new Scanner(System.in);
		
		
//		System.out.println("성별(m/f) :");
//		char gender= sc.next().charAt(0);
//		if (gender == 'm' || gender =='M') {
//			System.out.println("남학생입니다.");
//		}
//		else if(gender =='f' || gender=='F'){
//			System.out.println("여학생입니다.");	
//		}
//		else {System.out.println("잘못입력하셨습니다.");}
		
		/*
		 * 정수(양수)를 입력받아
		 * 짝수인지 홀수인지 출력하는 프로그램을 작성하라
		 * 
		 * [출력문]
		 * 정수 입력 : xx
		 * 짝수다 / 홀수다 / 양수가 아니다.
		 * */
		
		System.out.println("정수 입력 :");
		int a =sc.nextInt();
		if(a==0) {
			System.out.println("0이다.");
		}
		else if(a%2==0) {
			System.out.println("짝수다.");
		}
		else if (a%2==1) {
			System.out.println("홀수다.");
		}
		else {System.out.println("양수가 아니다.");}
		
		int num;
		
		// a>0일 경우를 만들고 그안에 또 if문을 만들어서 짝수,홀수를 구분하는거 만들고 a<=0일때 양수가 아니다 뜨도록
		
			
	}

}
