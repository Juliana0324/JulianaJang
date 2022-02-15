delete from students;
--drop은 롤백 안됨

delete from student where num=20;

delete from student where num=3 and name='강산';
INSERT INTO STUDENT (NUM,NAME,AGE,EMAIL,input_date) VALUES(3,'강산',27,'kang@sist.co.kr',sysdate);

--truncate: 모든 레코드 절삭(DDL: 정의어-> Transaction 대상쿼리문이 아님(rollback이 안됨))
--where절이 없음 특정레코드만 삭제 불가능
--rollback불가능
truncate table student;


--show recyclebin는 db클라이언트 툴에 따라 다르다.
--recyclebin에서는 복구: flashback
-- 같은 이름의 테이블이 있으면 복구안됨
--flashback table "BIN$T72p58qzTjuJJfBmRI4wyQ==$0/테이블명" to before drop;

flashback table  "BIN$U9IIlSfDQISsyhm+rcGDIQ==$0" to before drop;

--휴지통 비우기: purge
create table test(
	no number primary key
);
drop table test;
purge recyclebin;

drop table student;
select * from student;
commit;

--transaction 취소
rollback;


--savepoint: 롤백할 지점을 선택
--같은이름의savepoint가 있다면 이전의 savepoint사라짐
create table test(
	 name varchar2(15)

); --ddl
insert into test(name) values('신유철');
commit;

insert into test(name) values('전민정');
savepoint jun;
insert into test(name) values('최연이');
insert into test(name) values('김현우');


savepoint insert_job;
insert into test(name) values('테스트');

savepoint update_job;
update test set name='Test' where name='테스트';

savepoint delete_job;
delete from test where name='Test';



--rollback to delete_job;
--rollback to update_job;
rollback to insert_job;
select * from test;

commit; --rollback후에 commit되면 되돌리기 불가

drop table test;
purge recyclebin;
show recyclebin;



