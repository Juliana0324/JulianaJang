package day0107;

public class Ramen {
	private String ramenName;
	private int water;
	private int minute;
	
	
	public String getRamenName() {
		return ramenName;
	}
	public void setRamenName(String ramenName) {
		this.ramenName = ramenName;
	}
	public int getWater() {
		return water;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	public void makeRame() {
		System.out.println(ramenName+"�� "+water+"ml�� ���� �ְ� "+minute+"���� ���Դϴ�.");
	}
	

}
