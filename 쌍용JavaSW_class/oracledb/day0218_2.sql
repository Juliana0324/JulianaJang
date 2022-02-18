--문자열의 인덱스 찾기
--instr
select instr('hello','lo') from dual;

select * from student;
update student set semail='yusist.co.kr' where snum=1;
commit;
update student set semail='jun@googlecom' where snum=4;
commit;

--학생테이블에서
select * from student;
select snum,sname,sphnum,semail,input_date from student where instr(semail,'@')>0 and instr(semail,'.')>0;

select length('A
A') from dual;

select snum, sname, semail, sphnum, input_date from student where instr(semail,'@')=0 or instr(semail,'.')=0;

--substr(문자열, 시작인덱스, 자를 글자수)
select substr('ABCDE',2,3) from dual;
select substr('Oracle',3,3) from dual;
select substr('가나다라마',2,4),substr('ABCDE',2) from dual;

--학생테이블에서 메일주소가 올바른 학생에 대해서만
select sname,semail, substr(semail,1,instr(semail,'@')-1) mailadd, substr(semail,instr(semail,'@')+1) domain from student
where instr(semail,'@')>0 and instr(semail,'.')>0;

select '['||'    A bc    '||']','['||trim('    A bc    ')||']'
,'['||ltrim('    A bc    ')||']','['||rtrim('    A bc    ')||']'
, trim('a' from 'aaaaOracleaaa') from dual;

--문자열 앞에 특정문자열 채우기
select lpad('ABCD',10,'@'),lpad('ABCD',12,'lol'),rpad('ABCD',10,'#') from dual;

--concat
select concat('a','bcd')
from dual;

select empno, ename, concat('$',lpad(sal,8,'0')) sal from emp;

--null변환
select nvl('','없음'),nvl2('a','있음','없음') from dual;
select empno, ename, sal, comm, nvl2(comm,comm,0) from emp;
select empno, ename, sal, comm, nvl(comm,0) from emp;

update student set address='' where snum=1;
update student set address='' where snum=4;
commit;
select * from student;
select snum, sname, nvl(address,'주소 없음') from student;

--데이터 형이 다르다면 에러
select empno, ename, sal, comm, nvl(comm,'0$') from emp;

--사원테이블에서 사원번호,사원명, 매니저 존재 유무
select empno, ename, nvl2(mgr, '있음','없음') from emp;

select * from emp;
