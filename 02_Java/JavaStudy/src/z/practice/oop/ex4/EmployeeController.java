package z.practice.oop.ex4;

public class EmployeeController {
	private Employee e=new Employee();
	
	public void add(int empNo,String name,char gender,String phone) {
		e.setEmpNO(empNo);
		e.setGender(gender);
		e.setPhone(phone);
//		e=new Employee(empNo,name,gender,phone);
	}
	
	public void add(int empNo,String name,char gender,String phone,String dept,int salary,double bonus) {
		e.setEmpNO(empNo);
		e.setGender(gender);
		e.setPhone(phone);
		e.setBonus(bonus);
		e.setDept(dept);
		e.setSalary(salary);
		e.setName(name);
//		e=new Employee(empNo,name,gender,phone,dept,salary,bonus);
	}
	
	public void modify(String phone) {
		e.setPhone(phone);
	}
	
	public void modify(int salary) {
		e.setSalary(salary);
	}
	
	public void modify(double bonus) {
		e.setBonus(bonus);
	}
	
	public Employee remove() {
		e=null;
//		e.setBonus(0);
//		e.setDept(null);
//		e.setEmpNO(0);
//		e.setGender('\u0000');
//		e.setName(null);
//		e.setPhone(null);
//		e.setSalary(0);
		
		return e;
	}
	
	public String inform() {
		if(e==null) {
			return "사원 데이터가 없습니다.";
		}
		else {
			return e.printEmployee();
		}
		
	}
}
