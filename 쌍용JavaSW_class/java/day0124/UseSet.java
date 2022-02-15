package day0124;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 검색의 기능이 없고, 중복값 허용x, 데이터가 순차적으로 입력되지 않는 자료구조
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
		System.out.println(set); //출력이 순차적으로 되지 않음: [JAVA, JAVASCRIPT, CSS, JDBC, HTML, Oracle]

		System.out.println("set의 크기"+ set.size());
		//검색기능

		
		String[] copyArray = new String[set.size()];
		set.toArray(copyArray);
		Arrays.stream(copyArray).forEach(s->System.out.println("배열의 람다:"+s));
		for(int i=0; i<copyArray.length;i++) {
			System.out.println("for문의 복사된 값"+copyArray[i]);
		}
		System.out.println("-----------------------------------");
		String value= "";
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			value = "iterator: "+iter.next();
			System.out.println(value);
		}
		
		System.out.println("-------------------람다식의 사용-----------");
		//람다식 사용
		set.forEach(x -> System.out.println("람다식: "+ x));
		
		System.out.println("-------------------개선된 for문-----------");
		//개선된 for문 사용
		for(String str: set) {
			System.out.println("개선된 for문: "+str);
		}	// TODO Auto-generated constructor stub
	}
	
	/**
	 * Set 중복값 저장여부
	 */
	public void dupVal() {
		Set<TestVO> set = new HashSet<TestVO>();
		set.add(new TestVO("장정우", 26));
		set.add(new TestVO("정시헌", 25));
		set.add(new TestVO("정인선", 24));
		set.add(new TestVO("정시헌", 25));//새로운 주소니까 들어갈수 있음
		
		TestVO tv = new TestVO("전민정",26);
		set.add(tv);
		set.add(tv); //같은 주소이기 떄문에 중복x
		System.out.println(set);
	}
	public static void main(String[] args) {
		UseSet us = new UseSet();
		System.out.println("--------------------------------중복값의처리--------------------------------");
		us.dupVal();
	}
}
