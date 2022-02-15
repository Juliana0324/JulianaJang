package day0128;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestAdapterAnonymous extends JFrame {
	public TestAdapterAnonymous() {
		super("어댑터 Anonymous");
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("anonymous inner class에서 처리한 window종료 ");
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
