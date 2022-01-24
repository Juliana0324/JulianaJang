package day0121;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class UseList {
	public void useArrayList(){
		List<String> list= new ArrayList<String>();
		
		//�� �Ҵ� ) ���� ���������� �Ҵ�Ǹ�, ���� �Ҵ��� ������ ���� ������ ����
		///�ߺ��� �����
		list.add("Java");
		list.add("Oracle");
		list.add("JDBC");
		list.add("HTML");
		list.add("������");
//		list.add(2, "��������"); => LinkedList ŷ����
		
		System.out.println(list+" / "+ list.size());
//		list.clear();
		
		if(list.isEmpty()) {
			System.out.println("����Ʈ �������");
		}else {
			System.out.println("����Ʈ ������");
			
		}
		
		String val = list.get(0);
		System.out.println(val);
		for(int i=0; i<list.size();i++) {
			System.out.printf("list.get(%d) = %s\n", i,list.get(i));
		}
		
	
		//�迭�� ����: Generic�� �����Ǿ�� ��.
		//1. ������ �迭�� ����
		String[] copy = new String[list.size()];
		
	//2. ����
		list.toArray(copy);
		System.out.println(Arrays.toString(copy));
		
		//����
		list.remove(1);
		System.out.println(list+" / "+ list.size());
		
		//���� �������� ����. �ߺ����� �����Ѵٸ� ���� ó�� �������
		list.remove("Java");
		System.out.println(list+" / "+ list.size());

		
	}
	
	public void useVector(){
		List<String> list= new Vector<String>();
		
		//�� �Ҵ� ) ���� ���������� �Ҵ�Ǹ�, ���� �Ҵ��� ������ ���� ������ ����
		///�ߺ��� �����
		list.add("Java");
		list.add("Oracle");
		list.add("JDBC");
		list.add("HTML");
		list.add("������");
//		list.add(2, "��������"); => LinkedList ŷ����
		
		System.out.println(list+" / "+ list.size());
//		list.clear();
		
		if(list.isEmpty()) {
			System.out.println("����Ʈ �������");
		}else {
			System.out.println("����Ʈ ������");
			
		}
		
		String val = list.get(0);
		System.out.println(val);
		for(int i=0; i<list.size();i++) {
			System.out.printf("list.get(%d) = %s\n", i,list.get(i));
		}
		
	
		//�迭�� ����: Generic�� �����Ǿ�� ��.
		//1. ������ �迭�� ����
		String[] copy = new String[list.size()];
		
	//2. ����
		list.toArray(copy);
		System.out.println(Arrays.toString(copy));
		
		//����
		list.remove(1);
		System.out.println(list+" / "+ list.size());
		
		//���� �������� ����. �ߺ����� �����Ѵٸ� ���� ó�� �������
		list.remove("Java");
		System.out.println(list+" / "+ list.size());

		
	
		}
	
	int cnt;
	public void useLinkedList(){
		cnt++;
		System.out.println(cnt);
		List<String> list= new ArrayList<String>();
		
		//�� �Ҵ� ) ���� ���������� �Ҵ�Ǹ�, ���� �Ҵ��� ������ ���� ������ ����
		///�ߺ��� �����
		list.add("Java");
		list.add("Oracle");
		list.add("JDBC");
		list.add("HTML");
		list.add("������");
//		list.add(2, "��������"); => LinkedList ŷ����
		
		System.out.println(list+" / "+ list.size());
//		list.clear();
		
		if(list.isEmpty()) {
			System.out.println("����Ʈ �������");
		}else {
			System.out.println("����Ʈ ������");
			
		}
		
		String val = list.get(0);
		System.out.println(val);
		for(int i=0; i<list.size();i++) {
			System.out.printf("list.get(%d) = %s\n", i,list.get(i));
		}
		
	
		//�迭�� ����: Generic�� �����Ǿ�� ��.
		//1. ������ �迭�� ����
		String[] copy = new String[list.size()];
		
	//2. ����
		list.toArray(copy);
		System.out.println(Arrays.toString(copy));
		
		//����
		list.remove(1);
		System.out.println(list+" / "+ list.size());
		
		//���� �������� ����. �ߺ����� �����Ѵٸ� ���� ó�� �������
		list.remove("Java");
		System.out.println(list+" / "+ list.size());

		//useLinkedList();
	
	}

	
	
	
	public static void main(String[] args) {
		UseList ulist = new UseList();
		System.out.println("------------ArrayList--------------");System.out.println();
		ulist.useArrayList();
		System.out.println("------------Vector-----------------");System.out.println();
		ulist.useVector();
		System.out.println("------------LinkedList--------------");System.out.println();
		ulist.useLinkedList();
	}

}
