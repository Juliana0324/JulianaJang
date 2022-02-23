--unique: 값이 없을 수도 있지만(null허용) 있다묜 유일할때
--컬럼단위
create table unique_column(
	name varchar2(10),
	email varchar2(50) constraint ux_email unique,
	tel varchar2(16)
);
select * from user_constraints;

--테이블단위
create table unique_table(
	name varchar2(10),
	email varchar2(50),
	tel varchar2(16),
	constraint ux_unique_table_email unique(email)
);

--데이터 입력 성공
insert into UNIQUE_COLUMN(name, email,tel) values('테스트','test@test.com','010-1111-1234');
commit;

--다른 이메일 데이터 입력
insert into UNIQUE_COLUMN(name, email,tel) values('테스트','test1@test.com','010-1111-1234');
commit;

--null이 입력될때
insert into UNIQUE_COLUMN(name, email,tel) values('테스트3','','010-1111-1234');
commit;

insert into UNIQUE_COLUMN(name, tel) values('테스트3','010-1111-1234');
commit;

--실패경우
--중복되었을때
insert into UNIQUE_COLUMN(name, email,tel) values('황성준','test@test.com','010-1111-1234');
commit;

-------------------------------------------------------------------------------------------------
--check
--칼럼의 입력값을 원하는 형태의 값으로만 입력받을때
--칼럼단위 constraint 제약사항명 생략가능
--not null(반드시 입력해야할때)

create table other_constraint(
	name varchar2(30byte) not null,
	age number(3) check(age>=20 and age<30),
	gender char(3) null,
	address varchar2(100),
	input_date date default sysdate
);
alter table other_constraint modify gender char(10);
--테이블단위
insert into other_constraint(name, age, gender,address, input_date) values('테스트',20,'남자','서울시 강남구',sysdate);

--default
--inputdate
insert into other_constraint(name, age, gender,address) values('테스트',29,'남자','서울시 강남구');

--not null
insert into other_constraint(age, gender,address) values(29,'남자','서울시 강남구');

--check
insert into other_constraint(name, age, gender,address) values('테스트1',30,'남자','서울시 강남구');
insert into other_constraint(name, age, gender,address) values('테스트5',30,'','서울시 강남구');

select * from emp where job in ('SALESMAN', 'MANAGER');
