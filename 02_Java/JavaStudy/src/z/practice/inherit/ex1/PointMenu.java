package z.practice.inherit.ex1;

import java.util.Scanner;


/*
 * Menu클래스의 역할
 * 프레젠테이션 뷰의 역할
 * : 사용자와의 소통을 위한 클래스(입출력) 
 * */


public class PointMenu {
	private Scanner sc=new Scanner(System.in);
	private CircleController cc=new CircleController();
	private RectangleController rc=new RectangleController();
	
	public void mainMenu() {
		while(true) {
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 원");
		System.out.println("2. 사각형");
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : ");
		
		int choice=sc.nextInt();
		switch(choice) {
		case 1: this.circleMenu();
				break;
				
		case 2: this.rectangleMenu();
				break;
				
		case 9: return;
		
		default: System.out.println("다시 입력하세요.");
				break;
		}
		}
	}
	
	public void circleMenu() {
		System.out.println("===== 원 메뉴 =====");
		System.out.println("1. 원 둘레");
		System.out.println("2. 원 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int choice=sc.nextInt();
		
		switch(choice) {
			case 1: calcCircum();
					break;
			case 2: calcCircleArea();
					break;
			
			default: return;
		}
	}
	
	public void rectangleMenu() {
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 넓이");
		System.out.println("3. 메인으로");
		System.out.print("메뉴 번호 : ");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1: calcPerimeter();
				break;
		case 2: calcRectArea();
				break;
		
		default: return;
	}
	}
	
	public void calcCircum() {
		System.out.print("x좌표 : ");
		int x=sc.nextInt();
		System.out.print("y좌표 : ");
		int y=sc.nextInt();
		System.out.print("반지름 : ");
		int r=sc.nextInt();
		System.out.println(cc.calcCircum(x, y, r));
		;
	}
	
	public void calcCircleArea() {
		System.out.print("x좌표 : ");
		int x=sc.nextInt();
		System.out.print("y좌표 : ");
		int y=sc.nextInt();
		System.out.print("반지름 : ");
		int r=sc.nextInt();
		System.out.println(cc.calcArea(x, y, r));
				
	}
	
	public void calcPerimeter() {
		System.out.print("x좌표 : ");
		int x=sc.nextInt();
		System.out.print("y좌표 : ");
		int y=sc.nextInt();
		System.out.print("높이 : ");
		int height=sc.nextInt();
		System.out.println("너비 : ");
		int width=sc.nextInt();
		System.out.println(rc.calcPerimeter(x, y, height, width));
		
	}
	
	public void calcRectArea() {
		System.out.print("x좌표 : ");
		int x=sc.nextInt();
		System.out.print("y좌표 : ");
		int y=sc.nextInt();
		System.out.print("높이 : ");
		int height=sc.nextInt();
		System.out.println("너비 : ");
		int width=sc.nextInt();
		System.out.println(rc.calcArea(x, y, height, width));
		
	}
	
	
}
