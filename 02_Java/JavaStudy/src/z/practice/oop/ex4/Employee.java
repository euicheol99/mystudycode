package z.practice.oop.ex4;

public class Employee {
	private int empNO;
	private String name;
	private char gender;
	private String phone;
	private String dept;
	private int salary;
	private double bonus;
	
	public Employee() {
		super();
	}

	public Employee(int empNO, String name, char gender, String phone) {
		super();
		this.empNO = empNO;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
	}

	public Employee(int empNO, String name, char gender, String phone, String dept, int salary, double bonus) {
		super();
		this.empNO = empNO;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.dept = dept;
		this.salary = salary;
		this.bonus = bonus;
	}

	public int getEmpNO() {
		return empNO;
	}

	public void setEmpNO(int empNO) {
		this.empNO = empNO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public String printEmployee(){
		return this.getEmpNO()+" "+this.getName()+" "+this.getGender()+" "+this.getPhone()+" "+this.getDept()+" "+this.getSalary()+" "+this.getBonus();
	}
	
}
