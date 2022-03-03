package kr.co.sist.statement.vo;

public class CpEmp4UpdateVO {
	private int empno,sal;
	private String job;
	private double comm;

	public CpEmp4UpdateVO() {
		
	}

	public CpEmp4UpdateVO(int empno, String job,int sal, double comm) {
		super();
		this.empno = empno;
		this.sal = sal;
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

}
