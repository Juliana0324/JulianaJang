package kr.co.sist.prepared.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import kr.co.sist.prepared.dao.PreparedStatementDAO;
import kr.co.sist.prepared.vo.CpEmp4VO;
import kr.co.sist.statement.dao.StatementDAO;
import kr.co.sist.statement.vo.CpEmp4InsertVO;
import kr.co.sist.statement.vo.CpEmp4SelectAllVO;
import kr.co.sist.statement.vo.CpEmp4SelectOneVO;
import kr.co.sist.statement.vo.CpEmp4UpdateVO;

/**
 * ���������� ó���ϸ鼭 �ʿ信���� DB�۾��� ����ϴ� Ŭ����.<br>
 *  XxxService Ŭ������ method���� ������ ���� �ۼ��Ѵ�.
 *  ( ���� ������ method������ ���������ʴ´�.)
 * @author user
 */
public class UsePreparedStatementDAOService {
	
	public static final String ADD="1";
	public static final String MODIFY="2";
	public static final String REMOVE="3";
	public static final String SEARCH_ONE="4";
	public static final String SEARCH_ALL="5";
	public static final String EXIT="6";

	private PreparedStatementDAO psDAO;
	public UsePreparedStatementDAOService() {
		psDAO=new PreparedStatementDAO();
	}//UseStatementDAOService
	
	public void addCpEmp4() {
		String tempData=JOptionPane.showInputDialog
				("�߰��� ������� \",\"�� �����Է�\n�����,����,����,���ʽ�");
		String[] data=tempData.split(",");
		
		if( data.length != 4) { //���������� �Է»�Ȳ
			JOptionPane.showMessageDialog(null, "�Էµ������� ������ ���� �ʽ��ϴ�.");
			return; //early return;
		}//end if
		
		// �� if�� ���ǿ� ���� ���� �� ��Ȳ�ڵ�( else ������ �ڵ� )
		//�������� �Է»�Ȳ
		//1.���� ���� ����. ���ڿ�=> ��ȯ
		try {
			//���ҵ� ����
			String ename=data[0];
			String job=data[1];
			int sal=Integer.parseInt( data[2] );
			double comm=Double.parseDouble( data[3] );
			
			CpEmp4VO ceVO=new CpEmp4VO();
			ceVO.setEname(ename);
			ceVO.setJob(job);
			ceVO.setSal(sal);
			ceVO.setComm(comm);
			psDAO.insertCpEmp4(ceVO);

			JOptionPane.showMessageDialog(null, ceVO.getEname()+"��������� �߰��Ͽ����ϴ�.");
		}catch(SQLException se) {
			JOptionPane.showMessageDialog(null, "����߰��۾��� ������ �߻��Ͽ����ϴ�.");
			se.printStackTrace();
			//�پ��� ���ܻ�Ȳó��,
			int errCode=se.getErrorCode();
			String sqlErrMsg="";
			switch( errCode) {
			case 1 : //ORA-00001
				sqlErrMsg="���� ��� ��ȣ�� �̹� �����մϴ�.";	break;
			case 925 : //ORA-00925
				sqlErrMsg="�������� �߸� �Ǿ����ϴ�";	break;
			case 1438: //ORA-01438 - ���ڰ��� ������ ũ�⺸�� ū ���.
				sqlErrMsg="�����ȣ�� ���� 4�ڸ�����, ���� 5�ڸ�, ���ʽ� 5�ڸ� �Դϴ�.";break;
			case 12899: //ORA-12899 -���ڿ����� ������ ũ�⺸�� ū ���.
				sqlErrMsg="������� ����10�� �ѱ� 3���̳� �̾���ϰ�,\n������ ����9�� �ѱ� 3�� �̳�����մϴ�.";
			}//end switch
			
			JOptionPane.showMessageDialog(null, sqlErrMsg);
			
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "�����ȣ,����,���ʽ��� �����̾���մϴ�.");
		}//end catch
		
	}//addCpEmp4
	
	public void modifyCpEmp4() {
		String tempData=JOptionPane.showInputDialog
				("������ ������� \",\"�� �����Է�\n�����ȣ,����,����,���ʽ�\n�����ȣ�� ��ġ�ϴ� ����� ����,����,���ʽ��� �����մϴ�.");
		String[] data=tempData.split(",");
		
		if( data.length != 4) { //���������� �Է»�Ȳ
			JOptionPane.showMessageDialog(null, "�Էµ������� ������ ���� �ʽ��ϴ�. �Է°��� 4�� �̾���մϴ�.");
			return; //early return;
		}//end if
		
		//�������� �Է»�Ȳ
		try {
		//1. �������� ����
		int empno=Integer.parseInt(data[0]);
		String job=data[1];
		int sal=Integer.parseInt( data[2] );
		double comm=Double.parseDouble( data[3] );
	
		
		
//		String msg=ceuVO.getEmpno()+"�� ����� �������� �ʽ��ϴ�.";
//		if( cnt == 1 ) {
//			msg=ceuVO.getEmpno()+"�� ��������� ����Ǿ����ϴ�.";
//		}//end if
//		
//		JOptionPane.showMessageDialog(null, msg);
//		
//		}catch(SQLException se) {
//			se.printStackTrace();
//			//�پ��� ���ܻ�Ȳó��,
//			int errCode=se.getErrorCode();
//			String sqlErrMsg="";
//			switch( errCode) {
//			case 925 : //ORA-00925
//				sqlErrMsg="�������� �߸� �Ǿ����ϴ�";	break;
//			case 1438: //ORA-01438 - ���ڰ��� ������ ũ�⺸�� ū ���.
//				sqlErrMsg="���� 5�ڸ�, ���ʽ� 5�ڸ� �Դϴ�.";break;
//			case 12899: //ORA-12899 -���ڿ����� ������ ũ�⺸�� ū ���.
//				sqlErrMsg="������ ����9�� �ѱ� 3�� �̳�����մϴ�.";
//			}//end switch
//			
//			JOptionPane.showMessageDialog(null, sqlErrMsg);
//			
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "�����ȣ,����,���ʽ��� �����̾���մϴ�.");
		}//end catch
		
	}//modifyCpEmp4
	
	public void removeCpEmp4() {
		String tempData=JOptionPane.showInputDialog(" ������ �����ȣ �Է����ּ���.");
		
		try {
			//�Է°� ó��
			int empno=Integer.parseInt( tempData );
			//DB�۾� ����
			
//			String msg=empno+"�� ����� �������� �ʽ��ϴ�.";
//			if( cnt == 1 ) {
//				msg=empno+"�� ��������� �����Ǿ����ϴ�.";
//			}//end if
//			
//			JOptionPane.showMessageDialog(null, msg);
//			
//		}catch(SQLException se) {
//			se.printStackTrace();
//			
//			//�پ��� ���ܻ�Ȳó��,
//			int errCode=se.getErrorCode();
//			String sqlErrMsg="";
//			
//			switch( errCode) {
//			case 925 : //ORA-00925
//				sqlErrMsg="�������� �߸� �Ǿ����ϴ�";	break;
//			}//end switch
//			
//			JOptionPane.showMessageDialog(null, sqlErrMsg);
//			
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "�����ȣ�� ���ڷθ� �����˴ϴ�.");
		}
		
	}//removeCpEmp4
	
	public void searchOneCpEmp4() {
		String tempData=JOptionPane.showInputDialog(" ��ȸ�� �����ȣ �Է����ּ���.");
		
		try {
			//�Է°� ó��
			int empno=Integer.parseInt( tempData );
			//DB�۾�
		 
//		 StringBuilder empOutputData=new StringBuilder();
//		 empOutputData.append(empno).append("�� ������� ��ȸ ���\n");
//		 
//		 if( cesoVO == null) {//�����ȣ�� ��ȸ�� ����� ����.
//			empOutputData.append("��ȸ�� ����� �����ϴ�. �����ȣ�� Ȯ�����ּ���.");
//		 }else{
//			 empOutputData.append("����� : ").append( cesoVO.getEname()).append("\n");
//			 empOutputData.append("���� : ").append( cesoVO.getSal()).append("\n");
//			 empOutputData.append("���ʽ� : ").append( cesoVO.getComm()).append("\n");
//			 empOutputData.append("���� : ").append( cesoVO.getJob());
//		 }//end else
//		 
//		 JOptionPane.showMessageDialog(null,
//				 new JTextArea(empOutputData.toString(),10,50));
//			
//		}catch(SQLException se) {
//			JOptionPane.showMessageDialog(null, "��������� ��ȸ�� �� �����ϴ�.");
//			se.printStackTrace();
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "�����ȣ�� �����̾���մϴ�.");
		}//end catch
		
	}//searchOneCpEmp4
	
	public void searchAllCpEmp4() {
//		try {
		//��� ���ڵ带 ��ȸ�Ѵ�. 
			
		StringBuilder outputData=new StringBuilder();
		outputData.append("��ü��� ��ȸ\n");
		outputData.append("�����ȣ\t�����\t����\t����\t���ʽ�\t�Ի���\n");
		
		//��ȸ�� ����� ���� �� ������ ����
//		if( empList.isEmpty() ) {
//			outputData.append("��ȸ�� ��������� �����ϴ�.");
//		}//end if
//		
//		//����Ʈ�� �ݺ����� ��� ������ ����Ѵ�. 
//		//��¥ó��
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		for(CpEmp4SelectAllVO cesaVO : empList) {
//			outputData
//			.append(cesaVO.getEmpno()).append("\t")
//			.append(cesaVO.getEname()).append("\t")
//			.append(cesaVO.getJob()).append("\t")
//			.append(cesaVO.getSal()).append("\t")
//			.append(cesaVO.getComm()).append("\t")
//			.append(cesaVO.getHiredate2()).append("\t")
//			.append(sdf.format(cesaVO.getHiredate())).append("\n");
//		}//end for
//		outputData.append(empList.size()).append("�� ��ȸ");
//		
//		JTextArea jta=new JTextArea(outputData.toString(),15,60);
//		JScrollPane jsp=new JScrollPane(jta);
//		jsp.setBorder( new TitledBorder("��ü��� ���� ��ȸ") );
//		
//		JOptionPane.showMessageDialog(null, jsp);
//		
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "��ü ��� ��ȸ �� ���� �߻�.");
//			e.printStackTrace();
//		}//end catch
		
	}//searchAllCpEmp4
	
	public void menu() {
		
		boolean exitFlag=false;
		String inputMenu="";
		
		try {
			do {
				inputMenu=JOptionPane.showInputDialog("�޴�����\n1.����߰� 2.������� 3. ������� 4. �����ȸ 5.�������ȸ 6.����\n��ȣ�� �Է��ϼ���.");
				
				switch( inputMenu ) {
					case ADD : addCpEmp4(); break; 
					case MODIFY : modifyCpEmp4(); break; 
					case REMOVE : removeCpEmp4(); break; 
					case SEARCH_ONE : searchOneCpEmp4(); break; 
					case SEARCH_ALL : searchAllCpEmp4(); break; 
					case EXIT : exitFlag=true; break; 
				}//end switch
				
			}while( !exitFlag );
		}catch(NullPointerException npe) {
			//����ڰ� ��ҳ�, x�� ���� ���
		} finally {
			JOptionPane.showMessageDialog(null, "���α׷��� ����Ǿ����ϴ�.");
		}//catch
		
	}//menu
	
	public static void main(String[] args) {
		new UsePreparedStatementDAOService().menu();
	}//main

}//class
