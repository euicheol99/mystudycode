package z.practice.collection.ex1;

import java.util.Scanner;

public class MusicView {
	Scanner sc = new Scanner(System.in);
	MusicController mc = new MusicController();

	public void mainMenu() {
		while (true) {
			System.out.println("1. 마지막 위치에 곡 추가 ");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보 수정 ");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 :");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				addList();
				break;
			case 2:
				addAtZero();
				break;
			case 3:
				printAll();
				break;
			case 4:
				searchMusic();
				break;
			case 5:
				removeMusic();
				break;
			case 6:
				setMusic();
				break;
			case 7:
				ascTitle();
				break;
			case 8:
				descSinger();
				break;
			case 9:
				System.out.println("종료");
				return;
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력하세요");
			}
		}
	}

	public void addList() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 :");
		String music=sc.nextLine();
		System.out.print("가수 명 : ");
		String singer=sc.next();
		mc.addList(new Music(music,singer));
		

	}

	public void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.print("곡 명 :");
		String music=sc.nextLine();
		System.out.println("가수 명 : ");
		String singer=sc.next();
		int result=mc.addAtZero(new Music(music,singer));
		if(result==1) {
			System.out.println("추가 성공");
		}
		else {System.out.println("추가 실패");}
	}	

	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		System.out.println(mc.printAll());
	}

	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("검색할 곡 명 : ");
		String title=sc.next();
		System.out.println(mc.searchMusic(title));
	}

	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.println("삭제할 곡 명 : ");
		String title=sc.next();
		if(mc.removeMusic(title)==null) {
			System.out.println("수정할 곡이 없습니다.");
		}
		else {
			System.out.println(mc.removeMusic(title)+"을(를) 삭제했습니다.");
		}
	}

	public void setMusic() {

	}

	public void ascTitle() {

	}

	public void descSinger() {

	}
}
