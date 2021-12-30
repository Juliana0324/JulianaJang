/*
단항 연산자
연산자 대상체
~, !, +, -, ++,--
*/
class Operator1{
	public static void main(String[] args) {
		
		int i= 12;
		int j= -19;
		
		System.out.println("~"+i+" = "+ ~i); //양수: ~(tilde) 시 1증가 12 => -13
		System.out.println("~"+j+" = "+ ~j); //음수: ~(tilde) 시 1감소 -19 => 18

		
		i=12;
		j = 28;
		System.out.println(i+">"+j+" = "+ (i>j));
		
		boolean flag1 = true, flag2=false;
		System.out.println("!"+flag1+"=" + !flag1);
		System.out.println("!"+flag2+"=" + !flag2);
	 
		i = 12;
		j= -37;
		System.out.println("+"+i+"="+ +i); //12
		System.out.println("+"+j+"="+ +j); //-37

		System.out.println("+"+i+"="+ -i); //-12
		System.out.println("+"+j+"="+ -j); //37
			

		i=10;
		j=12;
		
		++i;
		i++;
		--j;
		j--;
		/*
		System.out.println(++i);	//11 전치 증감연산 
		System.out.println(i++);	//11 후치 증감연산
		
		System.out.println(--i);	//11 전치연산
		System.out.println(i--);	//11
		 */

		 int result =0;
		 result = ++i;
		 System.out.println("전위연산 후 i = "+i+", result: "+result);
			
		result = 0;
		result = i++;
		System.out.println("후위연산 후 i = "+i+", result: "+result);
		
		System.out.println("전위 : "+ ++i); //i를 증가 후 method에 할당 15가 출력
		System.out.println(i);

		System.out.println("후위 : "+ i++); //i를 method에 할당한 후 i를 증가 15출력
		System.out.println(i);

		i=10;
		j=20;
		

		System.out.println(i++ + --j); 

	}
}
