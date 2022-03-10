package day0310;

public class ProcedureVO {
	private int num, age;
	private String name, email, inputDate;
	
	public ProcedureVO() {
		
	}
	
	public ProcedureVO(int num, int age, String name, String email, String inputDate) {
		super();
		this.num = num;
		this.age = age;
		this.name = name;
		this.email = email;
		this.inputDate = inputDate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	@Override
	public String toString() {
		return "ProcedureVO [num=" + num + ", age=" + age + ", name=" + name + ", email=" + email + ", inputDate="
				+ inputDate + "]";
	}
	
	
}
