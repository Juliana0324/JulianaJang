-- 03_ORDER_BY
-- ORDER BY절: SELECT의 결과를 원하는 컬럼의 기준으로 정렬
--  ASC : ASCENDING 오름차순= 작은값이 먼저나온다
-- DESC : DESCENDING 내림차순 = 큰값이 먼저나온다
--          오름차순         /       내림차순
--  날짜:  더오래된 날짜            더 최신 날짜
-- 숫자:      작은값                   큰값
-- 문자         A-Z                    Z-A
-- NULL    가장마지막에나옴          가장먼저나옴

-- ASC는 생략가능
--(ORDERBY의 기본은 ASC)
SELECT * FROM EMP ORDER BY COMM;
SELECT * FROM EMP ORDER BY COMM DESC;
SELECT * FROM EMP ORDER BY sal;
SELECT * FROM EMP ORDER BY SAL DESC;

SELECT * FROM EMP ORDER BY HIREDATE ASC;
SELECT * FROM EMP ORDER BY HIREDATE DESC;
SELECT * FROM EMP ORDER BY ENAME ASC;
SELECT * FROM EMP ORDER BY ENAME DESC;

-- 정렬기준 여러개 가능
-- EX: 부서번호 기준 정렬한후 같은부서사람들은 이름순으로 정렬
-- 순서정할 때, 데이터가 많은 순서대로
SELECT * FROM EMP ORDER BY DEPTNO ASC, ENAME ASC;

-- 연습문제: 사원번호/사원이름/ 직급/ 입사일을 최근 입사한 순서대로 출력
SELECT EMPNO,ENAME,JOB,HIREDATE FROM EMP ORDER BY HIREDATE DESC;


-- 연습문제: 모든 사원 정보를 직급 가준 오름차순으로 출력하되 같은 직급인경우 월급을 많이 받는 순서대로 정렬하여 출력
SELECT * FROM EMP ORDER BY JOB,SAL DESC;


