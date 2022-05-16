package day0516.assembly;

import day0516.dao.DAO;
import day0516.dao.MySqlDAO;
import day0516.dao.OracleDAO;
import day0516.service.Service;
import day0516.service.ServiceImpl;

/**
 * Service와 DAO의 관계를 설정하는일
 * @author user
 *
 */
public class Assembly {
	public Service getBean() {
		//1. 의존성 주입할 클래스 생성
		//DAO dao= new OracleDAO();
		DAO dao= new OracleDAO();
		
		//2. 의존성 주입받을 클래스를 생성하고, 의존성 주입 수행
		Service service = new ServiceImpl(dao);
		
		//3. 의존성 주입받은 클래스 반환
		return service;
	}
}
