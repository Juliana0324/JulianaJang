package day0117;

import java.util.Calendar;
import java.util.Date;

public class RunTestOverrid {

	@Override
	public String toString() {
		return "��ü�� ��µɶ� �ּҰ� �ƴ� �ٸ� �޼����� ����ϵ��� ����: "+super.toString();
	}
	
	public static void main(String[] args) {
	
		// ��Ӱ����� ��üȭ :  �ڽ�Ŭ������ �������� �θ�Ŭ������ ����
		// �θ�Ŭ������ ��ü�� = new �ڽ�Ŭ���� ������();
		TestOverrideSuper tosuper = new TestOverrideSub();
		tosuper.test(); //�θ�Ŭ������ test method ==> �θ� ���ǵ� �޼ҵ�
		tosuper.temp(); //�ڽ�Ŭ������ temp method ==> �������̵� �� �ڽ� �޼ҵ�
//		tosuper.sub();  => error

		System.out.println("-------------------------------------------------");
		//�ڽ�Ŭ������ ��üȭ : �θ�Ŭ������ ��� �ڿ��� �ڽ�Ŭ������ ��� �ڿ��� ����� �� �ִ�
		TestOverrideSub tosub = new TestOverrideSub();
		tosub.test(); //�θ�Ŭ������ test method
		tosub.temp(); //�ڽ�Ŭ������ temp method
		tosub.sub(); //�ڽ�Ŭ������ ���� method
		
		System.out.println("-------------------------------------------------");
		//toString -> ��ü�� ��������� ��ü�� �ּҰ� �ƴ� ���� ��ȯ�Ҷ� toString()�� Override�Ͽ� Ŭ������ �ۼ�
		
		RunTestOverrid rto = new RunTestOverrid();
		System.out.println(rto.toString()); //�ּ�
		
		String str = new String("������ ������");
		System.out.println(str.toString()); //�޼��� ���
		
		Date date = new Date();
		System.out.println(date.toString()); //�޼��� ���

		System.out.println(tosub.toString());  // �ּ�-> toString�޼ҵ带 ����ϰԵ�
		
		Calendar cal = Calendar.getInstance();
		
		
	}
}
