--���� �Լ�
--rank() over() �ߺ� ���� �߻�
--��� ���̺��� �����ȣ ����� ���� ������ ������ ��ȸ
select empno, ename, sal, rank() over(order by sal)
from emp;

--row_number() over: �ߺ� ���� �߻����� ����
select empno, ename, sal, row_number() over(order by sal)
from emp;

--���� ������ �ߺ� ������
select job, sal, rank() over(partition by job order by sal) from emp;

select sysdate, sysdate+1, sysdate+2 from dual;

--add_months
select add_months(sysdate, 3) from dual;

--months_beween(ū��¥,������¥)
select months_between('2022-04-22',sysdate) from dual;

--������̺��� 1981�⿡ �Ի��� ������� �����ȣ, �����,����, ����, �Ի����� ��ȸ�Ͽ� ��ȸ �����
--cp_emp2���̺��� �����ϼ���
create table cp_emp2 as (
	select empno, ename,job, sal, hiredate from emp where to_char(hiredate,'yyyy') = 1981
);
select * from cp_emp2;

--�μ����̺��� ��� �÷�, ���ڵ带 ��ȸ�� c
create table cp_dept as(select * from dept);

create table cp_emp3 as (select empno, ename, job, sal, deptno from emp);

select empno, ename, job, hiredate, sal, comm from emp where ename is null;

create table cp_emp4 as
(select empno, ename, job, hiredate, sal, comm from emp where 1=0);
--1=1�� �׻� ������ ��� ���ڵ带 �˻��Ѵ�
--1=0�� �׻� �������� ���ڵ带 �˻����� �ʴ´�.

drop table cp_emp6;



