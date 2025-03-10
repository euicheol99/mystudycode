package z.practice.oop.ex6;

public class MemberController {
	private Member[] m = new Member[SIZE];
	public static final int SIZE = 10;

	public int existMemberNum() {
		int count = 0;
		for (int i = 0; i < SIZE; i++) {
			if (m[i] == null) {
				return count;
			} else {
				count++;
			}
		}
		return count;
	}

	public Boolean checkId(String inputId) {
		// true이면 중복 false면 중복x
		for (Member mem : m) {
			if (mem == null) {
				return false;
			} else if (mem.getId().equals(inputId)) {
				return true;
			}
		}
		return false;
	}

	public void insertMember(String id, String name, String password, String email, char gender, int age) {
		for (int i = 0; i < SIZE; i++) {
			if (m[i] == null) {
				m[i].setAge(age);
				m[i].setEmail(email);
				m[i].setGender(gender);
				m[i].setId(id);
				m[i].setName(name);
				m[i].setPassword(password);
				break;
			}
		}

	}

	public String searchId(String id) {
		for (Member mem : m) {
			if (mem == null) {
				return null;
			} else if (mem.getId().equals(id)) {
				return mem.inform();
			}
		}
		return null;
	}

	public Member[] searchName(String name) {
		Member[]mem2 = new Member[SIZE];
		int count=0;
		for (Member mem : m) {
			if (mem == null) {
				return mem2;
			} else if (mem.getName().equals(name)) {
				mem2[count]=mem;
				count++;
			}
		}
		return mem2;
	}

	public Member[] searchEmail(String email) {
		Member[]mem2 = new Member[SIZE];
		int count=0;
		for (Member mem : m) {
			if (mem == null) {
				return mem2;
			} else if (mem.getEmail().equals(email)) {
				mem2[count]=mem;
				count++;
			}
		}
		return mem2;
	}

	public Boolean updatePassword(String id, String password) {
		for(Member mem : m) {
			if(mem==null) {
				return false;
			}
			else if(mem.getId().equals(id)) {
				mem.setPassword(password);
				return true;
			}
		}
		return false;
	}

	public Boolean updateName(String id, String name) {
		return true;
	}

	public Boolean updateEmail(String id, String email) {
		return true;
	}

	public Boolean delete(String id) {
		return true;
	}

	public void delete() {

	}

	public Member[] printAll() {
		return null;
	}

}
