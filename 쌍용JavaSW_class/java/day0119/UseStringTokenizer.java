package day0119;

import java.util.StringTokenizer;

/**
 * StringTokenizer : 문자열을 짧은 마디로 구분할떄 사용하는 클래스
 * @author user
 *
 */
public class UseStringTokenizer {

	public UseStringTokenizer() {
		String msg = "자바,오라클,JDBC,HTML,Css"; // CSVdata
		
		//1. StringTokenizer 생성
//		StringTokenizer st = new StringTokenizer(msg,","); 
		
		//구분 문자열에는 or기능이 있음
//		StringTokenizer st = new StringTokenizer(msg,",.");
		StringTokenizer st = new StringTokenizer(msg,",",true);
		
		//2. 토큰이 얻어질때마다 감소함
		System.out.println(st.countTokens());
		
		//토큰이 존재하는가?
		System.out.println(st.hasMoreTokens());
		
		//countToken은 지속적으로 감소되기때문에 for문으로 쓸 수 없음
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		
	}//StringTo - 생성자
	
	
	public static void main(String[] args){
		UseStringTokenizer ust = new UseStringTokenizer();
		
		
	}
}
