package day0208;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FileCopy extends JFrame{
	private JButton copyFile;
	private JLabel jlblOutput;
	private FileCopy fc;
	
	public FileCopy() {
		super("���Ϻ���");
		
		jlblOutput = new JLabel("���");
		copyFile = new JButton("���Ϻ���");
		
		jlblOutput.setFont(new Font("�ü�ü", Font.BOLD, 20));
		fc = this;
		copyFile.addActionListener(new BtnEventProcess());
		
		JPanel jpCenter= new JPanel();
		jpCenter.add(copyFile);
		
		add("Center", jpCenter);
		add("South", jlblOutput);
		
		setBounds(100,100,400,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//��ư�̺�Ʈ ���� inner class
	public class BtnEventProcess implements ActionListener{
		public void copyFile(File originalFile) throws IOException{
			//��Ʈ������
			FileInputStream fis = null;
			FileOutputStream fos = null;
			
			try {
				//�������� ��Ʈ������
				fis = new FileInputStream(originalFile);
				
				//2. ���� ���ϸ� : �������ϸ�_copy�� �̸����� ����
				StringBuilder copyFileName =new StringBuilder(originalFile.getAbsolutePath());
				copyFileName.insert(copyFileName.lastIndexOf("."), "_copy");
				
				File copyFiles = new File(copyFileName.toString());
				//3. ��½�Ʈ�� ����
				fos = new FileOutputStream(copyFiles);
				jlblOutput.setText(copyFiles.getAbsolutePath());
				
				//5.������ �б�
				byte[] data = new byte[512];
				int dataSize = 0;
				while ((dataSize=fis.read(data) )!= -1) {
					//6.�迭�� ����� �������� ũ�⸦ ��Ʈ���� ���
					fos.write(data,0,dataSize);
				}
				
				
///////////////////////////////////(��������)HDD�� ������� �ʴ� �ڵ�///////////////////////////////////////////////////////////////////////
//				//�������Ͽ��� 1byte���� �о�鿩
//				int readData = 0;
//				while((readData = fis.read())!=-1) {
//					//������ ���Ͽ� ����. (�߷��� ���Ͽ� ����� ��Ʈ���� ����)
//					fos.write(readData);
//				}
//				//6.��Ʈ���� �����ִ� �����͸� ����
//				fos.flush();
//				JOptionPane.showMessageDialog(fc, copyFileName.toString()+"�� ����������ϴ�");
			}finally {
				if(fis != null) {
					fis.close();
				}
				if(fos != null) {
					fos.close();
				}
			}
		}
		
		//16byte��� - txt������ ��������� �̹����������ִ� ���簡 �ȵ�
		public void copyFile16(File originalFile) throws IOException{
			//��Ʈ������
			BufferedReader br = null;
			FileWriter fw = null;
			
			try {
				//�������� ��Ʈ������
				br = new BufferedReader(new FileReader(originalFile));
				
				//2. ���� ���ϸ� : �������ϸ�_copy�� �̸����� ����
				StringBuilder copyFileName =new StringBuilder(originalFile.getAbsolutePath());
				copyFileName.insert(copyFileName.lastIndexOf("."), "_copy16");
				
				File copyFiles = new File(copyFileName.toString());
				//3. ��½�Ʈ�� ����
				fw = new FileWriter(copyFiles);
				jlblOutput.setText(copyFiles.getAbsolutePath());
				
				
				//�������Ͽ��� 1byte���� �о�鿩
				String readData = "";
				while((readData = br.readLine())!=null) {
					//������ ���Ͽ� ����. (�߷��� ���Ͽ� ����� ��Ʈ���� ����)
					fw.write(readData);
				}
				//6.��Ʈ���� �����ִ� �����͸� ����
				fw.flush();
				JOptionPane.showMessageDialog(fc, copyFileName.toString()+"�� ����������ϴ�");
			}finally {
				if(fw != null) {
					fw.close();
				}
				if(br != null) {
					br.close();
				}
			}
		}
		public void openDialog() {
			FileDialog fdOpen = new FileDialog(fc, "���ϼ���", FileDialog.LOAD);
			fdOpen.setVisible(true);
			
			String path = fdOpen.getDirectory();
			String name = fdOpen.getFile();
			
			File originalFile = new File(path+name);
			if(originalFile.exists()) {
				//���� ����
				try {
					copyFile( originalFile );
				} catch (IOException ie) {
					JOptionPane.showMessageDialog(fc, "���Ϻ����� ���� �߻�!");
					ie.printStackTrace();
				}
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			openDialog();
		}		
	}
	
	public static void main(String[] args) {
		new FileCopy();
	}
}
