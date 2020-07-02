--09_SEQUENCE.SQL
-- �⺻Ű: PRIMARY KEY: �� ���� �����ϰ� ������ �� �ִ� Į��
-- �⺻Ű�� ������ ���� ������ �ϴµ�, ����ڰ� �װ��� �Ź� ���� �����Ϸ��� ����
-- �⺻Ű�� ����� �������� �ڵ����� ��ġ�� �ʴ� ���ڸ� �����ϴ� ���α׷��� ������ ���� ���� DB�� ������ ��� �Ѵ�
-- ��, �������� �ڵ���ȣ �߻���
/*
    CREATE SEQUENCE ��������
        INCREMENT BY ��������   --�⺻�� : +1, ���/���� ��� ��밡��
        START WITH ���ۼ���     -- ���۰��� ������ �� �ִ�, �⺻���� ������ �� MINVALUE, �����϶� MAXVALUE
        MINVALUE �ּҰ�        -- �������� �ּҰ��� �����Ѵ�
        MAXVALUE �ִ밪        -- �������� �ִ밪�� �����Ѵ�
        CYCLE/ NOCYCLE        -- CYCLE �� ��� �ִ밪�� �����ϸ� �ּҰ����� �ٽý���
        CACHE SIZE /NOCACHE       -- ������ȣ�� �̸� ������ ������ ������ �����Ѵ�
    
*/
SELECT * FROM user_sequences;
SELECT * FROM ALL_sequences;

SELECT * FROM MY_MEMBER;
DELETE FROM MY_MEMBER;
COMMIT;

--������ ����

CREATE SEQUENCE MY_MEMBER_MEMNO_SEQ NOCYCLE NOCACHE;

--�������� ����� ������ ����
INSERT INTO
    MY_MEMBER (MEM_NO, MEM_NAME, MEM_AGE)
VALUES 
    (MY_MEMBER_MEMNO_SEQ.nextval, 'tester', 10); 
    --��������.nextval :�������ڸ� ������ ����Ѵ�.���ڸ� �����Ѵ�.
SELECT * FROM MY_MEMBER;
-- ���������� �̿��� �����͸� �����ϸ鼭 ������ �̿��ϱ�
INSERT INTO
    my_member(MEM_NO,MEM_NAME,MEM_AGE)
    (SELECT MY_MEMBER_MEMNO_SEQ.NEXTVAL,MEM_NAME,MEM_AGE FROM MY_MEMBER);
    
COMMIT;
-- DUAL: �׽�Ʈ�� ���̺�
SELECT MY_MEMBER_MEMNO_SEQ.CURRVAL FROM DUAL;
-- ���簪: CURRVAL(������ȣ �ٷ� ��)
SELECT 10+10 FROM DUAL;

/*
    ������ ����
    ALTER SEQUENCE ������ ��
        INCREMENT BY ��������   --�⺻�� : +1, ���/���� ��� ��밡��
        START WITH ���ۼ���     -- ���۰��� ������ �� �ִ�, �⺻���� ������ �� MINVALUE, �����϶� MAXVALUE
        MINVALUE �ּҰ�        -- �������� �ּҰ��� �����Ѵ�
        MAXVALUE �ִ밪        -- �������� �ִ밪�� �����Ѵ�
        CYCLE/ NOCYCLE        -- CYCLE �� ��� �ִ밪�� �����ϸ� �ּҰ����� �ٽý���
        CACHE SIZE /NOCACHE       -- ������ȣ�� �̸� ������ ������ ������ �����Ѵ�
    �ѹ� ������ ���� ������ ���� �������� �������� ����
*/
ALTER SEQUENCE MY_MEMBER_MEMNO_SEQ INCREMENT BY 2;
SELECT * FROM MY_MEMBER ORDER BY MEM_NO DESC;
--������ ����
--DROP SEQUENCE ��������;

-- ������ ���̺��� ����� �������� �����ϰ� INSERT�� �����͸� ������ �߰��غ�����
-- 1. �������� ����� ������ Į���� ���� (���ٸ� ALTER TABLE�߰�)
-- 2. ������ ����
-- 3. ������ ����
CREATE TABLE MY_SCORE03(
    MY_NO NUMBER(12),
    MY_NAME VARCHAR2(10),
    MY_AGE NUMBER(3),
    MY_KOR NUMBER(3),
    MY_MATH NUMBER(3),
    MY_ENG NUMBER(3),
    MY_AVG NUMBER(6,3)
);

CREATE SEQUENCE MY_SCORE03_MY_NO_SEQ NOCYCLE NOCACHE;

INSERT INTO 
    MY_SCORE03(MY_NO,MY_NAME,MY_AGE,MY_KOR,my_math,my_eng, MY_AVG)
VALUES 
    (MY_SCORE03_MY_NO_SEQ.nextval, '�ȴ�', 10,80,50,70, round((80+50+70)/3, 3)); 

SELECT * FROM MY_SCORE03;
