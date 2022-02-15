package day0126;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class HomeWork0126 extends JFrame {
	
	public HomeWork0126() {
		super("사원 관리");
		JLabel numT = new JLabel("번호"), nameT = new JLabel("이름"), genderT=new JLabel("성별"), emailT= new JLabel("이메일");
		JTextField num = new JTextField("번호");
		JTextField name = new JTextField("이름");
		JRadioButton genderM = new JRadioButton("남");
		JRadioButton genderF = new JRadioButton("여");
		JTextField email = new JTextField("이메일");
		JTextArea data = new JTextArea();
		JButton add = new JButton("추가"), del = new JButton("삭제"), change = new JButton("변경"), close = new JButton("닫기");
		Font f = new Font("맑은 고딕", Font.PLAIN, 13);
		
		data.setBorder(new TitledBorder("데이터"));
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(genderM);
		bg.add(genderF);
		
		nameT.setFont(f);
		numT.setFont(f);
		genderT.setFont(f);
		emailT.setFont(f);
		genderM.setFont(f);
		genderF.setFont(f);
		
		setLayout(null);
		add(numT);
		add(num);
		add(nameT);
		add(name);
		add(genderT);
		add(genderM);
		add(genderF);
		add(emailT);
		add(email);
		add(data);
		add(add);
		add(del);
		add(change);
		add(close);
		
		numT.setBounds(10,50,100,13);
		num.setBounds(60,46,100,30);
		nameT.setBounds(10,90,100,13);
		name.setBounds(60,86,100,30);
		genderT.setBounds(10,130, 100, 13);
		genderM.setBounds(50, 130, 50,13);
		genderF.setBounds(100,130,100,13);
		emailT.setBounds(10,170,100,13);
		email.setBounds(60,160,100,30);
		data.setBounds(200, 50, 200,150);
		
		add.setBounds(20, 250, 75,30);
		del.setBounds(100, 250, 75,30);
		change.setBounds(180, 250, 75,30);
		close.setBounds(260, 250, 75,30);

		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new HomeWork0126();
	}

}
