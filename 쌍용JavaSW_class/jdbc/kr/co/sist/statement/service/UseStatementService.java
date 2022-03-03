package kr.co.sist.statement.service;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.statement.dao.StatementDAO;
import kr.co.sist.statement.vo.CpEmp4InsertVO;
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
	}//searchOneCpEmp4
	
	public void searchAllCpEmp4() {
		System.out.println("�������ȸ");
		try {
			stmtdao.selectCpEmp4();
		} catch (SQLException e) {
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
