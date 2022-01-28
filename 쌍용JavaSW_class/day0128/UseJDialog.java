package day0128;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UseJDialog extends JDialog {
	private JButton jbtnClose;
	
	public UseJDialog(UseJMenu ujm) {
		super(ujm, "�ڽ�â", true); //UseJMenuŬ������ �θ� ������� �� Dialog
		
		jbtnClose = new JButton("�ݱ�");
		JPanel jpSouth = new JPanel();
		jpSouth.add(jbtnClose);
		
		add("South", jpSouth);
		
		//�̺�Ʈ ��� - Dialog�� ������ ����ȭ ���� �Ͼ
		JDialogEvt ujde = new JDialogEvt(this);
		addWindowListener(ujde);
		jbtnClose.addActionListener(ujde);
		
		
//		setBounds(100,100,400,300); -���������� �θ�������� ���þ��� �׻������� ��ġ�� ��������
		setBounds(ujm.getX()+100,ujm.getY()+150,400,300);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); ==> false�� �پ�� ������
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}//UseJDialog
	
	
	public JButton getJbtnClose() {
		return jbtnClose;
	}
	

	
}
