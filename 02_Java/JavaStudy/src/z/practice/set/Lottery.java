package z.practice.set;

public class Lottery {
	private String name;
	private String phone;
	
	public Lottery() {
		super();
	}

	public Lottery(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Lottery [name=" + name + ", phone=" + phone + "]";
	}
	
	public int hashCode() {
		return 0;
	}
	
	public boolean equals() {
		return true;
	}
}
