package day0502.poly;

import java.util.HashMap;
import java.util.Map;

public class UseInterface {

	public static void main(String[] args) {
		//1. �� �Ҵ�
		Map<String, Action> map=new HashMap<String, Action>();
		
		//2. �� �Ҵ�
		map.put("a", new TestA());
		map.put("b", new TestB());
		map.put("c", new TestC());
		
		//3. �� ȹ��
		//��ü ������: �ϳ��� �̸����� �ٸ� ���� ������ �� �ִ�
		String key="a";
		if(map.containsKey(key)) {
			//4. key�� �־� �θ� ���
			Action action=map.get(key);
			
			//5. �޼ҵ� ȣ��: Override�� �޼ҵ尡 ��ȣ���
			System.out.println(action.execute());
			
		}
	}

}
