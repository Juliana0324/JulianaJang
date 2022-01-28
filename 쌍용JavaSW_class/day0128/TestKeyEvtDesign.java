package day0128;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 * 디자인 중심 프레임워크
 * @author user
 *
 */
@SuppressWarnings("serial")
public class TestKeyEvtDesign extends JFrame {
	//2. 이벤트 처리에 사영되는 컴포넌트 선언
	private JTextField jtfKey;
	private JLabel jlblOutput;
	
	public TestKeyEvtDesign() {
		super("키보드 이벤트");
		
		jtfKey = new JTextField();
		jlblOutput = new JLabel("출력 : ");
		Font font = new Font("맑은 고딕", Font.BOLD, 20);
		jtfKey.setFont(font);
		jlblOutput.setFont(font);
		
		setLayout(new GridLayout(2,1));
		add(jtfKey);
		add(jlblOutput);
		
		TestKeyEvtProcess tkep = new TestKeyEvtProcess(this);
		jtfKey.addKeyListener(tkep); //JTextField를 이벤트를 등록
		addWindowListener(tkep);// JFrame을 이벤트에 등록 - 기존 에러나던것이 tkep에서 window 어댑터를 상속받아서 사용될수 있게됨
		
		
		setBounds(100,100,300,150);
		setVisible(true);
	}
	
	
	public JTextField getJtfKey() {
		return jtfKey;
	}


	public JLabel getJlblOutput() {
		return jlblOutput;
	}

	public static void main(String[] args) {
		new TestKeyEvtDesign();
	}

}
