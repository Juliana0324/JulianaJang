--��� ���̺��� �����ȣ, �����, ������ ��ȸ
--�� ��ȸ����� �����(�����ȣ) ������ xxx$�Դϴ�.

select * from emp;
select ename||'('||empno||') ������ '|| sal||'$�Դϴ�.' as output from emp;

select ename En1, ename En2
from emp;

select ename "Ename" from emp;

select * from student;
select snum, sname, javascore, 100-javascore ȹ������
from student;


select empno, ename, sal, ceil(sal/12) mon_sal, sal*0.033 tax
from emp;

select * from EMP;

select empno, ename, deptno, hiredate from emp
where deptno=10;


--��� ���̺��� ������ 1250�� �ʰ��ϴ�
-- ������� �����ȣ �����, ����,������ ��ȸ
select empno, ename, sal, job
from emp
where sal>1250;

--��� ���̺��� ������ 1250�̻���
-- ������� �����ȣ �����, ����,������ ��ȸ
select empno, ename, sal, job
from emp
where sal>= 1250;


--��� ���̺��� ������ 3000�̸�
-- ������� �����ȣ �����, ����,������ ��ȸ
select empno, ename, sal, job
from emp
where sal<3000;

--��� ���̺��� ������ 3000����
-- ������� �����ȣ �����, ����,������ ��ȸ
select empno, ename, sal, job
from emp
where sal<=3000;

select deptno, empno, ename, job, comm
from emp
where deptno!=10 order by deptno;
--where deptno<>10 order by deptno;

select empno,ename,deptno,job,hiredate from emp
where job='SALESMAN';
