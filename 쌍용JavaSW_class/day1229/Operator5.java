/*
	�Ϲݳ�: 
	&&, ||
	
	��Ʈ��: 

*/
class Operator5 {
	public static void main(String[] args) {
		boolean flag1 = true, flag2 = false, flag3 = true, flag4 = false;

///////////////////////////////////////////////////////////////////////////////
		//&& : ���� ���� ��� true �϶��� true
		System.out.println(flag1 + " && " + flag3+" = "+ (flag1&&flag3));
		System.out.println(flag1 + " && " + flag2+" = "+ (flag1&&flag2));
		System.out.println(flag2 + " && " + flag3+" = "+ (flag2&&flag3));
		System.out.println(flag2 + " && " + flag4+" = "+ (flag2&&flag4));


///////////////////////////////////////////////////////////////////////////////
		//|| : ���� ���� �ϳ��� true���� true
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
		//int i�������� �ƹ� ������ �Ҵ��ϰ�, �� ������ 0������ 100���̶�� true�� ����ϰ�
		// 0 �������� 100���̰� �ƴ϶�� false ���
		int i= 80;
		System.out.println(i+"��/�� 0���� ũ�� 100���� �۳���? "+(i>=0 && i<=100));
		
		i=120;
		System.out.println(i+"��/�� 0���� ũ�� 100���� �۳���? "+(i>=0 && i<=100));
		
		i=-10;
		System.out.println(i+"��/�� 0���� ũ�� 100���� �۳���? "+(i>=0 && i<=100));
		System.out.println();

///////////////////////////////////////////////////////////////////////////////////
		i=20;
		int j =15;
		//��Ʈ &
		// 20 & 15
		// 20 : 0001 0100 
		// 15 : 0000 1111
		//	  : 0000 0100;
		// ==== 4
			
		System.out.println(i+" & "+j+"="+ (i&j));

		i=40;
		j=12;
		// ��Ʈ |(OR)
		// 40 : 0010 1000
		// 12 : 0000 1100
		//	  : 0010 1100
		//	==== 44
		System.out.println(i+" | "+j+"="+ (i|j));
		
		i=45;
		j=15;
		//��Ʈ ^ (XOR)
		// 45  : 0010 1101
		// 15  : 0000 1111
		//	   : 0010 0010
		// ==== 34
		System.out.println(i+" ^ "+j+"="+ (i^j));

		
	}
}
