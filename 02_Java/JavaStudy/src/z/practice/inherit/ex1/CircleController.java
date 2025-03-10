package z.practice.inherit.ex1;

public class CircleController {
	private Circle c=new Circle();
	
	public  String calcArea(int x, int y, int radius) {
		c=new Circle(x,y,radius);
		//this는 플드 위에 있는 가장 가까운 녀석을 부르는 것.파라미터에 있는 녀석은 못 불러옴
		
		return "면적 : "+c.toString()+" / "+(Math.PI * radius * radius);
	}
	
	public String calcCircum(int x, int y, int radius) {
		
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		
		return "둘레 : "+c.toString()+" / "+(Math.PI * radius * 2);
	}
}
