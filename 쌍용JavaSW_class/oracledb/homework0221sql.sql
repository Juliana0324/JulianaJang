/*
����1.
 ��� ���̺��� ������ 1500~3000������ �����
  �����ȣ, �����, ����, �Ի���, �μ���ȣ, ����, �Ŵ�����ȣ�� ��ȸ�� ���ڵ带 ����Ͽ�
  emp_work���̺��� �����ϰ� �߰��մϴ�.
*/
create table emp_work as (select empno, ename,sal, hiredate, deptno, job, mgr from emp where sal in(1500,3000)
);
/*
����2.
  emp���̺��� 10�� 30�� �μ��� ��� ������ ��ȸ�Ͽ� emp_work���̺�
  ��ȸ ����� �߰��մϴ�.
   ��, �����ȣ�� ��ȸ�� �����ȣ�� 1000�� ���� ������ �߰��� ��.
      ���� data 7788 -> insert 8788
*/
insert into emp_work(empno, ename,sal, hiredate,deptno,job,mgr)
(select empno+1000, ename,sal, hiredate,deptno,job,mgr from emp where deptno in(10,30));

/*
���� 3.
 emp_work ���̺��� 10�� �μ��� �ٹ��ϴ� ������� ������  emp���̺���
  �����ȣ�� 7369�� ��� ������ 7782�� ����� ������ ���� �ݾ����� �����ϼ���.
*/
select * from emp_work;
update emp_work
--set sal=(select sal from emp where empno=7698)+(select sal from emp where empno=7782)
set sal=(select sum(sal) from emp where empno in(7698,7782))
where deptno=10;

/*
����4. cp_emp4 ���̺� �Ʒ��� ���� ���ڵ带 �߰��ϼ���.
�����ȣ : ���� ������ �����ȣ���� 1 ������ ��ȣ, ����� :������, ���� : ������,
  �Ի��� : �߰��Ǵ� ������ ������
  */
select * from cp_emp4;
insert into cp_emp4(empno, ename,job,hiredate) values((select max(empno)+1 from emp),'������','������',sysdate);

  /*
����4.�Ʒ��� ���� ���ڵ带 ������ �� �ִ�  sales���̺��� �����ϰ� ���ڵ带 �߰��ϼ���.
 ��ȣ : 1, ��ǰ�� : Ű����, ���� : 20000, �Ǹ��� : ��2022-02-20��, ���� : 1
 ��ȣ : 2, ��ǰ�� : ���콺, ���� : 27000, �Ǹ��� : ��2022-02-20��, ���� : 1
 ��ȣ : 3, ��ǰ�� : �����, ���� : 350000, �Ǹ��� : ��2022-02-20��, ���� : 1
 ��ȣ : 4, ��ǰ�� : Ű����, ���� : 23000, �Ǹ��� : ��2022-02-20��, ���� : 1
 ��ȣ : 5, ��ǰ�� : Ű����, ���� : 15000, �Ǹ��� : ��2022-02-20��, ���� : 1
 ��ȣ : 6, ��ǰ�� : Ű����, ���� : 20000, �Ǹ��� : ��2022-02-21��, ���� : 1
 ��ȣ : 7, ��ǰ�� : ���콺, ���� : 13000, �Ǹ��� : ��2022-02-21��, ���� : 1
 ��ȣ : 8, ��ǰ�� : Ű����, ���� : 22000, �Ǹ��� : ��2022-02-21��, ���� : 1
*/
create table sales(
	snum number(4),
	product varchar2(15),
	price number(7),
	saldate Date,
	nums number(3)
);

insert into sales values(1,'Ű����',20000,'2022-02-20',1);
insert into sales values(2,'���콺',27000,'2022-02-20',1);
insert into sales values(3,'�����',350000,'2022-02-20',1);
insert into sales values(4,'Ű����',23000,'2022-02-20',1);
insert into sales values(5,'Ű����',15000,'2022-02-20',1);
insert into sales values(6,'Ű����',20000,'2022-02-21',1);
insert into sales values(7,'���콺',13000,'2022-02-21',1);
insert into sales values(8,'Ű����',22000,'2022-02-21',1);
commit;
/*
���� 5. ��ǰ��, �Ѱ���, �ǸŰǼ�, �Ǹ���, �Է��� �� ������ �� �ִ�  sales_adjustment ���̺��� �����ϼ���.
*/
create table sales_adjustment(product, price, nums, saldate) as
(select product, price, nums, saldate from sales where 1=0);

alter table sales_adjustment add inputdate date;
select * from sales_adjustment;

/*
����6. sales ���̺��� ��2022-02-20�� �� �Ǹŵ� ��ǰ�� ��ǰ��, �Ѱ���, �ǸŰǼ� ��  sales_adjustment
    ���̺� �߰��ϼ���. -����
   �߰�   ��)
     Ű����, 58000, 3, 2022-02-20, ����
     ���콺 , 27000,1,  ���͵���
     �����, 350000,1, ���͵���*/

     --�̹����� �׷��Լ�������Ͻø� ���ؿ�  => ������ �ѹ��� insert�۾��� �ϴ� �� �ǹ��ؿ�.
 insert into sales_adjustment(product, price, nums, saldate,inputdate)
 (select product,sum(price),sum(nums), saldate,sysdate
  from sales
  where saldate='2022-02-20'
  group by product,saldate);


--insert into sales_adjustment(product, price, nums, saldate,inputdate)
--values('Ű����', (select sum(price) from sales where product='Ű����' and saldate='2022-02-20'),
--(select count(*) sales from sales where product='Ű����'  and saldate='2022-02-20'),'2022-02-20', sysdate);
--
--insert into sales_adjustment(product, price, nums, saldate,inputdate)
--values('���콺', (select sum(price) from sales where product='���콺' and saldate='2022-02-20'),
--(select count(*) sales from sales where product='���콺'  and saldate='2022-02-20'),'2022-02-20', sysdate);
--
--insert into sales_adjustment(product, price, nums, saldate,inputdate)
--values('�����', (select sum(price) from sales where product='�����' and saldate='2022-02-20'),
--(select count(*) sales from sales where product='�����'  and saldate='2022-02-20'),'2022-02-20', sysdate);

select * from sales_adjustment;

