package day0128;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class HwDesign0128 extends JFrame {
	private JMenuItem file, item, newtxt, open, save, newNameSave, close, memoReview;
	
	public HwDesign0128() {
		super("�޸���");
		
		JMenuBar memoMenu = new JMenuBar();
		
		JMenu menuFile = new JMenu("����");
		JMenu menuFont = new JMenu("����");
		JMenu help= new JMenu("����");
		
		file = new JMenuItem("����");
		item = new JMenuItem("������");
		newtxt = new JMenuItem("���� ����");
		open = new JMenuItem("����");
		save = new JMenuItem("����");
		newNameSave= new JMenuItem("�ٸ��̸����� ����");
		close= new JMenuItem("�ݱ�");
		
		
	}
	
}
