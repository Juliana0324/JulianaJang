/*
	���� if
*/
class TestElseIf {
	public static void main(String[] args) {
		//������ �Է¹޾� 0���� �۾����� ���и޼����� 100������ ������ ���� �޽����� 
		//���������� �޼��� ���
		/*int score = Integer.parseInt(args[0]);

		System.out.print(score+"���� ");
		
		if(score < 0){
			System.out.println("0�� ���� �۽��ϴ�.");	
		} else if(score>100){
			System.out.println("100�� ���� Ů�ϴ�.");	
		} else{
			System.out.println("����");	
		}//end else
		*/

		/////////////////////////////////////
		
		// ���� �Է¹޾� 0~39������ "����"
		// 40-59 -> "�ٸ����� ����"
		// 60- 100 -> "�հ�"
		// 
		
		int score = Integer.parseInt(args[0]); 
		
		if (score>=0 && score<40){
			System.out.println("����");
		
		} else if(score>39 && score <60){
			System.out.println("�ٸ� ���� ����");
		
		} else if(score>59 && score<101){
			System.out.println("�հ�");			
		
		}




	} //end main
} //class
