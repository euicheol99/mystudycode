package z.practice.object;

public class Run {
	public static void main(String[] args) {
		Member m1=new Member("ronald","sss","정의철");
		Member m2=new Member();
		Member m3=new Member();
		
		m1.setInfo("010-1234-5678", "sss@naver.com", 20, "남");
		m1.toInfo();
		
		m2=new Member("mama","ddd","최지원");
		m2.toInfo();
		
		m3=new Member("papa","dss","윤석열");
		m3.setInfo("010-6789-9876", "ssss@naver.com", 55, "여");
		m3.toInfo();
		
		

		
	}
	

}
