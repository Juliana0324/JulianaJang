package day0105;

/**
 * While�� (���۰� ���� �𸦋� ����ϴ� �ݺ���)
 * �ּ� 0�� ���� �ִ����Ǳ��� ����
 * 
 * @author user
 */
public class UseWhile {

	public static void main(String[] args) {
		int i=1;
		while(i<101) {
			i++;
			System.out.print(i + " ");
		}//end while
		
		System.out.println();
		System.out.println("-----------------------------------------------");
		/////////////////////////////
		//1-100���� 3�ǹ���� ���
		int j=1;
		while(j<101) {
			j++;
			if(j%3==0) {
				System.out.print(j+" ");
			}//end if
		}//end while
	
		System.out.println();
		System.out.println("-----------------------------------------------");
		//////////////////////////////////////
		//while�� ����Ͽ� ������ 9�� ���
		i = 2;
		while(i<10) {
			System.out.print("9 * "+i+" = "+9*i+"\t");
			i++;
		}
		
		
		
		
		
	}

}
