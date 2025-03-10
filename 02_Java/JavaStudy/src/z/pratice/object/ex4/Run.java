package z.pratice.object.ex4;

public class Run {
	public static void main(String[] args) {
		Product p1=new Product("가위",2000,"문구점");
		Product p2=new Product("과자",3000,"롯데");
		
		p1.information();
		p2.information();
	}
}
