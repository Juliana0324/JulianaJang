package lab.web.model;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Emp.do")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EmpDAO dao;
    boolean s;
    boolean d;
	public EmpServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		dao=new EmpDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String url= "";
		if("list".equals(action)) {
			int num=0;
			if(request.getParameter("num")!=null) {
				num=Integer.parseInt(request.getParameter("num"));
				s= num==1 ? !s :s;
				d= num==2 ? !d :d;
			}
			request.setAttribute("list", dao.selectEmployeeList(num,num==1 ? s : d));	
			url="/hr/EmpList.jsp";
		}else if("view".equals(action)) {
			int empId= Integer.parseInt(request.getParameter("empId"));
			request.setAttribute("emp", dao.selectEmployee(empId));
			url="/hr/EmpView.jsp";
		}else if("byName".equals(action)) {
			String byName= request.getParameter("byName");
			request.setAttribute("list", dao.selectByName(byName));
			url="/hr/EmpList.jsp";
		}
		else if("byDept".equals(action)) {
			int deptId= Integer.parseInt(request.getParameter("deptId"));
			request.setAttribute("list", dao.selectEmployeeByDeptId(deptId));
			url="/hr/EmpList.jsp";
		}
		else if("insert".equals(action)) {
			request.setAttribute("action", action);
			request.setAttribute("message", "입력");
			request.setAttribute("jobList", dao.selectAllJobs());
			request.setAttribute("manList", dao.selectAllManager());
			request.setAttribute("deptList", dao.selectAllDepartment());
			url="/hr/EmpInsert.jsp";
		}else if("update".equals(action)) {
			request.setAttribute("action", action);
			request.setAttribute("message", "수정");
			int empId= Integer.parseInt(request.getParameter("empId"));
			request.setAttribute("emp", dao.selectEmployee(empId));
			request.setAttribute("jobList", dao.selectAllJobs());
			request.setAttribute("manList", dao.selectAllManager());
			request.setAttribute("deptList", dao.selectAllDepartment());
			url="/hr/EmpInsert.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action =request.getParameter("action");
		if("insert".equals(action)) {
			int employeeId= Integer.parseInt(request.getParameter("empId"));
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String email = request.getParameter("email");
			String phoneNumber=request.getParameter("phoneNumber");
			String sdate=request.getParameter("hireDate");
			SimpleDateFormat tool =new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date hireDate= null;
			try {
				hireDate=new java.sql.Date(tool.parse(sdate).getTime());
			}catch(ParseException e) {
				e.printStackTrace();
			}
			String jobId= request.getParameter("jobId");
			double salary= Double.parseDouble(request.getParameter("salary"));
			double commissionPct= Double.parseDouble(request.getParameter("commissionPct"));
			int managerId= Integer.parseInt(request.getParameter("man"));
			int departmentId= Integer.parseInt(request.getParameter("dept"));

			
			EmpVO emp= new EmpVO();
			emp.setEmployeeId(employeeId);
			emp.setFirstName(firstName);
			emp.setLastName(lastName);
			emp.setEmail(email);
			emp.setPhoneNumber(phoneNumber);
			emp.setHireDate(hireDate);
			emp.setJobId(jobId);
			emp.setSalary(salary);
			emp.setCommissionPct(commissionPct);
			emp.setManagerId(managerId);
			emp.setDepartmentId(departmentId);
			dao.insertEmployee(emp);
			response.sendRedirect("/JDBC/Emp.do?action=list");
			
		}else if("update".equals(action)) {
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String email = request.getParameter("email");
			String phoneNumber=request.getParameter("phoneNumber");
			String sdate=request.getParameter("hireDate");
			SimpleDateFormat tool =new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date hireDate= null;
			try {
				hireDate=new java.sql.Date(tool.parse(sdate).getTime());
			}catch(ParseException e) {
				e.printStackTrace();
			}
			String jobId= request.getParameter("jobId");
			double salary= Double.parseDouble(request.getParameter("salary"));
			double commissionPct= Double.parseDouble(request.getParameter("commissionPct"));
			int managerId= Integer.parseInt(request.getParameter("man"));
			int departmentId= Integer.parseInt(request.getParameter("dept"));
			int employeeId= Integer.parseInt(request.getParameter("empId"));

			
			EmpVO emp= new EmpVO();
			emp.setEmployeeId(employeeId);
			emp.setFirstName(firstName);
			emp.setLastName(lastName);
			emp.setEmail(email);
			emp.setPhoneNumber(phoneNumber);
			emp.setHireDate(hireDate);
			emp.setJobId(jobId);
			emp.setSalary(salary);
			emp.setCommissionPct(commissionPct);
			emp.setManagerId(managerId);
			emp.setDepartmentId(departmentId);
			dao.UpdateEmployee(emp);
			response.sendRedirect("/JDBC/Emp.do?action=view&empId="+employeeId);
		}
		}
		

	}
