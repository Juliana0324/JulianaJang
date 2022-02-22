--차량테이블에서 차량옵션에 ‘ABS’가 포함되어있는 모든 차량의 모델명, 연식,옵션,
--  이미지, 입력일을 조회 하세요.
--  단, 출력은 가격의 오름차순으로 정렬 했을 때 4~8번째 레코드만 조회하세요.
--    입력일은 “월-일-년 분기”의 형식으로 출력합니다.

select model,car_year,car_option,car_img,to_char(hi, 'mm-dd-yyyy q')
from (select model,car_year,car_option, row_number() over(order by price) r,car_img,hiredate hi
	from car_model where car_option like '%ABS%'
	)
where r between 4 and 8;

--2.아래의 데이터를 입력 할 수 있는 테이블을 생성하고, 적합하다고 판단되는 컬럼에
-- primary key, foreign key를  부여하세요.
--  foreign key : dept테이블을 참조하여 키를 설정
--생성되는 테이블은 번호, 아이디, 이름, 나이, 부서번호, 전화번호, 우편번호, 주소를  저장할 수 있습니다.
create table users(
	user_num char(6),
  id varchar2(16) primary key,
  age number(3),
  deptno number(3),
  tel varchar2(16),
  add_num number(7),
  address varchar2(20),
  constraint fk_users_dept foreign key(deptno) references dept(deptno)
);

alter table users modify address varchar2(50);



--3.위의 테이블을 사용하여 제약사항을 만족하는 쿼리와 제약사항을 만족하지 않는
--모든 쿼리를 만들어 보세요.
--만족쿼리
insert into users values('U0001','Julie', 26,20,'010-1111-1111',06219,'서울시 강남구 역삼2동');
insert into users(user_num,id,age,tel,add_num) values('U0002','abc', 26,'010-1111-5678',019232);



--불만족 쿼리
insert into users values('U0003','Julie', 21,30,'010-1111-1252',06219,'경기도 안양시 부흥동');
insert into users values('U0003','', 23,10,'010-8746-1923',12049,'경기도 부천시');
insert into users(user_num,age) values('U0004', 26);
delete dept where deptno=10;
