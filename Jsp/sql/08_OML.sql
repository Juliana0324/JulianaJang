-- DDL (DATA DEFINITION LANGUAGE)
-- DML(DATA MANIPULATION LANGUAGE)
-- CRUD:��� ���α׷��� �����ϴ� �ʼ����� ���
-- CREATE : ������ ����(INSERT)
-- READ: ������ ��ȸ(SELECT)
-- UPDATE: ������ ����(UPDATE)
-- DELETE: ������ ����

--INSERT : ���̺��� ���ο� ������ ����(�߰�, ����)



INSERT INTO MY_MEMBER(MEM_NO,MEM_NAME, MEM_AGE,JOINDATE) VALUES (10,'ȫ�浿',20,'09/11/20');
--Į���� ������ �ٲ�� VALUE�� ������ ����Ǿ�� �Ѵ�
INSERT INTO MY_MEMBER(MEM_NAME, MEM_AGE,JOINDATE,MEM_NO) VALUES('�׽�Ʈ1',13,'19/05/04',2);

--���Į���� ������� �߰��Ҷ��� Į������ �����ص��ȴ�
INSERT INTO MY_MEMBER VALUES (3,'�׽�Ʈ2',15,'13/07/07');

-- NOT NULL�� ������ Į���� �ƴ϶�� ���� ���� ���� �� �ִ�
-- (Į���� ������ VALUE)�� ������ ���̳��� ���� �߻�
INSERT INTO MY_MEMBER(MEM_NO, MEM_NAME) VALUES (4,'�׽�Ʈ3');
INSERT INTO MY_MEMBER(MEM_NO, MEM_NAME,MEM_AGE) VALUES (4,'�׽�Ʈ4',9);
--������ Į���� �ڵ����� NULL�� ����
--���Ѵٸ� NULL�� ���԰���
INSERT INTO MY_MEMBER(MEM_NO,MEM_NAME) VALUES (NULL,'TEST01');
-- '' �ٿ��� �����ϸ� NULL�� ��
INSERT INTO MY_MEMBER(MEM_NO,MEM_NAME) VALUES (7,'');
SELECT * FROM MY_MEMBER;

--���������� ������ �߰��ϱ�(�׽�Ʈ�� ���� ����)
INSERT INTO MY_MEMBER SELECT * FROM MY_MEMBER;

--UPDATE : �̹� �����ϴ� ���� ���� �� ����
-- UPDATE ���̺� �� SET Į��1 = VALUE1, Į��2= VALUE2, ... WHERE ����
-- ������ �������� ������ ������� �����ȴ�
COMMIT; --������� DM;�� ���� ������ ���̺� ��Ȳ�� Ȯ�����´�
select * from my_member;
UPDATE MY_MEMBER SET MEM_NAME='��浿', MEM_NO=10, MEM_AGE=45,JOINDATE='08/11/30';
rollback;
UPDATE MY_MEMBER SET MEM_NAME='��浿' WHERE MEM_NAME='ȫ�浿';

-- ���̺��� �ϳ��� ��(ROW)�� �����Ҽ��ִ� Į���� �ʿ�
-- �׷�Į���� ���ٸ�, �������� ���� ������� �����ǰų� �����Ǿ� ������
-- ���̺��� �ϳ��� ���� �����ϰ� �ĺ��� �ټ� �ִ� Į���� �⺻Ű��� �θ���(PRIMARY KEY/PK)

--�⺻Ű�� �Ǳ� ���� ����: 
    -- 1. �ߺ� �������(UNIQUE)
    -- 2. NULL�� �������(NOT NULL)
    
--KEY�� ����
--      ����Ű: KEY�� �ɼ� �ִ� ��� Į���� ����(�̸�+�̸���),(�̸���), (�̸�+��ȭ��ȣ)
--          ���ɼ��� ��� ��������
--      ����Ű: 2�� �̻��� Į���� ����� Ű
--      �ĺ�Ű: �⺻Ű�� �� �� �ִ� �ĺ��� �÷�
--      �⺻Ű: �ĺ�Ű �߿��� ���õ� Ű
--      FOREIGN KEY(�ܷ�Ű): �ٸ����̺����� �⺻Ű(Ȥ�� ���ϼ�-UNIQUE�� ����) ������ 
--                          �� ���̺����� �ߺ��� ����ϴ��÷�, �ٸ� ���̺��� �⺻Ű �÷��� �ݵ�� �����ؾ� �Ѵ�
--      EX: EMP���̺��� DEPTNO: �ܷ�Ű, DEPT������ DEPTNO: �⺻Ű
--          EMP���̺��� ���ο� ���� �߰��Ҷ� , DEPT���̺��� DEPTNO�� ���� �μ���ȣ�� �����  �� ����


--1. EMP���̺��� �����Ͽ� EMP02 ���̺� ����
CREATE TABLE EMP02 AS SELECT * FROM EMP;
SELECT * FROM EMP02;
--2. �μ���ȣ�� 10���� ������� �μ���ȣ�� 40������ ����
UPDATE EMP02 SET DEPTNO='40' WHERE DEPTNO='10';
-- 3. �޿��� 3000�̻��� ������� �޿��� 10% �λ�
UPDATE EMP02 SET SAL=SAL+(SAL*0.1) WHERE SAL>=3000;
-- 4. **1981�⿡ �Ի��� ������� �Ի����� ���÷� ����
UPDATE EMP02 SET HIREDATE=SYSDATE WHERE HIREDATE LIKE '81%';

COMMIT;

-- DELETE : ���̺� ������(��) ����
-- DELETE FROM ���̺�� WHERE ����;
-- *** ������ �������� ������ ��� ���� ���� ��
DELETE FROM EMP02;
SELECT * FROM EMP02;

--EMP02 ���̺��� COMM�� ���� �ʴ� ����� ����
DELETE FROM EMP02 WHERE COMM IS NULL;
DELETE FROM EMP02 WHERE COMM<=0;
ROLLBACK;


