package day0502;

import java.util.HashMap;
import java.util.Map;

public class NotUseInterface {

	
	public static void main(String[] args) {
		//�θ� ��ġ���� ���� Ŭ������ Map�� �ְ� ���
		
		//1. map ����
		Map<String, Object> map=new HashMap<String, Object>();
		
		//2. �� �Ҵ�
		map.put("a", new TestA());
		map.put("b", new TestB());
		map.put("c", new TestC());
		
		//3. �����(Ű���)
		//��ü�������� ������� ������ ������ Ŭ������ �� ���ϰ� ó���ؾ��Ѵ�(�ߺ��ڵ�����)
		String key="a";
		if("a".equals(key)) { //Ű ��
			TestA ta= (TestA)map.get(key);
			System.out.println(ta.execute());
		}
		if("b".equals(key)) {
			TestB tb= (TestB)map.get(key);
			System.out.println(tb.execute());
		}
		if("c".equals(key)) {
			TestC tc= (TestC)map.get(key);
			System.out.println(tc.execute());
		}
		
	}//main

}
