package day0127;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TestEvent extends JFrame implements ActionListener{
	//�̺�Ʈ ó������ ������Ʈ ����
	private JButton jbtn,jbtn2;
	private int cnt=0;
	
	public TestEvent() {
		super("is a Event ó������ ���");
		//3. ������Ʈ ��üȭ
		jbtn = new JButton("����");
		jbtn2 = new JButton("�߰�");
		
		//4. ������Ʈ�� �̺�Ʈ ���
		jbtn.addActionListener(this); //��ư���� �̺�Ʈ�� �߻��ϸ� this���� ������ method�� ȣ��
		jbtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cnt++;
				System.out.println(cnt);
			}
		}); //��ư���� �̺�Ʈ�� �߻��ϸ� method ������ ȣ��
		
		//5. 5 ��ġ
		JPanel jp = new JPanel();
		jp.add(jbtn); //��ư�� ����ũ�⸦ ������ �гο� ��ġ		
		jp.add(jbtn2); //��ư�� ����ũ�⸦ ������ �гο� ��ġ
		add("Center", jp);

		//6. ������ 
		setSize(300,300);
		setVisible(true);
		//7. ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	//8. �߻�޼ҵ� �������̵�
	public void actionPerformed(ActionEvent ae) {
		//9. �̺�Ʈ�� �߻��� ����ڿ��� ������ �ڵ�
		System.out.println("��ư�� ������");
		//���� �̺�Ʈ ó��
		dispose();
	}
	
	public static void main(String[] args) {
		new TestEvent();
	}

}
