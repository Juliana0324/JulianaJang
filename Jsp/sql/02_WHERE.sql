 --02.WHERE.sql
 
 -- where��: �����͸� ��ȸ�Ҷ� ������ ����
 -- select �÷� from ���̺� where����;
 /*
    =: ����
    !=, <>,^= : �ٸ���
    <,>,>=,<= : ��
 */
 
 select * from emp;
 select * from emp where sal=1600;
 
 --������ 1600�� �ƴ� ������ȸ(�ٸ���)
 select * from emp where sal!=1600;
 select * from emp where sal<>1600;
 select * from emp where sal^=1600;

 --������ 1600�� �̻�, �����λ��
 select * from emp where sal<=1600;
 select * from emp where sal<1600;
 select * from emp where sal>1600;

--���� Ȥ�� ��¥ �����͵� ũ�� �񱳰� ����
select * FROM EMP WHERE ENAME >= 'D';
SELECT * FROM EMP WHERE HIREDATE < '81/05/05';
--�۴ٴ� ���� �� �����ƴ�
SELECT * FROM EMP WHERE HIREDATE > '81/05/05';
--��¥�� �� ũ�ٴ� ���� �ֽ�

--���� ���� 
--�޿��� 1500������ ����� ��� ��ȣ/��� �̸�/�޿����
SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL<=1500;

-- ����̸��� "MARTIN"�� ����� ��� ��ȣ / �̸�/ �޿����
SELECT EMPNO, ENAME, SAL FROM EMP WHERE ENAME='MARTIN';

--AND, OR, NOT
SELECT * FROM EMP;
--�޿��� 1500�̻��̰� SALSEMAN�� �����ȸ
SELECT * FROM EMP WHERE SAL >= 1500 AND JOB ='SALESMAN';
--10�� �μ��� ������ �ʴ� ���
SELECT * FROM EMP WHERE NOT DEPTNO = 10;

-- COLUMN BETWEEN A AND B
-- �޿��� 2000�̻��̰� 3000������ ����� ��ȸ\
SELECT * FROM EMP WHERE SAL >=2000 AND SAL <= 3000;
SELECT * FROM EMP WHERE SAL BETWEEN 2000 AND 3000;

--�̸��� A���� ũ�� D���� ���� ��� ��ȸ
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'D';

--IN (A,B,C..)
-- �޿��� 800�̰ų� 1600�̰ų� 2850�� ����� ��ȸ
SELECT * FROM EMP WHERE SAL =800 OR SAL=1600 OR SAL=2850;
SELECT * FROM EMP WHERE SAL IN(800,1600,2850);

-- ���� ����
-- �����ȣ�� 7521�̰ų� 7654�̰ų� 7844�� ������� �����ȣ/�̸�/������� ��ȸ
SELECT EMPNO,ENAME,HIREDATE FROM EMP WHERE EMPNO IN (7521,7654,7844);

-- �����ȣ�� 7521,7844�� �ƴ� ����� ��ȸ
SELECT * FROM EMP WHERE EMPNO NOT IN(7521,7844,7654);

-- LIKE �����ڿ� ���ϵ� ī��
--  _:�ϳ��� ���ڰ� �ƹ� ���ڳ� �͵� ��
--  % : �ϳ� �̻��� ���ڰ� ��� �־�ǰ�, �ƹ� ���ڳ� �͵���

-- �̸��� E�� ���ԵǴ� ����� ��ȸ
SELECT * FROM EMP WHERE ENAME LIKE '%E%';

-- �ڿ��� �ι�° ���ڰ� E�λ���� ��ȸ
SELECT * FROM EMP WHERE ENAME LIKE '%E_';

-- �տ��� �ι�° ���ڰ� L�λ���� ��ȸ
SELECT * FROM EMP WHERE ENAME LIKE '_L%';

-- �տ��� �μ���° ���ڰ� L�� ���
SELECT * FROM EMP WHERE ENAME LIKE '__L%';

-- ��������: 
-- �̸��� K�� �����ϴ� ����� �����ȣ/�̸��� ��ȸ
SELECT EMPNO,ENAME FROM EMP WHERE ENAME LIKE 'K%'; 
-- �̸��� K�� ���Ե� ����� �����ȣ/�̸��� ��ȸ
SELECT EMPNO,ENAME FROM EMP WHERE ENAME LIKE '%K%';
-- �̸��� K�� ������ ����� �����ȣ/�̸��� ��ȸ
SELECT EMPNO,ENAME FROM EMP WHERE ENAME LIKE '%K';
-- �̸��� K�� ���»��
SELECT EMPNO,ENAME FROM EMP WHERE ENAME NOT LIKE '%K%';

-- ���ʽ��� NULL�λ���� ��ȸ
-- NULL�� �񱳿����ڷ� �񱳺Ұ���
SELECT * FROM EMP WHERE COMM IS NULL; 

-- COMM�� NULL�� �ƴ� ��Ȳ
SELECT * FROM EMP WHERE COMM IS NOT NULL;

SELECT * FROM EMP WHERE MGR IS NULL



