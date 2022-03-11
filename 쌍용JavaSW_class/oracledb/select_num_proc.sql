create or replace procedure select_num_proc(i_num number, 
cur out sys_refcursor)
is
	--변수선언
	temp_num number;

begin
	temp_num:=i_num;
	if temp_num <1 then
		temp_num:=2;
	end if;

	open cur for
	select num,name,email,age,to_char(input_date,'mm-dd-yyyy am q"분기"') input_date
	from test_procedure
	where num=temp_num;
end;
/
