--primary key
create table primary_column(
	name varchar2(15),
	id varchar2(16) constraint pk_primary_column primary key,
	tel varchar2(13),
	email varchar2(50)
);


insert into primary_column(name,id,tel,email) values('�׽�Ʈ','test','010-1234-5678','test@test.com');
insert into primary_column(name,id,tel,email) values('�׽�Ʈ','test1','010-1234-5678','test@test.com');
insert into primary_column(name,id,tel,email) values('������','test1','010-1234-5678','test@kim.com');

--primary key�� null �ȵ�
insert into primary_column(name,email) values('������','test@kim.com');
insert into PRIMARY_COLUMN(name,email, id) values('������','jjw@na.com','jjw');

--���̺� ���� �������
create table primary_table(
	ID VARCHAR2(20),
	NAME VARCHAR2(30),
	AGE NUMBER(3)
	,CONSTRAINT PK_PRIMARY_TABLE PRIMARY KEY(ID)
);


SELECT * FROM USER_CONSTRAINTS;

CREATE TABLE PRIMARY_MULTI(
	ITEM VARCHAR2(30),
	ITEM_NUM CHAR(6),
	PRD_DATE CHAR(10),
	INFO VARCHAR2(4000),
	CONSTRAINT PK_PRIMARY_MULTI PRIMARY KEY(ITEM_NUM,PRD_DATE)
);

INSERT INTO PRIMARY_MULTI(ITEM,ITEM_NUM, PRD_DATE,INFO)
VALUES('Ű����','KB0001','2022-02-22','����Ű����� û���� ���...');

INSERT INTO PRIMARY_MULTI(ITEM,ITEM_NUM, PRD_DATE,INFO)
VALUES('Ű����','KB0002','2022-02-22','����Ű����� ������ ���...');

INSERT INTO PRIMARY_MULTI(ITEM,ITEM_NUM, PRD_DATE,INFO)
VALUES('���콺','M0001','2022-02-22','�����콺');

INSERT INTO PRIMARY_MULTI(ITEM,ITEM_NUM, PRD_DATE,INFO)
VALUES('Ű����','KB0001','2022-02-23','����Ű����� û���� ���...');

SELECT * FROM PRIMARY_MULTI;

--FOREIGN KEY
--Į������ �������
--primary_column���̺��� id�� �����ϴ� �ڽ����̺�,
CREATE TABLE FOREIGN_COLUMN(
	id varchar2(16) constraint fk_id references primary_column(id),
	ADDRESS varchar2(100)
);

drop table foreign_column;
purge recyclebin;
select * from user_constraints where constraint_type='R';

--������� ���� ����
create table foreign_table(
	id varchar2(20),
	address varchar2(100),
	constraint fk_id2 foreign key(id) references primary_table(id)
);
INSERT INTO PRIMARY_TABLE(ID,NAME,AGE) VALUES('test','�׽�Ʈ',20);
INSERT INTO PRIMARY_TABLE(ID,NAME,AGE) VALUES('test1','�׽�Ʈ1',21);
INSERT INTO PRIMARY_TABLE(ID,NAME,AGE) VALUES('test2','�׽�Ʈ2',22);
commit;

SELECT * FROM USER_CONSTRAINTS;

--�θ����̺� �����ϴ� �����θ� �߰��ɶ�
select * from primary_table;
insert into FOREIGN_COLUMN(id,address) values('test','�����');
insert into FOREIGN_COLUMN(id,address) values('test','�λ��');
insert into FOREIGN_COLUMN(id,address) values('test1','��⵵');
--null���
insert into FOREIGN_COLUMN(id,address) values('','��õ��');
insert into FOREIGN_COLUMN(address) values('��õ��');


--�߰�����
--�θ����̺� �������� �ʴ� ������ �߰��ɶ�
insert into FOREIGN_COLUMN(id, address) values('kim','��õ��');
commit;

insert into foreign_table(id, address) values('test','�����ν�');
commit;

select * from foreign_table;

--�����ϴ� ���ڵ尡 ���ٸ� �ٷ� ����
delete from primary_table where id='test1';
select * from primary_table;

--�����ϴ� ���ڵ尡 ���ٸ� �����Ұ�
delete from primary_table where id='test';

--1.�����ϴ� �ڽķ��ڵ� ���� �� �θ��ڵ� ����
delete from foreign_table where id='test';
delete from primary_table where id='test';
commit;

select * from foreign_table;
select * from primary_table;

--on delete casecade: �θ��ڵ尡 �����ɶ� �ڽķ��ڵ嵵 �ڵ����� ������

--drop table foreign_table;
--purge recyclebin;

create table foreign_table(
	id varchar2(20),
	address varchar2(100),
	constraint fk_id2 foreign key(id) references primary_table(id)
	on delete cascade
);

insert into primary_table(id, name,age) values('test','�׽�Ʈ',20);

insert into foreign_table values('test','��õ��');
select * from foreign_table;

delete primary_table where id='test';

select * from primary_table;
