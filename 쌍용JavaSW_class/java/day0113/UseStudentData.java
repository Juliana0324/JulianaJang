package day0113;

/**
 * int,String,int, String, double로된 사용자 정의 자료형
 * @author user
 *
 */
public class UseStudentData{

	public static void main(String[] args) {
		StudentData jeongwoo = new StudentData(1, "장정우", 25, "A", 161.9);
		StudentData jaewon= new StudentData(2, "정재원", 25, "B", 185.5);
		
		
		System.out.printf("%s학생은 %d번이고 %d살 혈액형은 %s형입니다.\n", jeongwoo.getName(), jeongwoo.getNum(), jeongwoo.getAge(), jeongwoo.getBloodType());
		System.out.printf("%s학생은 %d번이고 %d살 혈액형은 %s형입니다.\n", jaewon.getName(), jaewon.getNum(), jaewon.getAge(), jaewon.getBloodType());
		
		jeongwoo.setAge(jeongwoo.getAge()+1);
		jaewon.setAge(jaewon.getAge()+1);
		System.out.printf("%s학생은 %d번이고 %d살 혈액형은 %s형입니다.\n", jeongwoo.getName(), jeongwoo.getNum(), jeongwoo.getAge(), jeongwoo.getBloodType());
		System.out.printf("%s학생은 %d번이고 %d살 혈액형은 %s형입니다.\n", jaewon.getName(), jaewon.getNum(), jaewon.getAge(), jaewon.getBloodType());

		
		System.out.println("--------------------------------------------------------------------------");
		//객체 배열
		// 선언 + 생성
		StudentData[] studentArr = new StudentData[3];
		
		studentArr[0] = new StudentData(1, "김진영", 24, "A", 162.1);
		studentArr[1] = new StudentData(2, "정시현", 26, "AB", 185.5);
		studentArr[2] = new StudentData(3, "강현모", 26, "O", 177.5);
		
		StudentData jww= studentArr[0];
//		System.out.println(jww.toString());
		
		StudentData tmp = null;
		for(int i=0; i<studentArr.length; i++) {
			tmp = studentArr[i];
			System.out.println(tmp.getName()+" / "+tmp.getAge());
		}
		
		
		for(StudentData i: studentArr) {
			System.out.printf("이름: %s, 나이: %d, 키: %.2f, 태어난해: %d\n",i.getName(), i.getAge(), i.getHeight(), (2021-i.getAge()+1));
		}
		
	}


}
