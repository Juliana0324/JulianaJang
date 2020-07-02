--09_SEQUENCE.SQL
-- 기본키: PRIMARY KEY: 각 행을 유일하게 구분할 수 있는 칼럼
-- 기본키는 유일한 값을 가져야 하는데, 사용자가 그것을 매번 직접 생성하려면 귀찮
-- 기본키로 사용할 목적으로 자동으로 겹치지 않는 숫자를 생성하는 프로그램을 구현해 놓은 것을 DB의 시퀀스 라고 한다
-- 즉, 시퀀스는 자동번호 발생기
/*
    CREATE SEQUENCE 시퀀스명
        INCREMENT BY 증감숫자   --기본값 : +1, 양수/음수 모두 사용가능
        START WITH 시작숫자     -- 시작값을 설정할 수 있다, 기본값은 증가일 떄 MINVALUE, 감소일때 MAXVALUE
        MINVALUE 최소값        -- 시퀸스의 최소값을 설정한다
        MAXVALUE 최대값        -- 시퀸스의 최대값을 설정한다
        CYCLE/ NOCYCLE        -- CYCLE 인 경우 최대값에 도달하면 최소값부터 다시시작
        CACHE SIZE /NOCACHE       -- 다음번호를 미리 생성해 놓을지 말지를 결정한다
    
*/
SELECT * FROM user_sequences;
SELECT * FROM ALL_sequences;

SELECT * FROM MY_MEMBER;
DELETE FROM MY_MEMBER;
COMMIT;

--시퀀스 생성

CREATE SEQUENCE MY_MEMBER_MEMNO_SEQ NOCYCLE NOCACHE;

--시퀀스를 사용해 데이터 생성
INSERT INTO
    MY_MEMBER (MEM_NO, MEM_NAME, MEM_AGE)
VALUES 
    (MY_MEMBER_MEMNO_SEQ.nextval, 'tester', 10); 
    --시퀀스명.nextval :다음숫자를 꺼내서 사용한다.숫자를 갱신한다.
SELECT * FROM MY_MEMBER;
-- 서브쿼리를 이용해 데이터를 생성하면서 시퀸스 이용하기
INSERT INTO
    my_member(MEM_NO,MEM_NAME,MEM_AGE)
    (SELECT MY_MEMBER_MEMNO_SEQ.NEXTVAL,MEM_NAME,MEM_AGE FROM MY_MEMBER);
    
COMMIT;
-- DUAL: 테스트용 테이블
SELECT MY_MEMBER_MEMNO_SEQ.CURRVAL FROM DUAL;
-- 현재값: CURRVAL(다음번호 바로 전)
SELECT 10+10 FROM DUAL;

/*
    시퀀스 수정
    ALTER SEQUENCE 시퀀스 명
        INCREMENT BY 증감숫자   --기본값 : +1, 양수/음수 모두 사용가능
        START WITH 시작숫자     -- 시작값을 설정할 수 있다, 기본값은 증가일 떄 MINVALUE, 감소일때 MAXVALUE
        MINVALUE 최소값        -- 시퀸스의 최소값을 설정한다
        MAXVALUE 최대값        -- 시퀸스의 최대값을 설정한다
        CYCLE/ NOCYCLE        -- CYCLE 인 경우 최대값에 도달하면 최소값부터 다시시작
        CACHE SIZE /NOCACHE       -- 다음번호를 미리 생성해 놓을지 말지를 결정한다
    한번 지나가 버린 시퀸스 값을 예전으로 돌릴수는 없다
*/
ALTER SEQUENCE MY_MEMBER_MEMNO_SEQ INCREMENT BY 2;
SELECT * FROM MY_MEMBER ORDER BY MEM_NO DESC;
--시퀸스 삭제
--DROP SEQUENCE 시퀸스명;

-- 만들어온 테이블에서 사용할 시퀸스를 생성하고 INSERT로 데이터를 여러개 추가해보세요
-- 1. 시퀸스를 사용할 적당한 칼럼을 고른다 (없다면 ALTER TABLE추가)
-- 2. 시퀀스 생성
-- 3. 데이터 생성
CREATE TABLE MY_SCORE03(
    MY_NO NUMBER(12),
    MY_NAME VARCHAR2(10),
    MY_AGE NUMBER(3),
    MY_KOR NUMBER(3),
    MY_MATH NUMBER(3),
    MY_ENG NUMBER(3),
    MY_AVG NUMBER(6,3)
);

CREATE SEQUENCE MY_SCORE03_MY_NO_SEQ NOCYCLE NOCACHE;

INSERT INTO 
    MY_SCORE03(MY_NO,MY_NAME,MY_AGE,MY_KOR,my_math,my_eng, MY_AVG)
VALUES 
    (MY_SCORE03_MY_NO_SEQ.nextval, '안뇽', 10,80,50,70, round((80+50+70)/3, 3)); 

SELECT * FROM MY_SCORE03;
