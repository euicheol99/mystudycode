package z.practice.io.ex1;

import java.util.Scanner;

public class FileMenu {
	Scanner sc = new Scanner(System.in);
	FileController fc = new FileController();

	public void mainMenu() {
		while (true) {
			System.out.println("***** My Note *****");
			System.out.println("1. 노트 새로 만들기");
			System.out.println("2. 노트 열기");
			System.out.println("3. 노트 열어서 수정하기");
			System.out.println("9. 끝내기");
			System.out.println("메뉴 번호 : ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				fileSave();
				break;
			case 2:
				fileOpen();
				break;
			case 3:
				fileEdit();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public void fileSave() {
		/*
		 * StringBuilder
		 * 가변문자열을 처리하는 클래스이다. 문자열을 수정할 때 새로운 객체를 생성하지않고
		 * 내부 버퍼를 이용해서 성능을 최적화한ㄷ.(String과 비슷한 역할을 함)
		 * */
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			System.out.println("파일에 저장할 내용을 입력하세요.");
			System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
			System.out.print("내용 : ");
			
			String st = sc.next();
			if (st.equals("ex끝it")) {
				System.out.println("저장할 파일 명을 입력해주세요(ex. myFile.txt) :");
				String fm=sc.next();
				if(fc.checkName(fm)) {
					System.out.println("이미 존재하는 파일입니다. 덮어쓰시겠습니다?(y/n)");
					char yn=sc.next().toUpperCase().charAt(0);
					switch(yn) {
					case 'Y': fc.fileSave(fm, sb);
							return;
					case 'N': 
						while(true) {System.out.println("저장할 파일 명을 입력해주세요 : ");
							fm=sc.next();
							if(!fc.checkName(fm)) {
								break;
							}
						}
					}
				}
					fc.fileSave(fm, sb);
					return;
			}
			sb.append(st + "\n");
		}
	}

	public void fileOpen() {
		System.out.println("열 파일 명 : ");
		String file=sc.nextLine();
		
		if(fc.checkName(file)) {
			System.out.println("fc.fileOPen(file)");
		}
		else {
			System.out.println("없는 파일입니다.");
			return;
		}
	}

	public void fileEdit() {
			
	}
}
