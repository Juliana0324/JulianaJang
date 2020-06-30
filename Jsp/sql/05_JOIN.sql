--05 join
-- join ���踦 ���� �� ���̺��� ��� ���ϴ� ������ ��ȸ�ϴ°�
SELECT * FROM EMP;  --������� ���̺�
SELECT * FROM DEPT; --�μ����� ���̺�

-- CROSS JOIN: �� ���̺��� ��� ����� ���� ��ȸ�ϴ� ����
SELECT * FROM EMP,DEPT;
SELECT ENAME,EMP.DEPTNO,DEPT.DEPTNO,DNAME FROM EMP, DEPT;
-- CROSS JOIN�� �ǹ��ִ� �����͸� ã�� ���� ��� ����
-- CROSS JOIN��ü�δ� �ƹ��ǹ� ����
-- JOIN ����� �ǹ̸� ������ ���ؼ��� CROSS JOIN�� ����� ������ �����ؾ���

--EQUI JOIN : ���� Į���� �������� ����
SELECT * FROM EMP, DEPT WHERE emp.deptno = DEPT.DEPTNO;

--EX: �̸��� MARTIN�� ����� �̸�/�μ����� ��ȸ�ϰ� ������
SELECT EMP.ENAME, DEPT.DNAME FROM EMP,DEPT WHERE EMP.DEPTNO=dept.deptno AND EMP.ENAME='MARTIN';

--���� : ���忡 �ٹ��ϴ� ����� �̸��� �޿��� ��ȸ�� ������
SELECT ENAME,SAL FROM EMP,DEPT WHERE emp.deptno = DEPT.DEPTNO AND DEPT.LOC='NEW YORK';

--����: SALES �μ� �Ҽ��� ������� �̸��� �Ի����� ��ȸ
SELECT ENAME,HIREDATE FROM EMP,DEPT WHERE emp.deptno = DEPT.DEPTNO AND DEPT.DNAME='SALES';

-- ���� : ������ MRG�� ����� �̸�/�μ���ȣ/�μ���/������ ��ȸ�� ������
SELECT
    ENAME,E.DEPTNO,DNAME,LOC 
FROM 
    EMP E,DEPT D --������ ����������� ��Ī�����ټ� ����
WHERE 
    E.deptno = D.DEPTNO 
AND 
    E.JOB='MANAGER';

--NON EQUI JOIN: �������� ���� Į������ �� ���̺��� �����Ѵ�
SELECT * FROM SALGRADE;
SELECT EMP.*, G.GRADE FROM EMP, SALGRADE G WHERE EMP.SAL BETWEEN LOSAL AND HISAL;

--SELF JOIN: ���̺� �ϳ��� �����ϴ°�(�ڱ� �ڽŰ� JOIN)
--EX: ������� ������ �Ŵ��� �̸��� �Բ� ��ȸ�ϱ�
SELECT A.*,B.* FROM EMP A, EMP B;
-- A�� �Ŵ��� ��ȣȭ B�� ������ȣ�� ��ġ�Ѵٸ� B��A�� �Ŵ����̴�
SELECT A.*, B.ENAME FROM EMP A,EMP B WHERE A.MGR=B.EMPNO;

--���� 1: �Ŵ����� KING�� ������� �̸��� ���� ���
SELECT E.*, B.ENAME FROM EMP E, EMP B WHERE E.MGR=B.EMPNO AND B.ENAME='KING';

SELECT * FROM EMP;
--���� 2: ALLEN �� ������ �ٹ���(DEPTNO)���� �ٹ��ϴ� ����� �̸����
SELECT * FROM EMP A,EMP B WHERE B.ENAME='ALLEN' AND A.DEPTNO=B.DEPTNO;

-- OUTER JOIN: ������ ������Ű�� ���ؼ� Ȥ�� NULL ������ ��ȸ���� �ʴ� ������ �Բ� ��ȸ�ϰ� ���� ��� ���
SELECT * FROM EMP A, EMP B WHERE A.MGR=B.EMPNO; --KING�� �Ŵ����� �������� ���ܵǾ�����

-- JOIN ������ �ѹ��� ������Ű�� ���� �ѹ��� �������� �� �� ���� (+)�� ���� �ʿ� NULL�� ���Խ��� �����ش�
--�Ŵ����� ��� ��ȸ���� �ʴ� �� �߰�
SELECT * FROM EMP A, EMP B WHERE A.MGR=B.EMPNO(+); 

--�����ϴ� ����� ��� ��ȸ���� ���ϴ� ��
SELECT * FROM EMP A, EMP B WHERE A.MGR(+)=B.EMPNO; 

-- ����: EMP���̺�� DEPT���̺��� �����Ͽ� �����, �μ���ȣ, �μ����� ����ϰ� ����� �Ѹ� �������� �ʴ� �μ��� ������ ���
SELECT E.ENAME,E.DEPTNO,D.DEPTNO, D.DNAME FROM EMP E, DEPT D WHERE E.DEPTNO(+)=D.DEPTNO;
SELECT * FROM EMP,DEPT;

-- �̱�ǥ�ؿ� ���� �� ���λ���
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

--3. NATURAL JOIN(�Ȱ��� �̸��� �÷����� INNER JOIN�� �ϴ°��)
SELECT * FROM EMP NATURAL JOIN DEPT;

--4. OUTER JOIN (���ǿ� ���� �ʴ� �൵ �����ִ� JOIN==> LEFT/RIGHT/FULL)
--������ ���̺��� �ȳ��� ������ ���� ���̺� (+)�ؼ� ������� ��
SELECT * FROM EMP RIGHT OUTER JOIN DEPT USING(DEPTNO); 

-- ���� ���̺��� �ȳ��� ������ ������ ���̺� (+)������� ��
SELECT * FROM DEPT LEFT OUTER JOIN EMP USING(DEPTNO); 

-- FULL OUTER JOIN: ���ʿ� (+)�� �� ���̴� ���
SELECT * FROM EMP FULL OUTER JOIN DEPT USING(DEPTNO); 

--INNER JOIN: ������ �´� ��� �� ���ڴ�
SELECT * FROM EMP A INNER JOIN EMP B ON A.MGR=B.EMPNO;

--OUTER JOIN : ������ ���� �ʴ� ����� ���ٴ�
SELECT * FROM EMP A FULL OUTER JOIN EMP B ON A.MGR=B.EMPNO;
SELECT * FROM EMP A LEFT OUTER JOIN EMP B ON A.MGR=B.EMPNO;




