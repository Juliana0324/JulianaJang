--���ڿ��� �ε��� ã��
--instr
select instr('hello','lo') from dual;

select * from student;
update student set semail='yusist.co.kr' where snum=1;
commit;
update student set semail='jun@googlecom' where snum=4;
commit;

--�л����̺���
select * from student;
select snum,sname,sphnum,semail,input_date from student where instr(semail,'@')>0 and instr(semail,'.')>0;

select length('A
A') from dual;

select snum, sname, semail, sphnum, input_date from student where instr(semail,'@')=0 or instr(semail,'.')=0;

--substr(���ڿ�, �����ε���, �ڸ� ���ڼ�)
select substr('ABCDE',2,3) from dual;
select substr('Oracle',3,3) from dual;
select substr('�����ٶ�',2,4),substr('ABCDE',2) from dual;

--�л����̺��� �����ּҰ� �ùٸ� �л��� ���ؼ���
select sname,semail, substr(semail,1,instr(semail,'@')-1) mailadd, substr(semail,instr(semail,'@')+1) domain from student
where instr(semail,'@')>0 and instr(semail,'.')>0;

select '['||'    A bc    '||']','['||trim('    A bc    ')||']'
,'['||ltrim('    A bc    ')||']','['||rtrim('    A bc    ')||']'
, trim('a' from 'aaaaOracleaaa') from dual;

--���ڿ� �տ� Ư�����ڿ� ä���
select lpad('ABCD',10,'@'),lpad('ABCD',12,'lol'),rpad('ABCD',10,'#') from dual;

--concat
select concat('a','bcd')
from dual;

select empno, ename, concat('$',lpad(sal,8,'0')) sal from emp;

--null��ȯ
select nvl('','����'),nvl2('a','����','����') from dual;
select empno, ename, sal, comm, nvl2(comm,comm,0) from emp;
select empno, ename, sal, comm, nvl(comm,0) from emp;

update student set address='' where snum=1;
update student set address='' where snum=4;
commit;
select * from student;
select snum, sname, nvl(address,'�ּ� ����') from student;

--������ ���� �ٸ��ٸ� ����
select empno, ename, sal, comm, nvl(comm,'0$') from emp;

--������̺��� �����ȣ,�����, �Ŵ��� ���� ����
select empno, ename, nvl2(mgr, '����','����') from emp;

select * from emp;
