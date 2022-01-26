package day0126;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UseLayoutManager extends JFrame{
	
	public UseLayoutManager() {
		super("복합적으로 사용하는 레이아웃 매니저");
		//2. 컴포넌트 생성
		// 일반컴포넌트 - 기능제공
		JLabel jlblName = new JLabel("이름");
		JTextField jtfName = new JTextField(10);
		JButton jbtnAdd = new JButton("추가");
		JTextArea jtaNameDisp = new JTextArea();
		
		// 컨테이너 컴포넌트(FlowLayout) 일반 컴포넌트를 배치
		JPanel jpNorth = new JPanel();
		
		//3. 배치
		jpNorth.add(jlblName);
		jpNorth.add(jtfName);
		jpNorth.add(jbtnAdd);
		
		//윈도우 컴포넌트(BorderLayout) 배치
		add("North", jpNorth);
		add("Center", jtaNameDisp);
		
		//4.윈도우 크기설정+가시화
		setSize(400,400);		
		setVisible(true);
		//5. 종료이벤트
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		new UseLayoutManager();
	}
}
