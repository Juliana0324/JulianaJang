--뷰생성
--권한이 부여된 계정만 가능
select * from user_views;

--단순 함수 연산식을 사용하지 않은 하나의 테이블에서 도출된 view
--뷰를ㄹ 생성한다
CREATE VIEW emp5 AS(SELECT empno, ename, sal, deptno FROM cp_emp5);

alter table cp_emp5 add constraints pk_cp_emp5 primary key(empno);

--뷰 권한 부여(관ㄹ자)
grant create view to scott;

select * from user_views;
--권환 회수
revoke create view from scott;

insert into cp_emp5(EMPNO, ENAME, SAL,COMM,DEPTNO)
values(14,'정인선',3000,100,10);

--view 조회
select * from emp5;

--view에 작업하면 실제 테이블에 반영됨
insert into emp5(empno,ename, sal, deptno)
values(100,'정시헌',3000,30);
commit;

select * from cp_emp5;

--update
--사원번호가 100번인 사원의 연봉을 3500으로 변경
UPDATE emp5
SET sal=3500
WHERE empno=100;
commit;

DELETE FROM emp5
WHERE empno=100 AND ename='정시헌';
rollback;
commit;

select * from cp_emp5;
drop view emp5;

select * from user_views;

--뷰생성
create view emp5 as
(select empno, ename, sal/12 month_sal,deptno from cp_emp5);

select * from emp5;
--복합 뷰로 만들어진 뷰는dml불가능(select 제외)
insert into emp5(EMPNO,ENAME,MONTH_SAL, DEPTNO)
VALUES(200,'정시헌',3500,10);

create view emp6 as
(select empno, ename, sal,deptno from cp_emp5) with read only;

select * from user_views;

--wirh read only
select * from emp6;
--읽기 전용에는 insert,update, delete안됨
insert into emp6(EMPNO,ENAME,SAL, DEPTNO)
VALUES(200,'정시헌',3500,10);

--복합뷰
--배기량 1500-3000사이인 차량의 제조국, 제조사,모델명, 연식 가격 이미지 입력일 배기량 옵선을 조회
CREATE VIEW car_view AS(
	SELECT row_number() over(order by cmo.cc desc) num,cc.country,cmo.car_year ,cc.maker, cma.model, cmo.hiredate,
			cmo.price, cmo.car_img, cmo.cc, cmo.car_option
	FROM car_country cc, car_maker cma, car_model cmo
	WHERE (cma.maker=cc.maker and cmo.model=cma.model) AND cmo.cc BETWEEN 1500 AND 3000
);

drop view car_view;
select num, country, maker, model, to_char(hiredate,'mm-dd-yyyy') hiredate, to_char(car_year,'9,999,999') ,to_char(price,'99,999,999'),car_img,
		to_char(cc,'9,999,999') cc, substr(car_option, 1, instr(car_option, ',')-1) from car_view where num between 3 and 6;

insert into car_view
(num, country, maker, model, car_year, car_img, hiredate, cc, car_option)
values(34,'국산','대우','임팔라','2022','im.jpg',sysdate,4000,'잘달림');

drop view car_view;
drop view emp5;
drop view emp6;

--뷰 권환 회수
revoke create view  from scott;

select * from dba_sys_privs where grantee='SCOTT';

--indexㅂ기
select * from user_indexes;

select rowid,empno from emp;

select * from zipcode where seq=52000;

select * from user_indexes where table_name ='CP_EMP4';

--인덱스 생성
--unique index 새용
create unique index ind_cp_emp4 on cp_emp4(empno);

select * from cp_emp4;
delete from cp_emp4 where to_char(hiredate, 'mi')=34;
commit;
select * from user_indexes;

--인덱스가 설정된 칼럼 조회
select * from user_ind_columns where table_name='CP_EMP4';

--non unique index;
select * from cp_emp5;
insert into cp_emp5 values(17,'정시헌',2000,200,10);
commit;

--사원명에 인덱스부여(non unique index)
create index ind_cp_emp5 on cp_emp5(ename);

select * from user_ind_columns
where table_name='CP_EMP5';

select * from user_indexes
where table_name='CP_EMP5';

--인덱스삭제
drop index ind_cp_emp5;
select * from user_indexes;

--인덱스 갱신
alter index ind_cp_emp5 rebuild;
alter index pk_cp_emp5 rebuild;

---------------------비트맵 인덱스:칼럼의 값이 독특한 형태 일때 쓰는 인덱스-----------------------------
create bitmap index ind_zipcode on cp_zipcode(zipcode);
drop index ind_zipcode;

select * from user_ind_columns
where index_name='IND_ZIPCODE';

--------------------composite index: 여러개의 칼럼으로 인덱스를 구성해야할때----------------
--create index 인덱스명 on 테이블명(칼럼명,,,);
select * from cp_emp3;

--cp_emp3테이블에 ename, job칼럼을 사용하여 복합 인덱스 생성
create index ind_cp_emp3 on cp_emp3(ename, job);

select * from user_ind_columns where index_name='IND_CP_EMP3';
select * from user_indexes where table_name='CP_EMP3';

--+인덱스 힌트 /*+인덱스 힌트*/ => +가 없으면 일반주석으로 인지함
alter index pk_cp_zipcode rebuild;
select * from user_indexes;

--인덱스를 사용하지 않은 조회
select zipcode, sido, gugun, dong, bunji, seq
from zipcode
where seq between 30000 and 30100;

--ctrl+p 하면 cost비용이 준다
select /*+ index(zipcode) pk_cp_zipcode */zipcode, sido, gugun, dong, bunji, seq
from cp_zipcode
where seq between 30000 and 30100;
