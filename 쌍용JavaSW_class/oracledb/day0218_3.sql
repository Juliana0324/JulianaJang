select to_char(2022,'0,000,000'), to_char(2022, '9,999,999')
from dual;

select sysdate, to_char(sysdate,'yyyy-mm-dd am day dy d hh24')
from dual;

select empno, ename, to_char(sal,'9,999,999') sal, to_char(hiredate,'mm-dd-yyyy dy') from emp;

select empno, ename, hiredate,to_char(hiredate, 'q') �б� from emp where to_char(hiredate,'q') in(3,4) order by hiredate;

select to_date('2022-02-18') from dual;

--todate �Լ�
insert into student(snum, sname, input_date) values(6,'������',to_date('2022-02-15','yyyy-mm-dd'));
commit;

select snum,sname, to_char(input_date, 'yyyy-mm-dd am q"�б�" hh24:mi:ss') from student;
select to_char(sysdate,'yy')
from dual;

select top(2) with ties ename, sal from emp order by sal desc;

--to_number
select to_number('') from dual;

select empno, ename,hiredate from emp where to_char(sysdate,'mm')=to_char(hiredate, 'mm');

--�л����̺��� 11�� 17�� 49�ʿ� �Էµ� �����͸� �����ص�����
select * from student;
delete from student where to_char(input_date,'HH24MISS')= '111749';

select count(*) from emp;

--������̺��� ���ʽ��� �������� �ʴ� �����
select count(*) from emp where comm is null;
select comm, count(*) from emp group by comm;

select sum(sal),avg(sal),max(sal),min(sal) from emp;


select * from emp where sal>=(select avg(sal) from emp);

select decode('B','A','�ҽ��ϴ�','B','�����ϴ�','AB','õ��','O','�����δ�','����� �ƴմϴ�')
from dual;

--�μ���ȣ �μ���
select deptno, dname,decode(deptno, 10,'����', 20,'��������',30,'�', '����') from dept;
