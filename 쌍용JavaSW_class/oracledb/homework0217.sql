
--1. 사원 테이블에서 '10‘번 부서가 아니면서 연봉이 1000이상 3000이하의
--모든 사원들의  사원번호,사원명, 입사일,부서번호, 연봉을 조회하세요.
select empno, ename hiredate, deptno, sal
from emp where deptno!=10 AND sal between 1000 and 3000;


/*2. 사원 테이블에서 보너스를 수령하는 사원들의  사원번호,사원명,
    연봉,보너스, 총 수령액, 월급을 조회 하세요.
    - 월급은 연봉을 12개월로 나눠 연산합니다.*/
select empno, ename, sal, comm, sal+comm total, ROUND(sal/12) mon_sal
from emp;

/*
3.  사원 테이블에서 부서번호가 10,30인  사원들의 사원명, 사원번호  입사일, 연봉을 조회 하세요.
    -단, 출력은  xxxx번 xxxx사원님 xxxx년에 입사하였고 연봉은 xxx$입니다.
        의 형식으로 하고, inline view의 컬럼명은 OutPut 으로 설정할 것.
*/
select empno||'번 '||ename||'사원님 '||extract(year from hiredate)||'년에 입사하였고  연봉은 '|| sal||'$입니다.' as output from emp
where deptno in(10,30);

/*
4. 사원 테이블에서 연봉이 3000 미만인 사원들의 사원번호, 사원명,
   입사일, 연봉,직무, 부서번호를 조회 하세요.
    단, 연봉의 오름차순으로 정렬할 것, 동일 연봉이 있다면 사원명의 내림차순으로 정렬할 것.*/

select empno, ename, hiredate, sal, job, deptno from emp
where sal<3000 order by sal, ename desc;

    /*
5. 아래의 데이터를 참조하여 test_like2 테이블을 생성하고  레코드를 추가할 것.
   컬럼명 : 번호, 이름, 주소, 출신고등하교
    1, 기임저엉은,서울시 동작구 상도동,정기고
    2, 정대만,경기도 부천시 원미구,썸타고
    3, 송태섭,서울시 동대문구 동대문2동,정기고
    4, 이내혁,서울시 동작구 상도동,오지고
    5, 김현우,서울시 동작구 동대문4동,지리고
*/
create table test_like2(
	tno number(3),
	tname varchar2(15),
	tadd varchar2(100),
	thighschool varchar2(20)
);
insert into test_like2 values(1, '기임저엉은','서울시 동작구 상도동','정기고');
commit;
insert into test_like2 values(2, '정대만','경기도 부천시 원미구','썸타고');
commit;
insert into test_like2 values(3, '송태섭','서울시 동대문구 동대문2동','정기고');
commit;
insert into test_like2 values(4, '이내혁','서울시 동작구 상도동','오지고');
commit;
insert into test_like2 values(5, '김현우','서울시 동작구 동대문4동','지리고');
commit;


/*
6. test_like2 테이블에서 '서울시'에 거주하며 이름이 3글자인 학생의  번호, 학생명,  주소, 학교정보를 아래와  같은 형식으로 출력하세요.
   컬럼명은 대소문자 구분하여 OutPut으로  할것.
    출력형식 :  번호 : x, 이름 : xx, 주소 : xx, 학교 : xx
*/

select '번호: '||tno||', 이름: '||tname||', 주소: '||tadd||',학교 :'||thighschool as output
 from test_like2
 where tadd like '서울시%' and tname like '___';

/*
7. 사원테이블에서 사원명이 4글자이거나 연봉이 3000이상인 사원의
   사원번호, 사원명, 연봉, 입사일, 부서번호, 직무를 조회 할 것.*/

select empno, ename, sal, hiredate, job from emp
where ename like '____' OR sal>3000;


/*
8. 사원 테이블에서 사원번호, 사원명, 입사일, 연봉, 내년연봉을 조회 하세요.
    내년 연봉은 현재 연봉보다 7% 향상된 금액으로 계산하여 출력할 것.
*/
select empno, ename, hiredate, sal, sal+sal*0.07 nextyear_sal
from emp;

/*
9. 사원 테이블에서 사원명이 'A'로 시작하면서 연봉이 1600이상인
     사원의 사원명,연봉,직무, 매니저번호, 입사일을 조회 할 것.*/
select ename, sal, job, mgr, hiredate from emp
where ename like 'A__' and sal>=1600;
