package day0125;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 * 그리드 레이아웃
 * @author user
 *
 */
@SuppressWarnings("serial")
public class UseGridLayout extends JFrame{
	
	public UseGridLayout() {
		super("그리드 레이아웃 연습");
		
		//컴포넌트 생성
		JLabel jlblHobby = new JLabel("취미");
		JLabel jlblGender = new JLabel("성별");
		
		JCheckBox jlblHobby1 = new JCheckBox("등산");
		JCheckBox jlblHobby2 = new JCheckBox("낚시");
		
		JRadioButton jrbM = new JRadioButton("남자");
		JRadioButton jrbF = new JRadioButton("여자");

		//둘중에 하나만 선택하게 된다면
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrbM);
		bg.add(jrbF);
		
		//컴포넌트 배치
		setLayout(new GridLayout(2,3));
		add(jlblHobby);
		add(jlblHobby1);
		add(jlblHobby2);
		
		add(jlblGender);
		add(jrbM);
		add(jrbF);
		
		setSize(300,200);
		setVisible(true);
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UseGridLayout();
	}
}
