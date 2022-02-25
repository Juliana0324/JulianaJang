--
select * from user_objects;

drop table car_country;
select * from car_model;

alter session set "_ORACLE_SCRIPT"=true;
drop user scott cascade;
select * from dba_users;
 -- system계정으로 로그인이 안되어있었어요

create user scott identified by tiger;
grant resource,connect to scott;

alter user scott default tablespace users quota unlimited on users;

select * from tab;

select * from user_objects;
-------------------synonym ---------------------------
select * from dba_sys_privs;
select * from user_synonyms;

--synonym 생성권한 부여-관리자

grant create synonym to scott;
--생성권한 조회
select * from dba_sys_privs where grantee='SCOTT';

--생성권한 회수
revoke create synonym from scott;

--시노님생성-scott
--car_country 테이블을 cc라는 시노님을 부여해서 사용
create synonym cc for car_country;

create synonym cma for car_maker;
--시노님 조회
select * from user_synonyms;

select * from cc;
select * from cma;

select cc.country,cc.maker,cma.model
from cc,cma where cma.maker=cc.maker;

drop synonym cc;
select * from user_synonyms;


