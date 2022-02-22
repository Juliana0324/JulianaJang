--rownum: ��ȸ�Ǵ� ���ڵ忡 1���� �����ϴ� ���� �ٿ��ִ� ���� Į��

--�μ����̺��� ��ȣ, �μ���ȣ �μ����� ��ȸ
--��ȣ�� ����������
select rownum num,deptno,dname from dept;

select rownum,empno, ename,sal
from emp
order by sal;

--where ������ �ο���� 1�����͸� �����ϴ�
select rownum, empno, ename, sal from emp
where rownum>=1 and rownum<6;

select * from car_country;

--select ������ ��������
--�ٱ� ������ �ζ��κ並 ����� ��ȸ�̹Ƿ� inline view�� ��밡��
select empno,ename, hi, sal
from (select empno, ename, hiredate hi, sal
from emp);

select rownum, empno, ename, hi
from (select empno, ename, hiredate hi from emp order by hiredate desc)
where rownum>=1 and rownum<6;

select rownum, empno, ename, hi
from(select rownum, empno, ename, hiredate hi from emp order by hiredate desc);


select r, empno,ename,hiredate from (select rownum r, empno, ename, hiredate
from(select empno, ename, hiredate from emp order by hiredate desc))
where r between 2 and 6;

select rnum,empno, ename, hiredate
from(select row_number() over(order by hiredate desc) rnum,empno, ename, hiredate
	from emp)
	where rnum between 2 and 6;

--car+model ���̺��� ��ⷮ�� ������������ ����������
--11~20��° �˻��� ���ڵ� ��ȸ
select model, cc, car_year, price, hiredate
from (select model,row_number() over(order by cc desc) r, cc, car_year,price,hiredate from car_model where cc is not null)
where r between 11 and 20;


select model, cc, car_year, price, hiredate
from (select model,row_number() over(order by cc desc) r, cc, car_year,price,hiredate
	from car_model
	where cc is not null and exists(select model from car_model where model='�׷���'))
where r between 11 and 20;

--union �������� ���̺��� ���ļ� �˻��Ҷ�(�ߺ�x)
select ename from emp
union
select ename from emp;

select empno,job,ename, hiredate
from emp
union all
select sal, ename, to_char(sal,'9,999'), hiredate
from cp_emp4;

select * from user_constraints;
