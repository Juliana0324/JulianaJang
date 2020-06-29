-- 03_ORDER_BY
-- ORDER BY��: SELECT�� ����� ���ϴ� �÷��� �������� ����
--  ASC : ASCENDING ��������= �������� �������´�
-- DESC : DESCENDING �������� = ū���� �������´�
--          ��������         /       ��������
--  ��¥:  �������� ��¥            �� �ֽ� ��¥
-- ����:      ������                   ū��
-- ����         A-Z                    Z-A
-- NULL    ���帶����������          �����������

-- ASC�� ��������
--(ORDERBY�� �⺻�� ASC)
SELECT * FROM EMP ORDER BY COMM;
SELECT * FROM EMP ORDER BY COMM DESC;
SELECT * FROM EMP ORDER BY sal;
SELECT * FROM EMP ORDER BY SAL DESC;

SELECT * FROM EMP ORDER BY HIREDATE ASC;
SELECT * FROM EMP ORDER BY HIREDATE DESC;
SELECT * FROM EMP ORDER BY ENAME ASC;
SELECT * FROM EMP ORDER BY ENAME DESC;

-- ���ı��� ������ ����
-- EX: �μ���ȣ ���� �������� �����μ�������� �̸������� ����
-- �������� ��, �����Ͱ� ���� �������
SELECT * FROM EMP ORDER BY DEPTNO ASC, ENAME ASC;

-- ��������: �����ȣ/����̸�/ ����/ �Ի����� �ֱ� �Ի��� ������� ���
SELECT EMPNO,ENAME,JOB,HIREDATE FROM EMP ORDER BY HIREDATE DESC;


-- ��������: ��� ��� ������ ���� ���� ������������ ����ϵ� ���� �����ΰ�� ������ ���� �޴� ������� �����Ͽ� ���
SELECT * FROM EMP ORDER BY JOB,SAL DESC;


