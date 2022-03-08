package homework0303.teacher;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import homework0303.HomeworkService;

@SuppressWarnings("serial")
public class HomeworkTeacher extends JFrame implements ActionListener{
	JLabel jblName;
	JTextField jfName;
	JButton jbtnInput;
	
	public HomeworkTeacher() {
		super("�̸�����");
		jblName=new JLabel("�̸�");
		jfName =new JTextField(10);
		jbtnInput=new JButton("�Է�");

		setLayout(new FlowLayout());
		
		add(jblName);
		add(jfName);
		add(jbtnInput);
		
		jfName.addActionListener(this);
		jbtnInput.addActionListener(this);
		setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void getJtfName() {
		//��ȿ�� ����
		String name = jfName.getText().trim();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "�߰��� �̸��� �Է��� �ּ���");
			return;
		}	
		
		try {
			insertName(name);
			JOptionPane.showMessageDialog(this, name+"���� ������ �߰��Ͽ����ϴ�.");
			jfName.setText("");
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(this, "�̸� �߰� �۾��߿� ������ �߻��Ͽ����ϴ�.");
			se.printStackTrace();
		}
	}
	
	
	private Connection getDBConnection() throws SQLException{
		Connection conn=null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pw="tiger";
		conn= DriverManager.getConnection(url, id,pw);
		
		return conn;
	}
	
	private void insertName(String name) throws SQLException{
		Connection conn=null;
		Statement stmt=null;
		try {
			//1. ����̹� �ε�
			//2. Ŀ�ؼ� ���
			conn=getDBConnection();
			//3. ������ ���� ��ü ���
			stmt=conn.createStatement();
			
			StringBuilder insertName=new StringBuilder();
			insertName.append("INSERT INTO names(name) VALUES('").append(name).append("')");
			
			stmt.executeUpdate(insertName.toString());
			
		} finally {
			if(conn!=null) {conn.close();}
			if(stmt!=null) {stmt.close();}
		}
	}
	
	public static void main(String[] args) {
		new HomeworkTeacher();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getJtfName();
	}
}
