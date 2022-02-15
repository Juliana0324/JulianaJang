package day0106;

public class Homework {
	
	//1. 자신의 성을 문자로
	public final char initial() {
		return 'J';
	}
	
	//2. 점수를 입력받아서 판정을 반환하는 method작성(0~100사이일 떄느 true를 , 아니면 false)
	/**
	 * 입력되는 점수의 판정
	 * @param score
	 * @return
	 */
	public boolean score(int score) {
		boolean flag = score>=0 && score<=100;

		return flag;
	}
	
	//3. 점수를 입력받아서 A-F구하여 반환하는 method작성(if작성)
	public char score2(int score) {
		char s = 'F';
		if(score>89 && score<=100) {
			s = 'A';
		} else if(score>79 && score<90) {
			s = 'B';
		} else if(score>69 && score<80) {
			s = 'C';
		} else if(score>59 && score<70) {
			s = 'D';
		}
		
		return s;
	}
	
	
	/**
	 * 별을 출력 - 고정일
	 * 다른 클래스에 존재하는 method를 상황에 맞게 호출
	 */
	public void printStar() {
		TestOverLoad tol = new TestOverLoad();		
		for(int i=1; i<5;i++) {
			for(int j=1; j<i+1;j++) {
				if(i%2==0) {
					tol.printstar(1);					
				}else {
					tol.printstar();
				}
			}
			System.out.println();
		}
	}
	
	
	
	//구구단을 출력하는 method를 작성
	public void gugudan() {
		for(int i=1; i<10; i++) {
			System.out.printf("2 * %d = %d\t",i,2*i);			
		}
	}
	public void gugudan(int num) {
		for(int i=1; i<10; i++) {
			System.out.printf("%d * %d = %d\t",num, i,num*i);			
		}
	}
	
	
	public static void main(String[] args) {
		Homework hm = new Homework();
		System.out.println("1번: "+hm.initial());
		
		int score = 100;
		boolean flag = hm.score(score);
		System.out.println("2번: "+flag);
		
		if(flag) {
			char gt = hm.score2(score);
			System.out.println("3번: "+gt);			
		}
		
		System.out.println("4번: ");
		
		//4-1번째 풀이
		hm.printStar();
		
		
		//4-2번째 풀이
//		System.out.println();
//		for(int i=1; i<5;i++) {
//			if(i%2 !=0) {
//				for(int j=0;j<i;j++) {
//					tol.printstar();
//				}
//			}else {
//				tol.printstar(i);
//			}
//			System.out.println();
//		}
		
		
		System.out.println();
		hm.gugudan();
		System.out.println();
		hm.gugudan(5);
		
	}

}

