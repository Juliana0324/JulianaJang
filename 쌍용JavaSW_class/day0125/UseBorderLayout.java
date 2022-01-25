package day0125;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * BorderLayout
 * @author user
 *
 */
@SuppressWarnings("serial")
//윈도우 컴포넌트 상속
public class UseBorderLayout extends JFrame {

	public UseBorderLayout() {
		super("경계레이아웃 연습");
		
		//2. 컴포넌트 생성
		JButton jbtSouth = new JButton("South 버튼");
		JButton jbtEast= new JButton("East 버튼");
		JLabel jlnlNorth = new JLabel("북쪽 라벨");
		JLabel jlnlWest= new JLabel("서쪽 라벨");
		JTextArea jtaCenter = new JTextArea("가운데 TextArea");
		
		//3. 캄포넌트 배치.
		// 배치관리자 설정
//		setLayout(new BorderLayout()); ==> 설정 초기값이 BorderLayout 이기 때문에 따로 안해줘도됨 
		
		//문자열 상수
		add("North", jlnlNorth);
		add("South", jbtSouth);
		//BorderLayout constant
		add(BorderLayout.CENTER, jtaCenter);
		add(BorderLayout.WEST, jlnlWest);
		add(BorderLayout.EAST, jbtEast);
		
		//4. 윈도우 크기 설정
		setSize(500,500);
		setVisible(true);
		
		//6. 윈도우 종료 이벤트 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new UseBorderLayout();
	}

}
