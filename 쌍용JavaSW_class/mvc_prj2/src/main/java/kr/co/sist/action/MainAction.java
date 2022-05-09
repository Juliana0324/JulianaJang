package kr.co.sist.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.service.DeptService;
import kr.co.sist.service.EmpService;
import kr.co.sist.vo.DeptVO;
import kr.co.sist.vo.EmpVO;

/**
 * 파라메터 처리, 파라미터 유효성 검증, 관계유지객체의 사용, service 객체 사용
 * 처리 결과를 scope 객체에 할당, View페이지명 설정, 이동 방식 설정
 * 
 * 모든 사원정보와 부서정보를 조회하여 scope 객체 할당
 * 
 * @author user
 * 
 */
public class MainAction implements Action {

	private String url;
	private boolean forwardFlag;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//업무로직의 처리
		DeptService ds = new DeptService();
		EmpService es = new EmpService();
		
		List<DeptVO> listDept=ds.searchDept();
		List<EmpVO> listEmp=es.searchEmp(0);
		
		
		//이동할 URL설정
		if(listDept==null || listEmp==null) {
			url="http://localhost/mvc_prj2/err/error_page.jsp";
			forwardFlag = false; //redirect
			return;
		}
		
		//view 페이지에서 값을 사용할 수 있도록 scope객체에 설정.
		request.setAttribute("deptData", listDept);
		request.setAttribute("empData", listEmp);
		
		//성공했을때 페이지 설정(forward로 이동)
		url="/day0509/main_page.jsp";
		forwardFlag = true; //forward
		
		
	}

	@Override
	public String moveURL() {
		// TODO Auto-generated method stub
		return url;
	}

	@Override
	public boolean forwardFlag() {
		// TODO Auto-generated method stub
		return forwardFlag;
	}

}
