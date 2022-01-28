package day0128;

import java.awt.Frame;
import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class UseJMenu extends JFrame {
	private JMenuItem jmiNew, jmiDialog, jmiClose, jmiHelp;
	
	public UseJMenu() {
		super("메뉴연습");
		
		JMenuBar jmb = new JMenuBar();
		
		JMenu jm = new JMenu("메뉴1");
		JMenu jm2 = new JMenu("메뉴2");
		
		jmiNew = new JMenuItem("메뉴 아이템");
		jmiDialog= new JMenuItem("다이얼로그");
		jmiClose= new JMenuItem("닫기");
		jmiHelp= new JMenuItem("도움말");
		
		//메뉴아이템 배치
		jm.add(jmiNew);
		jm.add(jmiDialog);
		jm.add(jmiClose);
		
		jm2.add(jmiHelp);
		
		//5. 메뉴를 메뉴바에 배치
		jmb.add(jm);
		jmb.add(jm2);
		
		//6. 메뉴바르 프레임에 배ㅐ치
		setJMenuBar(jmb);
		
		//MenuITem이벤트 등록
		UseJMenuEvt ujme = new UseJMenuEvt(this); //has a 관계설정
		jmiDialog.addActionListener(ujme);
		jmiClose.addActionListener(ujme);
		addWindowListener(ujme);
		
		setSize(800,600);
		setVisible(true);
	}
	
	
	
	public JMenuItem getJmiNew() {
		return jmiNew;
	}



	public JMenuItem getJmiDialog() {
		return jmiDialog;
	}



	public JMenuItem getJmiClose() {
		return jmiClose;
	}



	public JMenuItem getJmiHelp() {
		return jmiHelp;
	}



	public static void main(String[] args) {
		new UseJMenu();
	}

}
