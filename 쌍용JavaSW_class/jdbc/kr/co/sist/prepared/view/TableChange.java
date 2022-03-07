package kr.co.sist.prepared.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import kr.co.sist.prepared.dao.TableDAO;
import kr.co.sist.prepared.vo.CpEmp5VO;

@SuppressWarnings("serial")
public class TableChange extends JFrame implements ActionListener {
	
	private JRadioButton jrbEmp, jrbCpEmp;
	private JButton jbtn;
	private JTextArea jtaOutput;
	private JScrollPane jspJtaOutput;
	
	public TableChange() {
		super("������� ��ȸ");
		jrbEmp=new JRadioButton("����", true);
		jrbCpEmp=new JRadioButton("����", false);
		jbtn=new JButton("�����ȸ");
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(jrbEmp);
		bg.add(jrbCpEmp);
		
		JPanel jpanel=new JPanel();
		jpanel.setBorder(new TitledBorder("�����ȸ"));
		
		jpanel.add(jrbEmp);		
		jpanel.add(jrbCpEmp);		
		jpanel.add(jbtn);		
		
		jbtn.addActionListener(this);
		
		jtaOutput=new JTextArea();
		jspJtaOutput=new JScrollPane(jtaOutput);
		jspJtaOutput.setBorder(new TitledBorder("��ȸ���"));
		
		add("North",jpanel);
		add("Center",jspJtaOutput);
		
		setBounds(100,100,500,600);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}//TableChange
	
	public void searchEmp(String depart) {
		switch ( JOptionPane.showConfirmDialog(this, depart+"�� ��� ����� �˻��Ͻðڽ��ϱ�?")){
		case JOptionPane.OK_OPTION:
			System.out.println(depart);
			String tableName="EMP";
			if("����".equals(depart)) {
				tableName="cp_emp5";
			}
			//DB�۾�
			TableDAO tDAO= TableDAO.getInstance();
			try {
				List<CpEmp5VO> list=tDAO.selectTable(tableName);
				
				StringBuilder output= new StringBuilder();
				output.append("��ȣ\t�����ȣ\t�����\t����\t���ʽ�\t�μ���ȣ\n");
				CpEmp5VO ceVO=null;
				for(int i=0; i<list.size();i++) {
					ceVO= list.get(i);
					output.append(i+1).append("\t")
					.append(ceVO.getEmpno()).append("\t")
					.append(ceVO.getEname()).append("\t")
					.append(ceVO.getSal()).append("\t")
					.append(ceVO.getComm()).append("\t")
					.append(ceVO.getDeptno()).append("\n");
				}
				if(list.isEmpty()) {
					output.append("��������� �������� �ʽ��ϴ�.\n");
				}
				//�ʱ�ȭ�� ������ �Է�
				jtaOutput.setText(output.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//end case
	}//searchEmp
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String selectJrb="����";
		
		if( jrbEmp.isSelected()) {
			selectJrb="����";
		}//end if
		
		searchEmp(selectJrb);		
		
		
	}//actionPerformed

	public static void main(String[] args) {
		new TableChange();
	}//main

}//class
