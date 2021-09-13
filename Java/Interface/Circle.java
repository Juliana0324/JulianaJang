package Interface;

public class Circle extends Shape{
	public final double PI= 3.14;
	
	double radius;
	
	//�׸��ǿ��� ��ġ
	double x;
	double y;
	
	public Circle(Double radius) {
		this.radius = radius;
		x=0.0;
		y=0.0;
	}

	@Override
	public double getArea() {
		return PI * radius * radius;
	}
	
	@Override
	public double getPerimeter() {
		return 2* PI * radius;
	}
	
}
