--1. 배기량이 1500~3000 사이인 차량의 제조국,제조사,모델명,년식,가격, 이미지,입력일,배기량, 옵션을 조회
--   단. 출력은 배기량의 내림차순 정렬했을때 3~6번째 레코드만 조회하고,
--     옵션은 처음 ',' 까지만 출력 할것. 가격과 연식은 3자리마다 ,를 넣어출력,
--     입력일은 월-일-년 의 형식으로 출력 할것.

SELECT *
FROM(SELECT ROWNUM r, country,maker,model, car_year, TO_CHAR(price,'999,999') price, car_img,
		TO_CHAR(hiredate,'mm-dd-yyyy') hiredate, cc, car_option
		FROM(SELECT cc.country,cma.maker,cma.model,cmo.car_year, cmo.price, cmo.car_img,
			cmo.hiredate,cmo.cc,cmo.car_option
			FROM car_country cc, car_maker cma, car_model cmo
			WHERE (cma.maker=cc.maker AND cmo.model=cma.model)ORDER BY CC DESC)
	WHERE CC BETWEEN 1500 AND 3000)
WHERE r BETWEEN 3 AND 6;

--2. 부서번호가 10, 30,40번인 모든 부서의 사원번호,사원명,입사일,
--   연봉,연봉순위,부서명,부서번호,위치, 우편번호,시도, 구군,동,번지 를 조회.
--  단,출력은 사원번호의 오름차순으로 정렬했을 때 2~5번째 레코드만 출력,
--   우편번호는 '-' 뒤부터 끝까지 출력, 번지가 없다면 '번지없음'으로 대체
--  하여 출력 ,입사일은 월-일-년 요일까지 출력
SELECT empno,ename,TO_CHAR(hiredate,'mm-dd-yyyy') hi,sal,ranksal,dname, deptno,loc
	,SUBSTR(zipcode,INSTR(zipcode,'-')+1) zipcode, gugun, dong,NVL(bungi,'번지없음')

	FROM(SELECT ROW_NUMBER() OVER(ORDER BY empno) rnum, empno,ename,hiredate, sal,
			ranksal,dname,deptno,loc,zipcode,gugun,dong, bungi
		FROM(SELECT e.empno, e.ename, hiredate, e.sal,RANK() OVER(ORDER BY e.sal DESC) ranksal,
			d.dname, d.deptno, d.loc, z.zipcode, z.sido, z.gugun,z.dong,z.bungi
			FROM emp e, dept d, zipcode z
			WHERE (e.deptno(+)=d.deptno AND e.empno=z.seq))
		WHERE deptno IN(30,40, 10))
WHERE rnum BETWEEN 2 AND 5;

--
--량의 제조사가 '현대','기아','삼성','BMW','AUDI'이고 옵션에 'ABS','TCS'가
-- 있는 차량의  제조국, 제조사,모델명, 연식,가격, 옵션, 이미지, 배기량 조회
--  --단, 연식의 내림차순 정렬하고, 연식이 같다면 가격의 내림차순으로 정렬
--   하여 출력, 이미지는 이미지명과 확장자를 구분하여 출력할것,
--   제조사명이 영어라면 Bmw, Audi 의 형식으로 출력 .
SELECT *
FROM(SELECT country, INITCAP(maker) maker,model,car_year,price,car_option,
			SUBSTR(car_img,1,INSTR(car_img,'.')-1) img,SUBSTR(car_img,INSTR(car_img,'.')+1) filename, cc

		FROM (SELECT cc.country, cma.maker, cma.model,cmo.price, cmo.car_year, cmo.car_option, cmo.car_img, cmo.cc
				FROM car_country cc, car_maker cma, car_model cmo
				WHERE (cma.maker(+)=cc.maker AND cmo.model=cma.model) ORDER BY cmo.car_year DESC, cmo.price DESC)

		WHERE car_option LIKE '%ABS%' OR car_option LIKE '%TCS%')
WHERE maker IN('현대','기아','Bmw','Audi','삼성');

--4. 모델명이 'K5','아반테', '소렌토','A8','SM3' 인 차량의 번호, 모델명, 제조국,
--  제조사,가격,연식을 아래와 같은 형식의 문장으로 출력.
--  단,번호는 1번부터 출력하고,
--   출력 가격의 오름차순을 정렬했을 때 2~7 사이의 레코드만 출력,
--   [모델명] 차량의 연식은 [ xxxx ]이고, 제조국은 [국산|수입]이며,
--   [XX]사가 제조사입니다. 가격은 [0,000,000]원 입니다.

SELECT rprice, model||' 차량의 연식은 '||car_year||'이고, 제조국은 '||country||'이며, '||maker||'가 제조사입니다. 가격은 '||TO_CHAR(price, '9,999,999')||'원입니다.' output
FROM (SELECT ROW_NUMBER() OVER(ORDER BY price) rprice, model, country, maker, price, car_year
		FROM(SELECT cmo.model, cc.country, cc.maker, cmo.price, cmo.car_year
			  FROM car_country cc, car_maker cma, car_model cmo
			  WHERE (cma.maker = cc.maker AND cmo.model = cma.model)
			   AND cma.model IN ('K5','아반테','소렌토','A8','SM3')))
WHERE  rprice BETWEEN 2 AND 7;

--5. 제조사가 '현대'인 차량의 년식, 모델명, 연식별 총가격을 조회하세요.
SELECT   cmo.car_year, cmo.model, SUM(price) sum_of_price
FROM     car_maker cma, car_model cmo
WHERE    (cmo.model = cma.model)  AND   cma.maker='현대'
GROUP BY cmo.car_year, cmo.model ORDER BY cmo.car_year;


--6. 사원명이 'S'로 끝나거나 이름5자이면서 세번째 글자가 'A'인
--   사원의  사원번호, 사원명, 입사일,연봉,세금, 실수령액, 연봉인상액,
--   부서번호,부서명,위치,우편번호,시도, 구군,동,번지 를 조회
--   단,실수령액은 연봉+퇴직금+보너스-세금(연봉 3.3) 로 계산
--     연봉인상액은 부서번호에 따라 차등 인상
--     10- 년봉 7%, 20- 년봉 4%, 30- 년봉+보너스 10%, 그외 3%로
--     계산하여 3자리마다 ,를 넣어 출력.
--     모든 영어는 소문자로 출력.
SELECT  e.empno, LOWER(e.ename) ename, e.hiredate, e.sal, sal*0.033 tax,
        sal+TRUNC(sal/12, 0)+NVL(comm,0)-(sal*0.033) total,
        TO_CHAR(DECODE(e.deptno,10, sal*1.07 - sal,
        								20, sal*1.04 - sal,
        								30, (sal+NVL(comm,0))*1.1 - sal,sal*1.03 - sal), '999,999') sal_inc, d.deptno,
        LOWER(d.dname) dname, LOWER(d.loc) loc, z.zipcode, z.sido,
        z.gugun, z.dong, z.bungi
FROM	(SELECT * FROM   emp
         WHERE  emp.ename LIKE '%S' OR emp.ename LIKE '__A__') e, dept d, zipcode z
WHERE   (e.deptno(+) = d.deptno AND z.seq = e.empno);

--
--7.  아래 제시된 Data Dictionary를 파악한 후,  Dictionary를 사용하여
--   emp 테이블에 컬럼명,데이터형, 크기, defalut값, 제약사항명을 조회하세요.
--    단, 크기는 숫자인 경우 22자가 아닌 실제 크기를 출력.
--    Dictionary :  user_tab_cols , user_cons_columns, user_constraints

select * from user_cons_columns;
select * from user_tab_cols;
select * from user_constraints;
select * from all_tab_columns where table_name= 'EMP';

SELECT utc.column_name, utc.data_type,utc.data_length,utc.avg_col_len,utc.data_default, uc.constraint_name
FROM user_tab_cols utc, user_constraints uc
WHERE utc.table_name='EMP' AND utc.table_name(+) = uc.table_name;
