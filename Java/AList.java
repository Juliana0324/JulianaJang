import java.util.ArrayList;
public class AList {

	public static void main(String[] args) {
		ArrayList<String> nameList = new ArrayList<>();
		nameList.add("�����");
		nameList.add("������");
		nameList.add("������");
		nameList.add("�����");
		nameList.add("����ȭ");
		
		nameList.remove(3);
		
		System.out.println(nameList.size());
		
		
		ArrayList<Integer> numList2 = new ArrayList<>();
		
		numList2.add(1);
		numList2.add(2);
		numList2.add(3);
		numList2.add(4);
		
		for(int num:numList2) {
			System.out.println(num * num);
		}
		
		
		
	}

}
