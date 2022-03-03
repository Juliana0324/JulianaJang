package kr.co.sist.statement.vo;

import java.sql.Date;

public class CpEmp4SelectAllVO {
	private int sal;
	private String ename, job, hiredate2;
	private double comm;
	private Date hiredate;

	public CpEmp4SelectAllVO() {
		
	}

	

	public CpEmp4SelectAllVO(int sal, String ename, String job, String hiredate2, double comm, Date hiredate) {
		super();
		this.sal = sal;
		this.ename = ename;
		this.job = job;
		this.hiredate2 = hiredate2;
		this.comm = comm;
		this.hiredate = hiredate;
	}



	public String getHiredate2() {
		return hiredate2;
	}



	public void setHiredate2(String hiredate2) {
		this.hiredate2 = hiredate2;
	}



	public Date getHiredate() {
		return hiredate;
	}



	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
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
}
