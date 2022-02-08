package day0208;

import java.io.Serializable;

public class MyData implements Serializable{
	/**
	 * 클래스 id 생성됨
	 * 객체를 식별하기 위한 번호이고 1년 후에는 다른 번호로 변경됨
	 */
	private static final long serialVersionUID = 7865162799135629193L;
	//transient는 직렬화 방지 키워드
	private /* transient */ String name;
	private /* transient */ double height;

	private double weight;
	
	public MyData() {
		
	}
	
	public MyData(String name, double height, double weight) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
