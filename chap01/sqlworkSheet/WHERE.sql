--WHERE문
SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID=50;
SELECT * FROM EMPLOYEES WHERE SALARY<5000;
SELECT * FROM employees WHERE NOT DEPARTMENT_ID=50;
SELECT * FROM employees WHERE DEPARTMENT_ID<>50;
SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID=50 OR department_id=80;
SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID IN(50,80,30);
SELECT * FROM EMPLOYEES WHERE NOT DEPARTMENT_ID IN(50,80,30);

SELECT * FROM EMPLOYEES;
--직무가 SH_CKERK, IT_PROG인 사람들의 사원번호,이름, 성, 직무를 출력
SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,JOB_ID FROM EMPLOYEES WHERE JOB_ID IN('SH_CLERK','IT_PROG');

SELECT * FROM EMPLOYEES WHERE SALARY BETWEEN 3000 AND 5000;
SELECT * FROM EMPLOYEES WHERE JOB_ID LIKE '%CLERK';
SELECT * FROM EMPLOYEES WHERE HIRE_DATE LIKE '03%';


--입사일이 5월이고
-- 급여가 5천보다 높은사람들의 
-- 사원번호, 이름, 성 급여, 입사일 조회
SELECT
    EMPLOYEE_ID, FIRST_NAME, LAST_NAME,SALARY, HIRE_DATE 
FROM 
    EMPLOYEES
WHERE 
HIRE_DATE LIKE '%/05/%'
AND
SALARY>5000;

--IN: 하나라도 같으면 끌어옴

-- 직무가 CLERK로 끝나는 사람들이 아닌 사람들 중
-- 부서번호가 30 또는 50번이고 입사년도가 05년도이상인 사람의 
-- 사원번호, 이름, 성 급여, 입사일 조회
SELECT 
    EMPLOYEE_ID, FIRST_NAME, LAST_NAME,SALARY, HIRE_DATE 
FROM 
    EMPLOYEES
WHERE 
    NOT JOB_ID LIKE '%CLERK' 
    AND DEPARTMENT_ID IN(30,50) 
    AND HIRE_DATE>'05/01/01';


--EMPLOYEES 에서 부서별 평균급여보다 많은사람
SELECT * FROM EMPLOYEES,DEPARTMENTS;
SELECT AVG(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID;

select department_id, avg(salary) from employees
group by department_id;

--서브쿼리; 
-- **위치에 따라서 단일 비교 연산자: =,<,>,사용시 단일행을 사용해야함 
-- ERROR : SELECT * FROM EMPLOYEES WHERE SALARY<(SELECT SALARY FROM EMPLOYEES WHERE FIRSTNAME="STEVEN");
-- ==>3명나옴
SELECT * FROM EMPLOYEES WHERE SALARY<(SELECT SALARY FROM EMPLOYEES WHERE EMPLOYEE_ID=108);
-- FROM 뒤에 나왔으니까 다중행 가능
SELECT * FROM (SELECT * FROM employees WHERE SALARY>5000);


SELECT * FROM EMPLOYEES WHERE SALARY < 
    ALL(SELECT SALARY FROM EMPLOYEES WHERE FIRST_NAME='STEVEN');

--입사일이 사원번호 157번보다 적은 사람들의 모든 속성조회
SELECT * FROM EMPLOYEES WHERE HIRE_DATE<(SELECT HIRE_DATE FROM EMPLOYEES WHERE EMPLOYEE_ID=157);

-- 직무가 사원번호 199번과 같은 사람들의 모든속성 조회
SELECT * FROM EMPLOYEES WHERE JOB_ID = (SELECT JOB_ID FROM EMPLOYEES WHERE EMPLOYEE_ID=199);


SELECT * FROM EMPLOYEES;
--입사일이 매니저가 100번인 사람들보다 모두 늦은 ㅁ사람들중
-- 급여가 FIRST_NAME이 NANCY인 사람보다 작은 사람들의 
--사원번호, 이름,급여, 입사일 , 매니저 번호 조회
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, HIRE_DATE, MANAGER_ID 
FROM EMPLOYEES 
WHERE HIRE_DATE> ALL(SELECT HIRE_DATE FROM EMPLOYEES WHERE MANAGER_ID=100)
AND SALARY< ALL(SELECT SALARY FROM EMPLOYEES WHERE FIRST_NAME='NANCY');

--급여가 직무가 IT-PROG인 사람들 모두 보다 큰사람들 중(FROM 절 작성)
--부서는 사원번호 140번과 동일하고 매니저는 사원번호 141번과 동일한 사람의 
--사원번호, 이름,급여, 직무,부서, 매니저 번호 조회
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, JOB_ID, DEPARTMENT_ID ,MANAGER_ID 
FROM EMPLOYEES 
WHERE SALARY<ALL(SELECT SALARY FROM EMPLOYEES WHERE JOB_ID ='IT-PROG')
;