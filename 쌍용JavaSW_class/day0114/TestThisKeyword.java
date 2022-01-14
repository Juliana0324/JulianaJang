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
//		value = 10; //static 영역에 처음 로드 되기때문에 사영하수 x
		TestThisKeyword ttk = new TestThisKeyword(); //1.
		ttk.nonThis(100); //2
		
		System.out.println(ttk.getValue()); // 
		
	}
}
