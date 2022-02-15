package day0128;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UseJDialog extends JDialog {
	private JButton jbtnClose;
	
	public UseJDialog(UseJMenu ujm) {
		super(ujm, "자식창", true); //UseJMenu클래스를 부모 윈도우로 한 Dialog
		
		jbtnClose = new JButton("닫기");
		JPanel jpSouth = new JPanel();
		jpSouth.add(jbtnClose);
		
		add("South", jpSouth);
		
		//이벤트 등록 - Dialog는 무조건 가시화 전에 일어남
		JDialogEvt ujde = new JDialogEvt(this);
		addWindowListener(ujde);
		jbtnClose.addActionListener(ujde);
		
		
//		setBounds(100,100,400,300); -고정값으로 부모윈도우와 관련없이 항상정해진 위치에 보여진다
		setBounds(ujm.getX()+100,ujm.getY()+150,400,300);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); ==> false로 바쒸어서 에러남
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}//UseJDialog
	
	
	public JButton getJbtnClose() {
		return jbtnClose;
	}
	

	
}
