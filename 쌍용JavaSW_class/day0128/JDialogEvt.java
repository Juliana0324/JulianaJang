package day0128;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

/**
 * 다이얼로그 이벤트 처리
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
		switch(JOptionPane.showConfirmDialog(ujd,"정말 종료하시겠습니까?")) {
		case JOptionPane.OK_OPTION:
			ujd.dispose(); break;

		}
		
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		ujd.dispose();
		

	}

}
