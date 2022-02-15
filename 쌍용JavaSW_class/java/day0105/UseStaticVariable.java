package day0105;

/**
 * Static or variable(���뺯��)
 * ��üȭ�� �����ʰ� Ŭ���������� �����Ͽ� ����ϴ� ����
 * 
 * 
 * @author user
 *
 */
public class UseStaticVariable {
	static int i;
	public static int j;
	int insI;
	
	public static void main(String[] args) {
		System.out.println(UseStaticVariable.i);
		System.out.println(UseStaticVariable.j);
		
		//static ������ ��ü�� ������ ���� ���뺯���� ��ü��.���������� ���ɽ�
		// ����� ������ ������� �ƴϹǷ� ���޼��� ���
		
		UseStaticVariable usv = new UseStaticVariable();
		UseStaticVariable usv2 = new UseStaticVariable();
		usv.insI = 100;
		usv2.insI = 500;
		
/**	 �߸��� ���
	//static ������ ��ü������ ����ϴ��� �ϳ��� ������ ����ϴ°��̱� ������
		//����� ���� �����ȴ� 
		usv.i = 1000;
		System.out.println("��ü������ ���: "+usv.i +", instance variable = "+ usv.insI);  //��°��: ��ü������ ���: 1000, instance variable = 100
		System.out.println("��ü������ ���: "+usv2.i+", instance variable = "+ usv2.insI); //��°��: ��ü������ ���: 1000, instance variable = 500
		
		//�޼��� : The static field UseStaticVariable.i should be accessed in a static way
	*/	
		
		//������ ��� : static �������� ���
		UseStaticVariable.i = 1000;
		System.out.println("Static �������� ��� : "+UseStaticVariable.i +", instance variable = "+ usv.insI);  //��°��: static �������� ���: 1000, instance variable = 100
		System.out.println("Static �������� ��� : "+UseStaticVariable.i+", instance variable = "+ usv2.insI); //��°��: static �������� ���: 1000, instance variable = 500
	}

}
