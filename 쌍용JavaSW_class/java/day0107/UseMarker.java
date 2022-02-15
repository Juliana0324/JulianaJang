package day0107;

/**
 * 1. 마카펜 클래스를 사용하여 객체를 생성, 
 * 2. 마카펜 객체가 제고하는 기능을 사용
 * @author user
 *
 */
public class UseMarker {

	public static void main(String[] args) {
		//마카펜 클래스를 사용하여 검은색 마카펜 생성
		Marker black= new Marker(); //참조형 데이터형생성 (힙 영역)
		System.out.println(black); //4byte
		
		black.setCap(1);
		black.setBody(1);
		black.setColor("검은");
		System.out.println(black.write());
		System.out.println(black.write("하이"));
		System.out.println(black.getColor()+"색인 마카펜의 뚜껑 "+black.getCap()+"개, 몸체 "+black.getBody()+"개");
		System.out.println();
		
		//빨간펜을 생성하여 값을넣고 사용해보세요
		Marker red = new Marker();
		
		red.setCap(1);
		red.setBody(1);
		red.setColor("빨강");
		System.out.println(red.write());
		System.out.println(red.getColor()+"색인 마카펜의 뚜껑의 갯수: "+red.getCap()+"개, 몸체 :"+red.getBody()+"개");
	}

}
