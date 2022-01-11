package day0111;

import java.util.ArrayList;
import java.util.List;

/**
 * ������ �迭�� ���
 * 
 * @author user
 *
 */
public class UseArray {
	
	public void useArray1() {
		//1. ���� : ��������[] �迭�� = null;
		int[] arr = null;
		
		//2. ���� : �迭�� = new ��������[���� ��];
		// ���� �����ǰ� ��� ���� ���� �ڵ� �ʱ�ȭ�ȴ�. - ���� ������ ������ �ʴ´�. (���� ������)
		arr = new int[5];
		
		System.out.println(arr);
		
		//3. �� �Ҵ�
		arr[0] = 2022;
		arr[1] = 1;
		arr[2] = 11;
		arr[3] = 15;
		arr[4] = 7;
		
		System.out.println("arr�� ���� ����: "+arr.length);
		for(int i=0; i<arr.length;i++) {
			System.out.println("arr["+i+"]");
		}
		for(int i: arr) {
			System.out.print(i+" / ");
		}
		System.out.println();
		System.out.println("============================================================");
		System.out.println();
		System.out.println("¦������ ���");
		//�迭�� ¦�� ��°�游 ���
		for(int i=0; i<arr.length;i+=2) {
			System.out.println("arr["+i+"]: "+arr[i]);
		}
		System.out.println("============================================================");
		for(int i=arr.length-1; i>=0;i--) {
			System.out.println("arr["+i+"]: "+arr[i]);
		}
		
		System.out.println("-------------�迭�� �⺻�� ������ ��� ---------------------");
		//�迭�� ���� �̸� �˰� ���� ��
		int[] arr2 = new int[] {10,20,30,40,50,60};
		int[] arr3 = {10,20,30,40,50,60};
		
		for(int i=0; i<arr2.length;i++) {
			System.out.printf("arr[%d] = %-5d", i,arr2[i]);
		}
		System.out.println();
		for(int i=0; i<arr3.length;i++) {
			System.out.printf("arr[%d] = %-5d", i,arr3[i]);
		}
		
		
		
		
	}//useArray1
	
	public void scoreValidate() {
		/////////////////////////////////////////////////////////////////////////
		System.out.println("�л� 7���� ������ ó���ϴ� ���α׷� �ۼ�");
		int[] score = {89,77,91,99,63,100,86};
		int max=0;
		int min=score[0];
		for(int i=0;i<score.length;i++) {
			if(score[i]>max) {
				max = score[i];
			} else if(score[i]<min){
				min = score[i];
			}
		}
		System.out.println("�ִ����� :"+max);
		System.out.println("�ּ����� :"+min);
		
	}
	public static void main(String[] args) {
//		UseArray ua = new UseArray();
//		ua.useArray1();
		//==
		new UseArray().useArray1();
		System.out.println();
		
		System.out.println("=======================scoreValidation==============================");
		new UseArray().scoreValidate();
		System.out.println("=======================scoreValidation==============================");
		
	}//end main

}//end class
