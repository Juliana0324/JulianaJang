package day0114;

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
public class Clark extends Person{
	
	public int power;
	
	public Clark() {
		super(3,1,1); //�θ� Ŭ������ �����ε��� ������
		power= 8;
	}//clark
	
	//�������̵�
	public String eat(String food, int money) {
		return super.getName()+"�� ����������� "+food+"�� ������ "+money+"$ �ְ� ��Դ´�.";
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
	
	
}
