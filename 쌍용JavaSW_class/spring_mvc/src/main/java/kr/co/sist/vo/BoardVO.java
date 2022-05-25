package kr.co.sist.vo;

public class BoardVO {
	private int startNum, endNum;

	
	public BoardVO() {
		super();
	}

	public BoardVO(int startNum, int endNum) {
		super();
		this.startNum = startNum;
		this.endNum = endNum;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	@Override
	public String toString() {
		return "BoardVO [startNum=" + startNum + ", endNum=" + endNum + "]";
	}
	
	
	
	
}
