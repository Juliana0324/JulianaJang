--driving table
--조인할때 키로 사용하는 테이블
--driving table을 잘못 선정하면 검색 속도가 느려진다.
--driving table 선정조건(1.관계가 설정된 pk테이블, 2. 관계가 선정되지 않은 테이블에서는 칼럼의 레코드가 적은 테이블)
--ex) deptno
select * from car_country;
select * from car_maker;
select * from car_model;

--inner join : 테이블에 같은 값을 가진 레코드만 검색
--한쪽 테이블에만 레코드가 존재하면 검색되지 않는다

--차량의 제조국, 제조사,모델 조회
--ANSI
select co.country, ma.maker, ma.model
from car_country co
inner join car_maker ma
on ma.maker=co.maker;

--Oracle
select cc.country, cc.maker, cma.model
from car_country cc, car_maker cma
where cma.maker=cc.maker;

--ansi
select cma.maker, cma.model,cmo.car_option, cmo.car_year
from car_maker cma
inner join car_model cmo
on cmo.model=cma.model
where instr(cmo.car_option,'ABS')>0;

--oracle
--조인조건에는 (조인조건) 괄호로 써준다
select cma.maker, cma.model,cmo.car_option, cmo.car_year
from car_maker cma, car_model cmo
where (cmo.model=cma.model) and instr(cmo.car_option,'ABS')>0;

--테이블 세개 조인
--보유중인 차량의 제조국, 제조사(car country), 모델명, 카연식(car_maker), 옵션, 가격, 입력일(car model)
--ANSI
select cc.country, cc.maker,
	 	 cma.model,
		 cmo.car_year, cmo.car_option,cmo.price,cmo.hiredate
from car_country cc
inner join car_maker cma
on cma.maker=cc.maker
inner join car_model cmo
on cmo.model=cma.model;

--oracle
select  cc.country, cc.maker,
	 	 cma.model,
		 cmo.car_year, cmo.car_option,cmo.price,cmo.hiredate
from car_country cc, car_maker cma, car_model cmo
where (cma.maker=cc.maker and cmo.model= cma.model) ;

-------------------------------------------------------------
--outer join
select * from dept d
left outer join emp e
on e.deptno=d.deptno;

select * from dept d
full outer join emp e
on e.deptno=d.deptno;

--oracle outer join
--조인조건으로 사용되는 칼럼에(+)기호를 붙임
--fullouter지원해주지 않음
--primary key가 있는 칼럼으로 조회할것
select d.deptno,d.dname,e.empno,e.ename, e.hiredate
from emp e, dept d
where e.deptno(+)= d.deptno;

select * from car_maker;
select * from car_model;

--ansi
select cma.maker,cma.model, cmo.hiredate, cmo.price, cmo.car_option
from car_maker cma
left outer join car_model cmo
on cmo.model=cma.model
where cma.maker in('현대','기아');

--oracle
select cma.maker, cma.model, cmo.hiredate, cmo.price, cmo.car_option
from car_maker cma, car_model cmo
where (cmo.model(+)=cma.model) and cma.maker in ('현대','기아');

update car_model
set car_year='2022', price =3500, cc=1998
where price is null;

commit;

select* from car_country;

--체이블 3개 조인
--제조사가 '현대 BENZ'인 모든 차량의 제조사, 모델명, 연식 가격 옵션을 조회
select  cc.country,cc.maker, cma.model, cmo.car_year, cmo.price, cmo.car_option
from CAR_COUNTRY cc
inner join car_maker cma
on cma.maker=cc.maker
left outer join car_model cmo
on cmo.model=cma.model
where cc.maker in('현대','BENZ');

--오라클
select  cc.country,cc.maker, cmo.model, cmo.car_year, cmo.price, cmo.car_option
from CAR_COUNTRY cc, car_model cmo, car_maker cma
where (cma.maker=cc.maker and cmo.model(+)=cma.model)
and cc.maker in('현대','BENZ');

--모든 부서의 근무하는 사원의 사원번호,사원명 입사일 부서번호 부서명 우편번호 시도 구군 동 번지
--ANSI
select e.empno, e.ename, e.hiredate, d.deptno, d.dname, z.seq, z.sido,z.gugun,z.dong,z.zipcode
from dept d
left outer join emp e
on e.deptno=d.deptno
left outer join zipcode z
on z.seq=e.empno;


--오라클
select e.empno, e.ename, e.hiredate, d.deptno, d.dname, z.seq, z.sido,z.gugun,z.dong,z.zipcode
from dept d, emp e, zipcode z
where (e.deptno(+)=d.deptno and z.seq(+)=e.empno);

--self join
--사원명이 클락인 사원보다 연봉을 많이 받는 사람을 조회(서브쿼리로 대체가능)
select empno, ename,sal, hiredate from emp
where sal>(select sal from emp where ename=upper('clark'));

select e1.empno, e1.ename, e1.sal, e1.hiredate
from emp e1/*조회용*/, emp e2/*조건용*/
where (e1.sal>e2.sal) and e2.ename='CLARK';

--1-9999까지
create sequence test_seq
start with 1
increment by 1
maxvalue 9999
cycle
cache 40;

select * from user_sequences;

--시퀀스 번호 사용
--currval=> 접속자 session에 시퀀스 객체가 없다면 error발생
--없는 이유: 1. 새로 생성된 시퀀스 객체
--				2. db서버가 종료된 후 재시작되었다
select test_seq.currval
from dual;

select test_seq.nextval
from dual;

drop sequence test_seq;
insert into cp_emp5(empno,ename,sal,deptno) values(test_seq.nextval, '강사원',3000,20);
insert into cp_emp5(empno,ename,sal,deptno) values(test_seq.nextval, '정사원',3100,20);
insert into cp_emp5(empno,ename,sal,deptno) values(test_seq.nextval, '서사원',2900,20);
insert into cp_emp5(empno,ename,sal,deptno) values(test_seq.nextval, '신사원',3000,20);
insert into cp_emp5(empno,ename,sal,deptno) values(test_seq.nextval, '김사원',2400,20);
commit;

select * from cp_emp5;
truncate table cp_emp5;

--쿼리문이 실패하면 시퀀스 번호는 날라감
insert into cp_emp5(empno,ename,sal,deptno) values(test_seq.nextval, '김사원님',2400,20);

insert into cp_emp5(empno,ename,sal,deptno) values(test_seq.nextval, '장사원',2400,20);--7번 사라짐
insert into cp_emp5(empno,ename,sal,deptno) values(test_seq.nextval, '이사원',2400,20);

--쿼리문이 실패하더라도 번호가 연결되어야 한다면 sequence를 사용하면안된다
insert into cp_emp5(empno,ename,sal,deptno) values((select max(empno)+1 from cp_emp5), '김사원2',2400,20);


create sequence test_seq2
start with 10
increment by 10
maxvalue 1000000000
nocycle;

select test_seq2.nextval from dual;
