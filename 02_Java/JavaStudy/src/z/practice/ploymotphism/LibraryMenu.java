package z.practice.ploymotphism;

import java.util.Scanner;

public class LibraryMenu {
	private LibraryController lc=new LibraryController();
	private Scanner sc=new Scanner(System.in);
	
	public void mainMenu() {
		System.out.print("이름 : ");
		String name=sc.next();
		System.out.print("나이 : ");
		int age=sc.nextInt();
		System.out.print("성별 : ");
		char gender=sc.next().charAt(0);
		
		Member m=new Member(name,age,gender);
		lc.insertMember(m);
		
		while(true) {
		System.out.println("==== 메뉴 ====");
		System.out.println("1. 마이페이지");
		System.out.println("2. 도서 전체 조회");
		System.out.println("3. 도서 검색");
		System.out.println("4. 도서 대여하기 ");
		System.out.println("5. 도서 추가하기"); //추가 가능한지? 맨 뒤에 추가
		System.out.println("6. 도서 삭제하기"); //어떤 도서를 삭제할지?
		System.out.println("9. 프로그램 종료하기");
		System.out.print("메뉴 번호 :");
		
		int choice=sc.nextInt();
		
		switch(choice) {
		
		case 1: System.out.println(lc.myInfo());
				break;
		case 2: selectAll();
				break;
		case 3: searchBook();
				break;
		case 4: rentBook();
				break;
		case 9: System.out.println("프로그램을 종료합니다.");
			return;
		}
		}
		
	}
	
	public void selectAll() {
		Book[] bk=lc.selectAll();
		for(int i=0; i<bk.length; i++) {
			if(bk[i]==null) {
				break;
			}
			System.out.println(i+"번도서 : "+bk[i]);
		}
	}
	
	public void searchBook() {
		System.out.print("검색할 제목 키워드 : ");
		String keyword=sc.next();
		Book[] searchList=lc.searchBook(keyword);
		for(int i=0; i<searchList.length; i++) {
			if(searchList[i]==null) {
				break;
			}
			System.out.println(searchList[i]);
		}
	}
	
	public void rentBook() {
		selectAll();
		System.out.print("대여할 도서 번호 선택 :");
		int index=sc.nextInt();
		if(lc.rentBook(index)==0) {
			System.out.println("성공적으로 대여되어습니다.");
		}
		else if(lc.rentBook(index)==1) {
			System.out.println("나이 제한으로 대여 불가능입니다.");
		}
		else if(lc.rentBook(index)==2) {
			System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요");
		}
	}
}
