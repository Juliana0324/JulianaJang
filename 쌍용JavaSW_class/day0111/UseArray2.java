package day0111;

public class UseArray2 {
	
	//������
	public UseArray2() {
		int[] stuScore = {89,77,91,99,63,100,86};
		int sum = 0, max =0;
		int min = stuScore[0];
		for(int i=0; i<stuScore.length;i++) {
			System.out.printf("%d�� : %d�� = %s����\n", i+1, stuScore[i],gradeText(stuScore[i]));
			sum+= stuScore[i];
		}//end for

		System.out.println("����: "+sum);
		//�迭�� ���߿� �ְ������� ������ ���Ͻÿ�
		scoreValidate(stuScore);
		
		
//		if(stuScore[i]>max) {
//			max = stuScore[i];
//		}else if(stuScore[i]<min){
//			min = stuScore[i];
//		}//end if		
//		System.out.println("�ְ����� : "+max);
//		System.out.println("�������� : "+min);
		
		
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
	
	
	
	
	//�ְ����� 
	public void scoreValidate(int[] score) {
		System.out.println("�л� 7���� ������ ó���ϴ� ���α׷� �ۼ�");
		int max=0;
		int min=score[0];
		for(int i=0;i<score.length;i++) {
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
		//new UseArray2().scoreValidate();

	}//main

}//class
