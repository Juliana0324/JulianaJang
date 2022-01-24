package day0121;

import java.util.ArrayList;
import java.util.List;
import day0120.UseDate;

public class NotUseGeneric {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public NotUseGeneric() {
		//1. List생성
		List list = new ArrayList();

		//2. 값 할당
		list.add(2022);
		list.add(1);
		list.add(12.42);
		list.add("Generic");
		list.add(new UseDate());
		
		//3. 일괄처리하여 값 얻기
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));			
		}
	}	
	
	public static void main(String[] args) {
		new NotUseGeneric();
	}//main

}//class
