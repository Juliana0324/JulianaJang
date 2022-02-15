select empno,ename,sal,comm from emp;

--총수령액은 연봉와 보너스를 합산한 금액
--null은 연산되면 null로 나옴
select empno,ename,sal,comm,comm+sal from emp;

-- 1.아래 제시되는 정보를 확인하여 학생정보를 저장할 테이블을 생성하세요.
/*
번호 : 숫자 (0~99999)의 번호가 입력됩니다.
이름 : 한글로 10자까지 입력됩니다.
클래스 : 영어로 1자 입력됩니다.
이메일 : 영어로 최대 50자까지  입력됩니다.
전화번호 : 숫자와 '-'으로 구성되며 13자까지 입력됩니다.
주소 :  한글로 80자까지 입력됩니다.
성별 : 남자 여자와 같은 한글로된 성별이 입력됩니다.
자바점수 : 숫자(0~999)까지의 수가 입력될 수 있습니다.
입력일 : 날짜형식으로 입력됩니다.
*/
create table student(
	snum number(5),
	sname varchar(10),
	sclass char(1),
	semail varchar(50),
	sphnum varchar(13),
	address varchar(255),
	gender varchar(10),
	javascore number(3),
	input_date date
);

SELECT * FROM STUDENT;
/*
2. 아래의 정보를 1번에서 생성된 테이블에 추가하세요.
 Transaction이 쿼리문 하나로 구성된다. ( 각각 insert를 수행 한 후 commit을 해야한다. )
 1, 신유철, A, yu@sist.co.kr, 010-1234-5678,경기도 용인시, 남자, 91, 현재일자
 2, 김현우, A, kim@daum.net,010-7739-9761,서울시 강남구 역삼1동, 남자, 90, 현재일자
 3, 전민정,A, jeon@test.com,010-5878,8813,서울시 동작구 상도동, 여자,97,현재일자
 4, 황성준, B, jun@google.com,011-234-7611,서울시  동대문구 동대문동, 여자, 190, 현재일자
 5, 최연이, B, choi@sist.co.kr,010-4334-7656,인천시 부평구 부평3동, 여자, 89, 현재일자
*/

INSERT INTO STUDENT VALUES(1, '신유철', 'A', 'yu@sist.co.kr', '010-1234-5678','경기도 용인시','남자', 91,SYSDATE);
COMMIT;
INSERT INTO STUDENT VALUES(2, '김현우', 'A', 'kim@daum.net', '010-7739-9761','서울시 강남구 역삼1동','남자', 90,SYSDATE);
COMMIT;

INSERT INTO STUDENT VALUES(3, '전민정','A', 'jeon@test.com','010-5878,8813','서울시 동작구 상도동', '여자',97,sysdate);
COMMIT;
INSERT INTO STUDENT(SNUM, SNAME,SCLASS,SEMAIL,SPHNUM,ADDRESS,GENDER, JAVASCORE,INPUT_DATE) VALUES(4, '황성준', 'B', 'jun@google.com','011-234-7611','서울시  동대문구 동대문동', '여자', 190, sysdate);
COMMIT;
INSERT INTO STUDENT(SNUM, SNAME,SCLASS,SEMAIL,SPHNUM,ADDRESS,GENDER, JAVASCORE,INPUT_DATE) VALUES(5, '최연이', 'B', 'choi@sist.co.kr','010-4334-7656','인천시 부평구 부평3동', '여자', 89, sysdate);
COMMIT;

--3. 1번에서 생성된 테이블을 사용하여 모든레코드와 모든 컬럼을 조회하세요.
select * from student;

--4. 1번에서 생성된 테이블을 사용하여 이름,반, 주소, 자바점수를 조회하세요.
select sname, sclass,address,javascore from student;

--5. 4번 학생의 성별을 남자로 점수를 90점으로 반을 A, 전화번호를 010-2234-7611으로 변경해주세요.
update student set gender='남자',javascore=90, sclass='A',sphnum='010-2234-7611' where snum=4;
commit;

--6.  이름이 '황성준'이면서 반이 B반인 학생의 반을 A반, 전화번호를 010-1111-2341 로 변경해주세요.
update student set sphnum='010-1111-2341', sclass='A' where sname like '황%' and sclass='B';
commit;

-- 7.  반이 A반인 학생을 모두 삭제해보세요.
delete from student where sclass='A';

--8. 7번에서 삭제한 레코드를 모두 복구해 보세요.
rollback;

--9. 테이블 자체를 삭제해 보세요.
drop table student;

--9. 휴지통을 확인하고, 휴지통에 버려진 테이블을 복구해보세요.
show recyclebin;
flashback table "BIN$dAtXn71yS4WqYcu17bXqVg==$0" to before drop;

-- 10. 테이블의 모든 레코드를 절삭해보세요.
select * from student;
-- 11. 테이블자체를 삭제 해보세요.
truncate table student;

--12. 휴지통의 내용을 확인하고, 휴지통을 비워보세요.
drop table student;
show recyclebin;
purge recyclebin;
