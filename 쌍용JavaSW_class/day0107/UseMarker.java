package day0107;

/**
 * 1. ��ī�� Ŭ������ ����Ͽ� ��ü�� ����, 
 * 2. ��ī�� ��ü�� �����ϴ� ����� ���
 * @author user
 *
 */
public class UseMarker {

	public static void main(String[] args) {
		//��ī�� Ŭ������ ����Ͽ� ������ ��ī�� ����
		Marker black= new Marker(); //������ ������������ (�� ����)
		System.out.println(black); //4byte
		
		black.setCap(1);
		black.setBody(1);
		black.setColor("����");
		System.out.println(black.write());
		System.out.println(black.write("����"));
		System.out.println(black.getColor()+"���� ��ī���� �Ѳ� "+black.getCap()+"��, ��ü "+black.getBody()+"��");
		System.out.println();
		
		//�������� �����Ͽ� �����ְ� ����غ�����
		Marker red = new Marker();
		
		red.setCap(1);
		red.setBody(1);
		red.setColor("����");
		System.out.println(red.write());
		System.out.println(red.getColor()+"���� ��ī���� �Ѳ��� ����: "+red.getCap()+"��, ��ü :"+red.getBody()+"��");
	}

}
