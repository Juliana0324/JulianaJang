--수정하는 법
drop trigger HR.UPDATE_JOB_HISTORY;
truncate table job_history;

--회원관리 DB 생성
create table member ( 
 userid varchar2(20) primary  key,
 name varchar2(30) not null,
 password varchar2(32) not null,
 email varchar2(50) not null,
 address varchar2(100)
);