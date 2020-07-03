package chap06.dto;

import java.sql.ResultSet;
import java.util.Date;

public class emp {
	int empno;
	String ename;
	String job;
	int mgr;
	Date hiredatte;
	double sal;
	double comm;
	int deptno;

	public emp(ResultSet rs) {
		
	}
}
