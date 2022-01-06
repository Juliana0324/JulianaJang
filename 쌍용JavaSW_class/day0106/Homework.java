package day0106;

public class Homework {
	
	//1. 자신의 성을 문자로
	public char initial(char c) {
		return c;
	}
	
	//2. 점수를 입력받아서 판정을 반환하는 method작성(0~100사이일 떄느 true를 , 아니면 false)
	public boolean score(int score) {
		if(score>=0 && score<=100) {
			return true;
		} else {
			return false;
		}
	}
	
	//3. 점수를 입력받아서 A-F구하여 반환하는 method작성(if작성)
	public char score2(int score) {
		if(score>89 && score<=100) {
			return 'A';
		} else if(score>79 && score<91) {
			return 'B';
		} else if(score>69 && score<81) {
			return 'C';
		} else if(score>59 && score<71) {
			return 'D';
		} else {
			return 'F';
		}
	}
	
	// 4. 수업시간에 작성한 printStar 호출하여 별을 아래와 같이 출력/. 아까 TestOverload클래스 안에 printStar()를 작성했잖아요? 그 클래스의 method를 호출해서 해보시는거에요.
	public void printStar() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<i; j++) {
				if(i%2==0) {
					System.out.print("☆");
				}else {
					System.out.print("★");
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
		System.out.println("1번: "+hm.initial('J'));
		
		System.out.println("2번: "+hm.score(100));
		
		System.out.println("3번: "+hm.score2(80));
		
		System.out.println("4번: ");
		
		TestOverLoad tol = new TestOverLoad();
//		tol.printstar();
//		System.out.println();
//		tol.printstar(2);
//		for(int i=0; i<3;i++) {
//			tol.printstar();
//		}
//		System.out.println();
//		tol.printstar(4);
//		System.out.println();
		
		for(int i=0; i<5;i++) {
			for(int j=0; j<i;j++) {
				if(i%2==1) {
					tol.printstar();					
				}else {
					tol.printstar(j);
					
				}
			}
			System.out.println();
		}
		
		
		
		System.out.println();
		hm.gugudan();
		System.out.println();
		hm.gugudan(5);
		
	}

}
