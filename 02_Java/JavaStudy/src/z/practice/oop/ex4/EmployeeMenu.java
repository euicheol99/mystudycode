package z.practice.oop.ex4;

import java.util.Scanner;

public class EmployeeMenu {
	private Scanner sc=new Scanner(System.in);
	private EmployeeController ec=new EmployeeController();
	
	
	public EmployeeMenu() {
		
	while(true) {
		System.out.println("1. 사원 추가");
		System.out.println("2. 사원 수정");
		System.out.println("3. 사원 삭제");
		System.out.println("4. 사원 출력");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호를 누르세요:");
		int num=sc.nextInt();
		
		switch(num) {
			case 1: this.insertEmp();
					break;
			case 2: this.updateEmp();
					break;
			case 3: this.deleteEmp();
					break;
			case 4: this.printEmp();
					break;
			case 9: System.out.println("프로그램을 종료합니다.");
					return;
			default: System.out.println("잘못입력하셨습니다.");
					break;
					
		}
	}

}
	
	public void insertEmp() {
		System.out.print("사원 번호 : ");
		int empNo=sc.nextInt();
		System.out.print("사원 이름 : ");
		String name=sc.next();
		System.out.print("사원 성별 : ");
		char gender=sc.next().charAt(0);
		System.out.print("전화 번호 : ");
		String phone=sc.next();
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n)");
		char ch=sc.next().charAt(0);
		
		switch(ch) {
		case 'y','Y':
			System.out.print("사원 부서 : ");
			String dept=sc.next();
			System.out.print("사원 연봉 : ");
			int salary=sc.nextInt();
			System.out.print("보너스 율 : ");
			double bonus=sc.nextDouble();
			ec.add(empNo, name, gender, phone,dept,salary,bonus);
		case 'n','N':
			ec.add(empNo, name, gender, phone);
		}
	}
	
	public void updateEmp() {
		System.out.println("가장 최신의 사원 정보를 수정하게 됩니다.");
		System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
		System.out.println("1. 전화번호\n"+"2. 사원 연봉\n"+"3. 보너스 율\n"+"9. 돌아가기");
		System.out.print("메뉴 번호를 누르세요 :");
		int num=sc.nextInt();
		
		switch(num) {
		case 1: System.out.print("수정할 전화번호 : ");
				String phone=sc.next();
				ec.modify(phone);
				//ec.modify(sc.next()); 이거 하나로 2줄 쓸 필요가 없어짐
				break;
		
		case 2: System.out.print("수정할 사원 연봉 : ");
				int salary=sc.nextInt();
				ec.modify(salary);
				//ec.modify(sc.nextInt());
				break;
		
		case 3: System.out.print("수정할 보너스 율 : ");
				double bonus=sc.nextDouble();
				ec.modify(bonus);
				break;
				
		case 9: System.out.println("메인메뉴로 돌아갑니다.");
				break;
		
		default: System.out.println("잘못입력하셨습니다.");
				break;
		}
	}
	
	public void deleteEmp() {
		System.out.print("정말 삭제하시겠습니까? (y/n) :");
		char ch=sc.next().charAt(0);
		
		switch(ch) {
		case 'y','Y':
			ec.remove();
			
			if (ec.remove() == null) {
			    System.out.println("데이터 삭제에 성공하였습니다.");
			}
			break;

		case 'n','N':
			break;
		}
	}
	
	public void printEmp() {
		
			System.out.println(ec.inform());
		
	}
	
	
}
