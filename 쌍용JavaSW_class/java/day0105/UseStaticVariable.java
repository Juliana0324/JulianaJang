package day0105;

/**
 * Static or variable(공용변수)
 * 객체화를 하지않고 클래스명으로 접근하여 사용하는 변수
 * 
 * 
 * @author user
 *
 */
public class UseStaticVariable {
	static int i;
	public static int j;
	int insI;
	
	public static void main(String[] args) {
		System.out.println(UseStaticVariable.i);
		System.out.println(UseStaticVariable.j);
		
		//static 변수는 객체에 속하지 않은 공용변수로 객체명.변수명으로 사용될시
		// 사용은 되지만 사용방법이 아니므로 경고메세지 출력
		
		UseStaticVariable usv = new UseStaticVariable();
		UseStaticVariable usv2 = new UseStaticVariable();
		usv.insI = 100;
		usv2.insI = 500;
		
/**	 잘못된 방법
	//static 변수는 객체명으로 사용하더라도 하나의 변수를 사용하는것이기 떄문에
		//변경된 값이 공유된다 
		usv.i = 1000;
		System.out.println("객체명으로 사용: "+usv.i +", instance variable = "+ usv.insI);  //출력결과: 객체명으로 사용: 1000, instance variable = 100
		System.out.println("객체명으로 사용: "+usv2.i+", instance variable = "+ usv2.insI); //출력결과: 객체명으로 사용: 1000, instance variable = 500
		
		//메세지 : The static field UseStaticVariable.i should be accessed in a static way
	*/	
		
		//수정된 방법 : static 문법으로 사용
		UseStaticVariable.i = 1000;
		System.out.println("Static 문법으로 사용 : "+UseStaticVariable.i +", instance variable = "+ usv.insI);  //출력결과: static 문법으로 사용: 1000, instance variable = 100
		System.out.println("Static 문법으로 사용 : "+UseStaticVariable.i+", instance variable = "+ usv2.insI); //출력결과: static 문법으로 사용: 1000, instance variable = 500
	}

}
