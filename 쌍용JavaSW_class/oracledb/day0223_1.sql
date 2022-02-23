--unique: ���� ���� ���� ������(null���) �ִٹ� �����Ҷ�
--�÷�����
create table unique_column(
	name varchar2(10),
	email varchar2(50) constraint ux_email unique,
	tel varchar2(16)
);
select * from user_constraints;

--���̺����
create table unique_table(
	name varchar2(10),
	email varchar2(50),
	tel varchar2(16),
	constraint ux_unique_table_email unique(email)
);

--������ �Է� ����
insert into UNIQUE_COLUMN(name, email,tel) values('�׽�Ʈ','test@test.com','010-1111-1234');
commit;

--�ٸ� �̸��� ������ �Է�
insert into UNIQUE_COLUMN(name, email,tel) values('�׽�Ʈ','test1@test.com','010-1111-1234');
commit;

--null�� �Էµɶ�
insert into UNIQUE_COLUMN(name, email,tel) values('�׽�Ʈ3','','010-1111-1234');
commit;

insert into UNIQUE_COLUMN(name, tel) values('�׽�Ʈ3','010-1111-1234');
commit;

--���а��
--�ߺ��Ǿ�����
insert into UNIQUE_COLUMN(name, email,tel) values('Ȳ����','test@test.com','010-1111-1234');
commit;

-------------------------------------------------------------------------------------------------
--check
--Į���� �Է°��� ���ϴ� ������ �����θ� �Է¹�����
--Į������ constraint ������׸� ��������
--not null(�ݵ�� �Է��ؾ��Ҷ�)

create table other_constraint(
	name varchar2(30byte) not null,
	age number(3) check(age>=20 and age<30),
	gender char(3) null,
	address varchar2(100),
	input_date date default sysdate
);
alter table other_constraint modify gender char(10);
--���̺����
insert into other_constraint(name, age, gender,address, input_date) values('�׽�Ʈ',20,'����','����� ������',sysdate);

--default
--inputdate
insert into other_constraint(name, age, gender,address) values('�׽�Ʈ',29,'����','����� ������');

--not null
insert into other_constraint(age, gender,address) values(29,'����','����� ������');

--check
insert into other_constraint(name, age, gender,address) values('�׽�Ʈ1',30,'����','����� ������');
insert into other_constraint(name, age, gender,address) values('�׽�Ʈ5',30,'','����� ������');

select * from emp where job in ('SALESMAN', 'MANAGER');
