package day0106;

import java.util.Arrays;

/**
 * �����μ�
 * @author user
 *
 */
public class UseVariableArgument {

	/**
	 * variable Arguments�� ����� method�� JDK1.5+���� ���
	 * variable arguments�� method���ο��� �迭(��������������-�ּҸ� ����)�� ������
	 * 
	 * @param args
	 */
	public void useVA(int ...num) {
		for(int i=0;i<num.length;i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println();
		
	}
	
	public void stringVariable(String ...txt) {
		System.out.println(Arrays.toString(txt));
	}
	
	//VA�� ���� �������� ���� �Ǿ���� 	public void useVA2(int ...paramI, int paramJ) => �Ұ� 
	public void useVA2(int paramI, int ...paramJ) {
		System.out.println(paramI);
		for(int i:paramJ) {
			System.out.print(i+" ");			
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		//��üȭ: �ν��Ͻ� method�� ������ ����ϱ����� 

			UseVariableArgument tva = new UseVariableArgument();
			tva.useVA(10);
			tva.useVA(10,20);
			tva.useVA(10,30,100);
			tva.useVA(10,40, 50, 700);
		
			
			tva.stringVariable("hi");
			tva.stringVariable("hi","�ȳ�");
			
			tva.useVA2(1, 1,2,3,4,10);
	}

}
