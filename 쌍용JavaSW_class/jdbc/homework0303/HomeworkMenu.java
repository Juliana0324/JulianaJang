package homework0303;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class HomeworkMenu extends JFrame implements ActionListener{
	JLabel jblName;
	JTextField jfName;
	JButton jbtnInput;
	
	public HomeworkMenu() {
		jblName=new JLabel("이름");
		jfName =new JTextField();
		jbtnInput=new JButton("입력");

		setLayout(null);
		
		add(jblName);
		add(jfName);
		add(jbtnInput);
		
		jblName.setBounds(10,10,50,50);
		jfName.setBounds(70,20,100,30);
		jbtnInput.setBounds(190,10,90,50);
		
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
