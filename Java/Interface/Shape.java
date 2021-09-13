package Interface;

//추상클래스
public abstract class Shape {
	
	public abstract double getArea();
	
	public abstract	double getPerimeter();
	
	//이동기능
	private double x, y;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	
	public void move(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	
}
