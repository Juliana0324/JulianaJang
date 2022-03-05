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
 * 업무 로직을 처리하면서 필요에 따라 DB작업을 사용하는 클래스
 * XXXService 클래스의 method명은 업무의 용어로 작성한다.
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
		String tempData=JOptionPane.showInputDialog("[추가할 사원정보를 \",\"로 구분입력\n사원번호, 사원명, 직무, 연봉,보너스");
		String[] data=tempData.split(",");
		if(data.length!=5) {
			JOptionPane.showMessageDialog(null, "데이터의 갯수가 맞지않습니다.");
			return;//early return
		}

		//1. 값 제공
	try {
		int empno=Integer.parseInt(data[0]);
		String ename=data[1];
		String job=data[2];
		int sal = Integer.parseInt(data[3]);
		double comm=Double.parseDouble(data[4]);
		
		//2.VO에 값을 넣어 하나의객체에 모아서 처리
		CpEmp4InsertVO insertVO=new CpEmp4InsertVO(empno, sal, ename, job, comm);
		System.out.println(insertVO);
		
		//3.DAO값 전달
		stmtdao.insertCpEmp4(insertVO);
		JOptionPane.showMessageDialog(null, insertVO.getEmpno()+"사원 정보를 추가하였습니다.");
	}catch(SQLException se) {
		JOptionPane.showMessageDialog(null, "사원추가 작업의 문제발생");		
		se.printStackTrace();
		
		//다양한 예외 상황,
		int errCode=se.getErrorCode();
		String sqlErrMsg="";
		switch(errCode) {
		case 925: 
			sqlErrMsg="쿼리문이 잘못되었음";break;
		case 1:
			sqlErrMsg="같은 사원 번호가 이미 존재합니다.";break;
		case 1438:
			sqlErrMsg="사원번호는 4자리, 연봉은 5자리, 보너스 5자리까지만 가능합니다.";break;
		case 12899:
			sqlErrMsg="사원명은 영문 10자, 한글3자리까지만 가능합니다. \n직무는 영어 9자, 한글3자까지만 가능합니다";break;
		}
		JOptionPane.showMessageDialog(null, sqlErrMsg);
	}catch(NumberFormatException nf) {
		JOptionPane.showMessageDialog(null, "사원, 연봉,보너스는 숫자여야합니다.");
	}
	}//addCpEmp4
	
	public void modifyCpEmp4() {
		System.out.println("사원변경");
		String tempData=JOptionPane.showInputDialog("[수정할 사원정보를 \",\"로 구분입력\n사원번호, 직무, 연봉,보너스를 수정합니다.");
		String[] data=tempData.split(",");
		if(data.length!=4) {
			JOptionPane.showMessageDialog(null, "데이터의 갯수가 맞지않습니다.");
			return;//early return
		}
		
		//정상적인 입력상황
		try {
			int empno=Integer.parseInt(data[0]);
			String job=data[1];
			int sal = Integer.parseInt(data[2]);
			double comm=Double.parseDouble(data[3]);
			
			//2.VO에 값을 넣어 하나의객체에 모아서 처리
			CpEmp4UpdateVO updateVO=new CpEmp4UpdateVO(empno, job,sal, comm);
			System.out.println(updateVO);
			
			//3.DAO값 전달
			int cnt=stmtdao.updateCpEmp4(updateVO);
			
			String msg=updateVO.getEmpno()+"번 사원은 존재하지 않습니다";
			if(cnt==1) {
				msg=updateVO.getEmpno()+"번 사원 정보가 변경되었습니다.";
			}
			JOptionPane.showMessageDialog(null, msg);
		}catch(SQLException se) {
			se.printStackTrace();
			
			//다양한 예외 상황,
			int errCode=se.getErrorCode();
			String sqlErrMsg="";
			switch(errCode) {
			case 925: 
				sqlErrMsg="쿼리문이 잘못되었음";break;
			case 1438:
				sqlErrMsg="연봉은 5자리, 보너스 5자리까지만 가능합니다.";break;
			case 12899:
				sqlErrMsg="직무는 영어 9자, 한글3자까지만 가능합니다";break;
			}
			JOptionPane.showMessageDialog(null, sqlErrMsg);
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "연봉,보너스는 숫자여야합니다.");
		}
		
	}//modifyCpEmp4
	
	public void removeCpEmp4() {
		System.out.println("사원제거");
		int tempData=Integer.parseInt(JOptionPane.showInputDialog("[삭제할 사원번호를 입력해주세요.]"));

		//정상적인 입력상황
		try {
			int empno=tempData;
			
			//2.VO에 값을 넣어 하나의객체에 모아서 처리
			//3.DAO값 전달
			int cnt=stmtdao.deleteCpEm4(empno);
			
			String msg=empno+"번 사원은 존재하지 않습니다";
			if(cnt==1) {
				msg=empno+"번 사원이 삭제되었습니다.";
			}
			JOptionPane.showMessageDialog(null, msg);
		}catch(SQLException se) {
			se.printStackTrace();
			//다양한 예외 상황,
			int errCode=se.getErrorCode();
			String sqlErrMsg="";
			switch(errCode) {
			case 925: 
				sqlErrMsg="쿼리문이 잘못되었음";break;
			}
			JOptionPane.showMessageDialog(null, sqlErrMsg);
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원번호는 숫자여야합니다.");
		}
		
		
	}//removeCpEmp4
	
	public void searchOneCpEmp4() {
		System.out.println("사원조회");
		int tempData=Integer.parseInt(JOptionPane.showInputDialog("[조회할 사원번호를 입력해주세요.]"));

		//정상적인 입력상황
		try {
			int empno=tempData;
			
			 CpEmp4SelectOneVO selectOneVO=stmtdao.selectCpEmp4(empno);
			 StringBuilder empOutputData= new StringBuilder();
			 empOutputData.append(empno).append("번 사원정보 조회 결과\n");
			 
			 if(selectOneVO==null) { //사원번호로 조회한 결과가 없음
				 empOutputData.append("조회된 사원이 없습니다. 사원번호를 입력해주세요");
			 }else {
				 empOutputData.append("사원명: ").append(selectOneVO.getEname()).append("\n");
				 empOutputData.append("연봉: ").append(selectOneVO.getSal()).append("\n");
				 empOutputData.append("보너스: ").append(selectOneVO.getComm()).append("\n");
				 empOutputData.append("직무: ").append(selectOneVO.getJob()).append("\n");
			 }
			 JOptionPane.showMessageDialog(null, new JTextArea(empOutputData.toString(), 10,50));
		}catch(SQLException se) {
			JOptionPane.showMessageDialog(null, "사원정보를 조회할 수 없습니다.");			
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원번호는 숫자 이어야 합니다.");
		}
		
		
	}//searchOneCpEmp4
	
	public void searchAllCpEmp4() {
		System.out.println("모든사원조회");
		try {
			List<CpEmp4SelectAllVO> empList=stmtdao.selectCpEmp4();
			
			StringBuilder outputData = new StringBuilder();
			outputData.append("전체 사원조회 \n");
			outputData.append("사원번호\t사원명\t직무\t연봉\t보너스\t입사일\n");
			
			if(empList.isEmpty()) {
				outputData.append("조회된 사원정보가 없습니다.");
			}
			
			//리스트를 반복시켜 모든정보를 출력한다
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for(CpEmp4SelectAllVO selectAllVO:empList) {
				//날짜처리
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
			outputData.append(cnt).append("건이 조회");
			JTextArea jta= new JTextArea(outputData.toString(),15,60);
			JScrollPane jsp= new JScrollPane(jta);
			jsp.setBorder(new TitledBorder("전체 사원 정보 조회"));
			JOptionPane.showMessageDialog(null, jsp);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "전체 사원조회 중 문제가 발생했습니다.");
			e.printStackTrace();
			
		}
		
	}//searchAllCpEmp4
	
	public void menu() {
		boolean exitFlag=false;
		
		String inputMenu="";
		try {
			do {
				inputMenu=JOptionPane.showInputDialog("메뉴 선택 \n1. 사원추가 || 2.사원변경 || 3.사원 제거 || 4.사원조회 || 5.모든사원 조회 || 6.종료 \n번호를 입력해주세요. ");
				
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
			//사용자가 취소를 눌렀거너 x를 입력한경우
		}finally{
			JOptionPane.showMessageDialog(null,"프로그램이 종료되었습니다.");
		}
	}
	public static void main(String[] args) {
		new UseStatementService().menu();
	}

}
