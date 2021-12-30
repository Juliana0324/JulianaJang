/*
	일반논리: 
	&&, ||
	
	비트논리: 

*/
class Operator5 {
	public static void main(String[] args) {
		boolean flag1 = true, flag2 = false, flag3 = true, flag4 = false;

///////////////////////////////////////////////////////////////////////////////
		//&& : 전항 후항 모두 true 일때만 true
		System.out.println(flag1 + " && " + flag3+" = "+ (flag1&&flag3));
		System.out.println(flag1 + " && " + flag2+" = "+ (flag1&&flag2));
		System.out.println(flag2 + " && " + flag3+" = "+ (flag2&&flag3));
		System.out.println(flag2 + " && " + flag4+" = "+ (flag2&&flag4));


///////////////////////////////////////////////////////////////////////////////
		//|| : 전항 후항 하나만 true여도 true
		System.out.println(flag1 + " || " + flag3+" = "+ (flag1||flag3));
		System.out.println(flag1 + " || " + flag2+" = "+ (flag1||flag2));
		System.out.println(flag2 + " || " + flag3+" = "+ (flag2||flag3));
		System.out.println(flag2 + " || " + flag4+" = "+ (flag2||flag4));

		flag1 = false;
		flag2 = false;
		System.out.println(flag1 + ", " + flag2);
		
		flag3= (flag1 = 3<2) && (flag2 = 3<4);
		System.out.println(flag1 + ", " + flag2+", "+flag3);
		
///////////////////////////////////////////////////////////////////////////////
		//int i변수에는 아무 정수나 할당하고, 그 정수가 0에서붜 100사이라면 true를 출력하고
		// 0 에서부터 100사이가 아니라면 false 출력
		int i= 80;
		System.out.println(i+"은/는 0보다 크고 100보다 작나요? "+(i>=0 && i<=100));
		
		i=120;
		System.out.println(i+"은/는 0보다 크고 100보다 작나요? "+(i>=0 && i<=100));
		
		i=-10;
		System.out.println(i+"은/는 0보다 크고 100보다 작나요? "+(i>=0 && i<=100));
		System.out.println();

///////////////////////////////////////////////////////////////////////////////////
		i=20;
		int j =15;
		//비트 &
		// 20 & 15
		// 20 : 0001 0100 
		// 15 : 0000 1111
		//	  : 0000 0100;
		// ==== 4
			
		System.out.println(i+" & "+j+"="+ (i&j));

		i=40;
		j=12;
		// 비트 |(OR)
		// 40 : 0010 1000
		// 12 : 0000 1100
		//	  : 0010 1100
		//	==== 44
		System.out.println(i+" | "+j+"="+ (i|j));
		
		i=45;
		j=15;
		//비트 ^ (XOR)
		// 45  : 0010 1101
		// 15  : 0000 1111
		//	   : 0010 0010
		// ==== 34
		System.out.println(i+" ^ "+j+"="+ (i^j));

		
	}
}
