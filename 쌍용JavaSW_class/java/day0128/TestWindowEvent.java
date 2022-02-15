package day0128;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class TestWindowEvent extends JFrame implements WindowListener{
	public TestWindowEvent() {
		super("윈도우 이벤트 연습");
		
		addWindowListener(this);
		setSize(300,400);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new TestWindowEvent();
	}


	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}


	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		dispose();
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowIconified");
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeiconified");
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("windowActivated");
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeactivated");
		
	}
}
