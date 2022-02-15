package day0124;

import java.util.Stack;

/**
 * LIFO�� Ư¡�� ������ Ŭ���� : Stack
 * @author user
 *
 */
public class UseStack {

	public UseStack() {
		//1. ���� ����
		Stack<String> stk = new Stack<String>();
		
		//2. �� �ֱ�
		System.out.println(stk);
		stk.push("�ϼ���");
		stk.push("�ȳ�");
		stk.push("������ ������");
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
