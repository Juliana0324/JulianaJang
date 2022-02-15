class Operator6{
	public static void main(String[] args) {
		int i=30;

		//삼항연산식
		System.out.println(i+" > -1 ? 양수: 음수 = "+(i>-1 ? "양수":"음수"));
		
		i= 12;
		System.out.println("12는 "+ (i%2==0 ? "짝수":"홀수"));


	}
}
