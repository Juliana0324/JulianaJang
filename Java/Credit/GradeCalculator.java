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
		//이전학기 평균점수
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
		System.out.println("직전 학기 성적: "+scoreAvg()+" (총 "+(int)allCredit+"학점)");
		System.out.println("이번 학기 성적: "+ String.format("%.10f", curGrade)+" (총 "+currCredit()+"학점)");
		System.out.println("전체 예상 학점: "+ String.format("%.10f", allGrade)+" (총 "+sumCredit+"학점)");
		
	}
}
