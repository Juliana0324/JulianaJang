package day0125;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Homework0125 extends JFrame{
	
	public Homework0125() {
		super("¼÷Á¦");
		
		String but = "1,2,3,4,5,6,7,8,9,*,0,#";
		String[] butNum = but.split(",");
		JButton buttons = null;
		setLayout(new GridLayout(4,3));
		for(int i=0; i<butNum.length; i++) {
			buttons = new JButton(butNum[i]);
			add(buttons);
		}
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new Homework0125();
	}
}
