package day0110;

/**
 * Person클래스를 객체화하여 사용할 목적으로 만드는 클래스
 * @author user
 *
 */
public class UsePerson {

	/**
	 * Java application
	 * @param args
	 */
	public static void main(String[] args) {
		Person person1 = new Person();
		person1.setName("홍길동");
		
		System.out.println(person1.eat());
		System.out.println(person1.eat("돼지국밥",9000));
		
		Person jinban = new Person(3,1,1);
		jinban.setName("천진반");
		System.out.println(jinban.getEye()+" / "+jinban.getNose()+" / "+jinban.getMouth()+" / "
				+jinban.getName());
		System.out.println(jinban.eat());
		
		System.out.println(jinban.eat("선두", 0));
		
//		Person p2 = Person
		
		
		
	}

}
