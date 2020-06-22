package chap01.beans;
// # 자바 bean 객체(JAVA Bean Object)
// - 자바 빈 스타일의 오브젝트를의미
// - JSP에서 데이터를 편하게 주고 받기위한 객체의 표준을 의미
// - 자바빈 스타일로 생성해 놓은 객체는 jsp에서 자동으로 데이터를 매핑
// - GETTER/SETTER를 생성해 놓으면 EL이 자동으로 그것을 이용

/* #자바빈 객체의 관례
 1. 기본 생성자가 반드시 존재
 -- 자바빈 객체는 매개 변수가 없는 기본생성자를 반드시 갖고 있어야한다
 2. 속성의 접근제어자는 private이어야한다
	--자바빈 객체의 멤버변수는 접근 제어자를 private 으로 설정하고
	getter와 setter를 생성해 놓아야한다



*/


public class Student {
	private String name;
	private int age;
	private int kor;
	private int eng;
	private int math;
	private double avg;
	
	
	public Student() {
		//테스트용 더미 데이터 생성\
		name="김철수";
		age=10;
		kor=9;
		eng=5;
		math=30;
		calcAvg();
		
	}
	
	
	private void calcAvg() {
		double result=(kor + eng+ math)/3.0;
		this.avg = Math.round((result*10)/10.0);
		//round ==>2째자리
		//floor ==> 내림
	}
	
	//getter/setter를 생성해 놓으면 JSP와 EL이 자동으로 메서드 이용
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getKor() {
		return kor;
		
	}
	public void setKor(int kor) {
		this.kor = kor;
		calcAvg();
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
		calcAvg();
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
		calcAvg();
	}
	public double getAvg() {
		return avg;
	}
	
}
