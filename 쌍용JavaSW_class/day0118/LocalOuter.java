package day0118;

/**
 * ����Ŭ����
 * @author user
 *
 */
public class LocalOuter {
	
	int outI;
	
	public void method1(int parami, final int paramJ) {
		int localA = 2022;
		final int localB = 1;
//		paramJ = 200; final -> ���� ����
	
		///////////////////////���ú���///////////////////////////
		class LocalInner{
			int i;

			public LocalInner() {
				System.out.println("����Ŭ���� ������");
			}
			
			public void localMethod() {
				System.out.println("����Ŭ������ method");
				System.out.println("�ٱ� Ŭ������ instance I"+outI);
				
				
				//JDK1.8���ĺ��� ����Ŭ�������� final�� ��õ��� ���� ������ ����� �� �ְԵǾ���.
				//parami = 10; 
				System.out.println("method������ �Ķ����: "+parami+", "+paramJ);
				
				//localA = 10;
				System.out.println("method������ ��������: "+localA+", "+localB);
				
			}//Method
			
		}//Inner class
		///////���ú��� ��///////////

		
		LocalInner lo = new LocalInner();
		lo.i = 49;
		System.out.println(lo.i);
		lo.localMethod();		
		
	}	
	
	public static void main(String[] args) {
		LocalOuter loc = new LocalOuter();
		loc.method1(100, 300);
		

		
		

		
	}

}
