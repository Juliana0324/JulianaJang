--순위 함수
--rank() over() 중복 순위 발생
--사원 테이블에서 사원번호 사원명 연봉 연봉의 순위를 조회
select empno, ename, sal, rank() over(order by sal)
from emp;

--row_number() over: 중복 순위 발생하지 않음
select empno, ename, sal, row_number() over(order by sal)
from emp;

--같은 연봉은 중복 순위로
select job, sal, rank() over(partition by job order by sal) from emp;

select sysdate, sysdate+1, sysdate+2 from dual;

--add_months
select add_months(sysdate, 3) from dual;

--months_beween(큰날짜,작은날짜)
select months_between('2022-04-22',sysdate) from dual;

--사원테이블에서 1981년에 입사한 사원들의 사원번호, 사원명,직무, 연봉, 입사일을 조회하여 조회 결과로
--cp_emp2테이블을 생성하세요
create table cp_emp2 as (
	select empno, ename,job, sal, hiredate from emp where to_char(hiredate,'yyyy') = 1981
);
select * from cp_emp2;

--부서테이블의 모든 컬럼, 레코드를 조회후 c
create table cp_dept as(select * from dept);

create table cp_emp3 as (select empno, ename, job, sal, deptno from emp);

select empno, ename, job, hiredate, sal, comm from emp where ename is null;

create table cp_emp4 as
(select empno, ename, job, hiredate, sal, comm from emp where 1=0);
--1=1은 항상 참으로 모든 레코드를 검색한다
--1=0은 항상 거짓으로 레코드를 검색하지 않는다.

drop table cp_emp6;



