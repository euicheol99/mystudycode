package z.pratice.object.ex4;

public class Product {
	private String pName;
	private int price;
	private String brand;
	
	public Product(String pName, int price, String brand) {
		super();
		this.pName = pName;
		this.price = price;
		this.brand = brand;
	}

	public void information() {
		System.out.println("상품명 : "+pName+" 가격 : "+price+" 브랜드: "+brand);
	}

}
