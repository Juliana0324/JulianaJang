package kr.co.sist.statement.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import kr.co.sist.statement.dao.StatementDAO;
import kr.co.sist.statement.vo.CpEmp4InsertVO;
import kr.co.sist.statement.vo.CpEmp4SelectAllVO;
import kr.co.sist.statement.vo.CpEmp4SelectOneVO;
import kr.co.sist.statement.vo.CpEmp4UpdateVO;

/**
 * ���� ������ ó���ϸ鼭 �ʿ信 ���� DB�۾��� ����ϴ� Ŭ����
 * XXXService Ŭ������ method���� ������ ���� �ۼ��Ѵ�.
 * @author user
 *
 */
public class UseStatementService {
	public static final String ADD="1";
	public static final String MODIFY="2";
	public static final String REMOVE="3";
	public static final String SEARCH_ONE="4";
	public static final String SEARCH_ALL="5";
	public static final String EXIT="6";
	
	private StatementDAO stmtdao;
	
	public UseStatementService() {
		stmtdao=new StatementDAO();
	}//UseStatementService
	
	public void addCpEmp4() {
		String tempData=JOptionPane.showInputDialog("[�߰��� ��������� \",\"�� �����Է�\n�����ȣ, �����, ����, ����,���ʽ�");
		String[] data=tempData.split(",");
		if(data.length!=5) {
			JOptionPane.showMessageDialog(null, "�������� ������ �����ʽ��ϴ�.");
			return;//early return
		}

		//1. �� ����
	try {
		int empno=Integer.parseInt(data[0]);
		String ename=data[1];
		String job=data[2];
		int sal = Integer.parseInt(data[3]);
		double comm=Double.parseDouble(data[4]);
		
		//2.VO�� ���� �־� �ϳ��ǰ�ü�� ��Ƽ� ó��
		CpEmp4InsertVO insertVO=new CpEmp4InsertVO(empno, sal, ename, job, comm);
		System.out.println(insertVO);
		
		//3.DAO�� ����
		stmtdao.insertCpEmp4(insertVO);
		JOptionPane.showMessageDialog(null, insertVO.getEmpno()+"��� ������ �߰��Ͽ����ϴ�.");
	}catch(SQLException se) {
		JOptionPane.showMessageDialog(null, "����߰� �۾��� �����߻�");		
		se.printStackTrace();
		
		//�پ��� ���� ��Ȳ,
		int errCode=se.getErrorCode();
		String sqlErrMsg="";
		switch(errCode) {
		case 925: 
			sqlErrMsg="�������� �߸��Ǿ���";break;
		case 1:
			sqlErrMsg="���� ��� ��ȣ�� �̹� �����մϴ�.";break;
		case 1438:
			sqlErrMsg="�����ȣ�� 4�ڸ�, ������ 5�ڸ�, ���ʽ� 5�ڸ������� �����մϴ�.";break;
		case 12899:
			sqlErrMsg="������� ���� 10��, �ѱ�3�ڸ������� �����մϴ�. \n������ ���� 9��, �ѱ�3�ڱ����� �����մϴ�";break;
		}
		JOptionPane.showMessageDialog(null, sqlErrMsg);
	}catch(NumberFormatException nf) {
		JOptionPane.showMessageDialog(null, "���, ����,���ʽ��� ���ڿ����մϴ�.");
	}
	}//addCpEmp4
	
	public void modifyCpEmp4() {
		System.out.println("�������");
		String tempData=JOptionPane.showInputDialog("[������ ��������� \",\"�� �����Է�\n�����ȣ, ����, ����,���ʽ��� �����մϴ�.");
		String[] data=tempData.split(",");
		if(data.length!=4) {
			JOptionPane.showMessageDialog(null, "�������� ������ �����ʽ��ϴ�.");
			return;//early return
		}
		
		//�������� �Է»�Ȳ
		try {
			int empno=Integer.parseInt(data[0]);
			String job=data[1];
			int sal = Integer.parseInt(data[2]);
			double comm=Double.parseDouble(data[3]);
			
			//2.VO�� ���� �־� �ϳ��ǰ�ü�� ��Ƽ� ó��
			CpEmp4UpdateVO updateVO=new CpEmp4UpdateVO(empno, job,sal, comm);
			System.out.println(updateVO);
			
			//3.DAO�� ����
			int cnt=stmtdao.updateCpEmp4(updateVO);
			
			String msg=updateVO.getEmpno()+"�� ����� �������� �ʽ��ϴ�";
			if(cnt==1) {
				msg=updateVO.getEmpno()+"�� ��� ������ ����Ǿ����ϴ�.";
			}
			JOptionPane.showMessageDialog(null, msg);
		}catch(SQLException se) {
			se.printStackTrace();
			
			//�پ��� ���� ��Ȳ,
			int errCode=se.getErrorCode();
			String sqlErrMsg="";
			switch(errCode) {
			case 925: 
				sqlErrMsg="�������� �߸��Ǿ���";break;
			case 1438:
				sqlErrMsg="������ 5�ڸ�, ���ʽ� 5�ڸ������� �����մϴ�.";break;
			case 12899:
				sqlErrMsg="������ ���� 9��, �ѱ�3�ڱ����� �����մϴ�";break;
			}
			JOptionPane.showMessageDialog(null, sqlErrMsg);
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "����,���ʽ��� ���ڿ����մϴ�.");
		}
		
	}//modifyCpEmp4
	
	public void removeCpEmp4() {
		System.out.println("�������");
		int tempData=Integer.parseInt(JOptionPane.showInputDialog("[������ �����ȣ�� �Է����ּ���.]"));

		//�������� �Է»�Ȳ
		try {
			int empno=tempData;
			
			//2.VO�� ���� �־� �ϳ��ǰ�ü�� ��Ƽ� ó��
			//3.DAO�� ����
			int cnt=stmtdao.deleteCpEm4(empno);
			
			String msg=empno+"�� ����� �������� �ʽ��ϴ�";
			if(cnt==1) {
				msg=empno+"�� ����� �����Ǿ����ϴ�.";
			}
			JOptionPane.showMessageDialog(null, msg);
		}catch(SQLException se) {
			se.printStackTrace();
			//�پ��� ���� ��Ȳ,
			int errCode=se.getErrorCode();
			String sqlErrMsg="";
			switch(errCode) {
			case 925: 
				sqlErrMsg="�������� �߸��Ǿ���";break;
			}
			JOptionPane.showMessageDialog(null, sqlErrMsg);
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "�����ȣ�� ���ڿ����մϴ�.");
		}
		
		
	}//removeCpEmp4
	
	public void searchOneCpEmp4() {
		System.out.println("�����ȸ");
		int tempData=Integer.parseInt(JOptionPane.showInputDialog("[��ȸ�� �����ȣ�� �Է����ּ���.]"));

		//�������� �Է»�Ȳ
		try {
			int empno=tempData;
			
			 CpEmp4SelectOneVO selectOneVO=stmtdao.selectCpEmp4(empno);
			 StringBuilder empOutputData= new StringBuilder();
			 empOutputData.append(empno).append("�� ������� ��ȸ ���\n");
			 
			 if(selectOneVO==null) { //�����ȣ�� ��ȸ�� ����� ����
				 empOutputData.append("��ȸ�� ����� �����ϴ�. �����ȣ�� �Է����ּ���");
			 }else {
				 empOutputData.append("�����: ").append(selectOneVO.getEname()).append("\n");
				 empOutputData.append("����: ").append(selectOneVO.getSal()).append("\n");
				 empOutputData.append("���ʽ�: ").append(selectOneVO.getComm()).append("\n");
				 empOutputData.append("����: ").append(selectOneVO.getJob()).append("\n");
			 }
			 JOptionPane.showMessageDialog(null, new JTextArea(empOutputData.toString(), 10,50));
		}catch(SQLException se) {
			JOptionPane.showMessageDialog(null, "��������� ��ȸ�� �� �����ϴ�.");			
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "�����ȣ�� ���� �̾�� �մϴ�.");
		}
		
		
	}//searchOneCpEmp4
	
	public void searchAllCpEmp4() {
		System.out.println("�������ȸ");
		try {
			List<CpEmp4SelectAllVO> empList=stmtdao.selectCpEmp4();
			
			StringBuilder outputData = new StringBuilder();
			outputData.append("��ü �����ȸ \n");
			outputData.append("�����ȣ\t�����\t����\t����\t���ʽ�\t�Ի���\n");
			
			if(empList.isEmpty()) {
				outputData.append("��ȸ�� ��������� �����ϴ�.");
			}
			
			//����Ʈ�� �ݺ����� ��������� ����Ѵ�
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for(CpEmp4SelectAllVO selectAllVO:empList) {
				//��¥ó��
				outputData
				.append(selectAllVO.getEmpno()).append("\t")
				.append(selectAllVO.getEname()).append("\t")
				.append(selectAllVO.getJob()).append("\t")
				.append(selectAllVO.getSal()).append("\t")
				.append(selectAllVO.getComm()).append("\t")
				.append(selectAllVO.getHiredate2()).append("\t")
				.append(sdf.format(selectAllVO.getHiredate())).append("\n");
			}

			int cnt= empList.size();
			outputData.append(cnt).append("���� ��ȸ");
			JTextArea jta= new JTextArea(outputData.toString(),15,60);
			JScrollPane jsp= new JScrollPane(jta);
			jsp.setBorder(new TitledBorder("��ü ��� ���� ��ȸ"));
			JOptionPane.showMessageDialog(null, jsp);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "��ü �����ȸ �� ������ �߻��߽��ϴ�.");
			e.printStackTrace();
			
		}
		
	}//searchAllCpEmp4
	
	public void menu() {
		boolean exitFlag=false;
		
		String inputMenu="";
		try {
			do {
				inputMenu=JOptionPane.showInputDialog("�޴� ���� \n1. ����߰� || 2.������� || 3.��� ���� || 4.�����ȸ || 5.����� ��ȸ || 6.���� \n��ȣ�� �Է����ּ���. ");
				
				switch(inputMenu) {
				case ADD: addCpEmp4(); break;
				case MODIFY: modifyCpEmp4(); break;
				case REMOVE: removeCpEmp4(); break;
				case SEARCH_ONE: searchOneCpEmp4(); break;
				case SEARCH_ALL: searchAllCpEmp4(); break;
				case EXIT: exitFlag=true;break;
				}
			}while(!exitFlag);
		}catch(NullPointerException npe) {
			//����ڰ� ��Ҹ� �����ų� x�� �Է��Ѱ��
		}finally{
			JOptionPane.showMessageDialog(null,"���α׷��� ����Ǿ����ϴ�.");
		}
	}
	public static void main(String[] args) {
		new UseStatementService().menu();
	}

}
