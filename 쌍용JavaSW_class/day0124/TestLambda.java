package day0124;

public class TestLambda {
	public static void main(String[] args) {
		mySum lsum = (a,b) -> a+b;
		System.out.println(lsum.sum(10,20));
	}
}
