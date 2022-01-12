package day0112;

/**
 * ������ �迭([��][��])
 * ���Ǽ� : �迭��.length
 * ���� ��: �迭��[���ǹ�ȣ].length
 * @author user
 *
 */
public class UseArray2_1 {
	
	public void scoreProcess() {
		String[] names = {"������","����","������","������","������"};
		int[][] score = {{90, 94, 91},{86, 84, 71},{96,99,100},{75,76,73},{63,69, 69}};
		
		System.out.println("--------------------------------------------------------");
		System.out.println("��ȣ\t�̸�\t�ڹ�\t����Ŭ\tHTML\t�� ��\t���");
		System.out.println("--------------------------------------------------------");
		
		int totalScore = 0;
		for(int i=0; i<names.length; i++) {
			System.out.printf("%d\t%s\t",(i+1), names[i]);
			
			for(int j=0;j<score[i].length;j++) {
				System.out.printf("%d\t",score[i][j]);
				totalScore+= score[i][j];
			} //end for
			System.out.printf("%d\t%.2f\n",totalScore, (double)totalScore/score[i].length); //�������� ������ totalScore/score[i].length �θ� �ȵ�
			totalScore=0;
			
		}//end for
		
		
		//////////////////////////////////////////////////[����]/////////////////////////////////////////////////////////////////
		System.out.println("--------------------------------------------------------");
		System.out.printf("���� �ο� [%d]��\n",score.length);
		int sum = 0;
		
		for(int[] i:score) {
			for(int j: i)
			sum+=j;
		}
		//1. �ڵ带 ���� ����ؼ� ó��
		System.out.printf("��ü ���� [%d]��, ��ü ��� [%.2f]\n", sum, (double)sum/(score.length*score[0].length));
		
		
		

		//����
		//�Ʒ��� �۾��� instance variable�� method�� �ۼ��Ͽ� ó�� ����� ���
		eachScore(score);
		greatJava(score);
		bestStudent(score, names);

	}//UseArray2
	
	public void eachScore(int[][] score) {
		int java = 0, oracle=0, html=0;
		for(int i=0; i<score.length;i++) {
			java+=score[i][0];
			oracle+=score[i][1];
			html+=score[i][2];
		}
		System.out.printf("�ڹ� ����[%d], ����Ŭ ����[%d]��, Html ����[%d]\n",java,oracle,html);

	}//eachScore
	
	public void greatJava(int[][] score) {
		int max = score[0][0];
		for(int i=1; i<score.length;i++) {
			if(max<score[i][0]) {
				max = score[i][0];
			}//end if
		}//end for

		System.out.printf("�ڹ� �ְ���[%d]\n",max);
	}//greatJava
	
//	1���ȣ [0], �̸�[]
	public void bestStudent(int[][] score, String[] name) {
		int[] totalArr = new int[score.length];
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				totalArr[i] += score[i][j]; 
			}
			
			if(totalArr[0]<totalArr[i]) {
				System.out.printf("1���ȣ[%d], �̸�: [%s]",i+1,name[i]);
			}
			
		}//endfor
		
		
		
	}
	
	public static void main(String[] args) {
		new UseArray2_1().scoreProcess();
		System.out.println();
	
	}//main
	
}//class
