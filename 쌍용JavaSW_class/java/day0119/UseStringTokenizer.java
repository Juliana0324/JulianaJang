package day0119;

import java.util.StringTokenizer;

/**
 * StringTokenizer : ���ڿ��� ª�� ����� �����ҋ� ����ϴ� Ŭ����
 * @author user
 *
 */
public class UseStringTokenizer {

	public UseStringTokenizer() {
		String msg = "�ڹ�,����Ŭ,JDBC,HTML,Css"; // CSVdata
		
		//1. StringTokenizer ����
//		StringTokenizer st = new StringTokenizer(msg,","); 
		
		//���� ���ڿ����� or����� ����
//		StringTokenizer st = new StringTokenizer(msg,",.");
		StringTokenizer st = new StringTokenizer(msg,",",true);
		
		//2. ��ū�� ����������� ������
		System.out.println(st.countTokens());
		
		//��ū�� �����ϴ°�?
		System.out.println(st.hasMoreTokens());
		
		//countToken�� ���������� ���ҵǱ⶧���� for������ �� �� ����
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		
	}//StringTo - ������
	
	
	public static void main(String[] args){
		UseStringTokenizer ust = new UseStringTokenizer();
		
		
	}
}
