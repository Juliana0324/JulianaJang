package day0204;

import java.util.Random;

public class HwangSeoungJun {
	
	public String walk() throws TabacoException {
		String result = "";
		
		String[] studentGrade= "�ʵ�,�ߵ�,���,���".split(",");
		int tempFlag =new Random().nextInt(studentGrade.length);
		
		switch(tempFlag) {
		case 0: //�ʵ��� ����ǿ��
			throw new TabacoException("���� �ű� �ʵ��� ����ģ ���� �ǰ��� �طӽ��ϴ�.");
		}
		result = studentGrade[tempFlag] +"�� ���� ��ô ������.";
		
		return result;
	}//TabacoException
	
	public static void main(String[] args) {
		HwangSeoungJun hsj = new HwangSeoungJun();
		try {
			String result = hsj.walk();
			System.out.println("�������� ���� : "+ result);
		}catch(TabacoException te){
			System.err.println("���������� ���� :"+ te);
			te.printStackTrace();
		}
		
	}
}
