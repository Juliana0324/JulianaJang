package day0125;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * JFrame�� ��ӹ����� Window���� �����Ǿ�
 * ª�� �ڵ�� ����ڿ��� Application�� ������ �� �ִ�
 * @author user
 *
 */
@SuppressWarnings("serial")
public class UseJFrame extends JFrame{
	
	public UseJFrame() {
		setSize(800,200); //window Ŭ����
		setVisible(true); //window Ŭ����
		JButton b1 = new JButton("Click");
		b1.setBounds(100,100,100,40);
		add(b1); //container Ŭ���� �� ����
	}
	
	
	public static void main(String[] args) {
		new UseJFrame();
		
	}
}
