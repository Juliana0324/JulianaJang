--primary key
create table primary_column(
	name varchar2(15),
	id varchar2(16) constraint pk_primary_column primary key,
	tel varchar2(13),
	email varchar2(50)
);


insert into primary_column(name,id,tel,email) values('테스트','test','010-1234-5678','test@test.com');
insert into primary_column(name,id,tel,email) values('테스트','test1','010-1234-5678','test@test.com');
insert into primary_column(name,id,tel,email) values('김진영','test1','010-1234-5678','test@kim.com');

--primary key는 null 안됨
insert into primary_column(name,email) values('김진영','test@kim.com');
insert into PRIMARY_COLUMN(name,email, id) values('장정우','jjw@na.com','jjw');

--테이블 단위 제약사항
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
VALUES('키보드','KB0001','2022-02-22','기계식키보드로 청축을 사용...');

INSERT INTO PRIMARY_MULTI(ITEM,ITEM_NUM, PRD_DATE,INFO)
VALUES('키보드','KB0002','2022-02-22','기계식키보드로 갈축을 사용...');

INSERT INTO PRIMARY_MULTI(ITEM,ITEM_NUM, PRD_DATE,INFO)
VALUES('마우스','M0001','2022-02-22','광마우스');

INSERT INTO PRIMARY_MULTI(ITEM,ITEM_NUM, PRD_DATE,INFO)
VALUES('키보드','KB0001','2022-02-23','기계식키보드로 청축을 사용...');

SELECT * FROM PRIMARY_MULTI;

--FOREIGN KEY
--칼럼단위 제약사항
--primary_column테이블의 id를 참조하는 자식테이블,
CREATE TABLE FOREIGN_COLUMN(
	id varchar2(16) constraint fk_id references primary_column(id),
	ADDRESS varchar2(100)
);

drop table foreign_column;
purge recyclebin;
select * from user_constraints where constraint_type='R';

--제약사항 명은 유일
create table foreign_table(
	id varchar2(20),
	address varchar2(100),
	constraint fk_id2 foreign key(id) references primary_table(id)
);
INSERT INTO PRIMARY_TABLE(ID,NAME,AGE) VALUES('test','테스트',20);
INSERT INTO PRIMARY_TABLE(ID,NAME,AGE) VALUES('test1','테스트1',21);
INSERT INTO PRIMARY_TABLE(ID,NAME,AGE) VALUES('test2','테스트2',22);
commit;

SELECT * FROM USER_CONSTRAINTS;

--부모테이블에 존재하는 값으로만 추가될때
select * from primary_table;
insert into FOREIGN_COLUMN(id,address) values('test','서울시');
insert into FOREIGN_COLUMN(id,address) values('test','부산시');
insert into FOREIGN_COLUMN(id,address) values('test1','경기도');
--null허용
insert into FOREIGN_COLUMN(id,address) values('','인천시');
insert into FOREIGN_COLUMN(address) values('부천시');


--추가실패
--부모테이블에 존재하지 않는 값으로 추가될때
insert into FOREIGN_COLUMN(id, address) values('kim','부천시');
commit;

insert into foreign_table(id, address) values('test','의정부시');
commit;

select * from foreign_table;

--참조하는 레코드가 없다면 바로 삭제
delete from primary_table where id='test1';
select * from primary_table;

--참조하는 레코드가 없다면 삭제불가
delete from primary_table where id='test';

--1.참조하는 자식레코드 삭제 후 부모레코드 삭제
delete from foreign_table where id='test';
delete from primary_table where id='test';
commit;

select * from foreign_table;
select * from primary_table;

--on delete casecade: 부모레코드가 삭제될때 자식레코드도 자동으로 삭제됨

--drop table foreign_table;
--purge recyclebin;

create table foreign_table(
	id varchar2(20),
	address varchar2(100),
	constraint fk_id2 foreign key(id) references primary_table(id)
	on delete cascade
);

insert into primary_table(id, name,age) values('test','테스트',20);

insert into foreign_table values('test','인천시');
select * from foreign_table;

delete primary_table where id='test';

select * from primary_table;
