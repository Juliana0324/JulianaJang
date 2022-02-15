delete from students;
--drop�� �ѹ� �ȵ�

delete from student where num=20;

delete from student where num=3 and name='����';
INSERT INTO STUDENT (NUM,NAME,AGE,EMAIL,input_date) VALUES(3,'����',27,'kang@sist.co.kr',sysdate);

--truncate: ��� ���ڵ� ����(DDL: ���Ǿ�-> Transaction ����������� �ƴ�(rollback�� �ȵ�))
--where���� ���� Ư�����ڵ常 ���� �Ұ���
--rollback�Ұ���
truncate table student;


--show recyclebin�� dbŬ���̾�Ʈ ���� ���� �ٸ���.
--recyclebin������ ����: flashback
-- ���� �̸��� ���̺��� ������ �����ȵ�
--flashback table "BIN$T72p58qzTjuJJfBmRI4wyQ==$0/���̺��" to before drop;

flashback table  "BIN$U9IIlSfDQISsyhm+rcGDIQ==$0" to before drop;

--������ ����: purge
create table test(
	no number primary key
);
drop table test;
purge recyclebin;

drop table student;
select * from student;
commit;

--transaction ���
rollback;


--savepoint: �ѹ��� ������ ����
--�����̸���savepoint�� �ִٸ� ������ savepoint�����
create table test(
	 name varchar2(15)

); --ddl
insert into test(name) values('����ö');
commit;

insert into test(name) values('������');
savepoint jun;
insert into test(name) values('�ֿ���');
insert into test(name) values('������');


savepoint insert_job;
insert into test(name) values('�׽�Ʈ');

savepoint update_job;
update test set name='Test' where name='�׽�Ʈ';

savepoint delete_job;
delete from test where name='Test';



--rollback to delete_job;
--rollback to update_job;
rollback to insert_job;
select * from test;

commit; --rollback�Ŀ� commit�Ǹ� �ǵ����� �Ұ�

drop table test;
purge recyclebin;
show recyclebin;



