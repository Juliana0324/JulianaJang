package kr.co.sist.vo;

public class CpEmp4VO {
	private int empno,	sal,comm;
	private String ename,job;
	
	public CpEmp4VO() {
	}

	public CpEmp4VO(int empno, int sal, int comm, String ename, String job) {
		this.empno = empno;
		this.sal = sal;
		this.comm = comm;
		this.ename = ename;
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

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
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

	@Override
	public String toString() {
		return "CpEmp4VO [empno=" + empno + ", sal=" + sal + ", comm=" + comm + ", ename=" + ename + ", job=" + job
				+ "]";
	}
	
}
