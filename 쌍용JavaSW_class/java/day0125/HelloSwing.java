package day0125;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Swing Component를 사용한 windowApplication 작성방법
 * @author user
 *
 */
@SuppressWarnings("serial")
public class HelloSwing extends Frame{
	
	public HelloSwing() {
		super("안녕 스윙"); //title
		
		//2. 사용자에게 제공할 컴포넌트 생성
		//swing은 AWT컴포넌트를 혼합하여 사용할 수 있음
		JButton jb = new JButton("스윙 버튼");
		Button btn = new Button("AWT 버튼");
		
		
		//3. 생성된 컴포넌트를 윈도우 컴포넌트에 배치
		//여러 컴포넌트를 한번에 보여주려면 container Component가 사용되거나
		// 윈도우 컴포넌트에 배치관리자(LayoutManager)를 변경하여 보여준다
		setLayout(new GridLayout(1,2)); //배치 관리자 변경
		jb.setBounds(100,100,100,40);
		add(jb);
		add(btn);
		
		//4. 윈도우 사이즈
		setSize(500,250);
		setVisible(true);
		
		//6. 윈도우 종료 이벤트 처리
		//Frame에서는 강제종료를 해야함
		//윈도우에서 종료처리를 method로 처리가
//		addWindowListener(new WindowAdapter() {
//
//			@Override
//			public void windowClosing(WindowEvent e) {
//				dispose();
//			}
//			
//		});
		//이걸로 간단하게 종료 가능
//		setDefaultCloseOper(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new HelloSwing();
	}
}
