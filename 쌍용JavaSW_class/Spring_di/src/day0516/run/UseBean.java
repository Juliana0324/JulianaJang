package day0516.run;


import java.util.List;

import day0516.assembly.Assembly;
import day0516.service.Service;

/**
 * ������ ���Թ��� Ŭ������ �� ������ ���Թ��� Ŭ������ ����ϴ� ��.
 * @author user
 *
 */
public class UseBean {
	
	
	
	
	public static void main(String[] args) {
		//1. ������ Ŭ���� ����
		Assembly ass = new Assembly();
		
		//2. ������ ���� ���� Ŭ���� ���
		Service service = ass.getBean();
		
		//3. ������ ���Թ��� ��ü ���
		service.addMember("�׽�Ʈ");
		
		List<String> list = service.searchMember();
		System.out.println(list);
		
	}//main
}
