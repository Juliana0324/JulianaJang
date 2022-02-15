package day0119;

import java.util.StringTokenizer;

public class Homework0119 {
	
	//1¹ø
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
	
	
	//2¹ø
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
		
		System.out.print("·Î¶Ç ¹øÈ£: ");
		for(int i: randomList) {
			System.out.print(i+" ");
		}//endfor
		System.out.println();
	
	}//lotto
	
	
	//3¹ø
	public String words() {
		String csvData="¿ìÂ©·¡¹Ì,ÀúÂ©·¡¹Ì.³úÀýÆ¼ºñ~ÄíÄí·ç»æ»Í,Æ÷Ç×Ç×";
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
	
	//4¹ø
	public void nameVal(String firstName) {
		String data="±èÀÇÁ¤,°­¸íÁØ,±Ç¿ëÇö,Á¤ÀÎ¼±,±è¿¹Áø,°­»ê,±èÁø¿µ,±èÇö¿ì,¹Ú¼³Áø,¼­Áö¼÷,½ÅÀ¯Ã¶,ÀÌ³»Çõ,°­Çö¸ð,ÀåÁ¤¿ì,±èÁ¤ÇÏ,ÀåÇü±Ù,Àü¹ÎÁ¤,Á¤½ÃÇå,ÃÖ¿¬ÀÌ,È²¼ºÁØ,¼­Èñ¼ö";
		String[] names = data.split(",");
		int cnt =0;
		
		for(String first: names) {
			if(first.startsWith(firstName)) cnt++;
		}
		System.out.println(firstName+"¾¾ ¼ºÀ» °¡Áø ÀÎ¿ø: "+cnt);
	}//nameVal
	
	
	public static void main(String[] args) {
		Homework0119 hm = new Homework0119();
		System.out.println(hm.passValidation("AABAEDCA"));
		hm.lotto();
		System.out.println(hm.words());
		hm.nameVal("Àå");
	}

}
