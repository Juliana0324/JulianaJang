--04_GROUP
-- �׷��Լ� : �ϳ� �̻��� ���� �׷����� ���� ������ �� �ִ�;
--    SUM, AVC, COUNT,MAX, MIN....

--SUM�Լ��� �޿��� �Ѿ� ���ϱ�
SELECT SUM(SAL) FROM EMP;

--���ʽ��� �Ѿ� ���ϱ�
SELECT SUM(COMM) FROM EMP;

-- AVG: ��� �޿��� ��� ���ϱ�
SELECT AVG(SAL) FROM EMP;

--MAX()�� �ִ� �޿� ���ϱ�
SELECT MAX(SAL) FROM EMP;

--MIN()�� �ִ� �޿� ���ϱ�
SELECT MIN(SAL) FROM EMP;

--COUNT(): ����� ������ ������ش�(NULL�� �������� ���ܵ�)
SELECT COUNT(*) FROM EMP;
SELECT COUNT(COMM) FROM EMP;

--COUNT ���ο� DISTINCT�� Ȱ���� �ߺ�����
SELECT COUNT(DISTINCT JOB) FROM EMP;
SELECT COUNT(COMM) AS "���ʽ� �޴� ���" FROM EMP;

--���� �ֱ��Ի��� ����� �Ի��ϰ� ���� ������ ����� �Ի����� ����� ������
SELECT 
    MAX(HIREDATE) AS "���� �ֱ� �Ի���", 
    MIN(HIREDATE) AS "���� ������ �Ի���"
FROM EMP;

-- 10�� �μ��߿� ���ʽ��� �޴� ����� ���� ���غ�����
SELECT COUNT(COMM) AS "30�� �μ� ���ʽ����" FROM EMP WHERE DEPTNO=30 AND COMM<>0;


--GROUP BY��
-- �÷��� �������� �׷��� ���� �׷캰�� �׷��Լ��� �����ϱ� ���� ����
SELECT DEPTNO AS "�μ�",MAX(SAL) FROM EMP GROUP BY DEPTNO ORDER BY DEPTNO;
-- GROUP BY DEPTNO:: EMP���̺��� ������� DEPTNO�������� �׷��� ���´�
-- �׷��� ������ �׷��� ������ ����ߴ� �Լ��� ����� ���
-- ��, �� �׷캰�� �ϳ��� ���յ� �� �ִ� ����� GROUP BY�� �Բ� ���

SELECT DEPTNO,COUNT(COMM) FROM EMP GROUP BY DEPTNO;

--�� �μ��� �ִ� ���ִ� ������ ���غ���
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO;

--�� ���޺� �ּ� ���� ���غ���
SELECT JOB, MIN(SAL), MAX(SAL),COUNT(COMM) FROM EMP GROUP BY JOB;

-- ��������: �ҼӺμ����� ��� �޿��� ���غ�����
SELECT DEPTNO, ROUND(AVG(SAL),2) AS "deptAvgSal" FROM EMP GROUP BY DEPTNO;

-- HAVING ��: GROUP BY�� ����� ������ �ΰ��ϰ� ������쿡 ���
-- EX: �μ��� ��ձ޿��� ��ȸ�ϵ�, ��ձ޿��� 2000�̻��� �׷츸 ��ȸ�ϱ�
SELECT DEPTNO, ROUND(AVG(SAL),2) AS "�μ�" 
FROM EMP 
GROUP BY DEPTNO HAVING AVG(SAL)>=2000;

--��������: �μ��� �ּҿ����� ����ϵ�, �ּ� �޿��� 1000������ �μ��� ���
SELECT DEPTNO, MIN(SAL) AS "DEPARTMENT" FROM EMP GROUP BY DEPTNO HAVING MIN(SAL)<=1000;

