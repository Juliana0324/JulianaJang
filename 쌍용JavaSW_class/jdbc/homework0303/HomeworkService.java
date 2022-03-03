package homework0303;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class HomeworkService {
	
	private HomeworkDAO dao;
	
	public HomeworkService() {
		dao=new HomeworkDAO();
	}
	
	public void addNames(String name) {
		try {
			String inputName= name;
			dao.insertName(inputName);
			
		}catch(SQLException se) {
			JOptionPane.showMessageDialog(null, "이름추가 작업의 문제발생");
			se.printStackTrace();
			
			int errCode=se.getErrorCode();
			String sqlErrMsg="";
			switch(errCode) {
			case 925: 
				sqlErrMsg="쿼리문이 잘못되었음";break;
			case 12899:
				sqlErrMsg="이름은 영문 10자, 한글3자리까지만 가능합니다.";break;
			}
			JOptionPane.showMessageDialog(null, sqlErrMsg);
		}
	}
}
