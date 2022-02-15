package day0121;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class UseList {
	public void useArrayList(){
		List<String> list= new ArrayList<String>();
		
		//값 할당 ) 값은 순차적으로 할당되면, 값을 할당할 때마다 방의 개수가 증가
		///중복을 허용함
		list.add("Java");
		list.add("Oracle");
		list.add("JDBC");
		list.add("HTML");
		list.add("포항항");
//		list.add(2, "포항항항"); => LinkedList 킹추전
		
		System.out.println(list+" / "+ list.size());
//		list.clear();
		
		if(list.isEmpty()) {
			System.out.println("리스트 비어있음");
		}else {
			System.out.println("리스트 값있음");
			
		}
		
		String val = list.get(0);
		System.out.println(val);
		for(int i=0; i<list.size();i++) {
			System.out.printf("list.get(%d) = %s\n", i,list.get(i));
		}
		
	
		//배열로 복사: Generic이 설정되어야 함.
		//1. 복사할 배열을 생성
		String[] copy = new String[list.size()];
		
	//2. 복사
		list.toArray(copy);
		System.out.println(Arrays.toString(copy));
		
		//삭제
		list.remove(1);
		System.out.println(list+" / "+ list.size());
		
		//방의 내용으로 삭제. 중복값이 존재한다면 가장 처음 값사삭제
		list.remove("Java");
		System.out.println(list+" / "+ list.size());

		
	}
	
	public void useVector(){
		List<String> list= new Vector<String>();
		
		//값 할당 ) 값은 순차적으로 할당되면, 값을 할당할 때마다 방의 개수가 증가
		///중복을 허용함
		list.add("Java");
		list.add("Oracle");
		list.add("JDBC");
		list.add("HTML");
		list.add("포항항");
//		list.add(2, "포항항항"); => LinkedList 킹추전
		
		System.out.println(list+" / "+ list.size());
//		list.clear();
		
		if(list.isEmpty()) {
			System.out.println("리스트 비어있음");
		}else {
			System.out.println("리스트 값있음");
			
		}
		
		String val = list.get(0);
		System.out.println(val);
		for(int i=0; i<list.size();i++) {
			System.out.printf("list.get(%d) = %s\n", i,list.get(i));
		}
		
	
		//배열로 복사: Generic이 설정되어야 함.
		//1. 복사할 배열을 생성
		String[] copy = new String[list.size()];
		
	//2. 복사
		list.toArray(copy);
		System.out.println(Arrays.toString(copy));
		
		//삭제
		list.remove(1);
		System.out.println(list+" / "+ list.size());
		
		//방의 내용으로 삭제. 중복값이 존재한다면 가장 처음 값사삭제
		list.remove("Java");
		System.out.println(list+" / "+ list.size());

		
	
		}
	
	int cnt;
	public void useLinkedList(){
		cnt++;
		System.out.println(cnt);
		List<String> list= new ArrayList<String>();
		
		//값 할당 ) 값은 순차적으로 할당되면, 값을 할당할 때마다 방의 개수가 증가
		///중복을 허용함
		list.add("Java");
		list.add("Oracle");
		list.add("JDBC");
		list.add("HTML");
		list.add("포항항");
//		list.add(2, "포항항항"); => LinkedList 킹추전
		
		System.out.println(list+" / "+ list.size());
//		list.clear();
		
		if(list.isEmpty()) {
			System.out.println("리스트 비어있음");
		}else {
			System.out.println("리스트 값있음");
			
		}
		
		String val = list.get(0);
		System.out.println(val);
		for(int i=0; i<list.size();i++) {
			System.out.printf("list.get(%d) = %s\n", i,list.get(i));
		}
		
	
		//배열로 복사: Generic이 설정되어야 함.
		//1. 복사할 배열을 생성
		String[] copy = new String[list.size()];
		
	//2. 복사
		list.toArray(copy);
		System.out.println(Arrays.toString(copy));
		
		//삭제
		list.remove(1);
		System.out.println(list+" / "+ list.size());
		
		//방의 내용으로 삭제. 중복값이 존재한다면 가장 처음 값사삭제
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
