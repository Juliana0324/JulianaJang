--insert�� �ܼ��� ��������
select * from cp_emp4;

insert into cp_emp2(empno,ename) values(1,'�׽�Ʈ');
commit;
insert into cp_emp2(empno,ename,job) values(2,'�׽�Ʈ2','');
commit;


insert into cp_emp4 values(1,'�̳���','������',sysdate,
	(select sal from emp where empno=7902),''
);

insert into cp_emp4 values(2,'������','������',add_months(sysdate,1),
	(select sal from cp_emp4 where empno=1)+500,
	(select comm from emp where empno=7654)
);

--���� ������ ���� ���ο� �Լ��� �������Ҷ� dual�� ó��
insert into cp_emp4 values(2,'������','������',(select add_months(sysdate,1) from dual),
	(select sal from cp_emp4 where empno=1)+500,
	(select comm from emp where empno=7654)
);
commit;

--emp���̺� �����ȣ, �����, �Ի���, ������ ��ȸ�ϤŤ� cp_emp4�� �߰�
insert into cp_emp4 (empno, ename, hiredate, sal)
(select empno, ename, hiredate, sal from emp where deptno=10);


insert into cp_emp4(empno, ename, job, hiredate,sal)
(select empno,ename,job,hiredate,sal*1.2 from emp where to_char(hiredate, 'mm')='02');



--update ���� ����


update cp_emp4
set sal=(select sal from cp_emp4 where empno=7839)
where empno=1;


update cp_emp4
set sal=5200
where empno=(select empno from emp where sal=5000);


--��� ���̺��� �����ȣ, �����, ����, ���ʽ�, �μ���ȣ�� ��ȸ�Ͽ� cp_emp5�� �߰�
create table cp_emp5 as(select empno, ename, sal, comm, deptno from emp);

--emp���̺��� 20�� �μ������ ������ ����� cpemp5���� ã��,
-- ������� ���ʽ��� 1000����
update cp_emp5
set comm=1000
where empno in (select empno from emp where deptno=20);

select * from cp_emp5;
