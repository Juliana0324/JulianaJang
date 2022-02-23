--inner join
select e.empno, e.ename, e.deptno, d.loc from dept d
inner join emp e
on d.deptno=e.deptno;

--7698,7839매니저가 관리하는 사원부서정보를 조히ㅗ
select e.empno,e.ename,e.hiredate,e.mgr, d.deptno, d.dname,d.loc
from  dept d
inner join  emp e
on e.deptno=d.deptno
where e.mgr in(7698,7839);
