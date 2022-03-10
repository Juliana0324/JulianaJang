CREATE OR REPLACE PROCEDURE insert_test_proc(num number, name varchar2, email varchar2,
age number, row_cnt OUT number, errMsg OUT varchar2)
IS
BEGIN
	INSERT INTO test_procedure(num, name, email, age) VALUES(num, name, email, age);
	--������ ����� ���� ���� ������ ����
	row_cnt := sql%rowcount;
	--������ ���� ���� 1�� ���ٸ�
	IF row_cnt=1 THEN
		commit;
	END IF;

	EXCEPTION
	--primary key�ߺ�
	WHEN DUP_VAL_ON_INDEX THEN
		errMsg := '���� Ű�� �����մϴ�.';
	WHEN OTHERS THEN
		errMsg := sqlcode||''||sqlerrm;

END;
/
