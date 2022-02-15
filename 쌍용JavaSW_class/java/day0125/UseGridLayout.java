package day0125;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 * �׸��� ���̾ƿ�
 * @author user
 *
 */
@SuppressWarnings("serial")
public class UseGridLayout extends JFrame{
	
	public UseGridLayout() {
		super("�׸��� ���̾ƿ� ����");
		
		//������Ʈ ����
		JLabel jlblHobby = new JLabel("���");
		JLabel jlblGender = new JLabel("����");
		
		JCheckBox jlblHobby1 = new JCheckBox("���");
		JCheckBox jlblHobby2 = new JCheckBox("����");
		
		JRadioButton jrbM = new JRadioButton("����");
		JRadioButton jrbF = new JRadioButton("����");

		//���߿� �ϳ��� �����ϰ� �ȴٸ�
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrbM);
		bg.add(jrbF);
		
		//������Ʈ ��ġ
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
