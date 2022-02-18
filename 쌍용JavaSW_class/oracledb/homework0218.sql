/*
숙제
1. 사원테이블에서 사원번호, 사원명,직무, 매니저번호,연봉,
   입사일을 조회하세요.
 단, 입사일은 ‘월-일-년 요일’의 형식으로 출력하세요.
    연봉은 3자리마다 ,를 넣어 출력하세요.
*/
select empno, ename, job, mgr, to_char(sal,'99,999,999'), to_char(hiredate,'mm-dd-yyyy day') hiredate from emp;

/*
2. 사원테이블에서 부서번호, 사원번호, 연봉, 보너스, 총수령액, 실수령액, 월급
 입사일을 조회하세요.
   단. 총 수령액은 '연봉+보너스'를 합산한 금액으로 조회하세요.
       실 수령액은 ‘연봉+보너스를 합산한 금액에서 3.3%를 제외한 금액’으로 조회,
     월급은 연봉을 12로 나눈 값을 원단위 절사하여 조회하세요.
*/

select deptno, empno, sal, comm, sal+comm total, (sal+comm)*0.967 real_total, trunc(sal/12) monthly, hiredate from emp;

/*
3. 아래의 데이터를 참조하여 test1 테이블을 생성하고  레코드를 추가할 것.
   컬럼명 : 이름, 나이, 태어난해, 주민번호
     정인선,25,1995,’950101-2234567‘
     황성준,25,1995,’951126-1234567‘
     장정우,26,1994,’940101-2234567‘   신유철,26,1994,’940101-1234567‘*/

create table test1(
	name varchar2(15),
	age number(3),
	bornyear number(4),
	security_num varchar2(15)
);

insert into test1 values('정인선',25,1995,'950101-2234567');
insert into test1 values('황성준',25,1995,'951126-1234567');
insert into test1 values('장정우',26,1994,'940101-2234567');
insert into test1 values('신유철',26,1994,'940101-1234567');
commit;
/*
4. test1 테이블에서 이름 ,나이, 태어난 해, 주민번호,  성별을 조회 하세요.
   -성별은 주민번호의  8번째 자리로 구하고,
   8번째 자리가 1,3이면 '남자', 2,4면 '여자' 5,6,7,8이면 '외국인'그렇지
   않으면 "오류" 로 출력한다.
   -태어난해는 나이를 사용하여 구한다.
*/
select name, age, bornyear, security_num, decode(substr(security_num,8,1)
														,'1','남자'
														,'3','남자'
														,'2','여자'
														,'4','여자'
														,'5','외국인'
														,'6','외국인'
														,'7','외국인'
														,'8','외국인', '오류')gender
from test1;

/*
5.emp테이블을 사용하여 아래와 같이 조회 하세요.
  xxx번 Xxxx사원입 입사일은 yyyy-mm-dd 요일 일 입니다. 연봉은 xxx $입니다.
 단. 입사요일이 월,화,목에 입사한 사원에 대해서만 조회합니다.
     사원명은 첫글자만 대문자로 조회하고, 입사일의 오름차순 정렬하여 출력하되
     입사일이 같다면 연봉의 내림차순으로 정렬하여 출력하세요.
      연봉은 3자리마다 ,를 넣어서출력하세요.*/
select empno||'번 '||initcap(ename)||'사원님의 입사일은 '||to_char(hiredate,'yyyy-mm-dd day"요일입니다. 연봉은"')||to_char(sal,'99,999,999')||'$입니다' test from emp
where  to_char(hiredate, 'd') in(2,3) or to_char(hiredate, 'd')=5 order by hiredate,sal desc;


/*

6. dept테이블에서 '딸'이 많은 지역에 있는 부서의 부서번호, 부서명을 조회하세요. (nonsense)

*/

select deptno, dname from dept where loc = upper('dallas');
