package day0113;

import javax.swing.text.html.HTML;

/**
 * ������ �迭�� �⺻�� ������ ���
 * @author user
 */
/**
 * @author user
 *
 */
/**
 * @author user
 *
 */
/**
 * @author user
 *
 */
public class UseArray2_1 {
	public static final int JAVA_IDX =0;
	public static final int ORACLE_IDX =0;
	public static final int HTML_IDX =0;
	
	private int javaTotal, oracleTotal, htmlTotal;
	private int JavaTopScore;
	
	public void scoreProcess() {
		String[] names= {"������","�ǿ���","������","������","������"};
		int[][] score= {
				{90,94,91},{86,84,71},{96,99,100},{75,76,73},{63,69,69}
				};		
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("��ȣ\t�̸�\t�ڹ�\t����Ŭ\tHTML\t����\t���");
		System.out.println("---------------------------------------------------------------------------------");
		
		int totalScore=0;// �л� ���� 
		for( int i = 0 ; i < score.length ; i++) {//��
			System.out.printf("%d\t%s\t",i+1, names[i]);
			for(int j = 0 ; j < score[i].length ; j++) {//��
				System.out.printf("%d\t", score[i][j]);
				totalScore+=score[i][j];//�� �л��� ������ ���� ��(+=) 
			}//end for
			System.out.printf("%d\t%.2f\n",totalScore, (double)totalScore/score[0].length);
			totalScore=0;
		}//end for
		System.out.println("---------------------------------------------------------------------------------");
		 System.out.printf("�����ο� [ %d ]��\n",score.length);
		 //����. �ڵ带 ��������ؼ� ó��.
		 System.out.printf("��ü ���� [ %d ]��,��ü ���[%.2f]\n",0, 0.0);
		 //����. �Ʒ��� �۾��� instance variable�� method�� �ۼ��Ͽ� ó�� ����� ���.  
		 
		 
		 
		 System.out.printf("�ڹ� ���� [ %d ]��, ����Ŭ ����[ %d ], HTML ����[ %d ]\n",JAVA_IDX, ORACLE_IDX, HTML_IDX);
		 System.out.printf("�ڹ� �ְ����� [ %d ]��\n",0);
		 System.out.printf("1���л��� ��ȣ[ %d], �̸�[%s ]\n",0,"");
	}//useArray2
	
	
	/**
	 * ���� ����
	 */
	public void subjectTotal(int[][] score) {
		//score�迭
		for(int i=0; i<score.length; i++) {
			javaTotal += score[i][0];
			oracleTotal+= score[i][1];
			htmlTotal += score[i][2];
		}
		System.out.printf("�ڹ� ���� [ %d ]��, ����Ŭ ����[ %d ], HTML ����[ %d ]\n",javaTotal, oracleTotal,htmlTotal);
	}

	public int eachScore(int[][] score, int num) {
		int eachScore = 0;
		for(int i=0; i<score.length; i++) {
				eachScore += score[i][num];		
		}//end for
		
		return eachScore;
	}//eachScore
	
	
	
	public static void main(String[] args) {
		new UseArray2_1().scoreProcess();
	}//main

}//class
