package day0128;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * has a ����� TestKeyEvtDesign Ŭ������ �̺�Ʈ�� ó���� Ŭ����
 * @author user
 *
 */
public class TestKeyEvtProcess extends WindowAdapter implements KeyListener {
	
	private TestKeyEvtDesign tked;
	
	public TestKeyEvtProcess(TestKeyEvtDesign tked) {
		this.tked = tked;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		tked.dispose();
		//tked�� �����츦 �����ϰڴٴ� ��
	}






	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("keyTyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
	//	System.out.println("keyPressed");

	}

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("keyReleased");
		
		//����Ű�� Ű�� ������
		tked.getJlblOutput().setText(String.valueOf(e.getKeyCode())+" / "+e.getKeyChar());
		
//		if(e.getKeyCode() == 27) {
//			tked.dispose();
//		}
		
		//�ֿܼ� JTextField�� �Էµ� ��� ���ڿ��� ���.
		System.out.println(tked.getJtfKey().getText());
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			tked.dispose();
			break;
		}
	}

}
