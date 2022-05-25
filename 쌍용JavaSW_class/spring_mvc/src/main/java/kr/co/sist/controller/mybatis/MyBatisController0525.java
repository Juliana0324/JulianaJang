package kr.co.sist.controller.mybatis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.service.mybatis.ExamService0524;
import kr.co.sist.service.mybatis.ExamService0525;
import kr.co.sist.vo.BoardVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
@Controller
public class MyBatisController0525 {

	@Autowired(required=false)
	private ExamService0525 es;
	

	@RequestMapping(value="/mybatis/day0525/gtFrmProcess.do", method= {GET,POST})
	public String lessThan(Model model, @RequestParam(defaultValue = "-1")int sal) {
		if(sal != -1) {
			model.addAttribute("empList", es.greaterThan(sal));
		}
		
		return "mybatis/day0525/gtFrmProcess";
	}

	@RequestMapping(value="/mybatis/day0525/likeFrmProcess.do", method= {GET,POST})
	public String like(Model model, String option) {
		model.addAttribute("carList", es.like(option));
		
		return "mybatis/day0525/likeFrmProcess";
	}

	@RequestMapping(value="/mybatis/day0525/subquery.do", method= {GET,POST})
	public String subquery(Model model, @RequestParam(defaultValue = "1") int currentPage) {
		//1. ��ü ���ڵ�� 
		int totalCnt = es.searchTotalCnt();
		
		//2. ��ȭ�鿡 ������ �Խù��� ��
		int pageScale =es.pageScale();
		
		//3. ��ü ���ڵ带 10���� ������ �� �ʿ��� ü���� ��
		int pageCnt = es.pageCnt(totalCnt, pageScale);
		
		//4. ���� ������ ��ȣ 1������ -> 1 / 2������ -> 11 / 3������ -> 21
		int startNum = es.startNum(currentPage, pageScale);
		
		//5. 
		int endNum= es.endNum(startNum, pageScale, totalCnt);
		
		
		BoardVO bvo = new BoardVO(startNum, endNum);
		model.addAttribute("totalCnt", totalCnt);
		model.addAttribute("pageScale", pageScale);
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("startNum", startNum);
		model.addAttribute("endNum", endNum);
		model.addAttribute("carList", es.subquery(bvo));
		return "mybatis/day0525/subquery";
	}
	
	@RequestMapping(value="/mybatis/day0525/union.do", method= {GET,POST})
	public String union(Model model) {
		model.addAttribute("empList", es.union());
		
		return "mybatis/day0525/union";
	}
}
