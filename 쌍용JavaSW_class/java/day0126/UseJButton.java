package day0126;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UseJButton extends JFrame {

	public UseJButton() {
		super("��ư�� ����");
		ImageIcon img1= new ImageIcon("E:/dev/workspace/javase_prj/src/day1026/images/img1.PNG");
		ImageIcon img2= new ImageIcon("E:/dev/workspace/javase_prj/src/day1026/images/img2.PNG");
		ImageIcon img3= new ImageIcon("E:/dev/workspace/javase_prj/src/day1026/images/img3.PNG");
		ImageIcon img4= new ImageIcon("E:/dev/workspace/javase_prj/src/day1026/images/img4.PNG");
		
		JButton jb = new JButton("���ε�", img1);
		JButton jb2 = new JButton("������", img2);
		JButton jb3 = new JButton("����ġ", img3);
		
		//��ġ������
		setLayout(new GridLayout());
		add(jb);
		add(jb2);
		add(jb3);
		
		jb.setToolTipText("�������� ����ȭ");
		jb2.setToolTipText("����̸� ����ȭ");
		jb3.setToolTipText("�����Ƹ� ����ȭ");
		
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
