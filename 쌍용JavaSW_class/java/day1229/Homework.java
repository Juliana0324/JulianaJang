class Homework{
	public static void main(String[] args) {
		// 1. 숫자를 입력받아 숫자를 출력
		// 대문자에 속한 값의 범위일 때만 입력한 숫자의 문자출력
		int num = Integer.parseInt(args[0]);
		System.out.println("1번: "+ num);
		if(num>64 && num<91){
			System.out.println((char)num);
		}
		System.out.println();

		
		//2. 숫자입력받아 숫자를 출력하고, 3의 배수와 같다면 "짝"을 출력
		num = Integer.parseInt(args[1]);
		System.out.println("2번: "+ num);
		if(num%3==0){	
			System.out.println("짝수");
		}
		System.out.println();

		//3. 숫자를 입력받아 숫자 출력
		// 대문자 소문자 숫자에 속한 값의 범위인 경우에만 입력한 숫자에 해당되는 문자 출력
		num = Integer.parseInt(args[2]);
		System.out.println("3번: "+ num);
		if((num>47 && num<=57) || (num>=65 && num<=90) || (num>=97 && num<=122)){
			System.out.println((char)num);
		}

		System.out.println();
		
		//4. 입력한 문자열을 출력하고 버스, 지하철,마을버스,택시인 경우에는 "대중교통" 출력
		System.out.println("4번: "+ args[3]);
		if(args[3].equals("버스")||args[3].equals("지하철")||args[3].equals("택시")){
			System.out.println("대중교통");
		}
		

	}
}
