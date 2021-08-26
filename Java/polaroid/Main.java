package polaroid;

public class Main {

	public static void main(String[] args) {
		ShapeTriange printer = new ShapeTriange();
		
        // Å×½ºÆ®
        printer.printFloydsPyramid(3);
        System.out.println("----------");
        printer.printFloydsPyramid(5);
        System.out.println("----------");
        printer.printFloydsPyramid(15);
 	
	}

}
