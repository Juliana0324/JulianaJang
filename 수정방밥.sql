--�����ϴ� ��
drop trigger HR.UPDATE_JOB_HISTORY;
truncate table job_history;

--ȸ������ DB ����
create table member ( 
 userid varchar2(20) primary  key,
 name varchar2(30) not null,
 password varchar2(32) not null,
 email varchar2(50) not null,
 address varchar2(100)
);