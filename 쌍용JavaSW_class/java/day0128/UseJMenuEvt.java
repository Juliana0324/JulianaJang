package day0128;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 이벤트 처리
 * @author user
 *
 */
public class UseJMenuEvt extends WindowAdapter implements ActionListener {
	private UseJMenu ujm;

	
	public UseJMenuEvt(UseJMenu ujm) {this.ujm = ujm;}
	
	@Override
	public void windowClosing(WindowEvent we) {
		ujm.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == ujm.getJmiDialog()) {
			new UseJDialog(ujm);
		}
		if(ae.getSource() == ujm.getJmiClose()) {
			ujm.dispose();
		}
	}

}
