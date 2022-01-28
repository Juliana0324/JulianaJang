package day0128;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ������ Ŭ������ �޾� ������ Ŭ������ �̺�Ʈ�� ó���ϴ� Ŭ����
 * @author user
 *
 */
public class TestAdaptorHasA extends WindowAdapter {
	private TestDesign td;
	
	public TestAdaptorHasA(TestDesign td) {
		this.td = td;

	}
	
	
	@Override
	public void windowClosing(WindowEvent we) {
		System.out.println("�ܺ�Ŭ�������� ������ ���� �̺�Ʈ ó��");
		//dispose(); // ��� �ٿ��� �̱���� �������� x
		td.dispose();
	}
}
