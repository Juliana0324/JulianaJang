package day0104;

public class Homework {

	public static void main(String[] args) {
		//1. 1-100까지 수를 아래와 같이 출력
		// 1,2,짝 
		for(int i=1; i<101; i++) {
			if(i%3==0) {
				System.out.print("짝 ");
			}else {
				System.out.print(i+" ");
			}
		}
		
		System.out.println();
		System.out.println("----------------------------------------");
		
		//2.
		//열로 정렬
		for(int i=1; i<10;i++) {
			for(int j=2;j<10; j++) {
				System.out.print(j+" * "+i+" = "+i*j+"\t");
			}//end for
			System.out.println();
		}//end for
		System.out.println("----------------------------------------");

		
		//3. 입력되는 값이 2-9단 사이일때 입력되는 값으로 구구단을 출력하세요
		// 2-9단이 아니라면 
		int tri = Integer.parseInt(args[0]);
		if(tri>1 && tri<10) {
			for(int i=2; i<10; i++) {
				System.out.print(tri +" X " + i+" = "+ tri*i + "\t");
			}
		} else {
			System.out.println("구구단은 2~9까지만 가능합니다.");
		}
		
		
		
	}

}
