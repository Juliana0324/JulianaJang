package day0211;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Test4 extends JFrame {
	private JButton jbtn;
	public Test4() {
		super("테스트");
		jbtn = new JButton("클릭");
		add("Center", jbtn);
		
//		jbtn.addActionListener(e->{
//			int i = JOptionPane.showConfirmDialog(this, "윈도우를 종료하시겠습니까?");
//			switch(i) {
//			case JOptionPane.OK_OPTION: 
//				dispose();
//			}
//		});
		
		
		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test4();
	}

}
