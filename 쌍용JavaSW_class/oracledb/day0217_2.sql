select empno, ename, sal, job
from emp
where sal between 1000 and 3000;

select empno, ename, deptno from emp
where deptno=10 or deptno=30 order by deptno;


select empno, ename, deptno from emp
where deptno in(10,30) order by deptno;

select empno, ename, deptno from emp
where deptno not in(10,30) order by deptno;

select empno, ename, sal, comm from emp
where comm is null;

--문자열 연산자
create table test_like(
	name varchar2(15),
	addr varchar2(100)
);

insert into test_like values('김진영', '서울시 강남구 역삼동');
commit;
insert into test_like values('정인선', '서울시 동대문구 동대문동');
insert into test_like values('김현우', '서울시 구로구 구로1동');
insert into test_like values('정시헌', '서울시 구로구 구로2동');
insert into test_like values('이내혁', '인천시 부평구 부평동');
insert into test_like values('신유철', '수원시 영통면 영통리');
commit;

select * from test_like;

select addr from test_like where name='김진영';
select addr from test_like where name like '김%';
select addr from test_like where name like '김__';
select addr from test_like where addr like '%동';
select addr from test_like where addr like '%구로%';
select * from test_like where name like '_현_';
select * from test_like where name like '김__';
select * from test_like where addr like '서울시 %';

select * from emp;
--사운테이블에서 사원명이 4글자인 사원명사원번호 검색
select ename, empno from emp where ename like '____';
select ename from emp where ename like '__A__';

select ename from emp where ename like '_A%';
select * from emp;
select ename from emp where ename like '%A%A%';


create table zipcode(
	zipcode char(7),
	sido char(6),
	gugun varchar2(25),
	dong varchar2(100),
	bungi varchar2(25),
	seq number(5)
);

--sqlldr.exe.를 사용하여 CSV형식으로 만들어진 파일을 추가
select * from zipcode;

--자신이 살고있는 동의 우편번호, 시도 구군 동 번지를 조회
select zipcode,sido,gugun,dong,bungi from zipcode
where dong like '%그레이튼%';

