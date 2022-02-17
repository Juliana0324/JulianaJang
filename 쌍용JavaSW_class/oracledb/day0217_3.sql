--groupby는 중복값을 출력하지 않음
select deptno from emp
group by deptno;


--직무 출력
select job from emp
group by job;


--여러컬럼을 그룹으로 묶을때 동일값이 없다면 그룹으로 묶여지지 않음
select job,sal from emp group by job,sal;

select distinct job from emp;

select distinct mgr, job, deptno
from emp;

select deptno, count(*) from emp
group by deptno having count(deptno)>=4;

select empno, ename,sal from emp order by sal;

select empno, ename,sal from emp order by sal desc;

select empno, ename,sal from emp order by sal desc, ename,empno;

--
select ename,empno,hiredate from emp order by ename;
