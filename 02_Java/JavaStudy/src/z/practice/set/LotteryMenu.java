package z.practice.set;

import java.util.Scanner;

public class LotteryMenu {
	private Scanner sc = new Scanner(System.in);
	private LotteryController lc = new LotteryController();

	public void mainMenu() {
		while (true) {
			System.out.println("========== KH 추첨 프로그램 ==========");
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 추첨 대상 추가");
			System.out.println("2. 추첨 대상 삭제");
			System.out.println("3. 당첨 대상 확인 ");
			System.out.println("4. 정렬된 당첨 대상 확인");
			System.out.println("5. 당첨 대상 검색");
			System.out.println("9. 종료");
			System.out.println("메뉴 번호 선택 :");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				insertObject();
				break;
			case 2:
				deleteObject();
				break;
			case 3:
				winObject();
				break;
			case 4:
				sortedWinObject();
				break;
			case 5:
				searchWinner();
				break;
			case 9:
				System.out.println("프로그램 종료.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
		}
	}

	public void insertObject() {
		System.out.println("추가할 추첨 대상 수 :");
		int count=sc.nextInt();
		for(int i=0; i<count; i++) {
			System.out.print("이름 : ");
			String name=sc.next();
			System.out.print("핸드폰 번호('-'빼고) : ");
			String phone=sc.next();
		}
	}

	public void deleteObject() {

	}

	public void winObject() {

	}

	public void sortedWinObject() {

	}

	public void searchWinner() {

	}

}
