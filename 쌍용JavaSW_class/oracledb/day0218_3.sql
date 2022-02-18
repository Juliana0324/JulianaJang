select to_char(2022,'0,000,000'), to_char(2022, '9,999,999')
from dual;

select sysdate, to_char(sysdate,'yyyy-mm-dd am day dy d hh24')
from dual;

select empno, ename, to_char(sal,'9,999,999') sal, to_char(hiredate,'mm-dd-yyyy dy') from emp;

select empno, ename, hiredate,to_char(hiredate, 'q') 분기 from emp where to_char(hiredate,'q') in(3,4) order by hiredate;

select to_date('2022-02-18') from dual;

--todate 함수
insert into student(snum, sname, input_date) values(6,'김진영',to_date('2022-02-15','yyyy-mm-dd'));
commit;

select snum,sname, to_char(input_date, 'yyyy-mm-dd am q"분기" hh24:mi:ss') from student;
select to_char(sysdate,'yy')
from dual;

select top(2) with ties ename, sal from emp order by sal desc;

--to_number
select to_number('') from dual;

select empno, ename,hiredate from emp where to_char(sysdate,'mm')=to_char(hiredate, 'mm');

--학생테이블에서 11시 17분 49초에 입력된 데이터를 삭제해도세요
select * from student;
delete from student where to_char(input_date,'HH24MISS')= '111749';

select count(*) from emp;

--사원테이블에서 보너스를 수령하지 않는 사원수
select count(*) from emp where comm is null;
select comm, count(*) from emp group by comm;

select sum(sal),avg(sal),max(sal),min(sal) from emp;


select * from emp where sal>=(select avg(sal) from emp);

select decode('B','A','소심하다','B','터프하다','AB','천재','O','우유부단','사람이 아닙니다')
from dual;

--부서번호 부서명
select deptno, dname,decode(deptno, 10,'개발', 20,'유지보수',30,'운영', '영업') from dept;
