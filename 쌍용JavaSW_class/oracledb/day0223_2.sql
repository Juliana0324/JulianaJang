select count(*) from tab;
select * from dba_users;

--������ ��й�ȣ ����
alter user scott identified by tiger;

select * from dba_users where username='SCOTT';

--������ױ�
alter user scott account lock;
--���� ����
alter user scott account unlock;

--���� ����
--oracle12c���ʹ� c##�� ���
-- create user ������ identified by ���;
create user c##test identified by 1234;

--c## �ƴѰ�������(��ȸ��)
alter session set "_ORACLE_SCRIPT" = true;
create user test identified by 1234;
select * from dba_users where username='TEST';

--���Ѻο�
grant connect to test;
grant resource to test;

--���� ȸ��
revoke connect from test;

alter user test default tablespace users quota unlimited on users;
drop user test cascade;

--------------------------------------------------------------------
--Į���� ����
--Į�� ����

--������ ������
alter 