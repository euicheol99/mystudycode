package z.practice.inherit.ex1;

public class RectangleController {
	private Rectangle r=new Rectangle();
	
	public String calcArea (int x, int y, int height, int width) {
		r=new Rectangle(x,y,height,width);
		return "면적 : "+r.toString()+(width*height);
	}
	
	public String calcPerimeter(int  x, int y, int height,int width) {
		r.setX(x);
		r.setY(y);
		r.setWidth(width);
		r.setHeight(height);
		
		return "둘레: "+r.toString()+(2*(width+height));
	}
}
