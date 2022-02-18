create table test_orderby(
	num varchar2(5)

);

insert into test_orderby values('1');
insert into test_orderby values('2');
insert into test_orderby values('1002');
insert into test_orderby values('109');
insert into test_orderby values('25');
insert into test_orderby values('209');
insert into test_orderby values('3');
insert into test_orderby values('35');


select num from test_orderby
order by num;


--dual테이블을 써보자
select '황성준' from dual;

------수치함수
select abs(22), abs(-12)
from dual;

select ceil(10.1), round(10.4)
from dual;

select empno, ename, sal, ceil(sal*0.033) tax
from emp;

select floor(10.9)
from dual;

select 1/24/(60/10),'YYYY.MM.DD HH24:MI:SS'
FROM DUAL;

SELECT TRUNC(555.5555,2), TRUNC(555.5555,3)
FROM DUAL;

SELECT EMPNO,ENAME, SAL, TRUNC(SAL*0.033,-1)
FROM EMP;

---문자열함수
select upper('AbcdE') from dual;
select lower('AbcdE') from dual;

select empno,job,sal, hiredate from emp where ename=upper('scott');

select empno, lower(ename), hiredate from emp;

select initcap('hello') from dual;

select ename, empno, mgr, nullif(mgr,7698) as nm from emp;

select sal/comm from emp where ename='FORD';

select ename, empno, hiredate from emp where length(ename)=4;

select ename, comm, sal from emp;
select ename, comm, sal, coalesce(comm,sal) col from emp;

select ename, length(ename), empno from emp;
