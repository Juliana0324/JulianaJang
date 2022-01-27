package day0127;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Homework0127 extends JFrame implements ActionListener{
	JComboBox<String> className;
	JTextField chosenItem;
	public Homework0127() {
		super("¼ö¾÷¸í Ã¼Å©");
		className = new JComboBox<String>();
		chosenItem = new JTextField();
		
		className.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 25));
		chosenItem.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 25));
		
		className.addItem("");
		className.addItem("Java");
		className.addItem("Oracle");
		className.addItem("JDBC");
		className.addItem("HTML");
		
		className.addActionListener(this);
		
		add(className);
		add(chosenItem);
		
		TitledBorder tbClass = new TitledBorder("¼±ÅÃµÈ ¼ö¾÷");
		TitledBorder tbName = new TitledBorder("¼ö¾÷¸í");
		tbClass.setTitleFont(new Font("¸¼Àº °íµñ", Font.PLAIN,15));
		tbName.setTitleFont(new Font("¸¼Àº °íµñ", Font.PLAIN,15));
		chosenItem.setBorder(tbClass);
		className.setBorder(tbName);
		
		setLayout(null);
		className.setBounds(30, 80, 150, 70);
		chosenItem.setBounds(230, 85, 150,60);
		setSize(500,300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = (String) className.getSelectedItem();
		chosenItem.setText(name);
	}

	public static void main(String[] args) {
		new Homework0127();

	}



}
