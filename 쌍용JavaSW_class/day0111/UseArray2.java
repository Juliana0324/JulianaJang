package day0111;

public class UseArray2 {
	
	//������
	public UseArray2() {
		int[] stuScore = {89,77,91,99,63,100,86};
		int sum = 0;
		for(int i=0; i<stuScore.length;i++) {
			System.out.printf("%d�� : %d�� = %s����\n", i+1, stuScore[i],gradeText(stuScore[i]));
			sum+= stuScore[i];
		}//end for

		System.out.println("����: "+sum);
		//�迭�� ���߿� �ְ������� ������ ���Ͻÿ�
//		scoreValidate(stuScore); 

		System.out.println("�ְ����� : "+topScore(stuScore));
		
		//char������ �迭�� ����� �迭���� ����ϸ� �ٸ��迭�� �ٸ��� ���� ��µ�
		System.out.println(stuScore); //�ּ�
		
		char[] arr = {'A','b','c','D','e'};
		System.out.println(arr);
		
		for(char value: arr) {
			System.out.print(value+" ");
		}
		
		
	}//UseArray2

	public String gradeText(int score) {
		String s = "F";
		if(score<=100 && score>89) {
			s = "A";
		} else if(score<90 && score>79){
			s= "B";
		} else if(score<80 && score>69){
			s= "C";
		} else if(score<70 && score>59){
			s= "D";
		}
		
		return s;
		
	}
	
	public int topScore(int[] score) {
		int max=score[0];
		for(int i: score) {
			if(i>max) {
				max = i;
			} 
		}		
		
		return max;
	}
	
	
	//�ְ����� 
	public void scoreValidate(int[] score) {
		System.out.println("�л� 7���� ������ ó���ϴ� ���α׷� �ۼ�");
		int max=score[0];
		int min=score[0];
		for(int i=1;i<score.length;i++) {
			if(score[i]>max) {
				max = score[i];
			} else if(score[i]<min) {
				min = score[i];
			}
		}		
		System.out.println("�ְ����� :"+max);
		System.out.println("�ּ����� :"+min);
	}

	public static void main(String[] args) {
		//UseArray2 ua = new UseArray2();
		new UseArray2();
		System.out.println();

	}//main

}//class
