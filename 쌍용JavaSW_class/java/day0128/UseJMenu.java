package day0128;

import java.awt.Frame;
import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class UseJMenu extends JFrame {
	private JMenuItem jmiNew, jmiDialog, jmiClose, jmiHelp;
	
	public UseJMenu() {
		super("�޴�����");
		
		JMenuBar jmb = new JMenuBar();
		
		JMenu jm = new JMenu("�޴�1");
		JMenu jm2 = new JMenu("�޴�2");
		
		jmiNew = new JMenuItem("�޴� ������");
		jmiDialog= new JMenuItem("���̾�α�");
		jmiClose= new JMenuItem("�ݱ�");
		jmiHelp= new JMenuItem("����");
		
		//�޴������� ��ġ
		jm.add(jmiNew);
		jm.add(jmiDialog);
		jm.add(jmiClose);
		
		jm2.add(jmiHelp);
		
		//5. �޴��� �޴��ٿ� ��ġ
		jmb.add(jm);
		jmb.add(jm2);
		
		//6. �޴��ٸ� �����ӿ� ���ġ
		setJMenuBar(jmb);
		
		//MenuITem�̺�Ʈ ���
		UseJMenuEvt ujme = new UseJMenuEvt(this); //has a ���輳��
		jmiDialog.addActionListener(ujme);
		jmiClose.addActionListener(ujme);
		addWindowListener(ujme);
		
		setSize(800,600);
		setVisible(true);
	}
	
	
	
	public JMenuItem getJmiNew() {
		return jmiNew;
	}



	public JMenuItem getJmiDialog() {
		return jmiDialog;
	}



	public JMenuItem getJmiClose() {
		return jmiClose;
	}



	public JMenuItem getJmiHelp() {
		return jmiHelp;
	}



	public static void main(String[] args) {
		new UseJMenu();
	}

}
