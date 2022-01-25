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
//������ ������Ʈ ���
public class UseBorderLayout extends JFrame {

	public UseBorderLayout() {
		super("��跹�̾ƿ� ����");
		
		//2. ������Ʈ ����
		JButton jbtSouth = new JButton("South ��ư");
		JButton jbtEast= new JButton("East ��ư");
		JLabel jlnlNorth = new JLabel("���� ��");
		JLabel jlnlWest= new JLabel("���� ��");
		JTextArea jtaCenter = new JTextArea("��� TextArea");
		
		//3. į����Ʈ ��ġ.
		// ��ġ������ ����
//		setLayout(new BorderLayout()); ==> ���� �ʱⰪ�� BorderLayout �̱� ������ ���� �����൵�� 
		
		//���ڿ� ���
		add("North", jlnlNorth);
		add("South", jbtSouth);
		//BorderLayout constant
		add(BorderLayout.CENTER, jtaCenter);
		add(BorderLayout.WEST, jlnlWest);
		add(BorderLayout.EAST, jbtEast);
		
		//4. ������ ũ�� ����
		setSize(500,500);
		setVisible(true);
		
		//6. ������ ���� �̺�Ʈ ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new UseBorderLayout();
	}

}
