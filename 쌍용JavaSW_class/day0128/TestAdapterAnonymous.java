package day0128;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestAdapterAnonymous extends JFrame {
	public TestAdapterAnonymous() {
		super("����� Anonymous");
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("anonymous inner class���� ó���� window���� ");
				dispose();
			}
			
		});
		
		setSize(400, 300);
		setVisible(true);
		
	}
	
	
	
	public static void main(String[] args) {
		new TestAdapterAnonymous();
	}

}
