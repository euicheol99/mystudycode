package z.practice.oop.ex3;

public class Human {
	private String name;
	private int price;
	
	
	
	public Human() {
		super();
	}



	public Human(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}
	
	public void buy(TV tv) {
		System.out.println(name+"님"+" 구매내역");
		System.out.println(name);
	}
	
	
	
}
