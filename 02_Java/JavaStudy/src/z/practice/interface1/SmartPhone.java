package z.practice.interface1;

public abstract class SmartPhone implements CellPhone,TouchDisplay {
	//추상 클래스는 반드시 구현을 안 해도 된다. 
	//왜냐하면 추상메서드가 있을 수 있기 때문에
	
	private String maker;

	public SmartPhone() {
		super();
	}
	
	public abstract String printInformation();
	
	public void setMaker(String maker) {
		this.maker=maker;
	}
	
	public String getMaker() {
		return maker;
	}
	
	
	
}
