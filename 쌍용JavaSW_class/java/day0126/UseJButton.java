package day0126;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UseJButton extends JFrame {

	public UseJButton() {
		super("버튼의 제어");
		ImageIcon img1= new ImageIcon("E:/dev/workspace/javase_prj/src/day1026/images/img1.PNG");
		ImageIcon img2= new ImageIcon("E:/dev/workspace/javase_prj/src/day1026/images/img2.PNG");
		ImageIcon img3= new ImageIcon("E:/dev/workspace/javase_prj/src/day1026/images/img3.PNG");
		ImageIcon img4= new ImageIcon("E:/dev/workspace/javase_prj/src/day1026/images/img4.PNG");
		
		JButton jb = new JButton("프로도", img1);
		JButton jb2 = new JButton("제이지", img2);
		JButton jb3 = new JButton("어피치", img3);
		
		//배치관리자
		setLayout(new GridLayout());
		add(jb);
		add(jb2);
		add(jb3);
		
		jb.setToolTipText("강아지를 형상화");
		jb2.setToolTipText("고양이를 형상화");
		jb3.setToolTipText("복숭아를 형상화");
		
		jb.setVerticalTextPosition(JButton.BOTTOM);
		jb2.setHorizontalTextPosition(JButton.LEFT);
		jb3.setHorizontalTextPosition(JButton.CENTER);
		jb3.setVerticalTextPosition(JButton.TOP);
		
		setBounds(100,150,650,250);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new UseJButton();
	}

}
