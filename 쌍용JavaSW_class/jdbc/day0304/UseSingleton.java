package day0304;

public class UseSingleton {

	public static void main(String[] args) {
//		TestSingleton ts= new TestSingleton();
		
		TestSingleton ts = TestSingleton.getInstance();
		TestSingleton ts2 = TestSingleton.getInstance();
	}

}
