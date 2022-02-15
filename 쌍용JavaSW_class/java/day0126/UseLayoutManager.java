package day0126;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UseLayoutManager extends JFrame{
	
	public UseLayoutManager() {
		super("���������� ����ϴ� ���̾ƿ� �Ŵ���");
		//2. ������Ʈ ����
		// �Ϲ�������Ʈ - �������
		JLabel jlblName = new JLabel("�̸�");
		JTextField jtfName = new JTextField(10);
		JButton jbtnAdd = new JButton("�߰�");
		JTextArea jtaNameDisp = new JTextArea();
		
		// �����̳� ������Ʈ(FlowLayout) �Ϲ� ������Ʈ�� ��ġ
		JPanel jpNorth = new JPanel();
		
		//3. ��ġ
		jpNorth.add(jlblName);
		jpNorth.add(jtfName);
		jpNorth.add(jbtnAdd);
		
		//������ ������Ʈ(BorderLayout) ��ġ
		add("North", jpNorth);
		add("Center", jtaNameDisp);
		
		//4.������ ũ�⼳��+����ȭ
		setSize(400,400);		
		setVisible(true);
		//5. �����̺�Ʈ
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		new UseLayoutManager();
	}
}
