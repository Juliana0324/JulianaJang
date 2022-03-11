package day0311;

import java.awt.GridBagLayout;
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

@SuppressWarnings("serial")
public class LoginFormInjection extends JFrame implements ActionListener {

	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JLabel jlblOutput;
	
	public LoginFormInjection() {
		super("�α��� ����");
		
		jtfId=new JTextField();
		jpfPass=new JPasswordField();
		jlblOutput=new JLabel("�������");
		
		jtfId.setBorder(new TitledBorder("���̵�"));
		jpfPass.setBorder(new TitledBorder("��й�ȣ"));
		jlblOutput.setBorder(new TitledBorder("�������"));
		
		setLayout(new GridLayout(3,1));
		
		jtfId.addActionListener(this);
		jpfPass.addActionListener(this);
		
		add(jtfId);
		add(jpfPass);
		add(jlblOutput);
		
		setBounds(100, 100, 300, 250);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//LoginFormInjection
	
	private void chkNull() {
		String id=jtfId.getText().trim();
		if("".equals(id)) {
			JOptionPane.showMessageDialog(this, "���̵� �ʼ� �Է�");
			jtfId.requestFocus();
			return;
		}
		
		String pass=new String(jpfPass.getPassword()).trim();
		if("".equals(pass)) {
			JOptionPane.showMessageDialog(this, "��й�ȣ �ʼ� �Է�");
			jpfPass.requestFocus();
			return;
		}

		LoginDAO lDAO =new LoginDAO();
		
		LoginVO lVO=new LoginVO();
//		lVO.setId(lDAO.blockInjection(id));
//		lVO.setPasswd(lDAO.blockInjection(pass));
		
		lVO.setId(id);
		lVO.setPasswd(pass);
		
		try {
//			String name = lDAO.useStatement(lVO);
			String name=lDAO.usePreparedStatement(lVO);
			
			System.out.println(name);
			jtfId.setText(""); //���̵� �ʱ�ȭ
			jpfPass.setText("");	//��� �ʱ�ȭ
			jtfId.requestFocus(); 	//��ȸ��� �̸��̾��ٸ� ó������ Ŀ�� ������
			
			if("".equals(name)) {
				JOptionPane.showMessageDialog(this, "���̵� ��й�ȣ�� Ȯ���ϼ���");
				jlblOutput.setText("�������");
				
				return;
			}
			
			jlblOutput.setText("�α��� ����! "+name+"�� ȯ���մϴ�.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(lVO);
	}//chkNull;
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		chkNull();
	}//actionPerformed

	public static void main(String[] args) {
		new LoginFormInjection();
	}//main

}//clas
