package day0104;

public class Homework {

	public static void main(String[] args) {
		//1. 1-100���� ���� �Ʒ��� ���� ���
		// 1,2,¦ 
		for(int i=1; i<101; i++) {
			if(i%3==0) {
				System.out.print("¦ ");
			}else {
				System.out.print(i+" ");
			}
		}
		
		System.out.println();
		System.out.println("----------------------------------------");
		
		//2.
		//���� ����
		for(int i=1; i<10;i++) {
			for(int j=2;j<10; j++) {
				System.out.print(j+" * "+i+" = "+i*j+"\t");
			}//end for
			System.out.println();
		}//end for
		System.out.println("----------------------------------------");

		
		//3. �ԷµǴ� ���� 2-9�� �����϶� �ԷµǴ� ������ �������� ����ϼ���
		// 2-9���� �ƴ϶�� 
		int tri = Integer.parseInt(args[0]);
		if(tri>1 && tri<10) {
			for(int i=2; i<10; i++) {
				System.out.print(tri +" X " + i+" = "+ tri*i + "\t");
			}
		} else {
			System.out.println("�������� 2~9������ �����մϴ�.");
		}
		
		
		
	}

}
