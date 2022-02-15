package day0117;

/**
 * 사람을 대상으로 객체모델링하여 작성한 class
 * 
 * 01-17-2022 PersonClass를 추상클래스로 수정
 * 모든 사람은 다른것을 먹기때문에 => 부모클래스에서 굳이 구현할 필요x
 * 
 * @author Person
 */
public abstract class Person {
	private int eye;
	private int nose;
	private int mouth;
	private String name;
	
	/**
	 * 기본 생성자
	 * 사람이 기본으로 가지는 값 => default value
	 */
	public Person() {
		//사람이 기본으로 가지는 값 => default value
//		eye=2;
//		nose=1;
//		mouth=1;
		this(2,1,1); //01-13일 생성자를 this로 호출하는 코드로 변환되었습니다.
	}
	
	/** 
	 * 생성자 오버로딩
	 * 사람 객체가 생성될떄 기본값 입력받음
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
	 * 생성된 사럼 객체의 눈의 개수를 설정하는 일
	 * @param eye
	 */
	public void setEye(int eye) {
		this.eye = eye;
	}
	
	/**
	 * 생성된 사람의 객체가 가지고있는 눈의 변수에 값을 얻는일
	 * @return 눈의 갯수
	 */
	public int getEye() {
		return eye;
	}
	
	/**
	 * setter method
	 * 생성된 사럼 객체의 코의 개수를 설정하는 일
	 * @param nose
	 */
	public void setNose(int nose) {
		this.nose = nose;
	}

	/**
	 * 생성된 사람의 객체가 가지고있는 코의 instance변수에 값을 얻는일
	 * @return 코의 갯수
	 */
	public int getNose() {
		return nose;
	}
	
	/**
	 * setter method
	 * 생성된 사럼 객체의 입의 개수를 설정하는 일
	 * @param mouth
	 */
	public void setMouth(int mouth) {
		this.mouth = mouth;
	}

	/**
	 * 생성된 사람의 객체가 가지고있는 입의 instance 변수에 값을 얻는일
	 * @return 입의 갯수
	 */
	public int getMouth() {
		return mouth;
	}
	
	/**
	 * setter method
	 * 생성된 사럼 객체의 이름 설정하는 일
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 생성된 사람의 객체가 가지고있는 이름 instance 변수에 값을 얻는일
	 * @return 이름
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * 동사적인 특징구현
	 * 생성된 사람 객체가 집에서 밥을 먹는일
	 * @return 밥을 먹는일.
	 */
	public abstract String eat();
	
	/**
	 * 동사적인 특징구현
	 * 생성된 사람 객체가 밖에서 밥을 먹는일
	 * @param menu 음식종류
	 * @param price 음식가격
	 * @return 밥을 밖에서 사먹는 일.
	 */
	public abstract String eat(String menu, int price);


}
