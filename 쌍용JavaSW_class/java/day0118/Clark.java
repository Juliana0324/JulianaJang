package day0118;

/**
 * ����� ���� Ư¡(��,��,��,�̸�, �Դ���)�� PersonŬ�������� ������ ����ϰ�
 * �ڽ�Ŭ����
 * 
 *  
 * ��� ������ �ο��� 2���� ����
 * ���� 1-10����
 * @author user
 *
 */
public final class Clark extends Person implements Fly{
	
	public int power;
	
	public Clark() {
		super(3,1,1); //�θ� Ŭ������ �����ε��� ������
		power= 8;
	}//clark
	
	//�������̵�
	@Override
	public String eat() {
		return getName()+"��(��) ������ ���� ��Ʈ���� �Դ´�";
	}

	@Override
	public String eat(String menu, int price) {
		//public���� �Ǿ��ִ� method�� ȣ���Ͽ� ���
		return getName()+"�� ����������� "+ menu+ "�� ������ "+price+"$ �ְ� ��Դ´�.";
	}

	
	public String power(String stone) {
		String result = "";
		
		if(stone.equals("ũ���䳪��Ʈ")) {
			result = "���� ������ ��";
			power=1;
		}else if(stone.equals("���̾Ƹ��")) { 
			result = "^^ ���꼼�� >< ";
			power = 10;
			
		}else { //��� ���� ��
			result = "(�Ѥ� +) ��δϰ� ���� ����";
			power = 12;
			
		}//end 
		return result;
	}//power

	
	//���� ����� �������̽��κ��� ����
	@Override
	public String upwardForce() {
		return getName()+"�� ����� ����κ��� ��´�";
	}

	@Override
	public String drivingForce() {
		return getName()+"�� �������� ������ �ݾ ��� ������ ��´�";
	}

	
	
	
	
	
}
