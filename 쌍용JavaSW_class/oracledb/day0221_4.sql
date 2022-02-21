--delete subquery

delete from cp_emp4
where empno=(select empno from emp where sal=5000);

delete from cp_emp5
where empno in (select empno from emp where deptno=20);
commit;

select empno, ename, sal, deptno from cp_emp5
where deptno=(select deptno from emp where empno=7521);

--��� ���̺��� ������� �ͳ��� ������� ������ ���� �޴� �������
--��� ��ȣ ����� �μ���ȣ �Ի����� ��ȸ
select empno,ename,deptno,hiredate,sal from emp
where sal>(select sal from emp where ename=upper('turner'));

--scala subquery
--��� ���̺��� ����� �μ���ȣ �μ� ��ȸ
--�礷�μ����� dept���̺� dname���� ��ȸ
select empno,ename, dept.deptno, dept.dname
from emp, dept;

select empno, ename, deptno, (select loc from dept where dept.deptno = emp.deptno) from emp
where deptno=(select deptno from dept where dname=upper('sales'));

select empno, ename, deptno, (select dname from dept where dept.deptno= emp.deptno),
(select loc from dept where dept.deptno= emp.deptno)
from emp
where mgr=7698;

