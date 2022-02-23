-- 1. zipcode ���̺��� �����Ͽ� cp_zipcode ���̺��� �����ϼ���.
create table cp_zipcode as (select * from zipcode);

-- 2. zipcode ���̺� seq�÷��� PK�� �����ϼ���.
alter table cp_zipcode add constraint pk_zipcode primary key(seq);

--3. �Ʒ��� ��������� �����Ͽ� ���̺��� �����ϼ���.
--  ���� ������ : ���̵�, �̸�, �ּ�seq, ��ȭ��ȣ, ����, ����, �Է���
--
-- - ���̵�� null�� ������� �����鼭 �����մϴ�.
-- - �̸��� �ݵ�� �ԷµǾ�� �մϴ�.
-- - �ּ�seq�� null�� ��������� ���� ���� ������  cp_zipcode ���̺� �����ϴ�
--    �����θ� �Է°����մϴ�.
-- - ��ȭ��ȣ�� ���� ���� ������ �ִٸ� ���� �մϴ�.
-- - ���̴� �÷����� �����Ǿ� insert�Ǵ� ��� 0���� �����մϴ�.
-- - ������ ��M�� �Ǵ� ��F���θ� �Է°����մϴ�.
-- - �Է����� �÷����� �����Ǿ� insert�Ǵ� ��� ���� ���ڷ� �߰��մϴ�.
select * from cp_zipcode;
create table user_info(
	id number(10) primary key,
	name 	varchar2(30) not null,
	addr_seq number(3),
	tel varchar2(20) constraint ui_tel unique,
	gender char(2) check (gender in('M','F')),
	input_date	date default sysdate,
	foreign key(addr_seq) references cp_zipcode(seq)
	);

	alter table user_info modify addr_seq number(6);
   alter table user_info modify id varchar2(10);

-- 4. 3������ ���������̺� �Ʒ��� ���� �����͸� �߰��ϼ���
--   1, jung,���μ�,168,  010-1234-7890,F,������
--   2, kim,������,52144,  010-2234-8811,F,������
--   3, kang,����,3298,  010-8471-1345,M,������
--   4, test,�׽�Ʈ,,  010-1111-2222,M,������
delete user_info;
select * from user_info;
insert into user_info(id,name,addr_seq,tel,gender,input_date) values('jung','���μ�',168,'010-1234-7890','F',sysdate);
insert into user_info(id,name,addr_seq,tel,gender,input_date) values('kim','������',52144,'010-1234-8811','F',sysdate);
insert into user_info(id,name,addr_seq,tel,gender,input_date) values('kang','����',3298,'010-8471-1345','M',sysdate);
insert into user_info(id,name,tel,gender,input_date) values('test','�׽�Ʈ','010-1111-2222','M',sysdate);

-- 5. ���̵�, �̸�, ��ȭ��ȣ, �����ȣ, �ּҸ� ��ȸ�ϼ���.
--    ��, �ּҰ� �����ϴ� ���ڵ常 ��ȸ�ϼ���.
--       �ּҴ� copy_zipcode ���̺� sido,gugun,dong,bunji �÷��� �����Ͽ� �ϳ��� ����մϴ�.
select * from cp_zipcode;

select u.id,u.name, u.tel,u.addr_seq, c.sido, c.gugun, c.dong, c.bungi
from user_info u
inner join cp_zipcode c
on u.addr_seq = c.seq;
