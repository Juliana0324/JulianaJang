package kr.co.sist.vo;

import java.sql.Date;

public class MyTabVO {
	private int age;
	private String id,	name,	email;
	private Date input_date;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Date getInput_date() {
		return input_date;
	}
	public void setInput_date(Date input_date) {
		this.input_date = input_date;
	}
	
	@Override
	public String toString() {
		return "MyTabVO [age=" + age + ", id=" + id + ", name=" + name + ", email=" + email + ", input_date="
				+ input_date + "]";
	}
	
}
