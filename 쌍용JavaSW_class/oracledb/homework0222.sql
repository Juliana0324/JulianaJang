--�������̺��� �����ɼǿ� ��ABS���� ���ԵǾ��ִ� ��� ������ �𵨸�, ����,�ɼ�,
--  �̹���, �Է����� ��ȸ �ϼ���.
--  ��, ����� ������ ������������ ���� ���� �� 4~8��° ���ڵ常 ��ȸ�ϼ���.
--    �Է����� ����-��-�� �б⡱�� �������� ����մϴ�.

select model,car_year,car_option,car_img,to_char(hi, 'mm-dd-yyyy q')
from (select model,car_year,car_option, row_number() over(order by price) r,car_img,hiredate hi
	from car_model where car_option like '%ABS%'
	)
where r between 4 and 8;

--2.�Ʒ��� �����͸� �Է� �� �� �ִ� ���̺��� �����ϰ�, �����ϴٰ� �ǴܵǴ� �÷���
-- primary key, foreign key��  �ο��ϼ���.
--  foreign key : dept���̺��� �����Ͽ� Ű�� ����
--�����Ǵ� ���̺��� ��ȣ, ���̵�, �̸�, ����, �μ���ȣ, ��ȭ��ȣ, �����ȣ, �ּҸ�  ������ �� �ֽ��ϴ�.
create table users(
	user_num char(6),
  id varchar2(16) primary key,
  age number(3),
  deptno number(3),
  tel varchar2(16),
  add_num number(7),
  address varchar2(20),
  constraint fk_users_dept foreign key(deptno) references dept(deptno)
);

alter table users modify address varchar2(50);



--3.���� ���̺��� ����Ͽ� ��������� �����ϴ� ������ ��������� �������� �ʴ�
--��� ������ ����� ������.
--��������
insert into users values('U0001','Julie', 26,20,'010-1111-1111',06219,'����� ������ ����2��');
insert into users(user_num,id,age,tel,add_num) values('U0002','abc', 26,'010-1111-5678',019232);



--�Ҹ��� ����
insert into users values('U0003','Julie', 21,30,'010-1111-1252',06219,'��⵵ �Ⱦ�� ���ﵿ');
insert into users values('U0003','', 23,10,'010-8746-1923',12049,'��⵵ ��õ��');
insert into users(user_num,age) values('U0004', 26);
delete dept where deptno=10;
