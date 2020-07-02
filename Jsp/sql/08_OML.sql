-- DDL (DATA DEFINITION LANGUAGE)
-- DML(DATA MANIPULATION LANGUAGE)
-- CRUD:모든 프로그램에 존재하는 필수적인 기능
-- CREATE : 데이터 생성(INSERT)
-- READ: 데이터 조회(SELECT)
-- UPDATE: 데이터 수정(UPDATE)
-- DELETE: 데이터 삭제

--INSERT : 테이블의 새로운 데이터 생성(추가, 삽입)



INSERT INTO MY_MEMBER(MEM_NO,MEM_NAME, MEM_AGE,JOINDATE) VALUES (10,'홍길동',20,'09/11/20');
--칼럼의 순서가 바뀌면 VALUE의 순서도 변경되어야 한다
INSERT INTO MY_MEMBER(MEM_NAME, MEM_AGE,JOINDATE,MEM_NO) VALUES('테스트1',13,'19/05/04',2);

--모든칼럼을 순서대로 추가할때는 칼럼명을 생략해도된다
INSERT INTO MY_MEMBER VALUES (3,'테스트2',15,'13/07/07');

-- NOT NULL로 설정된 칼럼이 아니라면 값을 넣지 않을 수 있다
-- (칼럼의 개수와 VALUE)의 갯수가 차이나면 에러 발생
INSERT INTO MY_MEMBER(MEM_NO, MEM_NAME) VALUES (4,'테스트3');
INSERT INTO MY_MEMBER(MEM_NO, MEM_NAME,MEM_AGE) VALUES (4,'테스트4',9);
--누락된 칼럼은 자동으로 NULL이 생성
--원한다면 NULL값 대입가능
INSERT INTO MY_MEMBER(MEM_NO,MEM_NAME) VALUES (NULL,'TEST01');
-- '' 붙여서 대입하면 NULL값 됨
INSERT INTO MY_MEMBER(MEM_NO,MEM_NAME) VALUES (7,'');
SELECT * FROM MY_MEMBER;

--서브쿼리로 데이터 추가하기(테스트에 많이 사용됨)
INSERT INTO MY_MEMBER SELECT * FROM MY_MEMBER;

--UPDATE : 이미 존재하는 값을 변경 및 수정
-- UPDATE 테이블 명 SET 칼럼1 = VALUE1, 칼럼2= VALUE2, ... WHERE 조건
-- 조건을 설정하지 않으면 모든행이 수정된다
COMMIT; --현재까지 DM;로 인해 수정된 테이블 상황을 확정짓는다
select * from my_member;
UPDATE MY_MEMBER SET MEM_NAME='고길동', MEM_NO=10, MEM_AGE=45,JOINDATE='08/11/30';
rollback;
UPDATE MY_MEMBER SET MEM_NAME='고길동' WHERE MEM_NAME='홍길동';

-- 테이블에는 하나의 행(ROW)를 차별할수있는 칼럼이 필요
-- 그런칼럼이 없다면, 같은값을 지닌 모든행이 수정되거나 삭제되어 버린다
-- 테이블의 하나의 행을 유일하게 식별해 줄수 있는 칼럼을 기본키라고 부른다(PRIMARY KEY/PK)

--기본키가 되기 위한 조건: 
    -- 1. 중복 없어야함(UNIQUE)
    -- 2. NULL이 없어야함(NOT NULL)
    
--KEY의 종류
--      슈퍼키: KEY가 될수 있는 모든 칼럼의 조합(이름+이메일),(이메일), (이름+전화번호)
--          가능성을 모두 따져본다
--      복합키: 2개 이상의 칼럼을 사용한 키
--      후보키: 기본키가 될 수 있는 후보인 컬럼
--      기본키: 후보키 중에서 선택된 키
--      FOREIGN KEY(외래키): 다른테이블에서는 기본키(혹은 유일성-UNIQUE만 만족) 이지만 
--                          이 테이블에서는 중복을 허용하는컬럼, 다른 테이블의 기본키 컬럼을 반드시 참조해야 한다
--      EX: EMP테이블에서 DEPTNO: 외래키, DEPT에서는 DEPTNO: 기본키
--          EMP테이블에서 새로운 행을 추가할때 , DEPT테이블의 DEPTNO에 없는 부서번호는 사용할  수 없다


--1. EMP테이블을 복사하여 EMP02 테이블 생성
CREATE TABLE EMP02 AS SELECT * FROM EMP;
SELECT * FROM EMP02;
--2. 부서번호가 10번인 사원들의 부서번호를 40번으로 수정
UPDATE EMP02 SET DEPTNO='40' WHERE DEPTNO='10';
-- 3. 급여가 3000이상인 사원들의 급여를 10% 인상
UPDATE EMP02 SET SAL=SAL+(SAL*0.1) WHERE SAL>=3000;
-- 4. **1981년에 입사한 사원들의 입사일을 오늘로 수정
UPDATE EMP02 SET HIREDATE=SYSDATE WHERE HIREDATE LIKE '81%';

COMMIT;

-- DELETE : 테이블 데이터(행) 삭제
-- DELETE FROM 테이블명 WHERE 조건;
-- *** 조건을 지정하지 않으면 모든 행이 삭제 됨
DELETE FROM EMP02;
SELECT * FROM EMP02;

--EMP02 테이블에서 COMM을 받지 않는 사원을 삭제
DELETE FROM EMP02 WHERE COMM IS NULL;
DELETE FROM EMP02 WHERE COMM<=0;
ROLLBACK;


