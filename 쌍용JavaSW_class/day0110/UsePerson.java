package day0110;

/**
 * PersonŬ������ ��üȭ�Ͽ� ����� �������� ����� Ŭ����
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
		person1.setName("ȫ�浿");
		
		System.out.println(person1.eat());
		System.out.println(person1.eat("��������",9000));
		
		Person jinban = new Person(3,1,1);
		jinban.setName("õ����");
		System.out.println(jinban.getEye()+" / "+jinban.getNose()+" / "+jinban.getMouth()+" / "
				+jinban.getName());
		System.out.println(jinban.eat());
		
		System.out.println(jinban.eat("����", 0));
		
//		Person p2 = Person
		
		
		
	}

}
