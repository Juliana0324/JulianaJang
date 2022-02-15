package day0203;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UseFileDialogView extends JFrame {

	private JButton open, save ,input, msg, confirm;
	public UseFileDialogView() {
		super("���� ���̾�α� ����");
		open = new JButton("����");
		save = new JButton("����");
		input = new JButton("�Է�");
		msg= new JButton("�޼���");
		confirm= new JButton("Ȯ��");
		
		setLayout(new FlowLayout());
		add(open);
		add(save);
		add(input);
		add(msg);
		add(confirm);

		
		UseFileDialogEvt ufde = new UseFileDialogEvt(this);
		addWindowListener(ufde);
		open.addActionListener(ufde);
		save.addActionListener(ufde);
		input.addActionListener(ufde);
		msg.addActionListener(ufde);
		confirm.addActionListener(ufde);
		

		setBounds(100,100,700,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new UseFileDialogView();
	}

	public JButton getOpen() {
		return open;
	}

	public JButton getSave() {
		return save;
	}

	public JButton getInput() {
		return input;
	}

	public JButton getMsg() {
		return msg;
	}

	public JButton getConfirm() {
		return confirm;
	}
	
	
}
