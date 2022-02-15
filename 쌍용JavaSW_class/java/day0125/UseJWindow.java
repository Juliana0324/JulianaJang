package day0125;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JWindow;

/**
 * 윈도우를 상속받으면, 컴포넌트나 컨테이너 컴포넌트를 배치하여 담아서 
 * 보여주기 위해 JFRAME이 필요하다
 * @author user
 *
 */
@SuppressWarnings("serial")
public class UseJWindow extends JWindow{

	public UseJWindow(JFrame jf) {
		super(jf);
		jf.setSize(400,400); //사이즈는 400, 400 사이즈
		jf.setVisible(true);
		}
	
	public static void main(String[] args) {
		JFrame jf= new JFrame(); //판을 하나 만든다 
		new UseJWindow(jf);
		JButton b1 = new JButton("Click");
		b1.setBounds(100,100,100,40);
		jf.add(b1);
		
	}//main
	
}//class
