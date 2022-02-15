package day0126;

import java.awt.Button;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UseCManualLayout extends JFrame{
	
	public UseCManualLayout() {
		super("수동배치 연습");
		//컴포넌트 생성
		JLabel jbl = new JLabel("라벨");
		JComboBox<String> jcmbBox = new JComboBox<String>();
		ImageIcon ii = new ImageIcon("/img3.PNG");
		JButton bttn = new JButton(ii);
		
		
		jcmbBox.addItem("자바");
		jcmbBox.addItem("oracle");
		jcmbBox.addItem("JSP");
		jcmbBox.addItem("SPRING");
		jcmbBox.addItem("콤보박스");
		
		
		
		String[] data = "전민정, 정인선,, 장정우, 김진영, 김현우".split(",");
		JList<String> jl = new JList<String>(data);
		
		//3. 배치
		//기존에 설정되어있는 배치관리자 해제
		setLayout(null);
		
		//4, 컴포넌트 크기설정 or 컴포넌트 좌표설정
		//배경색
		jbl.setOpaque(true); //라벨은 투명도 설정 되어 있음 투명도 해제
		jbl.setBackground(new Color(0xFADCD9));
		
		//전경색
		jbl.setForeground(Color.red); 

		jbl.setLocation(10, 40);
		jcmbBox.setLocation(130, 100);

		jbl.setSize(80,30);
		jcmbBox.setSize(120,40);

		//좌표설정과 크기를 동시에 설정
		jl.setBounds(290,40,120,100);
		
		add(jbl);
		add(jcmbBox);
		add(jl);
		add(bttn);
		
		
		setSize(500,400);
		setVisible(true);
		//윈도우 크기변경막기
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UseCManualLayout();
	}
}
