/*
���� ������
������ ���ü
~, !, +, -, ++,--
*/
class Operator1{
	public static void main(String[] args) {
		
		int i= 12;
		int j= -19;
		
		System.out.println("~"+i+" = "+ ~i); //���: ~(tilde) �� 1���� 12 => -13
		System.out.println("~"+j+" = "+ ~j); //����: ~(tilde) �� 1���� -19 => 18

		
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
		System.out.println(++i);	//11 ��ġ �������� 
		System.out.println(i++);	//11 ��ġ ��������
		
		System.out.println(--i);	//11 ��ġ����
		System.out.println(i--);	//11
		 */

		 int result =0;
		 result = ++i;
		 System.out.println("�������� �� i = "+i+", result: "+result);
			
		result = 0;
		result = i++;
		System.out.println("�������� �� i = "+i+", result: "+result);
		
		System.out.println("���� : "+ ++i); //i�� ���� �� method�� �Ҵ� 15�� ���
		System.out.println(i);

		System.out.println("���� : "+ i++); //i�� method�� �Ҵ��� �� i�� ���� 15���
		System.out.println(i);

		i=10;
		j=20;
		

		System.out.println(i++ + --j); 

	}
}
