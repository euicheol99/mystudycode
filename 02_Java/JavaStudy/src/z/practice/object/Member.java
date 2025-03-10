package z.practice.object;

public class Member {
	String id;
	String pwd;
	String name;
	String phone;
	String email;
	int age;
	String gender;
	
	//alt + shift +s ->o (기본 생성자 생성)
	//객체가 생성될 때 무조건 작동
	public Member() {}
	
	public Member(String id,String pwd,String name) {
		this.id=id;
		this.pwd=pwd;
		this.name=name;
	}
	
	//호출을 했을 때 작동
	public void setInfo(String phone,String email,int age,String gender) {
		this.phone=phone;
		this.email=email;
		this.age=age;
		this.gender=gender;
	}
	public void toInfo() {
		System.out.println("id: "+ id +
				" pwd: "+this.pwd+
				" name: "+this.name+
				" phone: "+this.phone+
				" email: "+this.email+
				" age: "+this.age+
				" gender: "+this.gender);
	}
}
