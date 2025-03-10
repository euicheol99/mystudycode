package z.practice.inherit.ex2;

public class PersonController {
	private Student[] s = new Student[3];
	private Employee[] e = new Employee[10];

	public int[] PersonCount() {
		int[] count = new int[2];
		for (int i = 0; i < s.length; i++) {
			if (s[i] == null) {
				break;
			}
			count[0]++;
		}
		for (int j = 0; j < e.length; j++) {
			if (e[j] == null) {
				break;
			}
			count[1]++;
		}
		return count;
	}

	public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
		for (int i = 0; i < s.length; i++) {
			if (s[i] == null) {
				s[i] = new Student(name, age, height, weight, grade, major);
				break;
			}
		}
	}

	public Student[] PrintStudent() {
		
		return s;
	}

	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {

	}

	public Employee[] printEmployee() {
		return null;
	}

}
