package kr.co.sist.statement.vo;

public class CpEmp4InsertVO {
	private int empno,sal;
	private String ename, job;
	private double comm;

	public CpEmp4InsertVO() {
		
	}

	public CpEmp4InsertVO(int empno, int sal, String ename, String job, double comm) {
		super();
		this.empno = empno;
		this.sal = sal;
		this.ename = ename;
		this.job = job;
		this.comm = comm;
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

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	@Override
	public String toString() {
		return "CpEmp4InsertVO [empno=" + empno + ", sal=" + sal + ", ename=" + ename + ", job=" + job + ", comm="
				+ comm + "]";
	}
	
	
}
