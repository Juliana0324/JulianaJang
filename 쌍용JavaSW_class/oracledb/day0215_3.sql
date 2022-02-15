select empno,ename,sal,comm from emp;

--�Ѽ��ɾ��� ������ ���ʽ��� �ջ��� �ݾ�
--null�� ����Ǹ� null�� ����
select empno,ename,sal,comm,comm+sal from emp;

-- 1.�Ʒ� ���õǴ� ������ Ȯ���Ͽ� �л������� ������ ���̺��� �����ϼ���.
/*
��ȣ : ���� (0~99999)�� ��ȣ�� �Էµ˴ϴ�.
�̸� : �ѱ۷� 10�ڱ��� �Էµ˴ϴ�.
Ŭ���� : ����� 1�� �Էµ˴ϴ�.
�̸��� : ����� �ִ� 50�ڱ���  �Էµ˴ϴ�.
��ȭ��ȣ : ���ڿ� '-'���� �����Ǹ� 13�ڱ��� �Էµ˴ϴ�.
�ּ� :  �ѱ۷� 80�ڱ��� �Էµ˴ϴ�.
���� : ���� ���ڿ� ���� �ѱ۷ε� ������ �Էµ˴ϴ�.
�ڹ����� : ����(0~999)������ ���� �Էµ� �� �ֽ��ϴ�.
�Է��� : ��¥�������� �Էµ˴ϴ�.
*/
create table student(
	snum number(5),
	sname varchar(10),
	sclass char(1),
	semail varchar(50),
	sphnum varchar(13),
	address varchar(255),
	gender varchar(10),
	javascore number(3),
	input_date date
);

SELECT * FROM STUDENT;
/*
2. �Ʒ��� ������ 1������ ������ ���̺� �߰��ϼ���.
 Transaction�� ������ �ϳ��� �����ȴ�. ( ���� insert�� ���� �� �� commit�� �ؾ��Ѵ�. )
 1, ����ö, A, yu@sist.co.kr, 010-1234-5678,��⵵ ���ν�, ����, 91, ��������
 2, ������, A, kim@daum.net,010-7739-9761,����� ������ ����1��, ����, 90, ��������
 3, ������,A, jeon@test.com,010-5878,8813,����� ���۱� �󵵵�, ����,97,��������
 4, Ȳ����, B, jun@google.com,011-234-7611,�����  ���빮�� ���빮��, ����, 190, ��������
 5, �ֿ���, B, choi@sist.co.kr,010-4334-7656,��õ�� ���� ����3��, ����, 89, ��������
*/

INSERT INTO STUDENT VALUES(1, '����ö', 'A', 'yu@sist.co.kr', '010-1234-5678','��⵵ ���ν�','����', 91,SYSDATE);
COMMIT;
INSERT INTO STUDENT VALUES(2, '������', 'A', 'kim@daum.net', '010-7739-9761','����� ������ ����1��','����', 90,SYSDATE);
COMMIT;

INSERT INTO STUDENT VALUES(3, '������','A', 'jeon@test.com','010-5878,8813','����� ���۱� �󵵵�', '����',97,sysdate);
COMMIT;
INSERT INTO STUDENT(SNUM, SNAME,SCLASS,SEMAIL,SPHNUM,ADDRESS,GENDER, JAVASCORE,INPUT_DATE) VALUES(4, 'Ȳ����', 'B', 'jun@google.com','011-234-7611','�����  ���빮�� ���빮��', '����', 190, sysdate);
COMMIT;
INSERT INTO STUDENT(SNUM, SNAME,SCLASS,SEMAIL,SPHNUM,ADDRESS,GENDER, JAVASCORE,INPUT_DATE) VALUES(5, '�ֿ���', 'B', 'choi@sist.co.kr','010-4334-7656','��õ�� ���� ����3��', '����', 89, sysdate);
COMMIT;

--3. 1������ ������ ���̺��� ����Ͽ� ��緹�ڵ�� ��� �÷��� ��ȸ�ϼ���.
select * from student;

--4. 1������ ������ ���̺��� ����Ͽ� �̸�,��, �ּ�, �ڹ������� ��ȸ�ϼ���.
select sname, sclass,address,javascore from student;

--5. 4�� �л��� ������ ���ڷ� ������ 90������ ���� A, ��ȭ��ȣ�� 010-2234-7611���� �������ּ���.
update student set gender='����',javascore=90, sclass='A',sphnum='010-2234-7611' where snum=4;
commit;

--6.  �̸��� 'Ȳ����'�̸鼭 ���� B���� �л��� ���� A��, ��ȭ��ȣ�� 010-1111-2341 �� �������ּ���.
update student set sphnum='010-1111-2341', sclass='A' where sname like 'Ȳ%' and sclass='B';
commit;

-- 7.  ���� A���� �л��� ��� �����غ�����.
delete from student where sclass='A';

--8. 7������ ������ ���ڵ带 ��� ������ ������.
rollback;

--9. ���̺� ��ü�� ������ ������.
drop table student;

--9. �������� Ȯ���ϰ�, �����뿡 ������ ���̺��� �����غ�����.
show recyclebin;
flashback table "BIN$dAtXn71yS4WqYcu17bXqVg==$0" to before drop;

-- 10. ���̺��� ��� ���ڵ带 �����غ�����.
select * from student;
-- 11. ���̺���ü�� ���� �غ�����.
truncate table student;

--12. �������� ������ Ȯ���ϰ�, �������� ���������.
drop table student;
show recyclebin;
purge recyclebin;
