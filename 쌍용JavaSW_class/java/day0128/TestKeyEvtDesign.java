package day0128;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 * ������ �߽� �����ӿ�ũ
 * @author user
 *
 */
@SuppressWarnings("serial")
public class TestKeyEvtDesign extends JFrame {
	//2. �̺�Ʈ ó���� �翵�Ǵ� ������Ʈ ����
	private JTextField jtfKey;
	private JLabel jlblOutput;
	
	public TestKeyEvtDesign() {
		super("Ű���� �̺�Ʈ");
		
		jtfKey = new JTextField();
		jlblOutput = new JLabel("��� : ");
		Font font = new Font("���� ���", Font.BOLD, 20);
		jtfKey.setFont(font);
		jlblOutput.setFont(font);
		
		setLayout(new GridLayout(2,1));
		add(jtfKey);
		add(jlblOutput);
		
		TestKeyEvtProcess tkep = new TestKeyEvtProcess(this);
		jtfKey.addKeyListener(tkep); //JTextField�� �̺�Ʈ�� ���
		addWindowListener(tkep);// JFrame�� �̺�Ʈ�� ��� - ���� ������������ tkep���� window ����͸� ��ӹ޾Ƽ� ���ɼ� �ְԵ�
		
		
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
