package chap01.beans;
// # �ڹ� bean ��ü(JAVA Bean Object)
// - �ڹ� �� ��Ÿ���� ������Ʈ���ǹ�
// - JSP���� �����͸� ���ϰ� �ְ� �ޱ����� ��ü�� ǥ���� �ǹ�
// - �ڹٺ� ��Ÿ�Ϸ� ������ ���� ��ü�� jsp���� �ڵ����� �����͸� ����
// - GETTER/SETTER�� ������ ������ EL�� �ڵ����� �װ��� �̿�

/* #�ڹٺ� ��ü�� ����
 1. �⺻ �����ڰ� �ݵ�� ����
 -- �ڹٺ� ��ü�� �Ű� ������ ���� �⺻�����ڸ� �ݵ�� ���� �־���Ѵ�
 2. �Ӽ��� ���������ڴ� private�̾���Ѵ�
	--�ڹٺ� ��ü�� ��������� ���� �����ڸ� private ���� �����ϰ�
	getter�� setter�� ������ ���ƾ��Ѵ�



*/


public class Student {
	private String name;
	private int age;
	private int kor;
	private int eng;
	private int math;
	private double avg;
	
	
	public Student() {
		//�׽�Ʈ�� ���� ������ ����\
		name="��ö��";
		age=10;
		kor=9;
		eng=5;
		math=30;
		calcAvg();
		
	}
	
	
	private void calcAvg() {
		double result=(kor + eng+ math)/3.0;
		this.avg = Math.round((result*10)/10.0);
		//round ==>2°�ڸ�
		//floor ==> ����
	}
	
	//getter/setter�� ������ ������ JSP�� EL�� �ڵ����� �޼��� �̿�
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
