--
select * from user_objects;

drop table car_country;
select * from car_model;

alter session set "_ORACLE_SCRIPT"=true;
drop user scott cascade;
select * from dba_users;
 -- system�������� �α����� �ȵǾ��־����

create user scott identified by tiger;
grant resource,connect to scott;

alter user scott default tablespace users quota unlimited on users;

select * from tab;

select * from user_objects;
-------------------synonym ---------------------------
select * from dba_sys_privs;
select * from user_synonyms;

--synonym �������� �ο�-������

grant create synonym to scott;
--�������� ��ȸ
select * from dba_sys_privs where grantee='SCOTT';

--�������� ȸ��
revoke create synonym from scott;

--�ó�Ի���-scott
--car_country ���̺��� cc��� �ó���� �ο��ؼ� ���
create synonym cc for car_country;

create synonym cma for car_maker;
--�ó�� ��ȸ
select * from user_synonyms;

select * from cc;
select * from cma;

select cc.country,cc.maker,cma.model
from cc,cma where cma.maker=cc.maker;

drop synonym cc;
select * from user_synonyms;


