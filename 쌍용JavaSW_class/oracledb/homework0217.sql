
--1. ��� ���̺��� '10���� �μ��� �ƴϸ鼭 ������ 1000�̻� 3000������
--��� �������  �����ȣ,�����, �Ի���,�μ���ȣ, ������ ��ȸ�ϼ���.
select empno, ename hiredate, deptno, sal
from emp where deptno!=10 AND sal between 1000 and 3000;


/*2. ��� ���̺��� ���ʽ��� �����ϴ� �������  �����ȣ,�����,
    ����,���ʽ�, �� ���ɾ�, ������ ��ȸ �ϼ���.
    - ������ ������ 12������ ���� �����մϴ�.*/
select empno, ename, sal, comm, sal+comm total, ROUND(sal/12) mon_sal
from emp;

/*
3.  ��� ���̺��� �μ���ȣ�� 10,30��  ������� �����, �����ȣ  �Ի���, ������ ��ȸ �ϼ���.
    -��, �����  xxxx�� xxxx����� xxxx�⿡ �Ի��Ͽ��� ������ xxx$�Դϴ�.
        �� �������� �ϰ�, inline view�� �÷����� OutPut ���� ������ ��.
*/
select empno||'�� '||ename||'����� '||extract(year from hiredate)||'�⿡ �Ի��Ͽ���  ������ '|| sal||'$�Դϴ�.' as output from emp
where deptno in(10,30);

/*
4. ��� ���̺��� ������ 3000 �̸��� ������� �����ȣ, �����,
   �Ի���, ����,����, �μ���ȣ�� ��ȸ �ϼ���.
    ��, ������ ������������ ������ ��, ���� ������ �ִٸ� ������� ������������ ������ ��.*/

select empno, ename, hiredate, sal, job, deptno from emp
where sal<3000 order by sal, ename desc;

    /*
5. �Ʒ��� �����͸� �����Ͽ� test_like2 ���̺��� �����ϰ�  ���ڵ带 �߰��� ��.
   �÷��� : ��ȣ, �̸�, �ּ�, ��Ű���ϱ�
    1, ����������,����� ���۱� �󵵵�,�����
    2, ���븸,��⵵ ��õ�� ���̱�,��Ÿ��
    3, ���¼�,����� ���빮�� ���빮2��,�����
    4, �̳���,����� ���۱� �󵵵�,������
    5, ������,����� ���۱� ���빮4��,������
*/
create table test_like2(
	tno number(3),
	tname varchar2(15),
	tadd varchar2(100),
	thighschool varchar2(20)
);
insert into test_like2 values(1, '����������','����� ���۱� �󵵵�','�����');
commit;
insert into test_like2 values(2, '���븸','��⵵ ��õ�� ���̱�','��Ÿ��');
commit;
insert into test_like2 values(3, '���¼�','����� ���빮�� ���빮2��','�����');
commit;
insert into test_like2 values(4, '�̳���','����� ���۱� �󵵵�','������');
commit;
insert into test_like2 values(5, '������','����� ���۱� ���빮4��','������');
commit;


/*
6. test_like2 ���̺��� '�����'�� �����ϸ� �̸��� 3������ �л���  ��ȣ, �л���,  �ּ�, �б������� �Ʒ���  ���� �������� ����ϼ���.
   �÷����� ��ҹ��� �����Ͽ� OutPut����  �Ұ�.
    ������� :  ��ȣ : x, �̸� : xx, �ּ� : xx, �б� : xx
*/

select '��ȣ: '||tno||', �̸�: '||tname||', �ּ�: '||tadd||',�б� :'||thighschool as output
 from test_like2
 where tadd like '�����%' and tname like '___';

/*
7. ������̺��� ������� 4�����̰ų� ������ 3000�̻��� �����
   �����ȣ, �����, ����, �Ի���, �μ���ȣ, ������ ��ȸ �� ��.*/

select empno, ename, sal, hiredate, job from emp
where ename like '____' OR sal>3000;


/*
8. ��� ���̺��� �����ȣ, �����, �Ի���, ����, ���⿬���� ��ȸ �ϼ���.
    ���� ������ ���� �������� 7% ���� �ݾ����� ����Ͽ� ����� ��.
*/
select empno, ename, hiredate, sal, sal+sal*0.07 nextyear_sal
from emp;

/*
9. ��� ���̺��� ������� 'A'�� �����ϸ鼭 ������ 1600�̻���
     ����� �����,����,����, �Ŵ�����ȣ, �Ի����� ��ȸ �� ��.*/
select ename, sal, job, mgr, hiredate from emp
where ename like 'A__' and sal>=1600;
