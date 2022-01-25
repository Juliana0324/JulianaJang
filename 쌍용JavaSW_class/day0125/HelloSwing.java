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
 * Swing Component�� ����� windowApplication �ۼ����
 * @author user
 *
 */
@SuppressWarnings("serial")
public class HelloSwing extends Frame{
	
	public HelloSwing() {
		super("�ȳ� ����"); //title
		
		//2. ����ڿ��� ������ ������Ʈ ����
		//swing�� AWT������Ʈ�� ȥ���Ͽ� ����� �� ����
		JButton jb = new JButton("���� ��ư");
		Button btn = new Button("AWT ��ư");
		
		
		//3. ������ ������Ʈ�� ������ ������Ʈ�� ��ġ
		//���� ������Ʈ�� �ѹ��� �����ַ��� container Component�� ���ǰų�
		// ������ ������Ʈ�� ��ġ������(LayoutManager)�� �����Ͽ� �����ش�
		setLayout(new GridLayout(1,2)); //��ġ ������ ����
		jb.setBounds(100,100,100,40);
		add(jb);
		add(btn);
		
		//4. ������ ������
		setSize(500,250);
		setVisible(true);
		
		//6. ������ ���� �̺�Ʈ ó��
		//Frame������ �������Ḧ �ؾ���
		//�����쿡�� ����ó���� method�� ó����
//		addWindowListener(new WindowAdapter() {
//
//			@Override
//			public void windowClosing(WindowEvent e) {
//				dispose();
//			}
//			
//		});
		//�̰ɷ� �����ϰ� ���� ����
//		setDefaultCloseOper(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new HelloSwing();
	}
}
