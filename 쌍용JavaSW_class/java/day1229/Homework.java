class Homework{
	public static void main(String[] args) {
		// 1. ���ڸ� �Է¹޾� ���ڸ� ���
		// �빮�ڿ� ���� ���� ������ ���� �Է��� ������ �������
		int num = Integer.parseInt(args[0]);
		System.out.println("1��: "+ num);
		if(num>64 && num<91){
			System.out.println((char)num);
		}
		System.out.println();

		
		//2. �����Է¹޾� ���ڸ� ����ϰ�, 3�� ����� ���ٸ� "¦"�� ���
		num = Integer.parseInt(args[1]);
		System.out.println("2��: "+ num);
		if(num%3==0){	
			System.out.println("¦��");
		}
		System.out.println();

		//3. ���ڸ� �Է¹޾� ���� ���
		// �빮�� �ҹ��� ���ڿ� ���� ���� ������ ��쿡�� �Է��� ���ڿ� �ش�Ǵ� ���� ���
		num = Integer.parseInt(args[2]);
		System.out.println("3��: "+ num);
		if((num>47 && num<=57) || (num>=65 && num<=90) || (num>=97 && num<=122)){
			System.out.println((char)num);
		}

		System.out.println();
		
		//4. �Է��� ���ڿ��� ����ϰ� ����, ����ö,��������,�ý��� ��쿡�� "���߱���" ���
		System.out.println("4��: "+ args[3]);
		if(args[3].equals("����")||args[3].equals("����ö")||args[3].equals("�ý�")){
			System.out.println("���߱���");
		}
		

	}
}
