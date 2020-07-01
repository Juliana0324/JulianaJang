--07_CREATE TABLE

/* CREATE TABLE ���̺��(
        Į����1 Į��Ÿ��(��������),
        Į����2 Į��Ÿ��(��������),        
        Į����3 Į��Ÿ��(��������),
        ...
    );
*/
-- Į��Ÿ�� ����
/*
    NUMBER(����)  :���� (EX: NUMBER(7)�� 7�ڸ� ����)
    NUMBER(����, �Ҽ����ڸ���)  :�Ǽ� (EX: NUMBER(7,2)�� ���� 5�ڸ�, �Ҽ� 2�ڸ�)
    CHAR(ũ��): ���� ���� ���� ������. �Էµ� �ڷ� ���̿� ������� ������ ���̸� ���� �ϴ� Ÿ��, �߻�� ����
    VARCHAR2(ũ��): �������� ���� ������, ���� �Էµ� ���� ���� ��ŭ�� ������ ���� �ϴ� Ÿ��
    DATE    :��¥ �����͸� ������ �� �ִ� Ÿ��,
    TIMESTAMP   : �и� ��������� ���尡�� Ÿ��
        
*/
-- ���̺� ���� ��: ȸ�� ���̺�
CREATE TABLE MY_MEMBER (
    MEM_NO NUMBER(10),
    MEM_NAME VARCHAR(20),
    MEM_AGE NUMBER(3),
    JOINDATE DATE DEFAULT SYSDATE 
    --DEFAULT : �⺻�� ����
);
SELECT * FROM MY_MEMBER;

-- DROP TABLE : ���̺� ���� ��ɾ�
DROP TABLE MY_MEMBER;

-- ���� ���̺� �����ؼ� ����(�׽�Ʈ��)
-- ���������� �Բ� ��������� �ʴ´�(NOT NULL���� ��)
SELECT * FROM EMP02;
CREATE TABLE EMP02 AS SELECT * FROM EMP WHERE DEPTNO IN (20,30);
CREATE TABLE EMP03 AS SELECT EMPNO, ENAME, SAL FROM EMP;
SELECT * FROM EMP03;

SELECT * FROM MY_MEMBER;
--���̺� Į�� ������ɾ�
--ALTER TABLE ���̺��[ADD|MODIFY|DROP COLUMN] (Į����1, Į����2,...),

--ADD : Į���߰�
ALTER TABLE MY_MEMBER ADD(TEST NUMBER(5));
ALTER TABLE MY_MEMBER ADD(TEST2 NUMBER(5),TEST3 VARCHAR(50));

--MODIFY : Į�� Ÿ�� ����(Į���� ������ X)
ALTER TABLE MY_MEMBER MODIFY (TEST NUMBER(7));
ALTER TABLE MY_MEMBER MODIFY (TEST DATE);

--DROP COLUMN: Į�� ����==> ����÷��� ������ ����
ALTER TABLE MY_MEMBER DROP COLUMN TEST;
ALTER TABLE MY_MEMBER DROP COLUMN TEST2;
ALTER TABLE MY_MEMBER DROP COLUMN TEST3;

-- SET UNUSED: Į���� �����ϴ� ��� ��� ������� �ʰ� �����ϱ�
ALTER TABLE MY_MEMBER SET UNUSED(TEST);
ALTER TABLE MY_MEMBER SET UNUSED(TEST2);
ALTER TABLE MY_MEMBER SET UNUSED(TEST3);
--�����ִ� �ð��� UNUSEDó���� Į������ �����Ѵ�
ALTER TABLE MY_MEMBER DROP UNUSED COLUMNS;


--��Ÿ������: �����Ϳ� ���� ������(���̺� ����, Į�� ����,,)
-- �츮�� ���� ���� �ʰ� DB�� �˾Ƽ� �����ϴ� ���̺�
SELECT * FROM TABS; 
SELECT * FROM USER_TABLES;      --���� ���̺� ����
SELECT * FROM USER_SEQUENCES;   --���� ������ ����
SELECT * FROM USER_INDEXES;     --���� �ε��� ����
SELECT * FROM USER_CONSTRAINTS; --���� �������� ����

SELECT * FROM TABS; 
SELECT * FROM ALL_TABLES;      --��� ���̺� ����
SELECT * FROM ALL_SEQUENCES;   --��� ������ ����
SELECT * FROM ALL_INDEXES;     --��� �ε��� ����
SELECT * FROM ALL_CONSTRAINTS; --��� �������� ����

SHOW USER;
--���������� ���� ���� ����

DESC MY_MEMBER;

-- ����: ���̺� ¥����
