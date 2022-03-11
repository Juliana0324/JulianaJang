package day0311;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Homework0311Main extends JFrame implements ActionListener{
	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JLabel jlblOutput;
	
	public Homework0311Main() {
		super("로그인 인증");
		
		jtfId=new JTextField();
		jpfPass=new JPasswordField();
		jlblOutput=new JLabel("인증결과");
		
		jtfId.setBorder(new TitledBorder("아이디"));
		jpfPass.setBorder(new TitledBorder("비밀번호"));
		jlblOutput.setBorder(new TitledBorder("인증결과"));
		
		setLayout(new GridLayout(3,1));
		
		jtfId.addActionListener(this);
		jpfPass.addActionListener(this);
		
		add(jtfId);
		add(jpfPass);
		add(jlblOutput);
		
		setBounds(100, 100, 300, 250);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Homework0311Main();
	}

	private void chkNull() {
		String id=jtfId.getText().trim();
		if("".equals(id)) {
			JOptionPane.showMessageDialog(this, "아이디 필수 입력");
			jtfId.requestFocus();
			return;
		}
		
		String pass=new String(jpfPass.getPassword()).trim();
		if("".equals(pass)) {
			JOptionPane.showMessageDialog(this, "비밀번호 필수 입력");
			jpfPass.requestFocus();
			return;
		}

		Homework0311DAO lDAO= new Homework0311DAO();
		LoginVO lVO=new LoginVO();
		
		lVO.setId(id);
		lVO.setPasswd(pass);
		
		try {
//			String name = lDAO.useStatement(lVO);
			String name=lDAO.useLogin(lVO);
			
			System.out.println(name);
			jtfId.setText(""); //아이디 초기화
			jpfPass.setText("");	//비번 초기화
			jtfId.requestFocus(); 	//조회결과 이름이없다면 처음으로 커서 돌리기
			
			if("".equals(name)) {
				JOptionPane.showMessageDialog(this, "아이디나 비밀번호를 확인하세요");
				jlblOutput.setText("인증결과");
				
				return;
			}
			
			jlblOutput.setText("로그인 성공! "+name+"님 환영합니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(lVO);
	}//chkNull;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		chkNull();
	}

}
