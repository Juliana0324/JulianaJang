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
 * 업무로직을 처리하면서 필요에따라 DB작업을 사용하는 클래스.<br>
 *  XxxService 클래스의 method명은 업무의 용어로 작성한다.
 *  ( 절대 쿼리를 method명으로 설정하지않는다.)
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
				("추가할 사원정보 \",\"로 구분입력\n사원명,직무,연봉,보너스");
		String[] data=tempData.split(",");
		
		if( data.length != 4) { //비정상적인 입력상황
			JOptionPane.showMessageDialog(null, "입력데이터의 갯수가 맞지 않습니다.");
			return; //early return;
		}//end if
		
		// 위 if의 조건에 맞지 않을 때 상황코드( else 에대한 코드 )
		//정상적인 입력상황
		//1.값에 대한 가공. 문자열=> 변환
		try {
			//분할된 값을
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

			JOptionPane.showMessageDialog(null, ceVO.getEname()+"사원정보를 추가하였습니다.");
		}catch(SQLException se) {
			JOptionPane.showMessageDialog(null, "사원추가작업에 문제가 발생하였습니다.");
			se.printStackTrace();
			//다양한 예외상황처리,
			int errCode=se.getErrorCode();
			String sqlErrMsg="";
			switch( errCode) {
			case 1 : //ORA-00001
				sqlErrMsg="같은 사원 번호가 이미 존재합니다.";	break;
			case 925 : //ORA-00925
				sqlErrMsg="쿼리문이 잘못 되었습니다";	break;
			case 1438: //ORA-01438 - 숫자값이 정해진 크기보다 큰 경우.
				sqlErrMsg="사원번호는 숫자 4자리까지, 연봉 5자리, 보너스 5자리 입니다.";break;
			case 12899: //ORA-12899 -문자열값이 정해진 크기보다 큰 경우.
				sqlErrMsg="사원명은 영어10자 한글 3자이내 이어야하고,\n직무는 영어9자 한글 3자 이내어야합니다.";
			}//end switch
			
			JOptionPane.showMessageDialog(null, sqlErrMsg);
			
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원번호,연봉,보너스는 숫자이어야합니다.");
		}//end catch
		
	}//addCpEmp4
	
	public void modifyCpEmp4() {
		String tempData=JOptionPane.showInputDialog
				("수정할 사원정보 \",\"로 구분입력\n사원번호,직무,연봉,보너스\n사원번호에 일치하는 사원의 직무,연봉,보너스를 변경합니다.");
		String[] data=tempData.split(",");
		
		if( data.length != 4) { //비정상적인 입력상황
			JOptionPane.showMessageDialog(null, "입력데이터의 갯수가 맞지 않습니다. 입력값은 4개 이어야합니다.");
			return; //early return;
		}//end if
		
		//정상적인 입력상황
		try {
		//1. 데이터의 가공
		int empno=Integer.parseInt(data[0]);
		String job=data[1];
		int sal=Integer.parseInt( data[2] );
		double comm=Double.parseDouble( data[3] );
			
		//데이터 VO에 저장하기
		CpEmp4VO ceVO= new CpEmp4VO();
		ceVO.setEmpno(empno);
		ceVO.setJob(job);
		ceVO.setSal(sal);
		ceVO.setComm(comm);
		
		//3.DB작업 후 결과 얻기
		int cnt=psDAO.updateCpEmp4(ceVO);//업데이트 작업 후 변경된 행의 갯수
		
		String msg=empno+"번 사원은 존재하지 않습니다.";
		if( cnt == 1 ) {
			msg=empno+"번 사원정보가 변경되었습니다.";
		}//end if
		
		JOptionPane.showMessageDialog(null, msg);
		
		}catch(SQLException se) {
			se.printStackTrace();
			//다양한 예외상황처리,
			int errCode=se.getErrorCode();
			String sqlErrMsg="";
			switch( errCode) {
			case 925 : //ORA-00925
				sqlErrMsg="쿼리문이 잘못 되었습니다";	break;
			case 1438: //ORA-01438 - 숫자값이 정해진 크기보다 큰 경우.
				sqlErrMsg="연봉 5자리, 보너스 5자리 입니다.";break;
			case 12899: //ORA-12899 -문자열값이 정해진 크기보다 큰 경우.
				sqlErrMsg="직무는 영어9자 한글 3자 이내어야합니다.";
			}//end switch
			
			JOptionPane.showMessageDialog(null, sqlErrMsg);
			
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원번호,연봉,보너스는 숫자이어야합니다.");
		}//end catch
		
	}//modifyCpEmp4
	
	public void removeCpEmp4() {
		String tempData=JOptionPane.showInputDialog(" 삭제할 사원번호 입력해주세요.");
		
		try {
			//입력값 처리
			int empno=Integer.parseInt( tempData );
			String msg=empno+"번 사원은 존재하지 않습니다.";

			//DB작업 수행			
			int cnt=psDAO.deleteCpEmp4(empno);
			
			if( cnt == 1 ) {
				msg=empno+"번 사원정보가 삭제되었습니다.";
			}//end if
			
			JOptionPane.showMessageDialog(null, msg);
			
		}catch(SQLException se) {
			se.printStackTrace();
			
			//다양한 예외상황처리,
			int errCode=se.getErrorCode();
			String sqlErrMsg="";
			
			switch( errCode) {
			case 925 : //ORA-00925
				sqlErrMsg="쿼리문이 잘못 되었습니다";	break;
			}//end switch
			
			JOptionPane.showMessageDialog(null, sqlErrMsg);
			
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원번호는 숫자로만 구성됩니다.");
		}
		
	}//removeCpEmp4
	
	public void searchOneCpEmp4() {
		String tempData=JOptionPane.showInputDialog(" 조회할 사원번호 입력해주세요.");
		
		try {
			//입력값 처리
			int empno=Integer.parseInt( tempData );
			//DB작업
		 
		 CpEmp4VO ceVO=psDAO.selectOneCpEmp4(empno); //사원번호에 대한 사원하나 조회
		 StringBuilder empOutputData=new StringBuilder();
		 empOutputData.append(empno).append("번 사원정보 조회 결과\n");
		 
		 if(ceVO == null) {//사원번호로 조회한 결과가 없음.
			empOutputData.append("조회된 사원이 없습니다. 사원번호를 확인해주세요.");
		 }else{
			 empOutputData.append("사원명 : ").append( ceVO.getEname()).append("\n");
			 empOutputData.append("연봉 : ").append( ceVO.getSal()).append("\n");
			 empOutputData.append("보너스 : ").append( ceVO.getComm()).append("\n");
			 empOutputData.append("직무 : ").append( ceVO.getJob());
		 }//end else
		 
		 JOptionPane.showMessageDialog(null,
				 new JTextArea(empOutputData.toString(),10,50));
		}catch(SQLException se) {
			JOptionPane.showMessageDialog(null, "사원정보를 조회할 수 없습니다.");
			se.printStackTrace();
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원번호는 숫자이어야합니다.");
		}//end catch
		
	}//searchOneCpEmp4
	
	public void searchAllCpEmp4() {
		try {
		//모든 레코드를 조회한다. 
			List<CpEmp4VO> empList= psDAO.selectAllCpEmp4();
			
		StringBuilder outputData=new StringBuilder();
		outputData.append("전체사원 조회\n");
		outputData.append("사원번호\t사원명\t직무\t연봉\t보너스\t입사일\n");
		
		//조회된 결과가 없을 때 보여줄 내용
		if( empList.isEmpty() ) {
			outputData.append("조회된 사원정보가 없습니다.");
		}//end if
		
//		//리스트를 반복시켜 모든 정보를 출력한다. 
//		//날짜처리
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		for(CpEmp4VO ceVO : empList) {
			outputData
			.append(ceVO.getEmpno()).append("\t")
			.append(ceVO.getEname()).append("\t")
			.append(ceVO.getJob()).append("\t")
			.append(ceVO.getSal()).append("\t")
			.append(ceVO.getComm()).append("\t")
			.append(sdf.format(ceVO.getHiredate())).append("\n");
		}//end for
		outputData.append(empList.size()).append("명 조회");
		
		JTextArea jta=new JTextArea(outputData.toString(),15,60);
		JScrollPane jsp=new JScrollPane(jta);
		jsp.setBorder( new TitledBorder("전체사원 정보 조회") );
		
		JOptionPane.showMessageDialog(null, jsp);
		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "전체 사원 조회 중 문제 발생.");
			e.printStackTrace();
		}//end catch
		
	}//searchAllCpEmp4
	
	public void menu() {
		
		boolean exitFlag=false;
		String inputMenu="";
		
		try {
			do {
				inputMenu=JOptionPane.showInputDialog("메뉴선택\n1.사원추가 2.사원변경 3. 사원삭제 4. 사원조회 5.모든사원조회 6.종료\n번호를 입력하세요.");
				
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
			//사용자가 취소나, x를 누른 경우
		} finally {
			JOptionPane.showMessageDialog(null, "프로그램이 종료되었습니다.");
		}//catch
		
	}//menu
	
	public static void main(String[] args) {
		new UsePreparedStatementDAOService().menu();
	}//main

}//class
