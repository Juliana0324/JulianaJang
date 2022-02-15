select * from tab;
-- 주의: 테이블의 컬럼순서에 맞도록 값을 추가
--
INSERT INTO STUDENT VALUES(1,'장정우',26,'chiang324@naver.com','D',161.9,sysdate);
select * from student;
select * from emp where job='SALESMAN' order by ename asc;
select num, name, age, email, class, height, input_date from student;
commit;

select * from dept;

select * from dept where deptno<= all(30,50);

--칼럼을 명시하여 추가
-- 원하는 컬럼만 추가할수 있음(모든 정보를 알지 못하더라도 추가가능)
-- 생략되는 칼럼에는 NULL이 입력됨(숫자도 문자도 아닌 값)
INSERT INTO STUDENT(NUM,NAME,AGE,EMAIL,HEIGHT,INPUT_DATE) VALUES(2,'서지숙',25,'seo@doum.net',170.3,sysdate);
commit;

INSERT INTO STUDENT (NUM,NAME,AGE,EMAIL,input_date) VALUES(3,'강산',27,'kang@sist.co.kr',sysdate);
delete from student where name='강산' and input_date='';

select * from student where name='강산' and height is null;

update student set class='D' where num=2;
commit;

update student set class='E',height=184.6 where num=3;




INSERT INTO STUDENT (NUM,NAME,AGE,EMAIL,input_date) VALUES(3,'강현모',28,'mo@sist.co.kr',sysdate);

--번호가 3번인 강현모를 반 k로 키를 170.2, email: hyunmo@naver.com
update student set height=170.2,email='hyunmo@naver.com',class='K'
where num=3 and name like '%현%';
select * from student order by num;
commit;


