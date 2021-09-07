package Credit;

import java.util.ArrayList;

public class GradeCalculator {
	private String name; 
	private double lastScore;
	private double allCredit;
	private ArrayList<Course> courses = new ArrayList<>();
	
	public GradeCalculator(String name, double lastScore, int allCredit) {
		this.name = name;
		this.lastScore = lastScore;
		this.allCredit= allCredit;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
		
	}
	
	private double allScoreSum() {
		double scoresSums = 0;
		scoresSums += lastScore*allCredit;
		return scoresSums;
	}
	
	public double scoreAvg() {
		double avg= allScoreSum()/allCredit;
		//�����б� �������
		return avg;
	}
	
	public double currScore() {
		double score = 0;
		for(Course c: courses) {
			score+= c.getScore()*c.credit;
			
		}
		return score;
	}
	
	public int currCredit() {
		int credit=0;
		for(Course c:courses) {
			credit+=c.credit;
		}
		return credit;
	}
	
	public void print() {

		double curGrade = (double)currScore()/currCredit();
		int sumCredit = (int)allCredit+currCredit();
		double allGrade = (allScoreSum()+currScore())/sumCredit;
		System.out.println("���� �б� ����: "+scoreAvg()+" (�� "+(int)allCredit+"����)");
		System.out.println("�̹� �б� ����: "+ String.format("%.10f", curGrade)+" (�� "+currCredit()+"����)");
		System.out.println("��ü ���� ����: "+ String.format("%.10f", allGrade)+" (�� "+sumCredit+"����)");
		
	}
}
