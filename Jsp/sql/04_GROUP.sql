--04_GROUP
-- 그룹함수 : 하나 이상의 행을 그룹으로 묶어 연사할 수 있다;
--    SUM, AVC, COUNT,MAX, MIN....

--SUM함수로 급여의 총액 구하기
SELECT SUM(SAL) FROM EMP;

--보너스의 총액 구하기
SELECT SUM(COMM) FROM EMP;

-- AVG: 모든 급여의 평균 구하기
SELECT AVG(SAL) FROM EMP;

--MAX()로 최대 급여 구하기
SELECT MAX(SAL) FROM EMP;

--MIN()로 최대 급여 구하기
SELECT MIN(SAL) FROM EMP;

--COUNT(): 결과의 갯수를 계산해준다(NULL은 갯수에서 제외됨)
SELECT COUNT(*) FROM EMP;
SELECT COUNT(COMM) FROM EMP;

--COUNT 내부에 DISTINCT를 활용해 중복제외
SELECT COUNT(DISTINCT JOB) FROM EMP;
SELECT COUNT(COMM) AS "보너스 받는 사람" FROM EMP;

--가장 최근입사한 사원의 입사일과 가장 오래된 사원의 입사일을 출력해 보세요
SELECT 
    MAX(HIREDATE) AS "가장 최근 입사일", 
    MIN(HIREDATE) AS "가장 오래된 입사일"
FROM EMP;

-- 10번 부서중에 보너스를 받는 사원의 수를 구해보세요
SELECT COUNT(COMM) AS "30번 부서 보너스사원" FROM EMP WHERE DEPTNO=30 AND COMM<>0;


--GROUP BY절
-- 컬럼을 기준으로 그룹을 묶어 그룹별로 그룹함수를 적용하기 위한 문법
SELECT DEPTNO AS "부서",MAX(SAL) FROM EMP GROUP BY DEPTNO ORDER BY DEPTNO;
-- GROUP BY DEPTNO:: EMP테이블의 모든행을 DEPTNO기준으로 그룹을 짓는다
-- 그룹을 지으면 그룹을 지을때 사용했던 함수의 결과만 출력
-- 즉, 각 그룹별로 하나로 취합될 수 있는 결과만 GROUP BY와 함께 사용

SELECT DEPTNO,COUNT(COMM) FROM EMP GROUP BY DEPTNO;

--각 부서별 최대 월최대 월급을 구해보기
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO;

--각 직급별 최소 월급 구해보기
SELECT JOB, MIN(SAL), MAX(SAL),COUNT(COMM) FROM EMP GROUP BY JOB;

-- 연습문제: 소속부서별로 평균 급여를 구해보세요
SELECT DEPTNO, ROUND(AVG(SAL),2) AS "deptAvgSal" FROM EMP GROUP BY DEPTNO;

-- HAVING 절: GROUP BY의 결과에 조건을 부과하고 싶은경우에 사용
-- EX: 부서별 평균급여를 조회하되, 평균급여가 2000이상인 그룹만 조회하기
SELECT DEPTNO, ROUND(AVG(SAL),2) AS "부서" 
FROM EMP 
GROUP BY DEPTNO HAVING AVG(SAL)>=2000;

--연습문제: 부서별 최소월급을 출력하되, 최소 급여가 1000이하인 부서만 출력
SELECT DEPTNO, MIN(SAL) AS "DEPARTMENT" FROM EMP GROUP BY DEPTNO HAVING MIN(SAL)<=1000;

