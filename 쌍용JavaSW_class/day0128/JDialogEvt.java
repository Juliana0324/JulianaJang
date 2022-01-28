package day0128;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

/**
 * ���̾�α� �̺�Ʈ ó��
 * @author user
 *
 */
public class JDialogEvt extends WindowAdapter implements ActionListener {

	private UseJDialog ujd;
	
	public JDialogEvt(UseJDialog ujd) {
		this.ujd = ujd;
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		switch(JOptionPane.showConfirmDialog(ujd,"���� �����Ͻðڽ��ϱ�?")) {
		case JOptionPane.OK_OPTION:
			ujd.dispose(); break;

		}
		
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		ujd.dispose();
		

	}

}
