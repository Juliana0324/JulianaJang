package day0125;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * JFrame을 상속받으면 Window부터 생성되어
 * 짧은 코드로 사용자에게 Application을 제공할 수 있다
 * @author user
 *
 */
@SuppressWarnings("serial")
public class UseJFrame extends JFrame{
	
	public UseJFrame() {
		setSize(800,200); //window 클래스
		setVisible(true); //window 클래스
		JButton b1 = new JButton("Click");
		b1.setBounds(100,100,100,40);
		add(b1); //container 클래스 에 있음
	}
	
	
	public static void main(String[] args) {
		new UseJFrame();
		
	}
}
