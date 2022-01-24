package day0124;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * �˻��� ����� ����, �ߺ��� ���x, �����Ͱ� ���������� �Էµ��� �ʴ� �ڷᱸ��
 * @author user
 *
 */
public class UseSet {
	
	public UseSet() {
		Set<String> set = new HashSet<String>();
		set.add("JAVA");
		set.add("Oracle");
		set.add("JDBC");
		set.add("HTML");
		set.add("CSS");
		set.add("JAVASCRIPT");
		System.out.println(set); //����� ���������� ���� ����: [JAVA, JAVASCRIPT, CSS, JDBC, HTML, Oracle]

		System.out.println("set�� ũ��"+ set.size());
		//�˻����

		
		String[] copyArray = new String[set.size()];
		set.toArray(copyArray);
		Arrays.stream(copyArray).forEach(s->System.out.println("�迭�� ����:"+s));
		for(int i=0; i<copyArray.length;i++) {
			System.out.println("for���� ����� ��"+copyArray[i]);
		}
		System.out.println("-----------------------------------");
		String value= "";
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			value = "iterator: "+iter.next();
			System.out.println(value);
		}
		
		System.out.println("-------------------���ٽ��� ���-----------");
		//���ٽ� ���
		set.forEach(x -> System.out.println("���ٽ�: "+ x));
		
		System.out.println("-------------------������ for��-----------");
		//������ for�� ���
		for(String str: set) {
			System.out.println("������ for��: "+str);
		}	// TODO Auto-generated constructor stub
	}
	
	/**
	 * Set �ߺ��� ���忩��
	 */
	public void dupVal() {
		Set<TestVO> set = new HashSet<TestVO>();
		set.add(new TestVO("������", 26));
		set.add(new TestVO("������", 25));
		set.add(new TestVO("���μ�", 24));
		set.add(new TestVO("������", 25));//���ο� �ּҴϱ� ���� ����
		
		TestVO tv = new TestVO("������",26);
		set.add(tv);
		set.add(tv); //���� �ּ��̱� ������ �ߺ�x
		System.out.println(set);
	}
	public static void main(String[] args) {
		UseSet us = new UseSet();
		System.out.println("--------------------------------�ߺ�����ó��--------------------------------");
		us.dupVal();
	}
}
