select empno, replace(ename, 'A','a') from emp;

select deptno,
	case deptno when 10 then 'SI����'
					when 20 then 'SM'
					when 30 then 'QA'
					else 'OP'
					end dname
,ename, sal from emp;


select empno, ename, sal,
	case deptno when 10 then sal*0.15
					when 20 then sal*0.3
					when 30 then (sal+nvl(comm,0))*0.5    /*30�� �μ������� ���ʽ��� ���� ������� �־��*/
					else sal
					end comm
from emp;

--group by���� �Բ� ����ϴ� �����Լ�
select deptno,sum(sal),count(empno),max(sal),trunc(avg(sal),0) from emp
group by deptno
order by deptno;

--��� ���̺��� �Ŵ����� ������ ��ȸ
select mgr,count(*),max(sal) from emp
group by mgr
order by mgr;

--�׷캰 ����
--rollup
select deptno,sum(sal) from emp
group by rollup(deptno);

--cube : ������ ���� ���
--��� ���̺��� ������ ���� ��ȸ ������ �� �μ���ȣ, �μ��� ������ ��
select deptno, sum(sal)
from emp
group by cube(deptno);

--��� ���̺��� ������ ������ ��ȸ

select job, sum(sal)
from emp
group by rollup(job);

--Į���� �������� ���϶�
--�� �μ��� ���������� ����ϰ� ���μ��� ���� ����
select deptno,job, sum(sal)
from emp
group by rollup(deptno,job)
order by deptno;

-- ����, �׷캰 ������ ��ȸ�� �׷캰 �Ұ�� ���� ��ȸ
select deptno,job, sum(sal)
from emp
group by cube(deptno,job);

select * from emp;
