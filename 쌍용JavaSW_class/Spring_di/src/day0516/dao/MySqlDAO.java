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
public class MySqlDAO implements DAO{

	@Override
	public void insert(String name) throws SQLException {
		System.out.println("INSERT INTO MySql_TAB(name) values('"+name+"')");
		
	}

	@Override
	public List<String> select() throws SQLException {
		List<String> list = new ArrayList<String>();
		
		list.add("MySql DBMS�� SELECT�Դϴ�. ");
		list.add("�迹��");
		list.add("�ڼ���");
		list.add("������");
		list.add("������");

		return list;
	}
	
	
}
