package Interface;

public class Ractangle extends Shape{
	public double side1;
	public double side2;
	
	//그림판에서 위치
	double x;
	double y;
	
	public Ractangle(double side1, double side2) {
		this.side1 = side1;
		this.side2 = side2;
	}
	
	
	@Override
	public double getArea() {
		return side1 *side2;
	}
	
	@Override
	public double getPerimeter() {
		return 2*(side1+side2);
	}
}
