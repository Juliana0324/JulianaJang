--driving table
--�����Ҷ� Ű�� ����ϴ� ���̺�
--driving table�� �߸� �����ϸ� �˻� �ӵ��� ��������.
--driving table ��������(1.���谡 ������ pk���̺�, 2. ���谡 �������� ���� ���̺����� Į���� ���ڵ尡 ���� ���̺�)
--ex) deptno
select * from car_country;
select * from car_maker;
select * from car_model;

--inner join : ���̺� ���� ���� ���� ���ڵ常 �˻�
--���� ���̺��� ���ڵ尡 �����ϸ� �˻����� �ʴ´�

--������ ������, ������,�� ��ȸ
--ANSI
select co.country, ma.maker, ma.model
from car_country co
inner join car_maker ma
on ma.maker=co.maker;

--Oracle
select cc.country, cc.maker, cma.model
from car_country cc, car_maker cma
where cma.maker=cc.maker;

--ansi
select cma.maker, cma.model,cmo.car_option, cmo.car_year
from car_maker cma
inner join car_model cmo
on cmo.model=cma.model
where instr(cmo.car_option,'ABS')>0;

--oracle
--�������ǿ��� (��������) ��ȣ�� ���ش�
select cma.maker, cma.model,cmo.car_option, cmo.car_year
from car_maker cma, car_model cmo
where (cmo.model=cma.model) and instr(cmo.car_option,'ABS')>0;

--���̺� ���� ����
--�������� ������ ������, ������(car country), �𵨸�, ī����(car_maker), �ɼ�, ����, �Է���(car model)
--ANSI
select cc.country, cc.maker,
	 	 cma.model,
		 cmo.car_year, cmo.car_option,cmo.price,cmo.hiredate
from car_country cc
inner join car_maker cma
on cma.maker=cc.maker
inner join car_model cmo
on cmo.model=cma.model;

--oracle
select  cc.country, cc.maker,
	 	 cma.model,
		 cmo.car_year, cmo.car_option,cmo.price,cmo.hiredate
from car_country cc, car_maker cma, car_model cmo
where (cma.maker=cc.maker and cmo.model= cma.model) ;

-------------------------------------------------------------
--outer join
select * from dept d
left outer join emp e
on e.deptno=d.deptno;

select * from dept d
full outer join emp e
on e.deptno=d.deptno;

--oracle outer join
--������������ ���Ǵ� Į����(+)��ȣ�� ����
--fullouter���������� ����
--primary key�� �ִ� Į������ ��ȸ�Ұ�
select d.deptno,d.dname,e.empno,e.ename, e.hiredate
from emp e, dept d
where e.deptno(+)= d.deptno;

select * from car_maker;
select * from car_model;

--ansi
select cma.maker,cma.model, cmo.hiredate, cmo.price, cmo.car_option
from car_maker cma
left outer join car_model cmo
on cmo.model=cma.model
where cma.maker in('����','���');

--oracle
select cma.maker, cma.model, cmo.hiredate, cmo.price, cmo.car_option
from car_maker cma, car_model cmo
where (cmo.model(+)=cma.model) and cma.maker in ('����','���');

update car_model
set car_year='2022', price =3500, cc=1998
where price is null;

commit;

select* from car_country;

--ü�̺� 3�� ����
--�����簡 '���� BENZ'�� ��� ������ ������, �𵨸�, ���� ���� �ɼ��� ��ȸ
select  cc.country,cc.maker, cma.model, cmo.car_year, cmo.price, cmo.car_option
from CAR_COUNTRY cc
inner join car_maker cma
on cma.maker=cc.maker
left outer join car_model cmo
on cmo.model=cma.model
where cc.maker in('����','BENZ');

--����Ŭ
select  cc.country,cc.maker, cmo.model, cmo.car_year, cmo.price, cmo.car_option
from CAR_COUNTRY cc, car_model cmo, car_maker cma
where (cma.maker=cc.maker and cmo.model(+)=cma.model)
and cc.maker in('����','BENZ');

--��� �μ��� �ٹ��ϴ� ����� �����ȣ,����� �Ի��� �μ���ȣ �μ��� �����ȣ �õ� ���� �� ����
--ANSI
select e.empno, e.ename, e.hiredate, d.deptno, d.dname, z.seq, z.sido,z.gugun,z.dong,z.zipcode
from dept d
left outer join emp e
on e.deptno=d.deptno
left outer join zipcode z
on z.seq=e.empno;


--����Ŭ
select e.empno, e.ename, e.hiredate, d.deptno, d.dname, z.seq, z.sido,z.gugun,z.dong,z.zipcode
from dept d, emp e, zipcode z
where (e.deptno(+)=d.deptno and z.seq(+)=e.empno);

--self join
--������� Ŭ���� ������� ������ ���� �޴� ����� ��ȸ(���������� ��ü����)
select empno, ename,sal, hiredate from emp
where sal>(select sal from emp where ename=upper('clark'));

select e1.empno, e1.ename, e1.sal, e1.hiredate
from emp e1/*��ȸ��*/, emp e2/*���ǿ�*/
where (e1.sal>e2.sal) and e2.ename='CLARK';

--1-9999����
create sequence test_seq
start with 1
increment by 1
maxvalue 9999
cycle
cache 40;

select * from user_sequences;

--������ ��ȣ ���
--currval=> ������ session�� ������ ��ü�� ���ٸ� error�߻�
--���� ����: 1. ���� ������ ������ ��ü
--				2. db������ ����� �� ����۵Ǿ���
select test_seq.currval
from dual;

select test_seq.nextval
from dual;

drop sequence test_seq;
insert into cp_emp5(empno,ename,sal,deptno) values(test_seq.nextval, '�����',3000,20);
insert into cp_emp5(empno,ename,sal,deptno) values(test_seq.nextval, '�����',3100,20);
insert into cp_emp5(empno,ename,sal,deptno) values(test_seq.nextval, '�����',2900,20);
insert into cp_emp5(empno,ename,sal,deptno) values(test_seq.nextval, '�Ż��',3000,20);
insert into cp_emp5(empno,ename,sal,deptno) values(test_seq.nextval, '����',2400,20);
commit;

select * from cp_emp5;
truncate table cp_emp5;

--�������� �����ϸ� ������ ��ȣ�� ����
insert into cp_emp5(empno,ename,sal,deptno) values(test_seq.nextval, '������',2400,20);

insert into cp_emp5(empno,ename,sal,deptno) values(test_seq.nextval, '����',2400,20);--7�� �����
insert into cp_emp5(empno,ename,sal,deptno) values(test_seq.nextval, '�̻��',2400,20);

--�������� �����ϴ��� ��ȣ�� ����Ǿ�� �Ѵٸ� sequence�� ����ϸ�ȵȴ�
insert into cp_emp5(empno,ename,sal,deptno) values((select max(empno)+1 from cp_emp5), '����2',2400,20);


create sequence test_seq2
start with 10
increment by 10
maxvalue 1000000000
nocycle;

select test_seq2.nextval from dual;
