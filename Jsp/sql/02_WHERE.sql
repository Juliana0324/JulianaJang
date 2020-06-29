 --02.WHERE.sql
 
 -- where문: 데이터를 조회할때 조건을 지정
 -- select 컬럼 from 테이블 where조건;
 /*
    =: 같다
    !=, <>,^= : 다르다
    <,>,>=,<= : 비교
 */
 
 select * from emp;
 select * from emp where sal=1600;
 
 --월급이 1600이 아닌 직원조회(다르다)
 select * from emp where sal!=1600;
 select * from emp where sal<>1600;
 select * from emp where sal^=1600;

 --월급이 1600이 이상, 이하인사람
 select * from emp where sal<=1600;
 select * from emp where sal<1600;
 select * from emp where sal>1600;

--문자 혹은 날짜 데이터도 크기 비교가 가능
select * FROM EMP WHERE ENAME >= 'D';
SELECT * FROM EMP WHERE HIREDATE < '81/05/05';
--작다는 것은 더 오래됐다
SELECT * FROM EMP WHERE HIREDATE > '81/05/05';
--날짜가 더 크다는 것은 최신

--연습 문제 
--급여가 1500이하인 사원의 사원 번호/사원 이름/급여출력
SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL<=1500;

-- 사원이름이 "MARTIN"인 사원의 사원 번호 / 이름/ 급여출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE ENAME='MARTIN';

--AND, OR, NOT
SELECT * FROM EMP;
--급여가 1500이상이고 SALSEMAN인 사원조회
SELECT * FROM EMP WHERE SAL >= 1500 AND JOB ='SALESMAN';
--10번 부서에 속하지 않는 사람
SELECT * FROM EMP WHERE NOT DEPTNO = 10;

-- COLUMN BETWEEN A AND B
-- 급여가 2000이상이고 3000이하인 사원을 조회\
SELECT * FROM EMP WHERE SAL >=2000 AND SAL <= 3000;
SELECT * FROM EMP WHERE SAL BETWEEN 2000 AND 3000;

--이름이 A보다 크고 D보다 작은 사원 조회
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'D';

--IN (A,B,C..)
-- 급여가 800이거나 1600이거나 2850인 사원을 조회
SELECT * FROM EMP WHERE SAL =800 OR SAL=1600 OR SAL=2850;
SELECT * FROM EMP WHERE SAL IN(800,1600,2850);

-- 연습 문제
-- 사원번호가 7521이거나 7654이거나 7844인 사원들의 사원번호/이름/고용일을 조회
SELECT EMPNO,ENAME,HIREDATE FROM EMP WHERE EMPNO IN (7521,7654,7844);

-- 사원번호가 7521,7844도 아닌 사원을 조회
SELECT * FROM EMP WHERE EMPNO NOT IN(7521,7844,7654);

-- LIKE 연산자와 와일드 카드
--  _:하나의 문자가 아무 문자나 와도 됨
--  % : 하나 이상의 문자가 비어 있어도되고, 아무 문자나 와도됨

-- 이름에 E가 포함되는 사원을 조회
SELECT * FROM EMP WHERE ENAME LIKE '%E%';

-- 뒤에서 두번째 글자가 E인사원을 조회
SELECT * FROM EMP WHERE ENAME LIKE '%E_';

-- 앞에서 두번째 글자가 L인사원을 조회
SELECT * FROM EMP WHERE ENAME LIKE '_L%';

-- 앞에서 두세번째 글자가 L인 사원
SELECT * FROM EMP WHERE ENAME LIKE '__L%';

-- 연습문제: 
-- 이름이 K로 시작하는 사원의 사원번호/이름을 조회
SELECT EMPNO,ENAME FROM EMP WHERE ENAME LIKE 'K%'; 
-- 이름이 K가 포함된 사원의 사원번호/이름을 조회
SELECT EMPNO,ENAME FROM EMP WHERE ENAME LIKE '%K%';
-- 이름이 K로 끝나는 사원의 사원번호/이름을 조회
SELECT EMPNO,ENAME FROM EMP WHERE ENAME LIKE '%K';
-- 이름이 K가 없는사람
SELECT EMPNO,ENAME FROM EMP WHERE ENAME NOT LIKE '%K%';

-- 보너스가 NULL인사람을 조회
-- NULL은 비교연산자로 비교불가능
SELECT * FROM EMP WHERE COMM IS NULL; 

-- COMM이 NULL이 아닌 상황
SELECT * FROM EMP WHERE COMM IS NOT NULL;

SELECT * FROM EMP WHERE MGR IS NULL



