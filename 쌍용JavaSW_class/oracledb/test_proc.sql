create or replace procedure test_proc(
name in varchar2, age number, email varchar2,
birth out number, domain out varchar2)
is

begin
	--out parameter���� �� �Ҵ��� �����ϴ�
	birth := to_char(sysdate,'yyyy')-age+1;
	if instr(email,'@')!=0 then
		domain := substr(email, instr(email,'@')+1);
	else
		domain := '�߸��� ���� �ּ��Դϴ�.';
	end if;
end;
/

