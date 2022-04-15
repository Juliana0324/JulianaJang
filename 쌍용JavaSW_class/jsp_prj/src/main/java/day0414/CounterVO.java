package day0414;

public class CounterVO {
	private int cnt;
	private String name;

	public CounterVO() {
		System.out.println("CounterVO 기본생성자");
	}
	
	public CounterVO(int cnt, String name) {
		super();
		this.cnt = cnt;
		this.name = name;
	}


	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt += cnt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CounterVO [cnt=" + cnt + ", name=" + name + "]";
	}
	
	
}
