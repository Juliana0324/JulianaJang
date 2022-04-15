package day0415;

public class CodeVO {
	private int code;
	private String codeText;
	
	public CodeVO() {
		
	}
	
	public CodeVO(int code, String codeText) {
		super();
		this.code = code;
		this.codeText = codeText;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCodeText() {
		return codeText;
	}
	public void setCodeText(String codeText) {
		this.codeText = codeText;
	}

	@Override
	public String toString() {
		return "CodeVO [code=" + code + ", codeText=" + codeText + "]";
	}
	
	
	
}
