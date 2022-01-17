package day0117;

/**
 * 추상클래스의 자식클래스
 * 부모클래스의 추상메소드를 반드시 Overriding 해야함
 * @author user
 *
 */
public class AbstractSub extends AbstractSuper{
	
	int i;

//	@Override
//	public void methodA() {
//		System.out.println("메소드A");
//	}
	
	@Override
	public void methodB() {
		System.out.println("접근 지정자는 달라도되고, 반환형, method명, 매개변수는 같게 설정");
	}

	@Override
	public int methodC(String name) {
		return name.length();
	}

	public static void main(String[] args) {
		AbstractSub as = new AbstractSub(); //super() 자동생성
		as.i = 0;
		as.methodA();
		as.methodB();
		System.out.println(as.methodC("Julie"));
		
		
		System.out.println("======================");
		//상속관계의 객체화(자식은 부모이다. is a 관계)
		//자식클래스에서는 부모클래스의 정보를 알수 있기 떄문에 
		//자식클래스의 객체는 부모클래스로 만들어진 객체에 할당될수 있다
//		AbstractSub asub = new AbstractSuper(); ==> 부모는 자식을 모르기때문에 
		AbstractSuper asuper = new AbstractSub(); //is a 관계의 객체화
		//객체는 부모의 정보를 사용하기 떄문에 자식의 모든 기능을 사용할 수 x
		asuper.i =10;
		asuper.methodA();
		asuper.methodB(); //body가 없어 일을 할 수없지만 자식이 override를 했기 때문에 최우선적으로 불림
		
		System.out.println(asuper.methodC("눈온다"));
		
		
		
	}
}
