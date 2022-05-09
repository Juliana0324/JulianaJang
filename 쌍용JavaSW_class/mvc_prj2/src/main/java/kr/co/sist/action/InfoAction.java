package kr.co.sist.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.service.EmpService;
import kr.co.sist.vo.EmpVO;

/**
 * @author user
 * EMP목록을 scope에 담는일
 *
 */
public class InfoAction implements Action {
	
	private String url;
	private boolean forwardFlag;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//부서번호 받기
		String paramDeptno=request.getParameter("deptno");

		try {
			int deptno=Integer.parseInt(paramDeptno);			
			//입력된 부서번호를 사용하여 부서에 해당하는 사원 정보 조회
			EmpService es = new EmpService();
			
			List<EmpVO> listEmp= es.searchEmp(deptno);
			request.setAttribute("empData", listEmp);
			
			//조회된 결과가 있으면
			//성공했을때 페이지 설정(forward로 이동)
			url="day0509/search_emp.jsp";
			forwardFlag = true; //forward
			
		}catch (NumberFormatException ne) {
			ne.printStackTrace();
			url="http://localhost/mvc_prj2/err/error_page.jsp";
			forwardFlag = false; //redirect
			return;
		}
		
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
