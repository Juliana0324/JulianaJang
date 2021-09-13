package Interface;

public class Square extends Shape{
	double side;
	double x;
	double y;
	
	public Square(double side) {
		this.side = side;
	}
	
	@Override
	public double getArea() {
		return side * side;
	}
	@Override
	public double getPerimeter() {
		return 4*side;
	}
	
}
