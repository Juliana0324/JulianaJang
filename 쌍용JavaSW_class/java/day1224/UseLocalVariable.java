/*
	���������� ���
*/
class UseLocalVariable {
	//Java Application
	public static void main(String[] args) 
	{
		//1. ��������
		int i;
		int age = 25;
		System.out.println(age);

		age = 27;
		System.out.println(age);
		

/*		������ ���� �޶� �������� ���ٸ� ����
		double age = 200;
		System.out.println(age);

*/		
		int bornYear=sc.nextInt();
		int thisYear = 2021;
				
		int result = thisYear - bornYear + 1;
		System.out.println(result);

	}
}
