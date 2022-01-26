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
		super("Text Component 연습");
		
		JTextField jtf = new JTextField("이름");
		JPasswordField jpf = new JPasswordField("비밀번호호");
		JTextArea jta = new JTextArea();
		JButton b1 = new JButton("Click");
		//반향문자 설정
		jpf.setEchoChar('*');
		
		//JTextArea는 스크롤바가 없음으로 스크롤바를 구현한 JScrollPane과 has a 관계를 설정한후
		JScrollPane jsp = new JScrollPane(jta);
		jtf.setBorder(new TitledBorder("이름"));
		jpf.setBorder(new TitledBorder("나이"));
		jsp.setBorder(new TitledBorder("출력"));
		setLayout(null);
		
		
		
		jtf.setBounds(20,30,200,50);
		jpf.setBounds(20,80,200,50);
		
		//Jsp크기를 설정해준다
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
		
		//JTextArea를 가진 JScrollPane을 배치한다
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
