create or replace procedure login_proc(
i_id varchar2, i_password varchar2,login_cur out sys_refcursor)
is
begin
	open login_cur for
	select id,password, name
	from test_login
	where id=i_id AND password=i_password;
end;
/

