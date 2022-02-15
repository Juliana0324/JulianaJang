package day0127;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseJList extends JFrame {
	public UseJList() {
		super("MVC������ ���Ե� Ŭ����");
		
		//������Ʈ ����
		//MVC ������ ���Ե� ������Ʈ
		DefaultListModel<String> dlmFriend = new DefaultListModel<String>();
		DefaultListModel<String> dlmBlockFriend = new DefaultListModel<String>();
		JList<String> listFriend = new JList<String>(dlmFriend);
		JList<String> listBlockFriend = new JList<String>(dlmBlockFriend);

		JScrollPane jspListFriend= new JScrollPane(listFriend);
		JScrollPane jspListBlockFriend= new JScrollPane(listBlockFriend);
		
		jspListFriend.setBorder(new TitledBorder("ģ�����"));
		jspListBlockFriend.setBorder(new TitledBorder("���ܵ� ģ�����"));
		JButton jbtnBlock = new JButton(">>");
		JButton jbtnNonBlock = new JButton("<<");
		
		setLayout(null);
		
		jspListFriend.setBounds(20,40,200, 350);
		jspListBlockFriend.setBounds(330,40,200,350);
		jbtnBlock.setBounds(250,150,50,50);
		jbtnNonBlock.setBounds(250,200,50,50);
		
		dlmFriend.addElement("������");
		dlmFriend.addElement("���μ�");
		dlmFriend.addElement("������");
		dlmFriend.addElement("������");
		dlmFriend.addElement("������");
		dlmFriend.addElement("�ǿ���");
		dlmFriend.addElement("������");
		
		
		add(jspListFriend);
		add(jspListBlockFriend);
		add(jbtnBlock);
		add(jbtnNonBlock);
		
		
		setBounds(100,150,600, 450);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	public static void main(String[] args) {
		new UseJList();
	}

}
