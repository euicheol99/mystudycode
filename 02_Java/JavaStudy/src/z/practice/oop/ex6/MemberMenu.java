package z.practice.oop.ex6;

import java.util.Scanner;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);

	private MemberController mc = new MemberController();

	public MemberMenu() {

	}

	public void mainMenu() {
		while (true) {
			System.out.println("최대 등록 가능한 회원 수는 10명입니다.");
			System.out.printf("현재 등록된 회원 수는 %d명입니다.\n", mc.existMemberNum());
			if (mc.existMemberNum() == mc.SIZE) {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
			}
			if (mc.existMemberNum() < mc.SIZE) {
				System.out.println("1. 새 회원 등록 ");
			}
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모두 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				insertMember();
				break;
			case 2:
				searchMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				deleteMember();
				break;
			case 5:
				printAll();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}

		}
	}

	public void insertMember() {
		String id =null;
		while (true) {
			System.out.print("아이디 : ");
			id = sc.next();
			if (mc.checkId(id)) {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
				id=null;
			} else {
				break;
			}
		}
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		char gender='\u0000';
		while (true) {
			System.out.print("성별(M/F) : ");
			gender = sc.next().toUpperCase().charAt(0);
			if (gender != 'M' && gender != 'F') {
				System.out.println("성별을 다시 입력하세요.");
			} else {
				break;
			}
		}
		System.out.print("나이 : ");
		int age=sc.nextInt();
		mc.insertMember(id, name, password, email, gender, age);

	}

	public void searchMember() {
		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.println("메뉴 번호 :");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1: searchId();
				break;
		case 2: searchName();
				break;
		case 3: searchEmail();
				break;
		case 9: System.out.println("메인으로 돌아갑니다.");
				return;
		default: System.out.println("잘못 입력하셨습니다.");
				return;
		}
	}

	public void searchId() {
		System.out.println("검색할 아이디 : ");
		String id=sc.next();
		if(mc.searchId(id)==null) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			System.out.println(mc.searchId(id));
		}
	}

	public void searchName() {
		System.out.println("검색할 이름 : ");
		String name=sc.next();
		if(mc.searchName(name)==null) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for(Member m:mc.searchName(name)) {
				if(m==null) {
					return;
				}
				else {
					System.out.println(m.inform());
				}
			}
		}
	}

	public void searchEmail() {
		System.out.println("검색할 이메일 : ");
		String email=sc.next();
		if(mc.searchEmail(email)==null) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for(Member m:mc.searchEmail(email)) {
				if(m==null) {
					return;
				}
				else {
					System.out.println(m.inform());
				}
			}
		}
	}

	public void updateMember() {
		System.out.println("1. 비밀번호 수정하기");
		System.out.println("2. 이름 수정하기");
		System.out.println("3. 이메일 수정하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.println("메뉴 번호 : ");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1: updatePassword();
				break;
		case 2: updateName();
				break;
		case 3: updateEmail();
				break;
		case 9: System.out.println("메인으로 돌아갑니다.");
				return;
		default: System.out.println("잘못 입력하셨습니다.");
				return;
		}
	}

	public void updatePassword() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.next();
		System.out.print("수정할 비밀번호 : ");
		String password = sc.next();
		
		if(!mc.updatePassword(id, password)) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		} else {
			System.out.println("수정이 성공적으로 되었습니다.");
		}
	}

	public void updateName() {

	}

	public void updateEmail() {

	}

	public void deleteMember() {

	}

	public void deleteOne() {

	}

	public void deleteAll() {

	}

	public void printAll() {

	}
}
