package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.dao.DiDAO;

/**
 * DAO의존성 주입 받기
 * @author user
 *
 */
public class DiService {
	private DiDAO dao;
	
	public DiService(DiDAO dao) {
		this.dao = dao;
		System.out.println("DiService Dao: "+dao);
	}
	
	public List<String> searchData(){
		List<String> list = null;
		try {
			list = dao.getList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		
		return list;
	}
	
}
