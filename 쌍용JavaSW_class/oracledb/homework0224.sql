--1. ��ⷮ�� 1500~3000 ������ ������ ������,������,�𵨸�,���,����, �̹���,�Է���,��ⷮ, �ɼ��� ��ȸ
--   ��. ����� ��ⷮ�� �������� ���������� 3~6��° ���ڵ常 ��ȸ�ϰ�,
--     �ɼ��� ó�� ',' ������ ��� �Ұ�. ���ݰ� ������ 3�ڸ����� ,�� �־����,
--     �Է����� ��-��-�� �� �������� ��� �Ұ�.

SELECT *
FROM(SELECT ROWNUM r, country,maker,model, car_year, TO_CHAR(price,'999,999') price, car_img,
		TO_CHAR(hiredate,'mm-dd-yyyy') hiredate, cc, car_option
		FROM(SELECT cc.country,cma.maker,cma.model,cmo.car_year, cmo.price, cmo.car_img,
			cmo.hiredate,cmo.cc,cmo.car_option
			FROM car_country cc, car_maker cma, car_model cmo
			WHERE (cma.maker=cc.maker AND cmo.model=cma.model)ORDER BY CC DESC)
	WHERE CC BETWEEN 1500 AND 3000)
WHERE r BETWEEN 3 AND 6;

--2. �μ���ȣ�� 10, 30,40���� ��� �μ��� �����ȣ,�����,�Ի���,
--   ����,��������,�μ���,�μ���ȣ,��ġ, �����ȣ,�õ�, ����,��,���� �� ��ȸ.
--  ��,����� �����ȣ�� ������������ �������� �� 2~5��° ���ڵ常 ���,
--   �����ȣ�� '-' �ں��� ������ ���, ������ ���ٸ� '��������'���� ��ü
--  �Ͽ� ��� ,�Ի����� ��-��-�� ���ϱ��� ���
SELECT empno,ename,TO_CHAR(hiredate,'mm-dd-yyyy') hi,sal,ranksal,dname, deptno,loc
	,SUBSTR(zipcode,INSTR(zipcode,'-')+1) zipcode, gugun, dong,NVL(bungi,'��������')

	FROM(SELECT ROW_NUMBER() OVER(ORDER BY empno) rnum, empno,ename,hiredate, sal,
			ranksal,dname,deptno,loc,zipcode,gugun,dong, bungi
		FROM(SELECT e.empno, e.ename, hiredate, e.sal,RANK() OVER(ORDER BY e.sal DESC) ranksal,
			d.dname, d.deptno, d.loc, z.zipcode, z.sido, z.gugun,z.dong,z.bungi
			FROM emp e, dept d, zipcode z
			WHERE (e.deptno(+)=d.deptno AND e.empno=z.seq))
		WHERE deptno IN(30,40, 10))
WHERE rnum BETWEEN 2 AND 5;

--
--���� �����簡 '����','���','�Ｚ','BMW','AUDI'�̰� �ɼǿ� 'ABS','TCS'��
-- �ִ� ������  ������, ������,�𵨸�, ����,����, �ɼ�, �̹���, ��ⷮ ��ȸ
--  --��, ������ �������� �����ϰ�, ������ ���ٸ� ������ ������������ ����
--   �Ͽ� ���, �̹����� �̹������ Ȯ���ڸ� �����Ͽ� ����Ұ�,
--   ��������� ������ Bmw, Audi �� �������� ��� .
SELECT *
FROM(SELECT country, INITCAP(maker) maker,model,car_year,price,car_option,
			SUBSTR(car_img,1,INSTR(car_img,'.')-1) img,SUBSTR(car_img,INSTR(car_img,'.')+1) filename, cc

		FROM (SELECT cc.country, cma.maker, cma.model,cmo.price, cmo.car_year, cmo.car_option, cmo.car_img, cmo.cc
				FROM car_country cc, car_maker cma, car_model cmo
				WHERE (cma.maker(+)=cc.maker AND cmo.model=cma.model) ORDER BY cmo.car_year DESC, cmo.price DESC)

		WHERE car_option LIKE '%ABS%' OR car_option LIKE '%TCS%')
WHERE maker IN('����','���','Bmw','Audi','�Ｚ');

--4. �𵨸��� 'K5','�ƹ���', '�ҷ���','A8','SM3' �� ������ ��ȣ, �𵨸�, ������,
--  ������,����,������ �Ʒ��� ���� ������ �������� ���.
--  ��,��ȣ�� 1������ ����ϰ�,
--   ��� ������ ���������� �������� �� 2~7 ������ ���ڵ常 ���,
--   [�𵨸�] ������ ������ [ xxxx ]�̰�, �������� [����|����]�̸�,
--   [XX]�簡 �������Դϴ�. ������ [0,000,000]�� �Դϴ�.

SELECT rprice, model||' ������ ������ '||car_year||'�̰�, �������� '||country||'�̸�, '||maker||'�� �������Դϴ�. ������ '||TO_CHAR(price, '9,999,999')||'���Դϴ�.' output
FROM (SELECT ROW_NUMBER() OVER(ORDER BY price) rprice, model, country, maker, price, car_year
		FROM(SELECT cmo.model, cc.country, cc.maker, cmo.price, cmo.car_year
			  FROM car_country cc, car_maker cma, car_model cmo
			  WHERE (cma.maker = cc.maker AND cmo.model = cma.model)
			   AND cma.model IN ('K5','�ƹ���','�ҷ���','A8','SM3')))
WHERE  rprice BETWEEN 2 AND 7;

--5. �����簡 '����'�� ������ ���, �𵨸�, ���ĺ� �Ѱ����� ��ȸ�ϼ���.
SELECT   cmo.car_year, cmo.model, SUM(price) sum_of_price
FROM     car_maker cma, car_model cmo
WHERE    (cmo.model = cma.model)  AND   cma.maker='����'
GROUP BY cmo.car_year, cmo.model ORDER BY cmo.car_year;


--6. ������� 'S'�� �����ų� �̸�5���̸鼭 ����° ���ڰ� 'A'��
--   �����  �����ȣ, �����, �Ի���,����,����, �Ǽ��ɾ�, �����λ��,
--   �μ���ȣ,�μ���,��ġ,�����ȣ,�õ�, ����,��,���� �� ��ȸ
--   ��,�Ǽ��ɾ��� ����+������+���ʽ�-����(���� 3.3) �� ���
--     �����λ���� �μ���ȣ�� ���� ���� �λ�
--     10- ��� 7%, 20- ��� 4%, 30- ���+���ʽ� 10%, �׿� 3%��
--     ����Ͽ� 3�ڸ����� ,�� �־� ���.
--     ��� ����� �ҹ��ڷ� ���.
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
--7.  �Ʒ� ���õ� Data Dictionary�� �ľ��� ��,  Dictionary�� ����Ͽ�
--   emp ���̺� �÷���,��������, ũ��, defalut��, ������׸��� ��ȸ�ϼ���.
--    ��, ũ��� ������ ��� 22�ڰ� �ƴ� ���� ũ�⸦ ���.
--    Dictionary :  user_tab_cols , user_cons_columns, user_constraints

select * from user_cons_columns;
select * from user_tab_cols;
select * from user_constraints;
select * from all_tab_columns where table_name= 'EMP';

SELECT utc.column_name, utc.data_type,utc.data_length,utc.avg_col_len,utc.data_default, uc.constraint_name
FROM user_tab_cols utc, user_constraints uc
WHERE utc.table_name='EMP' AND utc.table_name(+) = uc.table_name;
