package day0104.work;

/* 2. ������ �Է¹޾� �Է¹��� ������ 0~100�����϶� 
 	40�� �̸�: ����
   60�� �̸� : �ٸ����� ����
   100�� ���� : ����
   0~100���� �ƴϸ� ��ȿ���� �ƴմϴ� */

 public class Work2 {

	public static void main(String[] args) {
	 int score = 0;
	 score = Integer.parseInt(args[0]);
	 
	 if(score>-1 && score<101){
		 if(score<40) {
			 System.out.println("����");
		 } else if(score<60) {
			 System.out.println("�ٸ����� ����");
		 }else if(score<101) {
			 System.out.println("�հ�");
		 }
		 
		 
	 }else{
		 System.out.println("��ȿ���� �ƴ�");
		 
	 }//end else
	 	
	}//main

}//class
