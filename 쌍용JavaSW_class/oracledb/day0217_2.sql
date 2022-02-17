select empno, ename, sal, job
from emp
where sal between 1000 and 3000;

select empno, ename, deptno from emp
where deptno=10 or deptno=30 order by deptno;


select empno, ename, deptno from emp
where deptno in(10,30) order by deptno;

select empno, ename, deptno from emp
where deptno not in(10,30) order by deptno;

select empno, ename, sal, comm from emp
where comm is null;

--���ڿ� ������
create table test_like(
	name varchar2(15),
	addr varchar2(100)
);

insert into test_like values('������', '����� ������ ���ﵿ');
commit;
insert into test_like values('���μ�', '����� ���빮�� ���빮��');
insert into test_like values('������', '����� ���α� ����1��');
insert into test_like values('������', '����� ���α� ����2��');
insert into test_like values('�̳���', '��õ�� ���� ����');
insert into test_like values('����ö', '������ ����� ���븮');
commit;

select * from test_like;

select addr from test_like where name='������';
select addr from test_like where name like '��%';
select addr from test_like where name like '��__';
select addr from test_like where addr like '%��';
select addr from test_like where addr like '%����%';
select * from test_like where name like '_��_';
select * from test_like where name like '��__';
select * from test_like where addr like '����� %';

select * from emp;
--������̺��� ������� 4������ ���������ȣ �˻�
select ename, empno from emp where ename like '____';
select ename from emp where ename like '__A__';

select ename from emp where ename like '_A%';
select * from emp;
select ename from emp where ename like '%A%A%';


create table zipcode(
	zipcode char(7),
	sido char(6),
	gugun varchar2(25),
	dong varchar2(100),
	bungi varchar2(25),
	seq number(5)
);

--sqlldr.exe.�� ����Ͽ� CSV�������� ������� ������ �߰�
select * from zipcode;

--�ڽ��� ����ִ� ���� �����ȣ, �õ� ���� �� ������ ��ȸ
select zipcode,sido,gugun,dong,bungi from zipcode
where dong like '%�׷���ư%';

