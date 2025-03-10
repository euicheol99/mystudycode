package z.practice.oop.ex5;

public class StudentMenu {
	private StudentController ssm=new StudentController();

	public StudentMenu() {
		System.out.println("===== 학생 정보 출력 =====");
		Student[] stuArr=ssm.printStudent();
		for(Student st: stuArr) {
			System.out.println(st.inform());;
		}
		//printStudent()에서 student배열 타입으로 반환해주므로 똑같이 배열 타입으로 받아준다.
		
		System.out.println("===== 학생 성적 출력 =====");
		double[] result =ssm.avgScore();
		System.out.println("학생 점수 합계 : "+result[0]);
		System.out.println("학생 점수 평균 : "+result[1]);
		//StudentController에 avgScore()를 통해 점수 합계와 평균 출력
		System.out.println("===== 성적 결과 출력 ===== ");
		
		for(Student st: stuArr) {
			String res = st.getScore() >= ssm.CUT_LINE ? "통과" : "재시험 대상";
			System.out.println(st.getName()+"학생은 "+res+"입니다.");
		}
		//
		
	}
	

}
