CREATE OR REPLACE PROCEDURE insert_test_proc(num number, name varchar2, email varchar2,
age number, row_cnt OUT number, errMsg OUT varchar2)
IS
BEGIN
	INSERT INTO test_procedure(num, name, email, age) VALUES(num, name, email, age);
	--쿼리가 수행된 행의 수를 변수에 저장
	row_cnt := sql%rowcount;
	--수행한 행의 수가 1과 같다면
	IF row_cnt=1 THEN
		commit;
	END IF;

	EXCEPTION
	--primary key중복
	WHEN DUP_VAL_ON_INDEX THEN
		errMsg := '같은 키가 존재합니다.';
	WHEN OTHERS THEN
		errMsg := sqlcode||''||sqlerrm;

END;
/
