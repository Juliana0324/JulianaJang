--------------------------------------------------------------------
create table test_alter(
	num number,
	neam varchar2(15),
	addr number
);

--칼럼값 변경
--칼럼 삭제

--데이터 형변경
alter table test_alter rename column neam to name;

alter table test_alter modify addr varchar2(100);

--칼럼추가
alter table test_alter add id number;

--레코드 추가
insert into test_alter(num,name,addr,id) values(1,'테스트','서울시 강남구',1111);

--데이터 형을 변경하려면 내부에 레코드 값이 없어야함
alter table test_alter modify id varchar2(10);

truncate table test_alter;
alter table test_alter modify id varchar2(10);

--칼럼 삭제
alter table test_alter drop column addr;

--제약사항을 설정한 칼럼 추가
alter table test_alter add gender char(6) check(gender in('여자','남자'));
insert into test_alter(num,name,gender,id) values(2,'테스트','영자',2222);
insert into test_alter(num,name,gender,id) values(2,'테스트','여자',2222);
alter table test_alter1 rename to test_alter;

select * from user_constraints;

--chek 조건 삭제
alter table test_alter drop constraint SYS_C007517;
--pk  삭제
alter table test_alter drop constraint PK_TEST_ALTER;

alter table test_alter add constraint pk_test_alter primary key(id);
select * from user_constraints;
--레코드 추가(pk제약사항에 위배되지 않는값만 추가)
insert into test_alter(num,name, id, gender)
values(1,'테스트1','test','여');

--제약사항 비활성화
alter table test_alter disable constraint pk_test_alter;

insert into test_alter(num,name, id, gender)
values(2,'테스트2','test','여');

--제약사항 활성화
--똑같은 자식 값이 이미 들어있기때문에 실행할수 없음
alter table test_alter enable constraint pk_test_alter;

