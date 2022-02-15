package day0119;

import java.util.StringTokenizer;

public class Homework0119 {
	
	//1��
	public char[] passValidation(String pass){
		char[] charArr = new char[62];   
	    
		if(pass.length()==8) {
		    for(int i=0; i<pass.length();) {
		    	char letters = (char)((Math.random()*75)+48);
				if(letters>90 && letters<97) {
					continue;
				}else if(letters>57 && letters<65) {
					continue;
				}else {
					charArr[i] = letters;
					i++;
				}		
		    }
		}
		return charArr;
					
	}
	
	
	//2��
	public void lotto() {
		int[] randomList = new int[6];
		for(int i=0; i<6; i++) {
			randomList[i] = (int)(Math.random()*45)+1;
			for(int j=0; j<i;j++) {
				if(randomList[i] == randomList[j]) {
					i--;
					break;
				}//endif
			}//endfor
		}//endfor
		
		System.out.print("�ζ� ��ȣ: ");
		for(int i: randomList) {
			System.out.print(i+" ");
		}//endfor
		System.out.println();
	
	}//lotto
	
	
	//3��
	public String words() {
		String csvData="��©����,��©����.����Ƽ��~�������,������";
		StringTokenizer st = new StringTokenizer(csvData, ",.~");
		String[] wordsList = new String[st.countTokens()];
		String answer= "";
		while(st.hasMoreTokens()) {
			for(int i=0;i<wordsList.length;i++) {
				wordsList[i]= st.nextToken();
				answer+= wordsList[i]+" ";
			}//end for
		}
		return answer;
		
	}
	
	//4��
	public void nameVal(String firstName) {
		String data="������,������,�ǿ���,���μ�,�迹��,����,������,������,�ڼ���,������,����ö,�̳���,������,������,������,������,������,������,�ֿ���,Ȳ����,�����";
		String[] names = data.split(",");
		int cnt =0;
		
		for(String first: names) {
			if(first.startsWith(firstName)) cnt++;
		}
		System.out.println(firstName+"�� ���� ���� �ο�: "+cnt);
	}//nameVal
	
	
	public static void main(String[] args) {
		Homework0119 hm = new Homework0119();
		System.out.println(hm.passValidation("AABAEDCA"));
		hm.lotto();
		System.out.println(hm.words());
		hm.nameVal("��");
	}

}
