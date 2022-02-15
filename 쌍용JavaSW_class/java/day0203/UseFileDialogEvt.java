package day0203;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class UseFileDialogEvt extends WindowAdapter implements ActionListener {
	private UseFileDialogView ufdv;
	private String inputMsg;
	
	public UseFileDialogEvt(UseFileDialogView ufdv) {
		this.ufdv = ufdv;
	}
	
	private void loadFileDialog() {
		FileDialog fdOpen = new FileDialog(ufdv, "열기", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String path = fdOpen.getDirectory();
		String name = fdOpen.getFile();
		
		
		if(name !=null) {
			try {
				//타이틀바에 경로와 파일명 설정
				ufdv.setTitle("열기 "+name);
				File file = new File(path+ name);
				BufferedReader bfr = new BufferedReader(new java.io.InputStreamReader(new FileInputStream(file)));
				System.out.println(bfr.readLine());
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	private void saveFileDialog() {
		FileDialog fdSave = new FileDialog(ufdv, "저장", FileDialog.SAVE);
		fdSave.setVisible(true);
		String path = fdSave.getDirectory();
		String name = fdSave.getFile();
				
		if(name !=null) {
			try {
				//타이틀바에 경로와 파일명 설정
				ufdv.setTitle("닫기 :"+name);
				File file = new File(path+ name);
				BufferedReader bfr = new BufferedReader(new java.io.InputStreamReader(new FileInputStream(file)));
				
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == ufdv.getOpen()) {
			loadFileDialog();
		}
		if(ae.getSource() == ufdv.getSave()) {
			saveFileDialog();
		}
		if(ae.getSource() == ufdv.getInput()) {
			useInputDialog();
		}
		if(ae.getSource() == ufdv.getMsg()) {
			useMsgDialog();
		}
		if(ae.getSource() == ufdv.getConfirm()) {
			useConfirmDialog();
		}
	}


	private void useConfirmDialog() {
		int ask = JOptionPane.showConfirmDialog(ufdv, "종료하시겠습니까?");
		switch(ask) {
		//저장하기
		//OK_OPTION = 0, NO_OPTION = 1, CANCEL_OPTION = 2
		case JOptionPane.OK_OPTION:
			ufdv.setTitle("예 선택");
			System.out.println("저장");
			break;
		case JOptionPane.NO_OPTION:
			ufdv.setTitle("아니오 선택");
			System.out.println("저장하지 않음");
			break;
		default:
			ufdv.setTitle("취소 선택");
			System.out.println("취소");
			
		}
		
	}

	private void useMsgDialog() {
//		 JOptionPane.showMessageDialog(ufdv, "안녕하세요 "+inputMsg+"님");
		//아이콘 변경
		 JOptionPane.showMessageDialog(ufdv, "안녕하세요 "+inputMsg+"님 ","기본 메세지", JOptionPane.PLAIN_MESSAGE);
		 JOptionPane.showMessageDialog(ufdv, "안녕하세요 "+inputMsg+"님 ","경고 메세지", JOptionPane.WARNING_MESSAGE);
		 JOptionPane.showMessageDialog(ufdv, "안녕하세요 "+inputMsg+"님 ","정보 메세지", JOptionPane.INFORMATION_MESSAGE);
		 JOptionPane.showMessageDialog(ufdv, "안녕하세요 "+inputMsg+"님 ","질문 메세지", JOptionPane.QUESTION_MESSAGE);
		 JOptionPane.showMessageDialog(ufdv, "안녕하세요 "+inputMsg+"님 ","에러 메세지", JOptionPane.ERROR_MESSAGE);
	}

	private void useInputDialog() {
//		String inputMsg = JOptionPane.showInputDialog("이름을 입력해 주세요");
//		String inputMsg = JOptionPane.showInputDialog(ufdv, "이름을 입력해 주세요");
//		String inputMsg = JOptionPane.showInputDialog(ufdv, "이름을 입력해 주세요", "이름(성)");
		this.inputMsg = JOptionPane.showInputDialog(ufdv, "이름을 입력해 주세요", "이름(성)", JOptionPane.WARNING_MESSAGE);
		ufdv.setTitle("이름: "+inputMsg);
	}

	@Override
	public void windowClosing(WindowEvent we) {
		ufdv.dispose();
		
	}

	
}
