--�������� ��ȸ�Ͽ� ������� �ܺη� ��ȯ�ϴ� ���ν���
create or replace procedure select_all_proc(
test_cur out sys_refcursor)
is
begin
	open test_cur for
		select num, name, email, age, to_char(input_date,'yyyy-mm-dd day') input_date
		from test_procedure;
end;
/
