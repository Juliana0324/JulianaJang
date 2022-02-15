package day0127;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;

@SuppressWarnings("serial")
public class UseTableModel extends JFrame{
	public UseTableModel() {
		super("MVC ������ ������ Ŭ����");
		
		//��ũ�ѹٸ� ������ �÷����� ������ �� �ִ�
		String[] columnNames = {"��ȣ", "�̸�", "����", "�̸���"};
		String[][] rowData= {{"1","���μ�", "24", "jung@test.com"},
							{"2","������", "25", "jang@test.com"},
							{"3","������", "26", "kim@test.com"}
							
		};
		DefaultTableModel dtm = new DefaultTableModel(rowData, columnNames);
		JTable jt = new JTable(dtm);
		JScrollPane jsp = new JScrollPane(jt);
		
		//data�߰�
		String[] data = {"4","������", "27", "kim@test.com"};
		dtm.addRow(data);
		
		//�������� ����� ��Ŭ������ ���
		jt.setRowHeight(25);
		jt.setGridColor(Color.red);
		jt.setFont(new Font("���� ���", Font.PLAIN, 15));
		
		//�÷��� ���̸� ���� (JTable�� �÷������� ���� ��ü�� �� ����)
		jt.getColumnModel().getColumn(0).setPreferredWidth(40);
		jt.getColumnModel().getColumn(1).setPreferredWidth(120);
		jt.getColumnModel().getColumn(2).setPreferredWidth(40);
		jt.getColumnModel().getColumn(3).setPreferredWidth(250);
		
		//BorderLayout�� Center�� ������Ʈ ��ġ
		add("Center", jsp);
		
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		new UseTableModel();
	}
}
