select empno, replace(ename, 'A','a') from emp;

select deptno,
	case deptno when 10 then 'SI개발'
					when 20 then 'SM'
					when 30 then 'QA'
					else 'OP'
					end dname
,ename, sal from emp;


select empno, ename, sal,
	case deptno when 10 then sal*0.15
					when 20 then sal*0.3
					when 30 then (sal+nvl(comm,0))*0.5    /*30번 부서이지만 보너스가 없는 사원들이 있어요*/
					else sal
					end comm
from emp;

--group by절과 함께 사용하는 집계함수
select deptno,sum(sal),count(empno),max(sal),trunc(avg(sal),0) from emp
group by deptno
order by deptno;

--사원 테이블에서 매니저별 정보를 조회
select mgr,count(*),max(sal) from emp
group by mgr
order by mgr;

--그룹별 집계
--rollup
select deptno,sum(sal) from emp
group by rollup(deptno);

--cube : 총합을 먼저 출력
--사원 테이블에서 총합을 먼저 조회 ㅏㅎㄴ 후 부서번호, 부서별 연봉의 합
select deptno, sum(sal)
from emp
group by cube(deptno);

--사원 테이블에서 직무별 정보를 조회

select job, sum(sal)
from emp
group by rollup(job);

--칼럼이 여러개로 묶일때
--각 부서별 직무연봉을 출력하고 각부서별 연봉 총합
select deptno,job, sum(sal)
from emp
group by rollup(deptno,job)
order by deptno;

-- 총합, 그룹별 총합을 조회후 그룹별 소계와 합을 조회
select deptno,job, sum(sal)
from emp
group by cube(deptno,job);

select * from emp;
