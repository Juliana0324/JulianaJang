/*
숙제1.
 사원 테이블에서 연봉이 1500~3000사이인 사원의
  사원번호, 사원명, 연봉, 입사일, 부서번호, 직무, 매니저번호를 조회한 레코드를 사용하여
  emp_work테이블을 생성하고 추가합니다.
*/
create table emp_work as (select empno, ename,sal, hiredate, deptno, job, mgr from emp where sal in(1500,3000)
);
/*
숙제2.
  emp테이블에서 10번 30번 부서의 사원 정보를 조회하여 emp_work테이블에
  조회 결과를 추가합니다.
   단, 사원번호는 조회된 사원번호에 1000을 더한 값으로 추가할 것.
      원본 data 7788 -> insert 8788
*/
insert into emp_work(empno, ename,sal, hiredate,deptno,job,mgr)
(select empno+1000, ename,sal, hiredate,deptno,job,mgr from emp where deptno in(10,30));

/*
숙제 3.
 emp_work 테이블에서 10번 부서에 근무하는 사원들의 연봉을  emp테이블의
  사원번호가 7369번 사원 연봉과 7782번 사원의 연봉을 더한 금액으로 변경하세요.
*/
select * from emp_work;
update emp_work
--set sal=(select sal from emp where empno=7698)+(select sal from emp where empno=7782)
set sal=(select sum(sal) from emp where empno in(7698,7782))
where deptno=10;

/*
숙제4. cp_emp4 테이블에 아래와 같은 레코드를 추가하세요.
사원번호 : 가장 마지막 사원번호에서 1 증가한 번호, 사원명 :강명준, 직무 : 개발자,
  입사일 : 추가되는 시점의 다음날
  */
select * from cp_emp4;
insert into cp_emp4(empno, ename,job,hiredate) values((select max(empno)+1 from emp),'강명준','개발자',sysdate);

  /*
숙제4.아래와 같은 레코드를 저장할 수 있는  sales테이블을 생성하고 레코드를 추가하세요.
 번호 : 1, 상품명 : 키보드, 가격 : 20000, 판매일 : ‘2022-02-20’, 수량 : 1
 번호 : 2, 상품명 : 마우스, 가격 : 27000, 판매일 : ‘2022-02-20’, 수량 : 1
 번호 : 3, 상품명 : 모니터, 가격 : 350000, 판매일 : ‘2022-02-20’, 수량 : 1
 번호 : 4, 상품명 : 키보드, 가격 : 23000, 판매일 : ‘2022-02-20’, 수량 : 1
 번호 : 5, 상품명 : 키보드, 가격 : 15000, 판매일 : ‘2022-02-20’, 수량 : 1
 번호 : 6, 상품명 : 키보드, 가격 : 20000, 판매일 : ‘2022-02-21’, 수량 : 1
 번호 : 7, 상품명 : 마우스, 가격 : 13000, 판매일 : ‘2022-02-21’, 수량 : 1
 번호 : 8, 상품명 : 키보드, 가격 : 22000, 판매일 : ‘2022-02-21’, 수량 : 1
*/
create table sales(
	snum number(4),
	product varchar2(15),
	price number(7),
	saldate Date,
	nums number(3)
);

insert into sales values(1,'키보드',20000,'2022-02-20',1);
insert into sales values(2,'마우스',27000,'2022-02-20',1);
insert into sales values(3,'모니터',350000,'2022-02-20',1);
insert into sales values(4,'키보드',23000,'2022-02-20',1);
insert into sales values(5,'키보드',15000,'2022-02-20',1);
insert into sales values(6,'키보드',20000,'2022-02-21',1);
insert into sales values(7,'마우스',13000,'2022-02-21',1);
insert into sales values(8,'키보드',22000,'2022-02-21',1);
commit;
/*
숙제 5. 상품명, 총가격, 판매건수, 판매일, 입력일 을 저장할 수 있는  sales_adjustment 테이블을 생성하세요.
*/
create table sales_adjustment(product, price, nums, saldate) as
(select product, price, nums, saldate from sales where 1=0);

alter table sales_adjustment add inputdate date;
select * from sales_adjustment;

/*
숙제6. sales 테이블에서 ‘2022-02-20’ 에 판매된 상품의 상품명, 총가격, 판매건수 를  sales_adjustment
    테이블에 추가하세요. -정산
   추가   예)
     키보드, 58000, 3, 2022-02-20, 오늘
     마우스 , 27000,1,  위와동일
     모니터, 350000,1, 위와동일*/

     --이문제는 그룹함수를사용하시면 편해요  => 정산은 한번에 insert작업을 하는 걸 의미해요.
 insert into sales_adjustment(product, price, nums, saldate,inputdate)
 (select product,sum(price),sum(nums), saldate,sysdate
  from sales
  where saldate='2022-02-20'
  group by product,saldate);


--insert into sales_adjustment(product, price, nums, saldate,inputdate)
--values('키보드', (select sum(price) from sales where product='키보드' and saldate='2022-02-20'),
--(select count(*) sales from sales where product='키보드'  and saldate='2022-02-20'),'2022-02-20', sysdate);
--
--insert into sales_adjustment(product, price, nums, saldate,inputdate)
--values('마우스', (select sum(price) from sales where product='마우스' and saldate='2022-02-20'),
--(select count(*) sales from sales where product='마우스'  and saldate='2022-02-20'),'2022-02-20', sysdate);
--
--insert into sales_adjustment(product, price, nums, saldate,inputdate)
--values('모니터', (select sum(price) from sales where product='모니터' and saldate='2022-02-20'),
--(select count(*) sales from sales where product='모니터'  and saldate='2022-02-20'),'2022-02-20', sysdate);

select * from sales_adjustment;

