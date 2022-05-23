package kr.co.sist.service.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.mybatis.ExamDao;

@Component
public class ExamService {
	//required 
	//@Autowired 애노테이션을 처리하던 중 해당하는 빈의 타입을 못찾거나 의존성 주입을 할 수 없는 경우에는 
	//에러가 발생하며 어플리케이션 구동이 제대로 되지 않는다.
	
	@Autowired(required = false)
	private ExamDao eDAO;
	
	public String scsr(int deptno) {
		String dname="";
		dname = eDAO.scsr(deptno);

		return dname;
	}
	
}
