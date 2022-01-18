package day0118;

/**
 * Person클래스를 객체화하여 사용할 목적으로 만드는 클래스
 * @author user
 *
 */
public class UsePerson {

	/**
	 * Java application
	 * @param args
	 */
	public static void main(String[] args) {
		HongGilDong hgd = new HongGilDong();
		//코드의 재 사용성
		hgd.setName("홍길동");
		System.out.printf("%s의 눈은 %d개, 코는 %d개, 입은 %d개\n", hgd.getName(), hgd.getEye(), hgd.getNose(), hgd.getMouth());
		System.out.println(hgd.eat());
		System.out.println(hgd.eat("뜨끈한 국밥",1));
		
		//자신만의 특징을 구현한 method를 호출
//		for(int i=3;i<11; i++) {
//			System.out.println(i+ "레벨 소유자와의 싸움: " +hgd.fight(i));			
//		}
		
		System.out.println("==================================================");
		Clark superman = new Clark();
		//코드의 재 사용성
		superman.setName("슈퍼맨");
		System.out.printf("%s의 눈은 %d개, 코는 %d개, 입은 %d개\n", superman.getName(), superman.getEye(), superman.getNose(), superman.getMouth());
		System.out.println(superman.eat());
		System.out.println(superman.eat("스테이크",10));
		
		//자신만의 특징 구현
		String stone = "짱똘";
		System.out.println(stone+"을 맞아서 "+ superman.power(stone) +"\n슈퍼맨 파워: "+superman.power);
		stone = "다이아몬드";
		System.out.println(stone+"을 맞아서 "+ superman.power(stone)+"\n슈퍼맨 파워: "+superman.power);
		System.out.println();
		
		System.out.println(superman.getName()+"한테 "+hgd.fight(superman.power));
		System.out.println();
		
		System.out.println("----------날기 위한 작업----------");
		System.out.println(superman.upwardForce());
		System.out.println(superman.drivingForce());
		
		
	}

}
