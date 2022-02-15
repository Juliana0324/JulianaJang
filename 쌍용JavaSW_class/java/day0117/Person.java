package day0117;

/**
 * ����� ������� ��ü�𵨸��Ͽ� �ۼ��� class
 * 
 * 01-17-2022 PersonClass�� �߻�Ŭ������ ����
 * ��� ����� �ٸ����� �Ա⶧���� => �θ�Ŭ�������� ���� ������ �ʿ�x
 * 
 * @author Person
 */
public abstract class Person {
	private int eye;
	private int nose;
	private int mouth;
	private String name;
	
	/**
	 * �⺻ ������
	 * ����� �⺻���� ������ �� => default value
	 */
	public Person() {
		//����� �⺻���� ������ �� => default value
//		eye=2;
//		nose=1;
//		mouth=1;
		this(2,1,1); //01-13�� �����ڸ� this�� ȣ���ϴ� �ڵ�� ��ȯ�Ǿ����ϴ�.
	}
	
	/** 
	 * ������ �����ε�
	 * ��� ��ü�� �����ɋ� �⺻�� �Է¹���
	 * @param eye
	 * @param nose
	 * @param mouth
	 */
	public Person(int eye, int nose, int mouth) {
		this.eye = eye;
		this.nose = nose;
		this.mouth = mouth;
	}
	
	/**
	 * setter method
	 * ������ �緳 ��ü�� ���� ������ �����ϴ� ��
	 * @param eye
	 */
	public void setEye(int eye) {
		this.eye = eye;
	}
	
	/**
	 * ������ ����� ��ü�� �������ִ� ���� ������ ���� �����
	 * @return ���� ����
	 */
	public int getEye() {
		return eye;
	}
	
	/**
	 * setter method
	 * ������ �緳 ��ü�� ���� ������ �����ϴ� ��
	 * @param nose
	 */
	public void setNose(int nose) {
		this.nose = nose;
	}

	/**
	 * ������ ����� ��ü�� �������ִ� ���� instance������ ���� �����
	 * @return ���� ����
	 */
	public int getNose() {
		return nose;
	}
	
	/**
	 * setter method
	 * ������ �緳 ��ü�� ���� ������ �����ϴ� ��
	 * @param mouth
	 */
	public void setMouth(int mouth) {
		this.mouth = mouth;
	}

	/**
	 * ������ ����� ��ü�� �������ִ� ���� instance ������ ���� �����
	 * @return ���� ����
	 */
	public int getMouth() {
		return mouth;
	}
	
	/**
	 * setter method
	 * ������ �緳 ��ü�� �̸� �����ϴ� ��
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ������ ����� ��ü�� �������ִ� �̸� instance ������ ���� �����
	 * @return �̸�
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * �������� Ư¡����
	 * ������ ��� ��ü�� ������ ���� �Դ���
	 * @return ���� �Դ���.
	 */
	public abstract String eat();
	
	/**
	 * �������� Ư¡����
	 * ������ ��� ��ü�� �ۿ��� ���� �Դ���
	 * @param menu ��������
	 * @param price ���İ���
	 * @return ���� �ۿ��� ��Դ� ��.
	 */
	public abstract String eat(String menu, int price);


}
