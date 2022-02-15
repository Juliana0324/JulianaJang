package day0208;

import java.io.Serializable;

public class MyData implements Serializable{
	/**
	 * Ŭ���� id ������
	 * ��ü�� �ĺ��ϱ� ���� ��ȣ�̰� 1�� �Ŀ��� �ٸ� ��ȣ�� �����
	 */
	private static final long serialVersionUID = 7865162799135629193L;
	//transient�� ����ȭ ���� Ű����
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
