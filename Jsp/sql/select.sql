 --01_SELECT.sql
 
 -- SELECT문: 데이터를 조회할때 사용하는 쿼리문
 -- SELECT 컬럼명 FROM 테이블명
 
 /*
    음식: 
        음식명    칼로리      가격      인기도     양       <- 컬럼명
        떡볶이     500        5000      9.0      적당    <-COL   |   ROW
        튀김      800        4000       9.5       적음           |
    음식후기:
    음식명     점수      댓글내용
    떡볶이     10.0      배고파
    떡볶이     8.0       좀있다 먹으러갈거야
    
 
 */
 
 
 --현재 계정이 가지고 있는 가지고 있는 테이블 확인하기
 SELECT * FROM TAB; --현재 SCOTT이 가진 테이블 이름은 : BONUS, DEPT, EMP, SALGRADE
 SELECT * FROM TABS;
 
  
 SELECT * FROM EMP;
 -- 테이블의 구조를 살펴보기
 DESC EMP;
 --DESC :내림차순
 --ASC: 오름차순
 /*
    EMPNO   : 사원번호
    ENAME   : 사원명
    JOB     : 직급
    MGR     : 해당직원 상사(매니저)의 사원번호
    HIREDATE: 입사일
    SAL     : 월급
    COMM    : 보너스
    DEPNO   : 직원이 속한 부서번호
    
    NUMBER(4)   :정수 4자리 저장할 수 있는 칼럼
    VARCHAR2(10): 문자열 최대길이 10을 저장할 수 있는 칼럼
    DATE : 날짜 데이터를 저장할 수 있는 칼럼
    NUMBER(7,2) : 소수점 2자리인 7자리 실수 저장가능 칼럼
    NOT NULL : 해당컬럼에는 빈값 (NULL)이 허용 X
    
 
 */
 

 
 
 --현재 SCOTT이 가진 테이블 이름은 : BONUS, DEPT, EMP, SALGRADE
SELECT * FROM BONUS;
SELECT * FROM DEPT;
SELECT * FROM EMP;
SELECT * FROM SALGRADE;

--컬럼명 : 표 제목에 해당하는것, *를 사용하면 테이블 내의 모든ㄴ 칼럼을 뜻한다
SELECT * FROM EMP;
SELECT ENAME,JOB FROM EMP;
SELECT EMPNO,ENAME,SAL FROM emp;

--1. 사원의 모든 정보를 출력하는 쿼리문을 작성
SELECT * FROM EMP;
--2. 사원의 이름과 급여와 입사 일자만 출력하는 SQL문
SELECT ENAME,SAL,HIREDATE FROM EMP;

--SELECT를 이용해 산술연산자사용
SELECT SAL+1000 FROM EMP;
SELECT SAL-100 FROM EMP;
SELECT SAL*2 FROM EMP;
SELECT SAL/2 FROM EMP;

--급여로 연봉구하기(AS로 별칭 지정)
SELECT ENAME, SAL*12 AS YEAR_SAL FROM EMP;

--보너스 계산
SELECT ENAME, SAL+COMM AS 보너스포함연봉 FROM EMP;
-- 숫자 와 NULL값을 계산하면 NULL값이 된다(NULL은 ?같은 알수없는 값을 의미)

--NULL값이 나올 수 있는 칼럼으로 계산하기 (NULL VALUE)
SELECT ENAME, SAL + NVL(COMM,-100)AS WITH_BONUS FROM EMP;

-- 문법적인것: 대문자 , 문법적이지 않은것 소문자(권장사항)
SELECT ename AS 사원명, sal + NVL(COMM,0)AS "연봉(보너스포함)" FROM emp;
-- 괄호 사용하고 싶을시에 "(쌍)따옴표" 쌍따옴표 사용

--DB의 대소문자 구분
-- 쿼리문: 대소문자 구분 X, SELECT, select 상관없음
-- 컬럼명: 대소문자 구분 X, ENAME, ename 상관없음
-- 데이터 : 대소문자 구분 O


-- SELECT DISTINCT : 중복되는 것을 한번씩만 출력하는 키워드
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO AS 부서번호 FROM EMP;
SELECT DISTINCT NVL(MGR,0) AS 매니저 FROM EMP;
