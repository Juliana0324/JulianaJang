--------------------------------------------------------------------
create table test_alter(
	num number,
	neam varchar2(15),
	addr number
);

--Į���� ����
--Į�� ����

--������ ������
alter table test_alter rename column neam to name;

alter table test_alter modify addr varchar2(100);

--Į���߰�
alter table test_alter add id number;

--���ڵ� �߰�
insert into test_alter(num,name,addr,id) values(1,'�׽�Ʈ','����� ������',1111);

--������ ���� �����Ϸ��� ���ο� ���ڵ� ���� �������
alter table test_alter modify id varchar2(10);

truncate table test_alter;
alter table test_alter modify id varchar2(10);

--Į�� ����
alter table test_alter drop column addr;

--��������� ������ Į�� �߰�
alter table test_alter add gender char(6) check(gender in('����','����'));
insert into test_alter(num,name,gender,id) values(2,'�׽�Ʈ','����',2222);
insert into test_alter(num,name,gender,id) values(2,'�׽�Ʈ','����',2222);
alter table test_alter1 rename to test_alter;

select * from user_constraints;

--chek ���� ����
alter table test_alter drop constraint SYS_C007517;
--pk  ����
alter table test_alter drop constraint PK_TEST_ALTER;

alter table test_alter add constraint pk_test_alter primary key(id);
select * from user_constraints;
--���ڵ� �߰�(pk������׿� ������� �ʴ°��� �߰�)
insert into test_alter(num,name, id, gender)
values(1,'�׽�Ʈ1','test','��');

--������� ��Ȱ��ȭ
alter table test_alter disable constraint pk_test_alter;

insert into test_alter(num,name, id, gender)
values(2,'�׽�Ʈ2','test','��');

--������� Ȱ��ȭ
--�Ȱ��� �ڽ� ���� �̹� ����ֱ⶧���� �����Ҽ� ����
alter table test_alter enable constraint pk_test_alter;

