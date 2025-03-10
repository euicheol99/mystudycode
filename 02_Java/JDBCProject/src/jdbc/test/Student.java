package jdbc.test;

public class Student {
	private String studentname;
	private int studentnum;
	private int grade;
	
	public Student() {
		super();
	}

	public Student(String name, int grade, int studentnum) {
		super();
		this.studentname = name;
		this.studentnum = studentnum;
		this.grade = grade;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public int getStudentnum() {
		return studentnum;
	}

	public void setStudentnum(int studentnum) {
		this.studentnum = studentnum;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [studentname=" + studentname + ", studentnum=" + studentnum + ", grade=" + grade + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
}
