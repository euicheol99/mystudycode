package z.practice.oop.ex3;

public class TV {
	private String name;
	private int year;
	private int inch;
	private int price;
	
	
	public TV() {
		super();
	}
	public TV(String name,int year,int inch,int price) {
		this.name=name;
		this.year=year;
		this.inch=inch;
		this.price=price;
	}
	public void show() {
		System.out.println(this.name+"에서 만든 "+this.year+"년형 "+this.inch+"인치 TV 가격 : "+this.price);
	}
}
