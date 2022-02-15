package day0203;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UseFileDialogView extends JFrame {

	private JButton open, save ,input, msg, confirm;
	public UseFileDialogView() {
		super("파일 다이얼로그 연습");
		open = new JButton("열기");
		save = new JButton("저장");
		input = new JButton("입력");
		msg= new JButton("메세지");
		confirm= new JButton("확인");
		
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
