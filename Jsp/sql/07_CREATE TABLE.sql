--07_CREATE TABLE

/* CREATE TABLE 테이블명(
        칼럼명1 칼럼타입(제약조건),
        칼럼명2 칼럼타입(제약조건),        
        칼럼명3 칼럼타입(제약조건),
        ...
    );
*/
-- 칼럼타입 종류
/*
    NUMBER(길이)  :정수 (EX: NUMBER(7)은 7자리 정수)
    NUMBER(길이, 소수점자리수)  :실수 (EX: NUMBER(7,2)는 정수 5자리, 소수 2자리)
    CHAR(크기): 고정 길이 문자 데이터. 입력된 자료 길이와 상관없이 정해진 길이를 차지 하는 타입, 잘사용 안함
    VARCHAR2(크기): 가변길이 문자 데이터, 실제 입력된 문자 길이 만큼만 공간을 차지 하는 타입
    DATE    :날짜 데이터를 저장할 수 있는 타입,
    TIMESTAMP   : 밀리 세컨드까지 저장가능 타입
        
*/
-- 테이블 생성 예: 회원 테이블
CREATE TABLE MY_MEMBER (
    MEM_NO NUMBER(10),
    MEM_NAME VARCHAR(20),
    MEM_AGE NUMBER(3),
    JOINDATE DATE DEFAULT SYSDATE 
    --DEFAULT : 기본값 설정
);
SELECT * FROM MY_MEMBER;

-- DROP TABLE : 테이블 삭제 명령어
DROP TABLE MY_MEMBER;

-- 기존 테이블 복사해서 생성(테스트용)
-- 제약조선도 함께 복사되지는 않는다(NOT NULL같은 것)
SELECT * FROM EMP02;
CREATE TABLE EMP02 AS SELECT * FROM EMP WHERE DEPTNO IN (20,30);
CREATE TABLE EMP03 AS SELECT EMPNO, ENAME, SAL FROM EMP;
SELECT * FROM EMP03;

SELECT * FROM MY_MEMBER;
--테이블 칼럼 수정명령어
--ALTER TABLE 테이블명[ADD|MODIFY|DROP COLUMN] (칼럼명1, 칼럼명2,...),

--ADD : 칼럼추가
ALTER TABLE MY_MEMBER ADD(TEST NUMBER(5));
ALTER TABLE MY_MEMBER ADD(TEST2 NUMBER(5),TEST3 VARCHAR(50));

--MODIFY : 칼럼 타입 변경(칼럼명 수정은 X)
ALTER TABLE MY_MEMBER MODIFY (TEST NUMBER(7));
ALTER TABLE MY_MEMBER MODIFY (TEST DATE);

--DROP COLUMN: 칼럼 삭제==> 드랍컬럼시 위험요소 높음
ALTER TABLE MY_MEMBER DROP COLUMN TEST;
ALTER TABLE MY_MEMBER DROP COLUMN TEST2;
ALTER TABLE MY_MEMBER DROP COLUMN TEST3;

-- SET UNUSED: 칼럼을 삭제하는 대신 잠깐 사용하지 않게 설정하기
ALTER TABLE MY_MEMBER SET UNUSED(TEST);
ALTER TABLE MY_MEMBER SET UNUSED(TEST2);
ALTER TABLE MY_MEMBER SET UNUSED(TEST3);
--여유있는 시간에 UNUSED처리된 칼럼들을 삭제한다
ALTER TABLE MY_MEMBER DROP UNUSED COLUMNS;


--메타데이터: 데이터에 대한 데이터(테이블 정보, 칼럼 정보,,)
-- 우리가 관리 하지 않고 DB가 알아서 관리하는 테이블
SELECT * FROM TABS; 
SELECT * FROM USER_TABLES;      --유저 테이블 정보
SELECT * FROM USER_SEQUENCES;   --유저 시퀸스 정보
SELECT * FROM USER_INDEXES;     --유저 인덱스 정보
SELECT * FROM USER_CONSTRAINTS; --유저 제약조건 정보

SELECT * FROM TABS; 
SELECT * FROM ALL_TABLES;      --모든 테이블 정보
SELECT * FROM ALL_SEQUENCES;   --모든 시퀸스 정보
SELECT * FROM ALL_INDEXES;     --모든 인덱스 정보
SELECT * FROM ALL_CONSTRAINTS; --모든 제약조건 정보

SHOW USER;
--현재유저가 누구 인지 구경

DESC MY_MEMBER;

-- 숙제: 테이블 짜오기
