select * from tab;
-- ����: ���̺��� �÷������� �µ��� ���� �߰�
--
INSERT INTO STUDENT VALUES(1,'������',26,'chiang324@naver.com','D',161.9,sysdate);
select * from student;
select * from emp where job='SALESMAN' order by ename asc;
select num, name, age, email, class, height, input_date from student;
commit;

select * from dept;

select * from dept where deptno<= all(30,50);

--Į���� ����Ͽ� �߰�
-- ���ϴ� �÷��� �߰��Ҽ� ����(��� ������ ���� ���ϴ��� �߰�����)
-- �����Ǵ� Į������ NULL�� �Էµ�(���ڵ� ���ڵ� �ƴ� ��)
INSERT INTO STUDENT(NUM,NAME,AGE,EMAIL,HEIGHT,INPUT_DATE) VALUES(2,'������',25,'seo@doum.net',170.3,sysdate);
commit;

INSERT INTO STUDENT (NUM,NAME,AGE,EMAIL,input_date) VALUES(3,'����',27,'kang@sist.co.kr',sysdate);
delete from student where name='����' and input_date='';

select * from student where name='����' and height is null;

update student set class='D' where num=2;
commit;

update student set class='E',height=184.6 where num=3;




INSERT INTO STUDENT (NUM,NAME,AGE,EMAIL,input_date) VALUES(3,'������',28,'mo@sist.co.kr',sysdate);

--��ȣ�� 3���� ������ �� k�� Ű�� 170.2, email: hyunmo@naver.com
update student set height=170.2,email='hyunmo@naver.com',class='K'
where num=3 and name like '%��%';
select * from student order by num;
commit;


