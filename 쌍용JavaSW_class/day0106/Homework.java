package day0106;

public class Homework {
	
	//1. �ڽ��� ���� ���ڷ�
	public final char initial() {
		return 'J';
	}
	
	//2. ������ �Է¹޾Ƽ� ������ ��ȯ�ϴ� method�ۼ�(0~100������ ���� true�� , �ƴϸ� false)
	/**
	 * �ԷµǴ� ������ ����
	 * @param score
	 * @return
	 */
	public boolean score(int score) {
		boolean flag = score>=0 && score<=100;

		return flag;
	}
	
	//3. ������ �Է¹޾Ƽ� A-F���Ͽ� ��ȯ�ϴ� method�ۼ�(if�ۼ�)
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
	 * ���� ��� - ������
	 * �ٸ� Ŭ������ �����ϴ� method�� ��Ȳ�� �°� ȣ��
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
		System.out.println("1��: "+hm.initial());
		
		int score = 100;
		boolean flag = hm.score(score);
		System.out.println("2��: "+flag);
		
		if(flag) {
			char gt = hm.score2(score);
			System.out.println("3��: "+gt);			
		}
		
		System.out.println("4��: ");
		
		//4-1��° Ǯ��
		hm.printStar();
		
		
		//4-2��° Ǯ��
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

