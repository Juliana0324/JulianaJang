package day0106;

import java.util.Arrays;

/**
 * 가변인수
 * @author user
 *
 */
public class UseVariableArgument {

	/**
	 * variable Arguments를 사용한 method로 JDK1.5+부터 사용
	 * variable arguments는 method내부에서 배열(참조형데이터형-주소를 가짐)로 쓰여짐
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
	
	//VA는 가장 마지막에 정의 되어야함 	public void useVA2(int ...paramI, int paramJ) => 불가 
	public void useVA2(int paramI, int ...paramJ) {
		System.out.println(paramI);
		for(int i:paramJ) {
			System.out.print(i+" ");			
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		//객체화: 인스턴스 method나 변수를 사용하기위해 

			UseVariableArgument tva = new UseVariableArgument();
			tva.useVA(10);
			tva.useVA(10,20);
			tva.useVA(10,30,100);
			tva.useVA(10,40, 50, 700);
		
			
			tva.stringVariable("hi");
			tva.stringVariable("hi","안녕");
			
			tva.useVA2(1, 1,2,3,4,10);
	}

}
