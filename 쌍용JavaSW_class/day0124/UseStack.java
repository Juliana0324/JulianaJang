package day0124;

import java.util.Stack;

/**
 * LIFO의 특징을 구현한 클래스 : Stack
 * @author user
 *
 */
public class UseStack {

	public UseStack() {
		//1. 스택 생성
		Stack<String> stk = new Stack<String>();
		
		//2. 값 넣기
		System.out.println(stk);
		stk.push("하세요");
		stk.push("안녕");
		stk.push("오늘은 월요일");
		stk.push("JAVA");
		
		while(!stk.empty()) {
			System.out.println(stk.pop());
		}
		System.out.println(stk);
		
		
	}
	
	
	public static void main(String[] args) {
		new UseStack();
	}
}
