package day0126;

import java.awt.Button;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UseCManualLayout extends JFrame{
	
	public UseCManualLayout() {
		super("������ġ ����");
		//������Ʈ ����
		JLabel jbl = new JLabel("��");
		JComboBox<String> jcmbBox = new JComboBox<String>();
		ImageIcon ii = new ImageIcon("/img3.PNG");
		JButton bttn = new JButton(ii);
		
		
		jcmbBox.addItem("�ڹ�");
		jcmbBox.addItem("oracle");
		jcmbBox.addItem("JSP");
		jcmbBox.addItem("SPRING");
		jcmbBox.addItem("�޺��ڽ�");
		
		
		
		String[] data = "������, ���μ�,, ������, ������, ������".split(",");
		JList<String> jl = new JList<String>(data);
		
		//3. ��ġ
		//������ �����Ǿ��ִ� ��ġ������ ����
		setLayout(null);
		
		//4, ������Ʈ ũ�⼳�� or ������Ʈ ��ǥ����
		//����
		jbl.setOpaque(true); //���� ���� ���� �Ǿ� ���� ���� ����
		jbl.setBackground(new Color(0xFADCD9));
		
		//�����
		jbl.setForeground(Color.red); 

		jbl.setLocation(10, 40);
		jcmbBox.setLocation(130, 100);

		jbl.setSize(80,30);
		jcmbBox.setSize(120,40);

		//��ǥ������ ũ�⸦ ���ÿ� ����
		jl.setBounds(290,40,120,100);
		
		add(jbl);
		add(jcmbBox);
		add(jl);
		add(bttn);
		
		
		setSize(500,400);
		setVisible(true);
		//������ ũ�⺯�渷��
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UseCManualLayout();
	}
}
