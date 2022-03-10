create or replace procedure test_proc(
name in varchar2, age number, email varchar2,
birth out number, domain out varchar2)
is

begin
	--out parameter에는 값 할당이 가능하다
	birth := to_char(sysdate,'yyyy')-age+1;
	if instr(email,'@')!=0 then
		domain := substr(email, instr(email,'@')+1);
	else
		domain := '잘못된 메일 주소입니다.';
	end if;
end;
/

