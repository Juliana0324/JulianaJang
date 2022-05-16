package day0516.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DB DAO
 * 약결합이 되기 위해서 DAO인터페이스 구현
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
		
		list.add("ORACLE DBMS의 SELECT입니다. ");
		list.add("강현모");
		list.add("황성준");
		list.add("강산");

		return list;
	}
	
	
}
