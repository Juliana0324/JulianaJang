class DataType 
{
	public static void main(String[] args) 
	{
		/*DataType: ���� �����ϱ� ���� �ο��Ͽ� ���� �̸� �����ص� ����
		Primitive type (�⺻��)
*/
		byte a = -128;
		//byte b = 128; // ����Ұ�
		byte b = 127;
		System.out.println("a:"+ a);
		System.out.println("b:"+ b);

		//��� ���� �޸𸮿� ���� �Ǵµ� ����������� literal�̶�� ��
		//��� ������� ���� �׼��� �����Ͽ� ����ϴ� �ڵ带 �ۼ�
		long money = 5000000000L;
		int tenYears = 120;
		
		System.out.println(money /tenYears);
			
		/*��� ����� 
		literal�� ũ�⸦ �Ͻ������� �����ϴ� ��
		��������� ����� �� ����
		
		���� ���: 4byte�� ���ͷ��� 8byte�� ���ͷ��� ����
		���L; Ȥ�� ���l;

		�Ǽ� ���: 8byte�� ���ͷ��� 4byte�� ���ͷ��� ����
		Float : f, F
		Double : D, d (����)
		8byte(3.14)�� ũ�⸦ ���� ���� 4byte(f)�� ũ�⸦ ���������� �Ҵ�ɼ� ����
	*/
	float f = 3.14f;
	System.out.print(f);

	}
}
