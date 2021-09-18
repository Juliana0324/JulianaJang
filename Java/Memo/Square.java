package Memo;

public class Square extends AbstractShape implements Printable{
	 // 길이
    double side;

    // 생성자
    public Square(double side) {
        super(0, 0);
        this.side = side;
    }

    // 넓이
    public double getArea() {
        return side * side;
    }

    // 둘레
    public double getPerimeter() {
        return 4 * side;
    }
    
    public void print() {
    	for(int i=1;i<=this.side;i++) {
    		for(int j=0; j<this.side;j++) {
    			System.out.print("*");    			
    		}
    		System.out.println();
    	}
    	
    	
}
    }