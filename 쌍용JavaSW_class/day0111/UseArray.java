package day0111;

import java.util.ArrayList;
import java.util.List;

/**
 * 일차원 배열의 사용
 * 
 * @author user
 *
 */
public class UseArray {
	
	public void useArray1() {
		//1. 선언 : 데이터형[] 배열명 = null;
		int[] arr = null;
		
		//2. 생성 : 배열명 = new 데이터형[방의 수];
		// 힙에 생성되고 모든 방의 값은 자동 초기화된다. - 방의 갯수를 변하지 않는다. (고정 길이형)
		arr = new int[5];
		
		System.out.println(arr);
		
		//3. 값 할당
		arr[0] = 2022;
		arr[1] = 1;
		arr[2] = 11;
		arr[3] = 15;
		arr[4] = 7;
		
		System.out.println("arr의 방의 갯수: "+arr.length);
		for(int i=0; i<arr.length;i++) {
			System.out.println("arr["+i+"]");
		}
		for(int i: arr) {
			System.out.print(i+" / ");
		}
		System.out.println();
		System.out.println("============================================================");
		System.out.println();
		System.out.println("짝수번만 출력");
		//배열의 짝수 번째방만 출력
		for(int i=0; i<arr.length;i+=2) {
			System.out.println("arr["+i+"]: "+arr[i]);
		}
		System.out.println("============================================================");
		for(int i=arr.length-1; i>=0;i--) {
			System.out.println("arr["+i+"]: "+arr[i]);
		}
		
		System.out.println("-------------배열의 기본형 형식의 사용 ---------------------");
		//배열의 값을 미리 알고 있을 때
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
		System.out.println("학생 7명의 점수를 처리하는 프로그램 작성");
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
		System.out.println("최대점수 :"+max);
		System.out.println("최소점수 :"+min);
		
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
