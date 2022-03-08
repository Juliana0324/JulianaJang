package day0308;

public class ClobVO {
	private String subject, content, inputDate;

	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	@Override
	public String toString() {
		return "ClobVO [subject=" + subject + ", content=" + content + ", inputDate=" + inputDate + "]";
	}
	
	
}
