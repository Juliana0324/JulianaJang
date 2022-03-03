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
			JOptionPane.showMessageDialog(null, "�̸��߰� �۾��� �����߻�");
			se.printStackTrace();
			
			int errCode=se.getErrorCode();
			String sqlErrMsg="";
			switch(errCode) {
			case 925: 
				sqlErrMsg="�������� �߸��Ǿ���";break;
			case 12899:
				sqlErrMsg="�̸��� ���� 10��, �ѱ�3�ڸ������� �����մϴ�.";break;
			}
			JOptionPane.showMessageDialog(null, sqlErrMsg);
		}
	}
}
