package day0118;

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
		HongGilDong hgd = new HongGilDong();
		//�ڵ��� �� ��뼺
		hgd.setName("ȫ�浿");
		System.out.printf("%s�� ���� %d��, �ڴ� %d��, ���� %d��\n", hgd.getName(), hgd.getEye(), hgd.getNose(), hgd.getMouth());
		System.out.println(hgd.eat());
		System.out.println(hgd.eat("�߲��� ����",1));
		
		//�ڽŸ��� Ư¡�� ������ method�� ȣ��
//		for(int i=3;i<11; i++) {
//			System.out.println(i+ "���� �����ڿ��� �ο�: " +hgd.fight(i));			
//		}
		
		System.out.println("==================================================");
		Clark superman = new Clark();
		//�ڵ��� �� ��뼺
		superman.setName("���۸�");
		System.out.printf("%s�� ���� %d��, �ڴ� %d��, ���� %d��\n", superman.getName(), superman.getEye(), superman.getNose(), superman.getMouth());
		System.out.println(superman.eat());
		System.out.println(superman.eat("������ũ",10));
		
		//�ڽŸ��� Ư¡ ����
		String stone = "¯��";
		System.out.println(stone+"�� �¾Ƽ� "+ superman.power(stone) +"\n���۸� �Ŀ�: "+superman.power);
		stone = "���̾Ƹ��";
		System.out.println(stone+"�� �¾Ƽ� "+ superman.power(stone)+"\n���۸� �Ŀ�: "+superman.power);
		System.out.println();
		
		System.out.println(superman.getName()+"���� "+hgd.fight(superman.power));
		System.out.println();
		
		System.out.println("----------���� ���� �۾�----------");
		System.out.println(superman.upwardForce());
		System.out.println(superman.drivingForce());
		
		
	}

}
