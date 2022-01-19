package day0119;

import java.util.ArrayList;
import java.util.List;

/**
 * Math => private�� �����ڰ� ���⋚���� 
 * instance�޼ҵ尡 ����
 * Static �޼ҵ�ۿ� ����
 * @author user
 *
 */
public class UseMath {

	
	public static void main(String[] args) {

		System.out.println(Math.max(10, 200));
		System.out.println(Math.abs(-10));//���밪
		System.out.println(Math.round(10.3));//�ݿø�
		System.out.println(Math.ceil(10.5));//�ø�
		System.out.println(Math.floor(10.5));//����
		System.out.println(Math.sqrt(4)); //������

		double num = Math.random();
		System.out.println("�߻��� ���� "+num);
		System.out.println("������ ���� "+(int)((num*9)+1));
		
		//1-100������ ����
		int temp = (int)(Math.random()*100)+1;
		System.out.println("1-100���� ���� "+temp);
		
		int alp = (int)(Math.random()*26)+65;
		System.out.println((char)alp);
		
		int lower = (int)(Math.random()*26)+97;
		System.out.println((char)lower);
		
		int cal = (int)(Math.random()*10)+48;
		System.out.println((char)cal);
		//���ϼ̽��ϴ�.
		
		
		System.out.println("========================");
		//�ߺ����� �ʴ� ���� ���ϱ�
		
		int[] randomList = new int[6];
		for(int i=0; i<6; i++) {
			randomList[i] = (int)(Math.random()*45);
			
			for(int j=0; j<i;j++) {
				if(randomList[i] == randomList[j]) {
					i--;
					break;
				}
			}
			
			
		}
		
		for(int i: randomList) {
			System.out.print(i+" ");
		}
		

	}

}
