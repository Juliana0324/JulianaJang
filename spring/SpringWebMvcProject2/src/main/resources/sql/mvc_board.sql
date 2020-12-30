--게시판 테이블 생성
CREATE TABLE mvc_board(
    board_no NUMBER PRIMARY KEY,
    title VARCHAR2(100) NOT NULL,
    content VARCHAR2(300) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    reg_date DATE DEFAULT SYSDATE,
    view_cnt NUMBER DEFAULT 0
);

--BOARD NUMBER 에 대한 시퀀스
CREATE SEQUENCE board_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 1000
    NOCYCLE 
    NOCACHE;