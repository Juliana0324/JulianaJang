package day0125;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UseFlowLayout extends JFrame {
	public UseFlowLayout() {
		//1. 윈도우 컴포넌트상속
		super("FlowLayout연습");
		
		//2. 컴포넌트 생성
		JLabel jblName = new JLabel("이름");
		JTextField jTextField = new JTextField(10);
		JCheckBox jcbSaveFlag = new JCheckBox("저장", true);
		JButton jbtn = new JButton("입력");
		
		//3. 컴포넌트 배치
		//Frame레이아웃을 BorderLayout => FlowLayout변경
		//add순서대로
		setLayout(new FlowLayout());
		add(jblName);
		add(jTextField);
		add(jcbSaveFlag);
		add(jbtn);
		
		//4. 윈도우 크기 설정
		setSize(400,400);
		
		//5. 가시화
		setVisible(true);
		
		//6. 종료이벤트
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
	
	public static void main(String[] args) {
		new UseFlowLayout();
	}
}
