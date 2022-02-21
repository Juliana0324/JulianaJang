--delete subquery

delete from cp_emp4
where empno=(select empno from emp where sal=5000);

delete from cp_emp5
where empno in (select empno from emp where deptno=20);
commit;

select empno, ename, sal, deptno from cp_emp5
where deptno=(select deptno from emp where empno=7521);

--사원 테이블에서 사원명이 터너인 사원보다 연봉을 높게 받는 사원들의
--사원 번호 사원명 부서번호 입사일을 조회
select empno,ename,deptno,hiredate,sal from emp
where sal>(select sal from emp where ename=upper('turner'));

--scala subquery
--사원 테이블에서 사원명 부서번호 부서 조회
--사ㅇ부서명은 dept테이블에 dname으로 조회
select empno,ename, dept.deptno, dept.dname
from emp, dept;

select empno, ename, deptno, (select loc from dept where dept.deptno = emp.deptno) from emp
where deptno=(select deptno from dept where dname=upper('sales'));

select empno, ename, deptno, (select dname from dept where dept.deptno= emp.deptno),
(select loc from dept where dept.deptno= emp.deptno)
from emp
where mgr=7698;

