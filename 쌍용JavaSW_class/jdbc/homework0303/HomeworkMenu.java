package homework0303;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import homework0303.HomeworkService;

@SuppressWarnings("serial")
public class HomeworkMenu extends JFrame implements ActionListener{
	JLabel jblName;
	JTextField jfName;
	JButton jbtnInput;
	
	public HomeworkMenu() {
		super("이름저장");
		jblName=new JLabel("이름");
		jfName =new JTextField(10);
		jbtnInput=new JButton("입력");

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
	
	
	public static void main(String[] args) {
		new HomeworkMenu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			String name = jfName.getText();
			new HomeworkService().addNames(name);
	}
}
