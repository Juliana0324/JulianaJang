package day0204;

import java.util.Random;

public class HwangSeoungJun {
	
	public String walk() throws TabacoException {
		String result = "";
		
		String[] studentGrade= "초딩,중딩,고딩,대딩".split(",");
		int tempFlag =new Random().nextInt(studentGrade.length);
		
		switch(tempFlag) {
		case 0: //초딩이 담배피운다
			throw new TabacoException("어이 거기 초딩님 지나친 흡연은 건강에 해롭습니다.");
		}
		result = studentGrade[tempFlag] +"님 흡연중 모른척 지나감.";
		
		return result;
	}//TabacoException
	
	public static void main(String[] args) {
		HwangSeoungJun hsj = new HwangSeoungJun();
		try {
			String result = hsj.walk();
			System.out.println("정상적인 상태 : "+ result);
		}catch(TabacoException te){
			System.err.println("비정상적인 상태 :"+ te);
			te.printStackTrace();
		}
		
	}
}
