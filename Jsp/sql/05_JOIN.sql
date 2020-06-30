--05 join
-- join 관계를 맺은 두 테이블을 엮어서 원하는 정보를 조회하는것
SELECT * FROM EMP;  --사원정보 테이블
SELECT * FROM DEPT; --부서정보 테이블

-- CROSS JOIN: 두 테이블의 모든 경우의 수를 조회하는 조인
SELECT * FROM EMP,DEPT;
SELECT ENAME,EMP.DEPTNO,DEPT.DEPTNO,DNAME FROM EMP, DEPT;
-- CROSS JOIN은 의미있는 데이터를 찾기 전에 모든 과정
-- CROSS JOIN자체로는 아무의미 없음
-- JOIN 결과가 의미를 가지기 위해서는 CROSS JOIN의 결과에 조건을 지정해야함

--EQUI JOIN : 동일 칼럼을 기준으로 조언
SELECT * FROM EMP, DEPT WHERE emp.deptno = DEPT.DEPTNO;

--EX: 이름이 MARTIN인 사람의 이름/부서명을 조회하고 싶을때
SELECT EMP.ENAME, DEPT.DNAME FROM EMP,DEPT WHERE EMP.DEPTNO=dept.deptno AND EMP.ENAME='MARTIN';

--연습 : 뉴욕에 근무하는 사원의 이름과 급여를 조회해 보세요
SELECT ENAME,SAL FROM EMP,DEPT WHERE emp.deptno = DEPT.DEPTNO AND DEPT.LOC='NEW YORK';

--연습: SALES 부서 소속인 사원들의 이름과 입사일을 조회
SELECT ENAME,HIREDATE FROM EMP,DEPT WHERE emp.deptno = DEPT.DEPTNO AND DEPT.DNAME='SALES';

-- 연습 : 직급이 MRG인 사원의 이름/부서번호/부서명/지역을 조회해 보세요
SELECT
    ENAME,E.DEPTNO,DNAME,LOC 
FROM 
    EMP E,DEPT D --쿼리가 길어질때에는 별칭정해줄수 있음
WHERE 
    E.deptno = D.DEPTNO 
AND 
    E.JOB='MANAGER';

--NON EQUI JOIN: 동일하지 않은 칼럼으로 두 테이블을 조인한다
SELECT * FROM SALGRADE;
SELECT EMP.*, G.GRADE FROM EMP, SALGRADE G WHERE EMP.SAL BETWEEN LOSAL AND HISAL;

--SELF JOIN: 테이블 하나로 조인하는것(자기 자신과 JOIN)
--EX: 사원들의 정보와 매니저 이름을 함께 조회하기
SELECT A.*,B.* FROM EMP A, EMP B;
-- A의 매니저 번호화 B의 직원번호가 일치한다면 B는A의 매니저이다
SELECT A.*, B.ENAME FROM EMP A,EMP B WHERE A.MGR=B.EMPNO;

--연습 1: 매니저가 KING인 사원들의 이름과 직급 출력
SELECT E.*, B.ENAME FROM EMP E, EMP B WHERE E.MGR=B.EMPNO AND B.ENAME='KING';

SELECT * FROM EMP;
--연습 2: ALLEN 과 동일한 근무지(DEPTNO)에서 근무하는 사원의 이름출력
SELECT * FROM EMP A,EMP B WHERE B.ENAME='ALLEN' AND A.DEPTNO=B.DEPTNO;

-- OUTER JOIN: 조건을 만족시키지 못해서 혹은 NULL 때문에 조회되지 않는 정보도 함께 조회하고 싶은 경우 사용
SELECT * FROM EMP A, EMP B WHERE A.MGR=B.EMPNO; --KING은 매니져가 없음으로 제외되어있음

-- JOIN 조건을 한번도 만족시키지 못해 한번도 등장하지 못 한 행을 (+)를 붙인 쪽에 NULL을 포함시켜 보여준다
--매니저가 없어서 조회되지 않는 행 추가
SELECT * FROM EMP A, EMP B WHERE A.MGR=B.EMPNO(+); 

--관리하는 사람이 없어서 조회되지 못하는 행
SELECT * FROM EMP A, EMP B WHERE A.MGR(+)=B.EMPNO; 

-- 연습: EMP테이블과 DEPT테이블을 조인하여 사원명, 부서번호, 부서명을 출력하고 사원이 한명도 존재하지 않는 부서의 정보도 출력
SELECT E.ENAME,E.DEPTNO,D.DEPTNO, D.DNAME FROM EMP E, DEPT D WHERE E.DEPTNO(+)=D.DEPTNO;
SELECT * FROM EMP,DEPT;

-- 미국표준에 따른 각 조인사용법
--1. CROSS JOIN
SELECT * FROM EMP;
SELECT * FROM DEPT;
SELECT * FROM EMP,DEPT WHERE EMP.DEPTNO=DEPT.DEPTNO;
SELECT * FROM EMP CROSS JOIN DEPT;  --ANSI

--2. INNER JOIN(EQUI JOIN,SELF, NON-EQUI)
SELECT * FROM EMP,DEPT WHERE EMP.DEPTNO=DEPT.DEPTNO;
SELECT * FROM EMP INNER JOIN DEPT ON EMP.DEPTNO=DEPT.DEPTNO; --ANSI
SELECT * FROM EMP INNER JOIN DEPT USING (DEPTNO); --ANSI
SELECT * FROM EMP A INNER JOIN EMP B ON A.MGR=B.EMPNO;  --ANSI SELF
SELECT * FROM EMP INNER JOIN SALGRADE ON SAL BETWEEN LOSAL AND HISAL;  --ANSI NON-EQUI

--3. NATURAL JOIN(똑같은 이름의 컬럼으로 INNER JOIN을 하는경우)
SELECT * FROM EMP NATURAL JOIN DEPT;

--4. OUTER JOIN (조건에 맞지 않는 행도 보여주는 JOIN==> LEFT/RIGHT/FULL)
--오른쪽 테이블에서 안나온 정보를 왼쪽 테이블에 (+)해서 보고싶을 때
SELECT * FROM EMP RIGHT OUTER JOIN DEPT USING(DEPTNO); 

-- 왼쪽 테이블에서 안나온 정보를 오른쪽 테이블에 (+)보고싶을 때
SELECT * FROM DEPT LEFT OUTER JOIN EMP USING(DEPTNO); 

-- FULL OUTER JOIN: 양쪽에 (+)를 다 붙이는 경우
SELECT * FROM EMP FULL OUTER JOIN DEPT USING(DEPTNO); 

--INNER JOIN: 조건이 맞는 결과 만 보겠다
SELECT * FROM EMP A INNER JOIN EMP B ON A.MGR=B.EMPNO;

--OUTER JOIN : 조건이 맞지 않는 결과도 보곘다
SELECT * FROM EMP A FULL OUTER JOIN EMP B ON A.MGR=B.EMPNO;
SELECT * FROM EMP A LEFT OUTER JOIN EMP B ON A.MGR=B.EMPNO;




