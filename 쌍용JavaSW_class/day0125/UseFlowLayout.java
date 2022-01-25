package day0125;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UseFlowLayout extends JFrame {
	public UseFlowLayout() {
		//1. ������ ������Ʈ���
		super("FlowLayout����");
		
		//2. ������Ʈ ����
		JLabel jblName = new JLabel("�̸�");
		JTextField jTextField = new JTextField(10);
		JCheckBox jcbSaveFlag = new JCheckBox("����", true);
		JButton jbtn = new JButton("�Է�");
		
		//3. ������Ʈ ��ġ
		//Frame���̾ƿ��� BorderLayout => FlowLayout����
		//add�������
		setLayout(new FlowLayout());
		add(jblName);
		add(jTextField);
		add(jcbSaveFlag);
		add(jbtn);
		
		//4. ������ ũ�� ����
		setSize(400,400);
		
		//5. ����ȭ
		setVisible(true);
		
		//6. �����̺�Ʈ
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
	
	public static void main(String[] args) {
		new UseFlowLayout();
	}
}
