--inner join
select e.empno, e.ename, e.deptno, d.loc from dept d
inner join emp e
on d.deptno=e.deptno;

--7698,7839�Ŵ����� �����ϴ� ����μ������� ������
select e.empno,e.ename,e.hiredate,e.mgr, d.deptno, d.dname,d.loc
from  dept d
inner join  emp e
on e.deptno=d.deptno
where e.mgr in(7698,7839);
