--�����
--������ �ο��� ������ ����
select * from user_views;

--�ܼ� �Լ� ������� ������� ���� �ϳ��� ���̺��� ����� view
--�並�� �����Ѵ�
CREATE VIEW emp5 AS(SELECT empno, ename, sal, deptno FROM cp_emp5);

alter table cp_emp5 add constraints pk_cp_emp5 primary key(empno);

--�� ���� �ο�(������)
grant create view to scott;

select * from user_views;
--��ȯ ȸ��
revoke create view from scott;

insert into cp_emp5(EMPNO, ENAME, SAL,COMM,DEPTNO)
values(14,'���μ�',3000,100,10);

--view ��ȸ
select * from emp5;

--view�� �۾��ϸ� ���� ���̺� �ݿ���
insert into emp5(empno,ename, sal, deptno)
values(100,'������',3000,30);
commit;

select * from cp_emp5;

--update
--�����ȣ�� 100���� ����� ������ 3500���� ����
UPDATE emp5
SET sal=3500
WHERE empno=100;
commit;

DELETE FROM emp5
WHERE empno=100 AND ename='������';
rollback;
commit;

select * from cp_emp5;
drop view emp5;

select * from user_views;

--�����
create view emp5 as
(select empno, ename, sal/12 month_sal,deptno from cp_emp5);

select * from emp5;
--���� ��� ������� ���dml�Ұ���(select ����)
insert into emp5(EMPNO,ENAME,MONTH_SAL, DEPTNO)
VALUES(200,'������',3500,10);

create view emp6 as
(select empno, ename, sal,deptno from cp_emp5) with read only;

select * from user_views;

--wirh read only
select * from emp6;
--�б� ���뿡�� insert,update, delete�ȵ�
insert into emp6(EMPNO,ENAME,SAL, DEPTNO)
VALUES(200,'������',3500,10);

--���պ�
--��ⷮ 1500-3000������ ������ ������, ������,�𵨸�, ���� ���� �̹��� �Է��� ��ⷮ �ɼ��� ��ȸ
CREATE VIEW car_view AS(
	SELECT row_number() over(order by cmo.cc desc) num,cc.country,cmo.car_year ,cc.maker, cma.model, cmo.hiredate,
			cmo.price, cmo.car_img, cmo.cc, cmo.car_option
	FROM car_country cc, car_maker cma, car_model cmo
	WHERE (cma.maker=cc.maker and cmo.model=cma.model) AND cmo.cc BETWEEN 1500 AND 3000
);

drop view car_view;
select num, country, maker, model, to_char(hiredate,'mm-dd-yyyy') hiredate, to_char(car_year,'9,999,999') ,to_char(price,'99,999,999'),car_img,
		to_char(cc,'9,999,999') cc, substr(car_option, 1, instr(car_option, ',')-1) from car_view where num between 3 and 6;

insert into car_view
(num, country, maker, model, car_year, car_img, hiredate, cc, car_option)
values(34,'����','���','���ȶ�','2022','im.jpg',sysdate,4000,'�ߴ޸�');

drop view car_view;
drop view emp5;
drop view emp6;

--�� ��ȯ ȸ��
revoke create view  from scott;

select * from dba_sys_privs where grantee='SCOTT';

--index����
select * from user_indexes;

select rowid,empno from emp;

select * from zipcode where seq=52000;

select * from user_indexes where table_name ='CP_EMP4';

--�ε��� ����
--unique index ����
create unique index ind_cp_emp4 on cp_emp4(empno);

select * from cp_emp4;
delete from cp_emp4 where to_char(hiredate, 'mi')=34;
commit;
select * from user_indexes;

--�ε����� ������ Į�� ��ȸ
select * from user_ind_columns where table_name='CP_EMP4';

--non unique index;
select * from cp_emp5;
insert into cp_emp5 values(17,'������',2000,200,10);
commit;

--����� �ε����ο�(non unique index)
create index ind_cp_emp5 on cp_emp5(ename);

select * from user_ind_columns
where table_name='CP_EMP5';

select * from user_indexes
where table_name='CP_EMP5';

--�ε�������
drop index ind_cp_emp5;
select * from user_indexes;

--�ε��� ����
alter index ind_cp_emp5 rebuild;
alter index pk_cp_emp5 rebuild;

---------------------��Ʈ�� �ε���:Į���� ���� ��Ư�� ���� �϶� ���� �ε���-----------------------------
create bitmap index ind_zipcode on cp_zipcode(zipcode);
drop index ind_zipcode;

select * from user_ind_columns
where index_name='IND_ZIPCODE';

--------------------composite index: �������� Į������ �ε����� �����ؾ��Ҷ�----------------
--create index �ε����� on ���̺��(Į����,,,);
select * from cp_emp3;

--cp_emp3���̺� ename, jobĮ���� ����Ͽ� ���� �ε��� ����
create index ind_cp_emp3 on cp_emp3(ename, job);

select * from user_ind_columns where index_name='IND_CP_EMP3';
select * from user_indexes where table_name='CP_EMP3';

--+�ε��� ��Ʈ /*+�ε��� ��Ʈ*/ => +�� ������ �Ϲ��ּ����� ������
alter index pk_cp_zipcode rebuild;
select * from user_indexes;

--�ε����� ������� ���� ��ȸ
select zipcode, sido, gugun, dong, bunji, seq
from zipcode
where seq between 30000 and 30100;

--ctrl+p �ϸ� cost����� �ش�
select /*+ index(zipcode) pk_cp_zipcode */zipcode, sido, gugun, dong, bunji, seq
from cp_zipcode
where seq between 30000 and 30100;
