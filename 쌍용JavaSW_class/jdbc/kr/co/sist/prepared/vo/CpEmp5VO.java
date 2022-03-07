package kr.co.sist.prepared.vo;

public class CpEmp5VO {
	private int empno, sal,comm, deptno;
	private String ename,job;
	
	public CpEmp5VO() {
		// TODO Auto-generated constructor stub
	}
	
	public CpEmp5VO(int empno, int sal, int comm, int deptno, String ename) {
		super();
		this.empno = empno;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
		this.ename = ename;
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
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "CpEmp5VO [empno=" + empno + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + ", ename="
				+ ename + "]";
	}
	
}
