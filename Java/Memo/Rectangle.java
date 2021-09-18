package Memo;

public class Rectangle extends AbstractShape implements Printable{
	
	// ����
    double side1; // ����
    double side2; // ����

    // ������
    public Rectangle(double side1, double side2) {
        super(0, 0);
        this.side1 = side1;
        this.side2 = side2;
    }

    // ����
    public double getArea() {
        return side1 * side2;
    }

    // �ѷ�
    public double getPerimeter() {
        return 2 * (side1 + side2);
    }
    
    public void print() {
    	for(int i=1;i<=this.side1;i++) {
    		for(int j=0; j<this.side2;j++) {
    			System.out.print("*");    			
    		}
    		System.out.println();
    	}
    	
    	}
}