package day0211;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Test4 extends JFrame {
	private JButton jbtn;
	public Test4() {
		super("�׽�Ʈ");
		jbtn = new JButton("Ŭ��");
		add("Center", jbtn);
		
//		jbtn.addActionListener(e->{
//			int i = JOptionPane.showConfirmDialog(this, "�����츦 �����Ͻðڽ��ϱ�?");
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
