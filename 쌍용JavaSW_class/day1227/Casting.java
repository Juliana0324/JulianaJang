/* 
	��������ȯ
	�����ڰ� �ʿ��� ������������ ��ȯ�ϴ°�
	(��ȯ�� ��������)������ �Ǵ� ���;

*/
class Casting{
	public static void main(String[] args) 
	{
		char c = 'A';
		int i = c;
		System.out.println(c+"�� Unicode : "+i);
		
		float f = (float)12.27;
		i = (int)f;
		System.out.println("�� �ս� �߻�: "+f+", ��ȯ�� ��: "+i);

		//�⺻�� ���������� ���������� ��������ȯ
		//i = 12;
		//String s = i;
		//==> error
		//�⺻�� i�� ������ String���� casting�Ҽ� ����
		String s = "2021";
		int nu = Integer.parseInt(s);
		System.out.println(nu);

		
	}
}
