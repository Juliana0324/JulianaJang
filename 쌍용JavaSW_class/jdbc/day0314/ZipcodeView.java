package day0314;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class ZipcodeView extends JFrame implements ActionListener {

	/**
	 *  03-14-2022
	 */
	private static final long serialVersionUID = 1285468668584200439L;

	private JTextField jtfDong;
	private DefaultTableModel dtmZipcode;
	private JTable jtZipcode;
	private JScrollPane jspZipcode;
	private JButton jbtnSearch;
	
	public ZipcodeView() {
		super("�����ȣ �˻�");
		jtfDong=new JTextField(10);
		
		String[] columnNames= {"�����ȣ","�ּ�"};
		dtmZipcode=new DefaultTableModel(columnNames, 0);
		jtZipcode=new JTable( dtmZipcode );
		jtZipcode.setRowHeight(20);
		jtZipcode.getColumnModel().getColumn(0).setPreferredWidth(70);
		jtZipcode.getColumnModel().getColumn(1).setPreferredWidth(530);
		
		jspZipcode=new JScrollPane( jtZipcode );
		jspZipcode.setBorder(new TitledBorder("��ȸ���"));
		
		
		jbtnSearch=new JButton("��ȸ");
		
		JPanel jpNorth=new JPanel();
		jpNorth.add(new JLabel("�� �Է�)"));
		jpNorth.add(jtfDong);
		jpNorth.add(jbtnSearch);
		jpNorth.setBorder(new TitledBorder("�� �̸��� �Է�"));

		add("North", jpNorth);
		add("Center",jspZipcode);
		
		jbtnSearch.addActionListener(this);
		
		setBounds(100,100,600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//ZipcodeView
	
	/**
	 * Default table �𵨿� ��ȸ�� �����ȣ�� �����ϴ���
	 */
	private void setZipcode() {
		String dong = jtfDong.getText().trim();
		
		if("".equals(dong)) {
			JOptionPane.showMessageDialog(this, "���� �ʼ� �Է�");
			jtfDong.requestFocus();
			return;
		}
		
		ZipcodeDAO zDAO= ZipcodeDAO.getInstance();
		try {
			List<ZipcodeVO> listZip=zDAO.selectPreparedStatement(dong);
			//defaultTableModel�� �ֱ�
			//���̺��� ���ڵ带 �ʱ�ȭ
			dtmZipcode.setRowCount(0);
			
			//��ȸ�� �����͸� DefaultTableMdel�� �����ϤӤ� ���� �迭����
			Object[] rowData=null;
			StringBuilder sbAddr = new StringBuilder();
			for(ZipcodeVO zVO:listZip) {
				rowData=new Object[2]; //�����ȣ, �ּ�(�õ�,����,��,���� �� ����)
				rowData[0]=zVO.getZipcode();
				
				sbAddr.append(zVO.getSido()).append(" ")
				.append(zVO.getGugun()).append(" ").append(zVO.getDong()).append(" ")
				.append(zVO.getBunji());
				rowData[1]=sbAddr.toString();
				
				//������ �����ȣ�� �ּҸ� ���� �迭�� DefaultTableModel����
				dtmZipcode.addRow(rowData);
				sbAddr.delete(0, sbAddr.length());
			}
			
			if(listZip.isEmpty()) {
				rowData=new Object[2];
				rowData[0]="";
				rowData[1]=dong+"�� �������� �ʽ��ϴ�.";
				dtmZipcode.addRow(rowData);
			}
			jtfDong.setText("");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		setZipcode();
	}//actionPerformed

	public static void main(String[] args) {
		new ZipcodeView();
	}//main

}//class
