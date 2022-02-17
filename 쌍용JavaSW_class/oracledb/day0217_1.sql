--사원 테이블에서 사원번호, 사원명, 연봉을 조회
--단 조회결과는 사원명(사원번호) 연봉은 xxx$입니다.

select * from emp;
select ename||'('||empno||') 연봉은 '|| sal||'$입니다.' as output from emp;

select ename En1, ename En2
from emp;

select ename "Ename" from emp;

select * from student;
select snum, sname, javascore, 100-javascore 획득점수
from student;


select empno, ename, sal, ceil(sal/12) mon_sal, sal*0.033 tax
from emp;

select * from EMP;

select empno, ename, deptno, hiredate from emp
where deptno=10;


--사원 테이블에서 연봉이 1250을 초과하는
-- 사원들의 사원번호 사원명, 연봉,직무를 조회
select empno, ename, sal, job
from emp
where sal>1250;

--사원 테이블에서 연봉이 1250이상인
-- 사원들의 사원번호 사원명, 연봉,직무를 조회
select empno, ename, sal, job
from emp
where sal>= 1250;


--사원 테이블에서 연봉이 3000미만
-- 사원들의 사원번호 사원명, 연봉,직무를 조회
select empno, ename, sal, job
from emp
where sal<3000;

--사원 테이블에서 연봉이 3000이하
-- 사원들의 사원번호 사원명, 연봉,직무를 조회
select empno, ename, sal, job
from emp
where sal<=3000;

select deptno, empno, ename, job, comm
from emp
where deptno!=10 order by deptno;
--where deptno<>10 order by deptno;

select empno,ename,deptno,job,hiredate from emp
where job='SALESMAN';
