select count(*) from tab;
select * from dba_users;

--계정의 비밀번호 변경
alter user scott identified by tiger;

select * from dba_users where username='SCOTT';

--계정잠그기
alter user scott account lock;
--계정 열기
alter user scott account unlock;

--계정 생성
--oracle12c부터는 c##을 사용
-- create user 계정명 identified by 비번;
create user c##test identified by 1234;

--c## 아닌계정생성(일회용)
alter session set "_ORACLE_SCRIPT" = true;
create user test identified by 1234;
select * from dba_users where username='TEST';

--권한부여
grant connect to test;
grant resource to test;

--권한 회수
revoke connect from test;

alter user test default tablespace users quota unlimited on users;
drop user test cascade;

--------------------------------------------------------------------
--칼럼값 변경
--칼럼 삭제

--데이터 형변경
alter 