--groupby�� �ߺ����� ������� ����
select deptno from emp
group by deptno;


--���� ���
select job from emp
group by job;


--�����÷��� �׷����� ������ ���ϰ��� ���ٸ� �׷����� �������� ����
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
