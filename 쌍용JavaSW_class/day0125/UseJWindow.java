package day0125;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JWindow;

/**
 * �����츦 ��ӹ�����, ������Ʈ�� �����̳� ������Ʈ�� ��ġ�Ͽ� ��Ƽ� 
 * �����ֱ� ���� JFRAME�� �ʿ��ϴ�
 * @author user
 *
 */
@SuppressWarnings("serial")
public class UseJWindow extends JWindow{

	public UseJWindow(JFrame jf) {
		super(jf);
		jf.setSize(400,400); //������� 400, 400 ������
		jf.setVisible(true);
		}
	
	public static void main(String[] args) {
		JFrame jf= new JFrame(); //���� �ϳ� ����� 
		new UseJWindow(jf);
		JButton b1 = new JButton("Click");
		b1.setBounds(100,100,100,40);
		jf.add(b1);
		
	}//main
	
}//class
