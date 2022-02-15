package day0128;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class HwDesign0128 extends JFrame {
	private JMenuItem file, item, newtxt, open, save, newNameSave, close, memoReview;
	
	public HwDesign0128() {
		super("메모장");
		
		JMenuBar memoMenu = new JMenuBar();
		
		JMenu menuFile = new JMenu("파일");
		JMenu menuFont = new JMenu("서식");
		JMenu help= new JMenu("도움말");
		
		file = new JMenuItem("파일");
		item = new JMenuItem("아이템");
		newtxt = new JMenuItem("새글 쓰기");
		open = new JMenuItem("열기");
		save = new JMenuItem("저장");
		newNameSave= new JMenuItem("다른이름으로 저장");
		close= new JMenuItem("닫기");
		
		
	}
	
}
