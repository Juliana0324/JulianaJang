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
	}
	
	public static void main(String[] args) {
		new Homework0311Main();
	}

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

		Homework0311DAO lDAO= new Homework0311DAO();
		LoginVO lVO=new LoginVO();
		
		lVO.setId(id);
		lVO.setPasswd(pass);
		
		try {
//			String name = lDAO.useStatement(lVO);
			String name=lDAO.useLogin(lVO);
			
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
	public void actionPerformed(ActionEvent e) {
		chkNull();
	}

}
