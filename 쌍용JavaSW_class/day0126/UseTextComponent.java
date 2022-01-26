package day0126;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseTextComponent extends JFrame{
	int cnt = 1;
	public UseTextComponent() {
		super("Text Component ����");
		
		JTextField jtf = new JTextField("�̸�");
		JPasswordField jpf = new JPasswordField("��й�ȣȣ");
		JTextArea jta = new JTextArea();
		JButton b1 = new JButton("Click");
		//���⹮�� ����
		jpf.setEchoChar('*');
		
		//JTextArea�� ��ũ�ѹٰ� �������� ��ũ�ѹٸ� ������ JScrollPane�� has a ���踦 ��������
		JScrollPane jsp = new JScrollPane(jta);
		jtf.setBorder(new TitledBorder("�̸�"));
		jpf.setBorder(new TitledBorder("����"));
		jsp.setBorder(new TitledBorder("���"));
		setLayout(null);
		
		
		
		jtf.setBounds(20,30,200,50);
		jpf.setBounds(20,80,200,50);
		
		//Jspũ�⸦ �������ش�
		jsp.setBounds(20,170,200,200);
		b1.setBounds(120,380,100,30);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jta.setText("Button Clicked: "+ (cnt++));
			}
		});
		
		add(jtf);
		add(jpf);
		
		//JTextArea�� ���� JScrollPane�� ��ġ�Ѵ�
		add(jsp);
		add(b1);
		
		setBounds(100,100,250,460);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UseTextComponent();
	}
}
