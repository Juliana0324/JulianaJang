class HomeworkPractice{

	public static final int PAYMENT=20000; 
	public static final int ONEWAY=2500; 

	public static void main(String[] args)	{
		//1. �Ϸ� �뵷 ***��, �� ���� ***��, �պ� ���� ***��,
		//���� �Ĵ� ***��
		//���� �ݾ�
		int lunch= 5000, fare= ONEWAY*2;
		int leftover = PAYMENT - (ONEWAY*2) - lunch;
		System.out.printf("�Ϸ� �뵷 %d��, �� ���� %d��, �պ� ���� %d��\n", PAYMENT, ONEWAY, fare);
		System.out.println("���� �� :"+lunch+"��");
		System.out.println("���� �ݾ� : "+leftover+"��");
		System.out.println();
			
		//2. ��Ƚ÷� : (�޴� + ������ )/2 
		double leftEye = 0.3;
		double rightEye = 1.0;
		double bothEye = (leftEye+rightEye)/2;
		System.out.println("���� ���� �� �÷� :"+leftEye+ " ������ �� �÷� : "+rightEye);
		System.out.println("��� �÷� :"+bothEye);
		System.out.println();
		
		//3. int i=65;�� �Ҵ�Ǿ��ִ�. 
		// i�� �̿��ؼ� �빮�ڿ� �ҹ��ڸ� ����Ͻÿ�
		int i = 65;
		char cap = (char)i;
		char low = (char)(i+32);
		System.out.println("�빮�� "+cap+"�̰�, �ҹ��� "+low);
		System.out.println();
		
		//4. API���� wrapper class�� ��� ã�ƺ��� �Ʒ��� ���� ���.
		//�� , MAX_VALUE�� MIN_VALUE�� �������� �ʴ� Wrapper Class�� ���ؼ��� ������� �ʴ´�
		System.out.println("Byte�� �ּҰ� "+ Byte.MIN_VALUE+" �ִ밪 "+Byte.MAX_VALUE);
		System.out.println("Short�� �ּҰ� "+ Short.MIN_VALUE+" �ִ밪 "+Short.MAX_VALUE);
		System.out.println("Integer�� �ּҰ� "+ Integer.MIN_VALUE+" �ִ밪 "+Integer.MAX_VALUE);
		System.out.println("Character �ּҰ�: "+(int)(Character.MIN_VALUE)+" �ִ밪 :"+(int)(Character.MAX_VALUE));
		System.out.println("Double�� �ּҰ� "+ Double.MIN_VALUE+" �ִ밪 "+Double.MAX_VALUE);
		System.out.println("Float�� �ּҰ� "+ Float.MIN_VALUE+" �ִ밪 "+Float.MAX_VALUE);
		System.out.println("Long�� �ּҰ� "+ Long.MIN_VALUE+" �ִ밪 "+Long.MAX_VALUE);
		System.out.println();
		
	}
}
