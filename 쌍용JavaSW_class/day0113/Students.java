package day0113;

public class Students {
	private String name; 
	private int java;
	private int oracle;
	private int html;
	private int totalScore;
	private double avg;
	
	public Students() {
		
	}
	
	public Students(String name, int java, int oracle, int html) {
		this.name = name;
		this.java = java;
		this.oracle = oracle;
		this.html = html;
		this.totalScore = getTotalScore();
		this.avg = getAvg();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getOracle() {
		return oracle;
	}
	public void setOracle(int oracle) {
		this.oracle = oracle;
	}
	public int getHtml() {
		return html;
	}
	public void setHtml(int html) {
		this.html = html;
	}
	
	public int getTotalScore() {
		totalScore = java+ oracle+html;
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	public double getAvg() {
		avg = getTotalScore()/3.0;
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
	
	
}
