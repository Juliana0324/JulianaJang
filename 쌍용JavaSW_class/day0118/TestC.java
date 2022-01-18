package day0118;


/**
 * TestA, TestB를 구현 받음
 * @author user
 *
 */
public interface TestC extends TestA, TestB{
	
	public abstract void testC();

	//부모 인터페이스의 추상method는 자식인터페이스에서 구현 필요x
//	@Override
//	public void testA();
	
}
