package day0310;

public class ResultVO {
	private int rowCnt;
	private String errMsg;
	
	public int getRowCnt() {
		return rowCnt;
	}
	public void setRowCnt(int rowCnt) {
		this.rowCnt = rowCnt;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	@Override
	public String toString() {
		return "ResultVO [rowCnt=" + rowCnt + ", errMsg=" + errMsg + "]";
	}
	
	
}
