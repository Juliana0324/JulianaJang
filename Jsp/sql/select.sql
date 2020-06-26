 --01_SELECT.sql
 
 -- SELECT��: �����͸� ��ȸ�Ҷ� ����ϴ� ������
 -- SELECT �÷��� FROM ���̺��
 
 /*
    ����: 
        ���ĸ�    Į�θ�      ����      �α⵵     ��       <- �÷���
        ������     500        5000      9.0      ����    <-COL   |   ROW
        Ƣ��      800        4000       9.5       ����           |
    �����ı�:
    ���ĸ�     ����      ��۳���
    ������     10.0      �����
    ������     8.0       ���ִ� ���������ž�
    
 
 */
 
 
 --���� ������ ������ �ִ� ������ �ִ� ���̺� Ȯ���ϱ�
 SELECT * FROM TAB; --���� SCOTT�� ���� ���̺� �̸��� : BONUS, DEPT, EMP, SALGRADE
 SELECT * FROM TABS;
 
  
 SELECT * FROM EMP;
 -- ���̺��� ������ ���캸��
 DESC EMP;
 --DESC :��������
 --ASC: ��������
 /*
    EMPNO   : �����ȣ
    ENAME   : �����
    JOB     : ����
    MGR     : �ش����� ���(�Ŵ���)�� �����ȣ
    HIREDATE: �Ի���
    SAL     : ����
    COMM    : ���ʽ�
    DEPNO   : ������ ���� �μ���ȣ
    
    NUMBER(4)   :���� 4�ڸ� ������ �� �ִ� Į��
    VARCHAR2(10): ���ڿ� �ִ���� 10�� ������ �� �ִ� Į��
    DATE : ��¥ �����͸� ������ �� �ִ� Į��
    NUMBER(7,2) : �Ҽ��� 2�ڸ��� 7�ڸ� �Ǽ� ���尡�� Į��
    NOT NULL : �ش��÷����� �� (NULL)�� ��� X
    
 
 */
 

 
 
 --���� SCOTT�� ���� ���̺� �̸��� : BONUS, DEPT, EMP, SALGRADE
SELECT * FROM BONUS;
SELECT * FROM DEPT;
SELECT * FROM EMP;
SELECT * FROM SALGRADE;

--�÷��� : ǥ ���� �ش��ϴ°�, *�� ����ϸ� ���̺� ���� ��礤 Į���� ���Ѵ�
SELECT * FROM EMP;
SELECT ENAME,JOB FROM EMP;
SELECT EMPNO,ENAME,SAL FROM emp;

--1. ����� ��� ������ ����ϴ� �������� �ۼ�
SELECT * FROM EMP;
--2. ����� �̸��� �޿��� �Ի� ���ڸ� ����ϴ� SQL��
SELECT ENAME,SAL,HIREDATE FROM EMP;

--SELECT�� �̿��� ��������ڻ��
SELECT SAL+1000 FROM EMP;
SELECT SAL-100 FROM EMP;
SELECT SAL*2 FROM EMP;
SELECT SAL/2 FROM EMP;

--�޿��� �������ϱ�(AS�� ��Ī ����)
SELECT ENAME, SAL*12 AS YEAR_SAL FROM EMP;

--���ʽ� ���
SELECT ENAME, SAL+COMM AS ���ʽ����Կ��� FROM EMP;
-- ���� �� NULL���� ����ϸ� NULL���� �ȴ�(NULL�� ?���� �˼����� ���� �ǹ�)

--NULL���� ���� �� �ִ� Į������ ����ϱ� (NULL VALUE)
SELECT ENAME, SAL + NVL(COMM,-100)AS WITH_BONUS FROM EMP;

-- �������ΰ�: �빮�� , ���������� ������ �ҹ���(�������)
SELECT ename AS �����, sal + NVL(COMM,0)AS "����(���ʽ�����)" FROM emp;
-- ��ȣ ����ϰ� �����ÿ� "(��)����ǥ" �ֵ���ǥ ���

--DB�� ��ҹ��� ����
-- ������: ��ҹ��� ���� X, SELECT, select �������
-- �÷���: ��ҹ��� ���� X, ENAME, ename �������
-- ������ : ��ҹ��� ���� O


-- SELECT DISTINCT : �ߺ��Ǵ� ���� �ѹ����� ����ϴ� Ű����
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO AS �μ���ȣ FROM EMP;
SELECT DISTINCT NVL(MGR,0) AS �Ŵ��� FROM EMP;
