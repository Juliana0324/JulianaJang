--rownum: 조회되는 레코드에 1부터 증가하는 수를 붙여주는 가상 칼럼

--부서테이블에서 번호, 부서번호 부서명을 조회
--번호는 순차적으로
select rownum num,deptno,dname from dept;

select rownum,empno, ename,sal
from emp
order by sal;

--where 절에서 로우넘은 1번부터만 가능하다
select rownum, empno, ename, sal from emp
where rownum>=1 and rownum<6;

select * from car_country;

--select 다중행 서브쿼리
--바깥 쿼리는 인라인뷰를 사용한 조회이므로 inline view만 사용가능
select empno,ename, hi, sal
from (select empno, ename, hiredate hi, sal
from emp);

select rownum, empno, ename, hi
from (select empno, ename, hiredate hi from emp order by hiredate desc)
where rownum>=1 and rownum<6;

select rownum, empno, ename, hi
from(select rownum, empno, ename, hiredate hi from emp order by hiredate desc);


select r, empno,ename,hiredate from (select rownum r, empno, ename, hiredate
from(select empno, ename, hiredate from emp order by hiredate desc))
where r between 2 and 6;

select rnum,empno, ename, hiredate
from(select row_number() over(order by hiredate desc) rnum,empno, ename, hiredate
	from emp)
	where rnum between 2 and 6;

--car+model 테이블에서 배기량의 내림차순으로 정렬했을때
--11~20번째 검색된 레코드 조회
select model, cc, car_year, price, hiredate
from (select model,row_number() over(order by cc desc) r, cc, car_year,price,hiredate from car_model where cc is not null)
where r between 11 and 20;


select model, cc, car_year, price, hiredate
from (select model,row_number() over(order by cc desc) r, cc, car_year,price,hiredate
	from car_model
	where cc is not null and exists(select model from car_model where model='그랜저'))
where r between 11 and 20;

--union 여러개의 테이블을 합쳐서 검색할때(중복x)
select ename from emp
union
select ename from emp;

select empno,job,ename, hiredate
from emp
union all
select sal, ename, to_char(sal,'9,999'), hiredate
from cp_emp4;

select * from user_constraints;
