package day0516.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DB DAO
 * ������� �Ǳ� ���ؼ� DAO�������̽� ����
 * @author user
 *
 */
public class OracleDAO implements DAO{

	@Override
	public void insert(String name) throws SQLException {
		System.out.println("INSERT INTO ORACLE_TAB(name) values('"+name+"')");
		
	}

	@Override
	public List<String> select() throws SQLException {
		List<String> list = new ArrayList<String>();
		
		list.add("ORACLE DBMS�� SELECT�Դϴ�. ");
		list.add("������");
		list.add("Ȳ����");
		list.add("����");

		return list;
	}
	
	
}
