/*
	Constant : ���α׷� ���ؿ��� ������ �ְ� ����Ҷ�
*/

class Constant{
	//���ذ����� ����ϴ� Constant�� class Field������ ��밡��
	public static final int MAX_SCORE=100;
	public static final int MIN_SCORE=0;

	public static void main(String[] args) {
	//	public static final int MAX_SCORE=100; ==> Error

		int myScore = 85;

		System.out.println(MAX_SCORE + "/" + MIN_SCORE);
		System.out.println(Constant.MAX_SCORE+ "/"+ Constant.MIN_SCORE);

		System.out.println("�������� �ְ� ������ ����: "+(MAX_SCORE- myScore));
	
	
	}
}
