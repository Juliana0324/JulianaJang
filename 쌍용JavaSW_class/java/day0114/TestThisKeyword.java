package day0114;

public class TestThisKeyword {
	
	private int value;
	
	public void nonThis(int value) { //3. 
		this.value = value;
	} // non this
	
	public int getValue() {
		return value;
	}
	
	
	public static void main(String[] args) {
//		value = 10; //static ������ ó�� �ε� �Ǳ⶧���� �翵�ϼ� x
		TestThisKeyword ttk = new TestThisKeyword(); //1.
		ttk.nonThis(100); //2
		
		System.out.println(ttk.getValue()); // 
		
	}
}
