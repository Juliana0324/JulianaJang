--JOIN.����
--EMPLOYEES ���� �μ��� ��ձ޿����� �������
SELECT B.* FROM EMPLOYEES A, EMPLOYEES B 
WHERE (SELECT AVG(SALARY) FROM EMPLOYEES GROUP BY A.DEPARTMENT_ID)>
(SELECT B.SALARY FROM EMPLOYEES GROUP BY B.DEPARTMENT_ID)
;
--������ Ǯ��
select * from employees e
join 
(SELECT department_id, avg(salary) as avg_salary FROM EMPLOYEES GROUP BY department_id) d
on e.department_id = d.department_id
where e.salary > d.avg_salary;


--�μ��� ���� �޿����� ������ ���� ���� �μ��� ��հ�
-- ���� ���� �޿� ���
SELECT MAX(ROUND(AVG(SALARY))) HIGHER_SAL, MIN(ROUND(AVG(SALARY))) LOWER_SAL FROM EMPLOYEES  
GROUP BY DEPARTMENT_ID;

SELECT * FROM DEPARTMENTS;

--ON(JOIN������ ����)
--���̺��� �������� �Ѵ� ����ִ� ���(EX. DEPARTMENT_ID) �ҷ��� �� �������� �ۼ�
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, E.DEPARTMENT_ID,DEPARTMENT_NAME, CITY
FROM EMPLOYEES E JOIN DEPARTMENTS D 
ON E.DEPARTMENT_ID=D.DEPARTMENT_ID
JOIN LOCATIONS L 
ON d.location_id=l.location_id
;

SELECT E.EMPLOYEE_ID,E.FIRST_NAME,E.LAST_NAME,E.MANAGER_ID FROM EMPLOYEES E 
JOIN EMPLOYEES M
ON E.MANAGER_ID=M.EMPLOYEE_ID;

--�Ŵ����� �������� :
-- DISTINCT ��ɾ�: �ߺ� �ɷ�����
SELECT EMPLOYEE_ID, FIRST_NAME||' '||LAST_NAME AS MANAGER_NAME FROM EMPLOYEES 
WHERE EMPLOYEE_ID IN
(SELECT DISTINCT MANAGER_ID FROM EMPLOYEES);


SELECT * FROM EMPLOYEES E 
LEFT JOIN
(
SELECT EMPLOYEE_ID AS MANAGER_ID, EMPLOYEE_ID, FIRST_NAME||' '||LAST_NAME AS MANAGER_NAME FROM EMPLOYEES 
WHERE EMPLOYEE_ID IN
(SELECT DISTINCT MANAGER_ID FROM EMPLOYEES)
) M
ON E.MANAGER_ID = M.MANAGER_ID;


--�μ����� ���� ��ձ޿����� ���� �޴� ��� ���
select * from employees e
join 
(SELECT department_id, avg(salary) as avg_salary FROM EMPLOYEES GROUP BY department_id) d
on e.department_id = d.department_id
where e.salary > d.avg_salary;