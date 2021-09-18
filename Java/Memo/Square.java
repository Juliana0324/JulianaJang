package Memo;

public class Square extends AbstractShape implements Printable{
	 // ����
    double side;

    // ������
    public Square(double side) {
        super(0, 0);
        this.side = side;
    }

    // ����
    public double getArea() {
        return side * side;
    }

    // �ѷ�
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