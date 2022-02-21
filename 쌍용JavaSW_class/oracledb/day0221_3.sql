--insert의 단수행 서브쿼리
select * from cp_emp4;

insert into cp_emp2(empno,ename) values(1,'테스트');
commit;
insert into cp_emp2(empno,ename,job) values(2,'테스트2','');
commit;


insert into cp_emp4 values(1,'이내혁','개발자',sysdate,
	(select sal from emp where empno=7902),''
);

insert into cp_emp4 values(2,'정시헌','개팔자',add_months(sysdate,1),
	(select sal from cp_emp4 where empno=1)+500,
	(select comm from emp where empno=7654)
);

--위와 같지만 만약 내부에 함수가 들어가지못할때 dual로 처리
insert into cp_emp4 values(2,'정시헌','개팔자',(select add_months(sysdate,1) from dual),
	(select sal from cp_emp4 where empno=1)+500,
	(select comm from emp where empno=7654)
);
commit;

--emp테이블에 사원번호, 사원면, 입사일, 연봉을 조회하ㅕㅇ cp_emp4에 추가
insert into cp_emp4 (empno, ename, hiredate, sal)
(select empno, ename, hiredate, sal from emp where deptno=10);


insert into cp_emp4(empno, ename, job, hiredate,sal)
(select empno,ename,job,hiredate,sal*1.2 from emp where to_char(hiredate, 'mm')='02');



--update 서브 쿼리


update cp_emp4
set sal=(select sal from cp_emp4 where empno=7839)
where empno=1;


update cp_emp4
set sal=5200
where empno=(select empno from emp where sal=5000);


--사원 테이블에서 사원번호, 사원명, 연봉, 보너스, 부서선호를 조회하여 cp_emp5에 추가
create table cp_emp5 as(select empno, ename, sal, comm, deptno from emp);

--emp테이블에서 20번 부서사원과 동일한 사원을 cpemp5에서 찾고,
-- 사원들의 보너스를 1000설정
update cp_emp5
set comm=1000
where empno in (select empno from emp where deptno=20);

select * from cp_emp5;
