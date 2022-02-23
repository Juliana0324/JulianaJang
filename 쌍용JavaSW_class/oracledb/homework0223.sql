-- 1. zipcode 테이블을 복사하여 cp_zipcode 테이블을 생성하세요.
create table cp_zipcode as (select * from zipcode);

-- 2. zipcode 테이블에 seq컬럼에 PK를 설정하세요.
alter table cp_zipcode add constraint pk_zipcode primary key(seq);

--3. 아래의 제약사항을 설정하여 테이블을 생성하세요.
--  저장 데이터 : 아이디, 이름, 주소seq, 전화번호, 나이, 성별, 입력일
--
-- - 아이디는 null을 허용하지 않으면서 유일합니다.
-- - 이름은 반드시 입력되어야 합니다.
-- - 주소seq는 null을 허용하지만 값이 있을 때에는  cp_zipcode 테이블에 존재하는
--    값으로만 입력가능합니다.
-- - 전화번호는 없을 수도 있지만 있다면 유일 합니다.
-- - 나이는 컬럼명이 생략되어 insert되는 경우 0으로 설정합니다.
-- - 성별은 ‘M’ 또는 ‘F’로만 입력가능합니다.
-- - 입력일은 컬럼명이 생략되어 insert되는 경우 현재 일자로 추가합니다.
select * from cp_zipcode;
create table user_info(
	id number(10) primary key,
	name 	varchar2(30) not null,
	addr_seq number(3),
	tel varchar2(20) constraint ui_tel unique,
	gender char(2) check (gender in('M','F')),
	input_date	date default sysdate,
	foreign key(addr_seq) references cp_zipcode(seq)
	);

	alter table user_info modify addr_seq number(6);
   alter table user_info modify id varchar2(10);

-- 4. 3번으로 생성한테이블에 아래와 같은 데이터를 추가하세요
--   1, jung,정인선,168,  010-1234-7890,F,현재일
--   2, kim,김진영,52144,  010-2234-8811,F,현재일
--   3, kang,강산,3298,  010-8471-1345,M,현재일
--   4, test,테스트,,  010-1111-2222,M,현재일
delete user_info;
select * from user_info;
insert into user_info(id,name,addr_seq,tel,gender,input_date) values('jung','정인선',168,'010-1234-7890','F',sysdate);
insert into user_info(id,name,addr_seq,tel,gender,input_date) values('kim','김진영',52144,'010-1234-8811','F',sysdate);
insert into user_info(id,name,addr_seq,tel,gender,input_date) values('kang','강산',3298,'010-8471-1345','M',sysdate);
insert into user_info(id,name,tel,gender,input_date) values('test','테스트','010-1111-2222','M',sysdate);

-- 5. 아이디, 이름, 전화번호, 우편번호, 주소를 조회하세요.
--    단, 주소가 존재하는 레코드만 조회하세요.
--       주소는 copy_zipcode 테이블에 sido,gugun,dong,bunji 컬럼을 결합하여 하나로 출력합니다.
select * from cp_zipcode;

select u.id,u.name, u.tel,u.addr_seq, c.sido, c.gugun, c.dong, c.bungi
from user_info u
inner join cp_zipcode c
on u.addr_seq = c.seq;
