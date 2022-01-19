package day0119;

import java.util.StringTokenizer;

/**
 * 긴 문자열을 다루는 클래스
 * StringBuilder(JDK 1.5이후) - 동시접근가능(동기화x) 
 * 속도: Builder > Buffer
 */
public class UseStringBuilder {
	
	public void useStringBuffer() {
		StringBuffer sb = new StringBuffer();
		sb.append(2022);
		sb.append('A');
		sb.append(1.19);
		sb.append(false);

		System.out.println(sb);
		System.out.println(sb.length());
		
		StringBuffer sb2 = new StringBuffer();
		sb2.append("오늘은 수요일입니다.");
		sb2.insert(4, "2022년 1월 19일입니다.");
		sb2.delete(4, 8);
		System.out.println(sb2);
		
		StringTokenizer st = new StringTokenizer(sb2.toString(), " ");
		System.out.println(st.countTokens());

		
	}//useStringBuffer
	public void useStringBuilder() {

		StringBuilder sb = new StringBuilder();
		sb.append(2022);
		sb.append('A');
		sb.append(1.19);
		sb.append(false);

		System.out.println(sb);
		System.out.println(sb.length());
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append("오늘은 수요일입니다.");
		sb2.insert(4, "2022년 1월 19일입니다.");
		sb2.delete(4, 9);
		System.out.println(sb2);
		
		
		String fileName = "e:/dev/workspace/javase_prj/day0119/UseStringBuilder.java";
		StringBuilder file = new StringBuilder(fileName);
		
		int last = file.lastIndexOf(".");

		file.insert(last, "_bak");
		System.out.println(file);
		
		//String temp = file.toString().toUpperCase()
		System.out.println(file.toString().toUpperCase());

	}//useStringBuilder
	
	public static void main(String[] args) {

		UseStringBuilder usbuilder = new UseStringBuilder();
		System.out.println("--------String Buffer-----------");
		usbuilder.useStringBuffer();
		
		System.out.println("--------String Builder-----------");
		usbuilder.useStringBuilder();
	}
}
