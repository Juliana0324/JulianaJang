package day0106;

public class Homework {
	
	//1. �ڽ��� ���� ���ڷ�
	public char initial(char c) {
		return c;
	}
	
	//2. ������ �Է¹޾Ƽ� ������ ��ȯ�ϴ� method�ۼ�(0~100������ ���� true�� , �ƴϸ� false)
	public boolean score(int score) {
		if(score>=0 && score<=100) {
			return true;
		} else {
			return false;
		}
	}
	
	//3. ������ �Է¹޾Ƽ� A-F���Ͽ� ��ȯ�ϴ� method�ۼ�(if�ۼ�)
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
	
	// 4. �����ð��� �ۼ��� printStar ȣ���Ͽ� ���� �Ʒ��� ���� ���/. �Ʊ� TestOverloadŬ���� �ȿ� printStar()�� �ۼ����ݾƿ�? �� Ŭ������ method�� ȣ���ؼ� �غ��ô°ſ���.
	public void printStar() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<i; j++) {
				if(i%2==0) {
					System.out.print("��");
				}else {
					System.out.print("��");
				}
				
			}
			System.out.println();
		}
	}	
	
	//�������� ����ϴ� method�� �ۼ�
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
		System.out.println("1��: "+hm.initial('J'));
		
		System.out.println("2��: "+hm.score(100));
		
		System.out.println("3��: "+hm.score2(80));
		
		System.out.println("4��: ");
		
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
