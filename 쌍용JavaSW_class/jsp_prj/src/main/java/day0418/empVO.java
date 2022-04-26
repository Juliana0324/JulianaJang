package day0418;

import java.sql.Date;

public class empVO {
	private String ename,job ;
	private int empno,sal;
	private Date hiredate;

	public empVO(String ename, String job, int empno, int sal, Date hiredate) {
		super();
		this.ename = ename;
		this.job = job;
		this.empno = empno;
		this.sal = sal;
		this.hiredate = hiredate;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
		
	
}
