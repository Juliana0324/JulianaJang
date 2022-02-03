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
		FileDialog fdOpen = new FileDialog(ufdv, "����", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String path = fdOpen.getDirectory();
		String name = fdOpen.getFile();
		
		
		if(name !=null) {
			try {
				//Ÿ��Ʋ�ٿ� ��ο� ���ϸ� ����
				ufdv.setTitle("���� "+name);
				File file = new File(path+ name);
				BufferedReader bfr = new BufferedReader(new java.io.InputStreamReader(new FileInputStream(file)));
				System.out.println(bfr.readLine());
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	private void saveFileDialog() {
		FileDialog fdSave = new FileDialog(ufdv, "����", FileDialog.SAVE);
		fdSave.setVisible(true);
		String path = fdSave.getDirectory();
		String name = fdSave.getFile();
				
		if(name !=null) {
			try {
				//Ÿ��Ʋ�ٿ� ��ο� ���ϸ� ����
				ufdv.setTitle("�ݱ� :"+name);
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
		int ask = JOptionPane.showConfirmDialog(ufdv, "�����Ͻðڽ��ϱ�?");
		switch(ask) {
		//�����ϱ�
		//OK_OPTION = 0, NO_OPTION = 1, CANCEL_OPTION = 2
		case JOptionPane.OK_OPTION:
			ufdv.setTitle("�� ����");
			System.out.println("����");
			break;
		case JOptionPane.NO_OPTION:
			ufdv.setTitle("�ƴϿ� ����");
			System.out.println("�������� ����");
			break;
		default:
			ufdv.setTitle("��� ����");
			System.out.println("���");
			
		}
		
	}

	private void useMsgDialog() {
//		 JOptionPane.showMessageDialog(ufdv, "�ȳ��ϼ��� "+inputMsg+"��");
		//������ ����
		 JOptionPane.showMessageDialog(ufdv, "�ȳ��ϼ��� "+inputMsg+"�� ","�⺻ �޼���", JOptionPane.PLAIN_MESSAGE);
		 JOptionPane.showMessageDialog(ufdv, "�ȳ��ϼ��� "+inputMsg+"�� ","��� �޼���", JOptionPane.WARNING_MESSAGE);
		 JOptionPane.showMessageDialog(ufdv, "�ȳ��ϼ��� "+inputMsg+"�� ","���� �޼���", JOptionPane.INFORMATION_MESSAGE);
		 JOptionPane.showMessageDialog(ufdv, "�ȳ��ϼ��� "+inputMsg+"�� ","���� �޼���", JOptionPane.QUESTION_MESSAGE);
		 JOptionPane.showMessageDialog(ufdv, "�ȳ��ϼ��� "+inputMsg+"�� ","���� �޼���", JOptionPane.ERROR_MESSAGE);
	}

	private void useInputDialog() {
//		String inputMsg = JOptionPane.showInputDialog("�̸��� �Է��� �ּ���");
//		String inputMsg = JOptionPane.showInputDialog(ufdv, "�̸��� �Է��� �ּ���");
//		String inputMsg = JOptionPane.showInputDialog(ufdv, "�̸��� �Է��� �ּ���", "�̸�(��)");
		this.inputMsg = JOptionPane.showInputDialog(ufdv, "�̸��� �Է��� �ּ���", "�̸�(��)", JOptionPane.WARNING_MESSAGE);
		ufdv.setTitle("�̸�: "+inputMsg);
	}

	@Override
	public void windowClosing(WindowEvent we) {
		ufdv.dispose();
		
	}

	
}
